package is.idega.idegaweb.egov.cases.focal.business;

import is.idega.idegaweb.egov.cases.data.GeneralCase;
import is.idega.idegaweb.egov.cases.focal.business.beans.CaseArg;
import is.idega.idegaweb.egov.cases.focal.business.beans.Status;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.CASEDATA;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.PERSONINFO;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.ProjectServiceLocator;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.Customer;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.CustomerPersonalInfo;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.ProjectInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import com.idega.business.IBOLookup;
import com.idega.business.IBOServiceBean;
import com.idega.core.contact.data.Email;
import com.idega.core.contact.data.EmailHome;
import com.idega.core.contact.data.Phone;
import com.idega.core.contact.data.PhoneHome;
import com.idega.core.location.data.Address;
import com.idega.core.location.data.Commune;
import com.idega.core.location.data.Country;
import com.idega.idegaweb.IWMainApplication;
import com.idega.presentation.IWContext;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.User;
import com.idega.util.CypherText;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;

/**
 * 
 * Last modified: $Date: 2007/06/19 11:15:13 $ by $Author: alexis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.13 $
 */
public class FocalCasesIntegrationBean extends IBOServiceBean implements FocalCasesIntegration {

	private static final long serialVersionUID = -486408791846081399L;
	
	private static final String const_project_list = "ProjectList";
	private static final String const_project_info = "ProjectInfo";
	private static final String const_customer = "Customer";
	private static final String focal_service_login_app_key = "focal.ws.login";
	private static final String focal_service_pass_app_key = "focal.ws.pass";
	private static final String ck = "ZIZYFk9nxC41RhCtJBDydBRiUNPvyKlIWmJDJ9p2xYWXvmqIrVyTNXIljGupoFBqi6TyC7bUXWLL2OxdRsWnaph2kQyETYlzHzhv";
	
	private ProjectServiceLocator locator;
	
	private static final Logger logger = Logger.getLogger(FocalCasesIntegrationBean.class.getName());
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public List findProjects(String search_txt) throws Exception {
		
		Project service = getFocalService();
		
		String[] loging_pass = getLoginAndPassword();
		
		if(loging_pass == null)
			throw new NullPointerException("Login and pass for focal ws not set as application properties.");
		
		String xml_str = service.GETPROJECTLIST(const_project_list, loging_pass[0], loging_pass[1]);
		
		if(xml_str == null)
			return null;
		
		XStream xstream = new XStream();
		
		xstream.alias(const_project_list, ArrayList.class);
		xstream.alias(const_project_info, ProjectInfo.class);
		
		try {
			return (List)xstream.fromXML(xml_str);
			
		} catch (StreamException e) {
			
			logger.log(Level.WARNING, "Exception while parsing xml to bean. This can be either an error in document, or that's how focal returns when nothing is found (plain string with blah blah ;])", e);
			return null;
		}
	}
	
	private void setNoOverwriteFaxValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String fax1 = customerFocal.getFax();
			if(fax1 != null && !fax1.equals("")) {
				ci.setFax(fax1);
			} else {
				ci.setFax("");
			}
			String fax2 = customerFocal.getFaxoffice();
			if(fax2 != null && !fax2.equals("")) {
				ci.setFaxoffice(fax2);
			} else {
				ci.setFaxoffice("");
			}
		} else {
			ci.setFax("");
			ci.setFaxoffice("");
		}
	}
	
	private void setNoOverwriteAddress1Value(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address1 = customerFocal.getAddress1();
			if(address1 != null && !address1.equals("")) {
				ci.setAddress1(address1);
			} else {
				ci.setAddress1("");
			}
		} else {
			ci.setAddress1("");
		}
	}
	
	private void setNoOverwriteAddress2Value(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getAddress2();
			if(address2 != null && !address2.equals("")) {
				ci.setAddress2(address2);
			} else {
				ci.setAddress2("");
			}
		} else {
			ci.setAddress2("");
		}
	}
	
	private void setNoOverwritePostaddressValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getPostaddress();
			if(address2 != null && !address2.equals("")) {
				ci.setPostaddress(address2);
			} else {
				ci.setPostaddress("");
			}
		} else {
			ci.setPostaddress("");
		}
	}
	
	private void setNoOverwriteCountryValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getCountry();
			if(address2 != null && !address2.equals("")) {
				ci.setCountry(address2);
			} else {
				ci.setCountry("");
			}
		} else {
			ci.setCountry("");
		}
	}
	
	private void setNoOverwriteCountyValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getCounty();
			if(address2 != null && !address2.equals("")) {
				ci.setCounty(address2);
			} else {
				ci.setCounty("");
			}
		} else {
			ci.setCounty("");
		}
	}
	
	private void setNoOverwritePhoneworkValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getPhonework();
			if(address2 != null && !address2.equals("")) {
				ci.setPhonework(address2);
			} else {
				ci.setPhonework("");
			}
		} else {
			ci.setPhonework("");
		}
	}
	
	private void setNoOverwritePhoneofficeValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getPhoneoffice();
			if(address2 != null && !address2.equals("")) {
				ci.setPhoneoffice(address2);
			} else {
				ci.setPhoneoffice("");
			}
		} else {
			ci.setPhoneoffice("");
		}
	}
	
	private void setNoOverwriteGsmValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getGsm();
			if(address2 != null && !address2.equals("")) {
				ci.setGsm(address2);
			} else {
				ci.setGsm("");
			}
		} else {
			ci.setGsm("");
		}
	}
	
	private void setNoOverwriteCarphoneValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getCarphone();
			if(address2 != null && !address2.equals("")) {
				ci.setCarphone(address2);
			} else {
				ci.setCarphone("");
			}
		} else {
			ci.setCarphone("");
		}
	}
	
	private void setNoOverwriteBeeperValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getBeeper();
			if(address2 != null && !address2.equals("")) {
				ci.setBeeper(address2);
			} else {
				ci.setBeeper("");
			}
		} else {
			ci.setBeeper("");
		}
	}
	
	private void setNoOverwritePhonehomeValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getPhonehome();
			if(address2 != null && !address2.equals("")) {
				ci.setPhonehome(address2);
			} else {
				ci.setPhonehome("");
			}
		} else {
			ci.setPhonehome("");
		}
	}
	
	private void setNoOverwriteLanguageValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getLanguage();
			if(address2 != null && !address2.equals("")) {
				ci.setLanguage(address2);
			} else {
				ci.setLanguage("");
			}
		} else {
			ci.setLanguage("");
		}
	}
	
	private void setNoOverwriteContactseperatorValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getContactseperator();
			if(address2 != null && !address2.equals("")) {
				ci.setContactseperator(address2);
			} else {
				ci.setContactseperator("");
			}
		} else {
			ci.setContactseperator("");
		}
	}
	
	private void setNoOverwriteEmailaddressValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getEmailaddress();
			if(address2 != null && !address2.equals("")) {
				ci.setEmailaddress(address2);
			} else {
				ci.setEmailaddress("");
			}
		} else {
			ci.setEmailaddress("");
		}
	}
	
	private void setNoOverwriteStatusValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getStatus();
			if(address2 != null && !address2.equals("")) {
				ci.setStatus(address2);
			} else {
				ci.setStatus("");
			}
		} else {
			ci.setStatus("");
		}
	}
	
	private void setNoOverwriteAvarpValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getAvarp();
			if(address2 != null && !address2.equals("")) {
				ci.setAvarp(address2);
			} else {
				ci.setAvarp("");
			}
		} else {
			ci.setAvarp("");
		}
	}
	
	private void setNoOverwriteDepartmentValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getDepartment();
			if(address2 != null && !address2.equals("")) {
				ci.setDepartment(address2);
			} else {
				ci.setDepartment("");
			}
		} else {
			ci.setDepartment("");
		}
	}
	
	private void setNoOverwriteHomepageValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getHomepage();
			if(address2 != null && !address2.equals("")) {
				ci.setHomepage(address2);
			} else {
				ci.setHomepage("");
			}
		} else {
			ci.setHomepage("");
		}
	}
	
	private void setNoOverwriteTitleValue(Customer customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getTitle();
			if(address2 != null && !address2.equals("")) {
				ci.setTitle(address2);
			} else {
				ci.setTitle("");
			}
		} else {
			ci.setTitle("");
		}
	}
	
	public CustomerPersonalInfo createCustomerBean(String personalID, IWContext iwc) throws Exception {
		CustomerPersonalInfo ci = new CustomerPersonalInfo();
		if(personalID != null && !personalID.equals("")) {
			Customer customerFocal = findCustomer(personalID);
			UserBusiness userBusiness = (UserBusiness) IBOLookup.getServiceInstance(iwc, UserBusiness.class);
			if(userBusiness != null) {
				
				User customer = userBusiness.getUser(personalID);
				if(customer != null) {
					int id = ((Integer) customer.getPrimaryKey()).intValue();
					Address address1 = userBusiness.getUsersMainAddress(id);
					if(address1 != null) {
						String address1Value = address1.getStreetAddress();
						if(address1Value != null && !address1Value.equals("")) {
							ci.setAddress1(address1Value);
						} else {
							setNoOverwriteAddress1Value(customerFocal, ci);
						}
						String postalAddress = address1.getPostalAddress();
						if(postalAddress != null && !postalAddress.equals("")) {
							ci.setPostaddress(postalAddress);
						} else {
							setNoOverwritePostaddressValue(customerFocal, ci);
						}
						Country country = address1.getCountry();
						if(country != null) {
							ci.setCountry(country.getName());
						} else {
							setNoOverwriteCountryValue(customerFocal, ci);
						}
						Commune commune = address1.getCommune();
						if(commune != null) {
							ci.setCounty(commune.getCommuneName());
						} else {
							setNoOverwriteCountyValue(customerFocal, ci);
						}
					} else {
						setNoOverwriteAddress1Value(customerFocal, ci);
						setNoOverwritePostaddressValue(customerFocal, ci);
						setNoOverwriteCountryValue(customerFocal, ci);
						setNoOverwriteCountyValue(customerFocal, ci);
					}
					Address address2 = userBusiness.getUsersCoAddress(id);
					if(address2 != null) {
						String address2Value = address2.getStreetAddress();
						if(address2Value != null && !address2Value.equals("")) {
							ci.setAddress2(address2Value);
						} else {
							setNoOverwriteAddress2Value(customerFocal, ci);
						}
					} else {
						setNoOverwriteAddress2Value(customerFocal, ci);
					}
					PhoneHome phoneHome = userBusiness.getPhoneHome();
					if(phoneHome != null) {
						Phone home = phoneHome.findUsersHomePhone(customer);
						if(home != null) {
							String homeValue = home.getNumber();
							if(homeValue != null && !homeValue.equals("")) {
								ci.setPhonehome(home.getNumber());
							} else {
								setNoOverwritePhonehomeValue(customerFocal, ci);
							}
						} else {
							setNoOverwritePhonehomeValue(customerFocal, ci);
						}
						Phone work = phoneHome.findUsersWorkPhone(customer);
						if(work != null) {
							String workValue = work.getNumber();
							if(workValue != null && !workValue.equals("")) {
								ci.setPhoneoffice(work.getNumber());
								ci.setPhonework(work.getNumber());
							} else {
								setNoOverwritePhoneworkValue(customerFocal, ci);
								setNoOverwritePhoneofficeValue(customerFocal, ci);
							}
						} else {
							setNoOverwritePhoneworkValue(customerFocal, ci);
							setNoOverwritePhoneofficeValue(customerFocal, ci);
						}
						Phone mobile = phoneHome.findUsersMobilePhone(customer);
						if(mobile != null) {
							String mobileValue = mobile.getNumber();
							if(mobileValue != null && !mobileValue.equals("")) {
								ci.setGsm(mobile.getNumber());
							} else {
								setNoOverwriteGsmValue(customerFocal, ci);
							}
						} else {
							setNoOverwriteGsmValue(customerFocal, ci);
						}
						Phone fax = phoneHome.findUsersFaxPhone(customer);
						if(fax != null) {
							String faxValue = fax.getNumber();
							if(faxValue != null && !faxValue.equals("")) {
								ci.setFax(fax.getNumber());
								ci.setFaxoffice(fax.getNumber());
							} else {
								setNoOverwriteFaxValue(customerFocal, ci);
							}
						} else {
							setNoOverwriteFaxValue(customerFocal, ci);
						}
						setNoOverwriteCarphoneValue(customerFocal, ci);
						setNoOverwriteBeeperValue(customerFocal, ci);
					} else {
						setNoOverwritePhoneworkValue(customerFocal, ci);
						setNoOverwritePhoneofficeValue(customerFocal, ci);
						setNoOverwriteGsmValue(customerFocal, ci);
						setNoOverwriteFaxValue(customerFocal, ci);
						setNoOverwriteCarphoneValue(customerFocal, ci);
						setNoOverwriteBeeperValue(customerFocal, ci);
						setNoOverwritePhonehomeValue(customerFocal, ci);
					}
					ci.setSocNr(customer.getPersonalID());
					
					EmailHome emailHome = userBusiness.getEmailHome();
					if(emailHome != null) {
						Email email = emailHome.findMainEmailForUser(customer);
						if(email != null) {
							ci.setEmailaddress(email.getEmailAddress());
						} else {
							setNoOverwriteEmailaddressValue(customerFocal, ci);
						}
					} else {
						setNoOverwriteEmailaddressValue(customerFocal, ci);
					}
					
					String title = userBusiness.getUserJob(customer);
					if(title != null && !title.equals("")) {
						ci.setTitle(title);
					} else {
						setNoOverwriteTitleValue(customerFocal, ci);
					}
					//TODO ??????
					ci.setTargetMail(false);
					
					String firstName = customer.getFirstName();
					String middleName = customer.getMiddleName();
					String lastName = customer.getLastName();
					
					StringBuffer fullName = new StringBuffer();
					fullName.append(firstName)
					.append(" ");
					if(middleName != null && !middleName.equals("")) {
						fullName.append(middleName)
						.append(". ");
					}
					
					fullName.append(lastName);
					ci.setName(fullName.toString());
				
					setNoOverwriteLanguageValue(customerFocal, ci);
					setNoOverwriteHomepageValue(customerFocal, ci);
					setNoOverwriteAvarpValue(customerFocal, ci);
					setNoOverwriteDepartmentValue(customerFocal, ci);
					setNoOverwriteStatusValue(customerFocal, ci);
					ci.setContactseperator(" ");
				}
			}
		}
		return ci;
	}
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public Customer findCustomer(String search_txt) throws Exception {
		
		Project service = getFocalService();
		
		String[] loging_pass = getLoginAndPassword();
		
		if(loging_pass == null)
			throw new NullPointerException("Login and pass for focal ws not set as application properties.");
		
		String xml_str = service.FINDCUSTOMER(search_txt, const_project_list, loging_pass[0], loging_pass[1]);
		
		if(xml_str == null)
			return null;
		
		XStream xstream = new XStream();
		
		xstream.alias(const_customer, Customer.class);
		
		try {
			return (Customer)xstream.fromXML(xml_str);
			
		} catch (StreamException e) {
			
			logger.log(Level.WARNING, "Exception while parsing xml to bean. This can be either an error in document, or that's how focal returns when nothing is found (plain string with blah blah ;])", e);
			return null;
		}
	}
	
	protected Project getFocalService() throws ServiceException {
		
		if(locator == null)
			locator = new ProjectServiceLocator();
		
		return locator.getDomino();
	}
	
	protected String[] getLoginAndPassword() {
		
		IWMainApplication iwma = IWMainApplication.getDefaultIWMainApplication();
		
		if(iwma != null) {
			
			String login = (String)iwma.getSettings().getProperty(focal_service_login_app_key);
			String pass = (String)iwma.getSettings().getProperty(focal_service_pass_app_key);
			
			if(login == null || pass == null)
				return null;
			
			CypherText ct = new CypherText();
			login = ct.doDeCypher(login, ck);
			pass = ct.doDeCypher(pass, ck);

			return new String[] {login, pass};
		}
		
		return null;
	}
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public List createCasesUnderProject(String project_id, List cases) throws Exception {

		if(cases == null || cases.isEmpty())
			return cases;
		
		Project service = getFocalService();
		
		for (Iterator iter = cases.iterator(); iter.hasNext();) {
			CaseArg case_arg = (CaseArg) iter.next();
			
			GeneralCase gen_case = case_arg.getGcase();
			
			if(gen_case.getExternalId() != null) {

				logger.log(Level.WARNING, "Case was tried to move under a project when already moved. Case id: "+gen_case.getId()+", external id: "+gen_case.getExternalId());
				continue;
			}
			
			CASEDATA case_data = new CASEDATA(
					gen_case.getOwner().getPersonalID(),				//"SOCSECNUM"
					gen_case.getCreator() == null ? null :
					gen_case.getCreator().getName(), 					//"CUSTOMERNAME"
					gen_case.getSubject(),								//"SUBJECT"
					gen_case.getCreated() == null ? null :
					String.valueOf(gen_case.getCreated().getTime()),	//"DATE"
		            gen_case.getBody(),									//"BODY"
			        null,												//"PROJECTNAME"
			        project_id											//"PROJECTNUMBER"
			);
			
			String[] login_and_pass = getLoginAndPassword();

//			TODO: is this the correct profile key - const_project_list ?
			RETURNSTATUS ret_status = service.NEWPROJECT(case_data, const_project_list, login_and_pass[0], login_and_pass[1]);
			
			try {
				int status_code = Integer.parseInt(ret_status.getSTATUS());
				
				if(status_code == 0)
					case_arg.setStatus(new Status(Status.success));
				else {
					case_arg.setStatus(new Status(Status.unknown_fail));
					logger.log(Level.WARNING, "Error occured while creating project by case. Status message: "+ret_status.getERRORTEXT());
				}
				
			} catch (Exception e) {
				
				case_arg.setStatus(new Status(Status.unknown_fail));
				
				if(ret_status == null)
					logger.log(Level.SEVERE, "No status was retrieved", e);
				else
					logger.log(Level.SEVERE, "Exception while parsing status code. Status message: "+ret_status.getERRORTEXT(), e);
			}
		}
		
		return cases;
	}
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public Status createUpdateCustomer(CustomerPersonalInfo customer) throws Exception {
		
		Project service = getFocalService();
		String[] login_and_pass = getLoginAndPassword();
		
		PERSONINFO person_info = new PERSONINFO(
					customer.getAddress1(),								//ADDRESS2
					customer.getAddress2(), 							//ADDRESS2
					customer.getCounty(), 								//COUNTY
					customer.getCountry(), 								//COUNTRY
					customer.getEmailaddress(),							//EMAIL
					customer.getFax(), 									//FAX
					customer.getHomepage(),								//HOMEPAGE
					customer.getLanguage(), 							//LANGUAGE
					customer.getPhonework(),							//PHONEWORK
					customer.getPostaddress(), 							//POSTADDRESS
					customer.getSocNr(),		 						//SOCSECNUM
					customer.getStatus(), 								//STATUS
					customer.getTargetMail(),				 			//TARGETMAIL
					customer.getAvarp(), 								//AVARP
					customer.getBeeper(), 								//BEEPER
					customer.getCarphone(), 							//CARPHONE
					customer.getGsm(),	 								//GSM
					customer.getName(), 								//PERSONNAME
					customer.getPhonehome(),							//PHONEHOME
					customer.getPhoneoffice(),							//PHONEOFFICE
					customer.getContactseperator(),						//SEPERATOR
					customer.getTitle() 								//TITLE
		);
		
//		TODO: is this the correct profile key - const_project_list ?
		RETURNSTATUS ret_status = service.CREATEUPDATEPERSON(person_info, const_project_list, login_and_pass[0], login_and_pass[1]);
		
		try {
				int status_code = Integer.parseInt(ret_status.getSTATUS());
				
				if(status_code == 0)
					return new Status(Status.success);
				else {
					logger.log(Level.WARNING, "Error occured while doing CREATEUPDATEPERSON. Status message: "+ret_status.getERRORTEXT());
					return new Status(Status.unknown_fail);
				}
				
			} catch (Exception e) {
				
				if(ret_status == null)
					logger.log(Level.SEVERE, "No status was retrieved", e);
				else
					logger.log(Level.SEVERE, "Exception while parsing status code. Status message: "+ret_status.getERRORTEXT(), e);
				
				return new Status(Status.unknown_fail);
			}
	}
}