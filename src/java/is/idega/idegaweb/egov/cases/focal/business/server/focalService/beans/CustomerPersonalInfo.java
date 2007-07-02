package is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans;

import is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER;

/**
 * 
 * Last modified: $Date: 2007/07/02 10:31:11 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.4 $
 */
public class CustomerPersonalInfo extends CUSTOMER {
	
	private static final long serialVersionUID = 644025245021476293L;
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