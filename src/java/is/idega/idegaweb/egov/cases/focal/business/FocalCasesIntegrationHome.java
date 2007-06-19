package is.idega.idegaweb.egov.cases.focal.business;


import javax.ejb.CreateException;
import com.idega.business.IBOHome;
import java.rmi.RemoteException;

public interface FocalCasesIntegrationHome extends IBOHome {
	public FocalCasesIntegration create() throws CreateException, RemoteException;
}