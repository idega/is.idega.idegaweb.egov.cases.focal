package is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans;

/**
 * 
 * Bean corresponding to ProjectInfo element in focal ProjectList xml.
 * 
 * Last modified: $Date: 2007/05/29 07:54:51 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public class ProjectInfo {
	
	private String Name;
	private String Number;
	private String Status;
	private String Customer;
	
	public String toString() {
		return "Project info: "+Name+" "+Number+" "+Status+" "+Customer;
	}

	public String getCustomer() {
		return Customer;
	}

	public void setCustomer(String customer) {
		Customer = customer;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}