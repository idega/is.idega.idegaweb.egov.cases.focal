package is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans;

import com.idega.user.data.User;

/**
 * 
 * Last modified: $Date: 2007/06/18 14:58:23 $ by $Author: alexis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.2 $
 */
public class CustomerPersonalInfo extends Customer {
	
	
	private String soc_nr;
	private boolean target_mail;
	
	public CustomerPersonalInfo() {
		super();
		this.soc_nr = "";
		this.target_mail = false;
	}
	
	public CustomerPersonalInfo(User customer) {
//		this.set
		//TODO fill this bean with User data
	}
	
	public String getSocNr() {
		return soc_nr;
	}
	public void setSocNr(String soc_nr) {
		this.soc_nr = soc_nr;
	}
	public boolean getTargetMail() {
		return target_mail;
	}
	public void setTargetMail(boolean target_mail) {
		this.target_mail = target_mail;
	}
}