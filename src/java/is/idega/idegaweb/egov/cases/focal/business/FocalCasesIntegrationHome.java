package is.idega.idegaweb.egov.cases.focal.business;

import javax.ejb.CreateException;
import com.idega.business.IBOHome;
import java.rmi.RemoteException;

/**
 * 
 * Last modified: $Date: 2007/05/04 09:22:19 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public interface FocalCasesIntegrationHome extends IBOHome {

	public FocalCasesIntegration create() throws CreateException, RemoteException;
}