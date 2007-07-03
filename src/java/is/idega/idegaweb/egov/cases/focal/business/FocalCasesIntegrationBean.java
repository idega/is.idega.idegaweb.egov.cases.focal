package is.idega.idegaweb.egov.cases.focal.business;

import is.idega.idegaweb.egov.cases.data.CaseCategory;
import is.idega.idegaweb.egov.cases.data.CaseType;
import is.idega.idegaweb.egov.cases.data.GeneralCase;
import is.idega.idegaweb.egov.cases.focal.business.beans.CaseArg;
import is.idega.idegaweb.egov.cases.focal.business.beans.Status;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.ATTACHMENT;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.CASEDATA;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECTARRAY;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.PERSONINFO;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.PROJECTRETURNSTATUS;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.ProjectServiceLocator;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.CustomerPersonalInfo;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.idega.core.file.data.ICFile;
import com.idega.core.location.data.Address;
import com.idega.core.location.data.Commune;
import com.idega.core.location.data.Country;
import com.idega.idegaweb.IWMainApplication;
import com.idega.presentation.IWContext;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.User;
import com.idega.util.CypherText;

/**
 * 
 * Last modified: $Date: 2007/07/03 12:24:51 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.23 $
 */
public class FocalCasesIntegrationBean extends IBOServiceBean implements FocalCasesIntegration {

	private static final long serialVersionUID = -486408791846081399L;
	
	private static final String const_project_list = "ProjectList";
	private static final String const_project_type_BY_NAME = "nafn";
	private static final String const_project_type_BY_SOCIAL_NUMBER = "kt";
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
		
		NOTESPROJECTARRAY project_list = null;
		List result_project_list = new ArrayList();
		
		try {
			project_list = service.GETPROJECTLIST(search_txt, const_project_type_BY_NAME, const_project_list, loging_pass[0], loging_pass[1]);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exceptioon while trying to get project list by search type: "+const_project_type_BY_NAME+" and search query: "+search_txt, e);
		}
		
		if(project_list != null && project_list.getPROJECTARRAY() != null)
			result_project_list.addAll(Arrays.asList(project_list.getPROJECTARRAY()));
		
		try {
			project_list = service.GETPROJECTLIST(search_txt, const_project_type_BY_SOCIAL_NUMBER, const_project_list, loging_pass[0], loging_pass[1]);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exceptioon while trying to get project list by search type: "+const_project_type_BY_SOCIAL_NUMBER+" and search query: "+search_txt, e);
		}
		
		if(project_list != null && project_list.getPROJECTARRAY() != null)
			result_project_list.addAll(Arrays.asList(project_list.getPROJECTARRAY()));
		
		return result_project_list;
	}
	
	private void setNoOverwriteFaxValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String fax1 = customerFocal.getFAX();
			if(fax1 != null && !fax1.equals("")) {
				ci.setFAX(fax1);
			} else {
				ci.setFAX("");
			}
			String fax2 = customerFocal.getFAXOFFICE();
			if(fax2 != null && !fax2.equals("")) {
				ci.setFAXOFFICE(fax2);
			} else {
				ci.setFAXOFFICE("");
			}
		} else {
			ci.setFAX("");
			ci.setFAXOFFICE("");
		}
	}
	
	private void setNoOverwriteAddress1Value(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address1 = customerFocal.getADDRESS1();
			if(address1 != null && !address1.equals("")) {
				ci.setADDRESS1(address1);
			} else {
				ci.setADDRESS1("");
			}
		} else {
			ci.setADDRESS1("");
		}
	}
	
	private void setNoOverwriteAddress2Value(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getADDRESS2();
			if(address2 != null && !address2.equals("")) {
				ci.setADDRESS2(address2);
			} else {
				ci.setADDRESS2("");
			}
		} else {
			ci.setADDRESS2("");
		}
	}
	
	private void setNoOverwritePostaddressValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getPOSTADDRESS();
			if(address2 != null && !address2.equals("")) {
				ci.setPOSTADDRESS(address2);
			} else {
				ci.setPOSTADDRESS("");
			}
		} else {
			ci.setPOSTADDRESS("");
		}
	}
	
	private void setNoOverwriteCountryValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getCOUNTRY();
			if(address2 != null && !address2.equals("")) {
				ci.setCOUNTRY(address2);
			} else {
				ci.setCOUNTRY("");
			}
		} else {
			ci.setCOUNTRY("");
		}
	}
	
	private void setNoOverwriteCountyValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getCOUNTY();
			if(address2 != null && !address2.equals("")) {
				ci.setCOUNTY(address2);
			} else {
				ci.setCOUNTY("");
			}
		} else {
			ci.setCOUNTY("");
		}
	}
	
	private void setNoOverwritePhoneworkValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getPHONEWORK();
			if(address2 != null && !address2.equals("")) {
				ci.setPHONEWORK(address2);
			} else {
				ci.setPHONEWORK("");
			}
		} else {
			ci.setPHONEWORK("");
		}
	}
	
	private void setNoOverwritePhoneofficeValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getPHONEOFFICE();
			if(address2 != null && !address2.equals("")) {
				ci.setPHONEOFFICE(address2);
			} else {
				ci.setPHONEOFFICE("");
			}
		} else {
			ci.setPHONEOFFICE("");
		}
	}
	
	private void setNoOverwriteGsmValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getGSM();
			if(address2 != null && !address2.equals("")) {
				ci.setGSM(address2);
			} else {
				ci.setGSM("");
			}
		} else {
			ci.setGSM("");
		}
	}
	
	private void setNoOverwriteCarphoneValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getCARPHONE();
			if(address2 != null && !address2.equals("")) {
				ci.setCARPHONE(address2);
			} else {
				ci.setCARPHONE("");
			}
		} else {
			ci.setCARPHONE("");
		}
	}
	
	private void setNoOverwriteBeeperValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getBEEPER();
			if(address2 != null && !address2.equals("")) {
				ci.setBEEPER(address2);
			} else {
				ci.setBEEPER("");
			}
		} else {
			ci.setBEEPER("");
		}
	}
	
	private void setNoOverwritePhonehomeValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getPHONEHOME();
			if(address2 != null && !address2.equals("")) {
				ci.setPHONEHOME(address2);
			} else {
				ci.setPHONEHOME("");
			}
		} else {
			ci.setPHONEHOME("");
		}
	}
	
	private void setNoOverwriteLanguageValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getLANGUAGE();
			if(address2 != null && !address2.equals("")) {
				ci.setLANGUAGE(address2);
			} else {
				ci.setLANGUAGE("");
			}
		} else {
			ci.setLANGUAGE("");
		}
	}
	
	private void setNoOverwriteContactseperatorValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getCONTACTSEPERATOR();
			if(address2 != null && !address2.equals("")) {
				ci.setCONTACTSEPERATOR(address2);
			} else {
				ci.setCONTACTSEPERATOR("");
			}
		} else {
			ci.setCONTACTSEPERATOR("");
		}
	}
	
	private void setNoOverwriteEmailaddressValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getEMAILADDRESS();
			if(address2 != null && !address2.equals("")) {
				ci.setEMAILADDRESS(address2);
			} else {
				ci.setEMAILADDRESS("");
			}
		} else {
			ci.setEMAILADDRESS("");
		}
	}
	
	private void setNoOverwriteStatusValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getSTATUS();
			if(address2 != null && !address2.equals("")) {
				ci.setJOBSTATUS(address2);
			} else {
				ci.setJOBSTATUS("");
			}
		} else {
			ci.setJOBSTATUS("");
		}
	}
	
	private void setNoOverwriteAvarpValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getAVARP();
			if(address2 != null && !address2.equals("")) {
				ci.setAVARP(address2);
			} else {
				ci.setAVARP("");
			}
		} else {
			ci.setAVARP("");
		}
	}
	
	private void setNoOverwriteDepartmentValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getDEPARTMENT();
			if(address2 != null && !address2.equals("")) {
				ci.setDEPARTMENT(address2);
			} else {
				ci.setDEPARTMENT("");
			}
		} else {
			ci.setDEPARTMENT("");
		}
	}
	
	private void setNoOverwriteHomepageValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getHOMEPAGE();
			if(address2 != null && !address2.equals("")) {
				ci.setHOMEPAGE(address2);
			} else {
				ci.setHOMEPAGE("");
			}
		} else {
			ci.setHOMEPAGE("");
		}
	}
	
	private void setNoOverwriteTitleValue(CUSTOMER customerFocal, CustomerPersonalInfo ci) {
		if(customerFocal != null) {
			String address2 = customerFocal.getTITLE();
			if(address2 != null && !address2.equals("")) {
				ci.setTITLE(address2);
			} else {
				ci.setTITLE("");
			}
		} else {
			ci.setTITLE("");
		}
	}
	
	public CustomerPersonalInfo createCustomerBean(String personalID, IWContext iwc) throws Exception {
		CustomerPersonalInfo ci = new CustomerPersonalInfo();
		if(personalID != null && !personalID.equals("")) {
			CUSTOMER customerFocal = findCustomer(personalID);
			UserBusiness userBusiness = (UserBusiness) IBOLookup.getServiceInstance(iwc, UserBusiness.class);
			if(userBusiness != null) {
				
				User customer = userBusiness.getUser(personalID);
				if(customer != null) {
					int id = ((Integer) customer.getPrimaryKey()).intValue();
					Address address1 = userBusiness.getUsersMainAddress(id);
					try {
						String address1Value = address1.getStreetAddress();
						if(address1Value != null && !address1Value.equals("")) {
							ci.setADDRESS1(address1Value);
						} else {
							setNoOverwriteAddress1Value(customerFocal, ci);
						}
						String postalAddress = address1.getPostalAddress();
						if(postalAddress != null && !postalAddress.equals("")) {
							ci.setPOSTADDRESS(postalAddress);
						} else {
							setNoOverwritePostaddressValue(customerFocal, ci);
						}
						Country country = address1.getCountry();
						if(country != null) {
							ci.setCOUNTRY(country.getName());
						} else {
							setNoOverwriteCountryValue(customerFocal, ci);
						}
						Commune commune = address1.getCommune();
						if(commune != null) {
							ci.setCOUNTY(commune.getCommuneName());
						} else {
							setNoOverwriteCountyValue(customerFocal, ci);
						}
					} catch(Exception e) {
						setNoOverwriteAddress1Value(customerFocal, ci);
						setNoOverwritePostaddressValue(customerFocal, ci);
						setNoOverwriteCountryValue(customerFocal, ci);
						setNoOverwriteCountyValue(customerFocal, ci);
					}
					try {
						Address address2 = userBusiness.getUsersCoAddress(id);
						String address2Value = address2.getStreetAddress();
						if(address2Value != null && !address2Value.equals("")) {
							ci.setADDRESS2(address2Value);
						} else {
							setNoOverwriteAddress2Value(customerFocal, ci);
						}
					} catch(Exception e) {
						setNoOverwriteAddress2Value(customerFocal, ci);
					}
					PhoneHome phoneHome = userBusiness.getPhoneHome();
					if(phoneHome != null) {
						try {
							Phone home = phoneHome.findUsersHomePhone(customer);
						
							String homeValue = home.getNumber();
							if(homeValue != null && !homeValue.equals("")) {
								ci.setPHONEHOME(home.getNumber());
							} else {
								setNoOverwritePhonehomeValue(customerFocal, ci);
							}
						} catch(Exception e) {
							setNoOverwritePhonehomeValue(customerFocal, ci);
						}
						try {
							Phone work = phoneHome.findUsersWorkPhone(customer);
						
							String workValue = work.getNumber();
							if(workValue != null && !workValue.equals("")) {
								ci.setPHONEOFFICE(work.getNumber());
								ci.setPHONEWORK(work.getNumber());
							} else {
								setNoOverwritePhoneworkValue(customerFocal, ci);
								setNoOverwritePhoneofficeValue(customerFocal, ci);
							}
						} catch(Exception e) {
							setNoOverwritePhoneworkValue(customerFocal, ci);
							setNoOverwritePhoneofficeValue(customerFocal, ci);
						}
						try {
							Phone mobile = phoneHome.findUsersMobilePhone(customer);
						
							String mobileValue = mobile.getNumber();
							if(mobileValue != null && !mobileValue.equals("")) {
								ci.setGSM(mobile.getNumber());
							} else {
								setNoOverwriteGsmValue(customerFocal, ci);
							}
						} catch(Exception e) {
							setNoOverwriteGsmValue(customerFocal, ci);
						}
						try {
							Phone fax = phoneHome.findUsersFaxPhone(customer);
						
							String faxValue = fax.getNumber();
							if(faxValue != null && !faxValue.equals("")) {
								ci.setFAX(fax.getNumber());
								ci.setFAXOFFICE(fax.getNumber());
							} else {
								setNoOverwriteFaxValue(customerFocal, ci);
							}
						} catch(Exception e) {
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
					try {
						Email email = emailHome.findMainEmailForUser(customer);
						if(email != null) {
							ci.setEMAILADDRESS(email.getEmailAddress());
						} else {
							setNoOverwriteEmailaddressValue(customerFocal, ci);
						}
					} catch(Exception e) {
						setNoOverwriteEmailaddressValue(customerFocal, ci);
					}
					
					String title = userBusiness.getUserJob(customer);
					if(title != null && !title.equals("")) {
						ci.setTITLE(title);
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
					ci.setCUSTOMERNAME(fullName.toString());
				
					setNoOverwriteLanguageValue(customerFocal, ci);
					setNoOverwriteHomepageValue(customerFocal, ci);
					setNoOverwriteAvarpValue(customerFocal, ci);
					setNoOverwriteDepartmentValue(customerFocal, ci);
					setNoOverwriteStatusValue(customerFocal, ci);
					ci.setCONTACTSEPERATOR(" ");
				}
			}
		}
		return ci;
	}
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public CUSTOMER findCustomer(String search_txt) throws Exception {
		
		Project service = getFocalService();
		
		String[] loging_pass = getLoginAndPassword();
		
		if(loging_pass == null)
			throw new NullPointerException("Login and pass for focal ws not set as application properties.");
		
		return service.FINDCUSTOMER(search_txt, const_project_list, loging_pass[0], loging_pass[1]);
		
//		String xml_str = service.FINDCUSTOMER(search_txt, const_project_list, loging_pass[0], loging_pass[1]);
//		
//		if(xml_str == null)
//			return null;
//		
//		XStream xstream = new XStream();
//		
//		xstream.alias(const_customer, Customer.class);
//		
//		try {
//			return (Customer)xstream.fromXML(xml_str);
//			
//		} catch (StreamException e) {
//			
//			logger.log(Level.WARNING, "Exception while parsing xml to bean. This can be either an error in document, or that's how focal returns when nothing is found (plain string with blah blah ;])", e);
//			return null;
//		}
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
	public List createCasesUnderProject(String project_id, String projectName, List cases) throws Exception {

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
			CaseCategory category = gen_case.getCaseCategory();
			CaseType type = gen_case.getCaseType();
			
			CASEDATA case_data = new CASEDATA(
					gen_case.getOwner().getPersonalID(),				//"SOCSECNUM"
					gen_case.getOwner() == null ? null :
					gen_case.getOwner().getName(), 						//"CUSTOMERNAME"
//					gen_case.getSubject(),								//"SUBJECT"
					category.getName() + " - " + type.getName(),		//"SUBJECT"
					gen_case.getCreated() == null ? null :
					String.valueOf(gen_case.getCreated().getTime()),	//"DATE"
		            gen_case.getMessage(),								//"BODY"
			        projectName,									 	//"PROJECTNAME"
			        project_id											//"PROJECTNUMBER"
			);
			
			String[] login_and_pass = getLoginAndPassword();

			PROJECTRETURNSTATUS ret_status = service.NEWPROJECT(case_data, const_project_list, login_and_pass[0], login_and_pass[1]);
			
			try {
				int status_code = Integer.parseInt(ret_status.getSTATUS());
				
				if(status_code == Status.success)
					addAttachment(case_arg, ret_status.getUNID(), service);
					
				else if(status_code == Status.failed_to_save) {
					case_arg.setStatus(new Status(Status.failed_to_save));
					logger.log(Level.WARNING, "Error occured while creating project by case. Status message: "+ret_status.getERRORTEXT());
				} else {
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
	
	private void addAttachment(CaseArg case_arg, String UNID, Project service) {
		ICFile att_file = case_arg.getGcase().getAttachment();
		
		if(att_file == null) {
			case_arg.setStatus(new Status(Status.success));
			return;
		}
		
		RETURNSTATUS status = null;
		
		try {
			byte[] serialized_file = new byte[att_file.getFileSize().intValue()];
			int bytes_read = att_file.getFileValue().read(serialized_file);
			
			ATTACHMENT att = new ATTACHMENT();
			att.setBASE64(serialized_file);
			att.setFILENAME(att_file.getName());
			att.setFILESIZE(bytes_read != -1 ? bytes_read : att_file.getFileSize().intValue());
			
			String[] login_and_pass = getLoginAndPassword();
			status = service.ADDATTACHMENT(att, UNID, const_project_list, login_and_pass[0], login_and_pass[1]);
			
			int status_code = Integer.parseInt(status.getSTATUS());
			
			if(status_code == Status.success)
				case_arg.setStatus(new Status(Status.success));
			else if(status_code == Status.failed_to_save) {
				case_arg.setStatus(new Status(Status.failed_to_save));
				logger.log(Level.WARNING, "Error occured while adding attachment. Status message: "+status.getERRORTEXT());
			} else {
				case_arg.setStatus(new Status(Status.unknown_fail));
				logger.log(Level.WARNING, "Error occured while adding attachment. Status message: "+status.getERRORTEXT());
			}
			
		} catch (Exception e) {
			
			if(status != null)
				logger.log(Level.SEVERE, "Exception while adding attachment. Status message: "+status.getERRORTEXT(), e);
			else
				logger.log(Level.SEVERE, "Exception while adding attachment.", e);
			
			case_arg.setStatus(new Status(Status.unknown_fail));
			
		} finally {
			try {
				att_file.getFileValue().close();
			} catch (Exception e) {
				logger.log(Level.WARNING, "Failed to close ICFile value input stream", e);
			}
		}
	}
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public Status createUpdateCustomer(CustomerPersonalInfo customer) throws Exception {
		
		Project service = getFocalService();
		String[] login_and_pass = getLoginAndPassword();
		
		PERSONINFO person_info = new PERSONINFO(
					customer.getADDRESS1(),								//ADDRESS2
					customer.getADDRESS2(), 							//ADDRESS2
					customer.getCOUNTY(), 								//COUNTY
					customer.getCOUNTRY(), 								//COUNTRY
					customer.getEMAILADDRESS(),							//EMAIL
					customer.getFAX(), 									//FAX
					customer.getHOMEPAGE(),								//HOMEPAGE
					customer.getLANGUAGE(), 							//LANGUAGE
					customer.getPHONEWORK(),							//PHONEWORK
					customer.getPOSTADDRESS(), 							//POSTADDRESS
					customer.getSocNr(),		 						//SOCSECNUM
					customer.getJOBSTATUS(), 							//STATUS
					customer.getTargetMail(),				 			//TARGETMAIL
					customer.getAVARP(), 								//AVARP
					customer.getBEEPER(), 								//BEEPER
					customer.getCARPHONE(), 							//CARPHONE
					customer.getGSM(),	 								//GSM
					customer.getCUSTOMERNAME(), 						//PERSONNAME
					customer.getPHONEHOME(),							//PHONEHOME
					customer.getPHONEOFFICE(),							//PHONEOFFICE
					customer.getCONTACTSEPERATOR(),						//SEPERATOR
					customer.getTITLE() 								//TITLE
		);
		
		RETURNSTATUS ret_status = service.CREATEUPDATEPERSON(person_info, const_project_list, login_and_pass[0], login_and_pass[1]);
		
		try {
				int status_code = Integer.parseInt(ret_status.getSTATUS());
				
				if(status_code == Status.success)
					return new Status(Status.success);
				else if(status_code == Status.failed_to_save) {
					logger.log(Level.WARNING, "Error occured while doing CREATEUPDATEPERSON. Status message: "+ret_status.getERRORTEXT());
					return new Status(Status.failed_to_save);
				} else {
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