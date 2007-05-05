package is.idega.idegaweb.egov.cases.focal.business;

import java.util.List;

import com.idega.business.IBOService;

/**
 * 
 * Last modified: $Date: 2007/05/05 19:00:06 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.2 $
 */
public interface ExportCasesManagement extends IBOService {

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
	public abstract void updateCasesExternalId(String project_id, List cases);
}