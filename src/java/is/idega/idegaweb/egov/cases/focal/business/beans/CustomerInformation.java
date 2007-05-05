package is.idega.idegaweb.egov.cases.focal.business.beans;

/**
 * 
 * Last modified: $Date: 2007/05/05 18:46:32 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public class CustomerInformation {

	private String customer_id;
    private String email;
    private String name;
    private String phone;
    
	public String getCustomerId() {
		return customer_id;
	}
	public void setCustomerId(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}