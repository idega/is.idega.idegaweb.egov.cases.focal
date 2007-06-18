package is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans;

/**
 * 
 * Last modified: $Date: 2007/06/18 12:16:24 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public class CustomerPersonalInfo extends Customer {
	
	
	private String soc_nr;
	private boolean target_mail;
	
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