package is.idega.idegaweb.egov.cases.focal.business;

/**
 * 
 * Last modified: $Date: 2007/05/04 09:22:19 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public class UnsuccessfulStatusException extends Exception {

	private static final long serialVersionUID = 8020380823364682303L;
	
	public static final int unknown_fail = 0;
	public static final int no_customer = 1;
	public static final int no_projects = 2;
	
	public UnsuccessfulStatusException()
    {
    }

    public UnsuccessfulStatusException(String s)
    {
        super(s);
    }

    public UnsuccessfulStatusException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public UnsuccessfulStatusException(Throwable throwable)
    {
        super(throwable);
    }
	
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}