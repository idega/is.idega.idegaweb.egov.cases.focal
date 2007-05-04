package is.idega.idegaweb.egov.cases.focal.business.beans;

import is.idega.idegaweb.egov.cases.data.GeneralCase;

/**
 * 
 * Last modified: $Date: 2007/05/04 12:04:16 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public class CaseArg {
	
	private GeneralCase gcase;
	private Status status;
	
	public GeneralCase getGcase() {
		return gcase;
	}
	public void setGcase(GeneralCase gcase) {
		this.gcase = gcase;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}