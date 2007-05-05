package is.idega.idegaweb.egov.cases.focal.business;

import is.idega.idegaweb.egov.cases.data.GeneralCase;
import is.idega.idegaweb.egov.cases.focal.business.beans.CaseArg;
import is.idega.idegaweb.egov.cases.focal.business.beans.Status;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import com.idega.business.IBOServiceBean;
import com.idega.data.IDOStoreException;
import com.idega.transaction.IdegaTransactionManager;

/**
 * 
 * Last modified: $Date: 2007/05/05 18:47:55 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public class ExportCasesManagementBean extends IBOServiceBean implements ExportCasesManagement {

	private static final long serialVersionUID = -4409596745472629280L;
	private Logger logger = Logger.getLogger(ExportCasesManagementBean.class.getName());

	/**
	 * 
	 * <p>
	 * Updates case external id with a project id which the case was created under
	 * <br />
	 * Cases updated are only those containing success status mean to describe if move to focal system was successful
	 * </p>
	 * 
	 * @param cases - list of is.idega.idegaweb.egov.cases.focal.business.beans.CaseArg
	 */
	public void updateCasesExternalId(String project_id, List cases) {
	
		TransactionManager tm = IdegaTransactionManager.getInstance(GeneralCase.class);
		
		boolean transaction_started = false;
		
		try {
			tm.begin();
			transaction_started = true;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Transaction failed to begin, storing immediately", e);
		}
		
		for (Iterator iter = cases.iterator(); iter.hasNext();) {
			
			CaseArg case_arg = (CaseArg) iter.next();
			Status status = case_arg.getStatus();
			
			if(status.getStatus().intValue() == Status.success) {
				
				GeneralCase gcase = case_arg.getGcase();
				
				try {
					gcase.setExternalId(project_id);
					System.out.println("gen case data source from bean: "+gcase.getDatasource());
					gcase.store();
					
				} catch (IDOStoreException e) {
					
					logger.log(Level.SEVERE, "Error while storing general case: "+gcase.getId(), e);
				}
			}
		}

		if(transaction_started) {
			
			try {
				tm.commit();
				
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Transaction failed to commit, rollbacking", e);
				
				try {
					tm.rollback();
				} catch (SystemException e2) {
					logger.log(Level.SEVERE, "Transaction failed to rollback", e2);
				}
			}
		}
	}
}