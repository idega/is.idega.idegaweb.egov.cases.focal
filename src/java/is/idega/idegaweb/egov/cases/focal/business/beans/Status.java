package is.idega.idegaweb.egov.cases.focal.business.beans;

/**
 * 
 * Last modified: $Date: 2007/05/04 12:04:16 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public class Status {
	
	public static final int success = 0;
	public static final int unknown_fail = 1;
	public static final int no_customer = 2;
	public static final int no_projects = 3;
	
	private int status = -1;
	
	public Status(int status) {
		
		if(status < 0 || status > 3)
			throw new RuntimeException("Value not supported: "+status);
		
		this.status = status;
	}
	
	public Integer getStatus() {
		
		return new Integer(status);
	}
}