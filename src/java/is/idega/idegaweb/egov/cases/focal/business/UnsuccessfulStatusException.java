package is.idega.idegaweb.egov.cases.focal.business;

import is.idega.idegaweb.egov.cases.focal.business.beans.Status;

/**
 * 
 * Last modified: $Date: 2007/05/04 12:04:16 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.2 $
 */
public class UnsuccessfulStatusException extends Exception {

	private static final long serialVersionUID = 8020380823364682303L;
	
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
	
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}