package is.idega.idegaweb.egov.cases.focal.business;

import is.idega.idegaweb.egov.cases.focal.business.beans.Status;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.Customer;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.CustomerPersonalInfo;

import java.util.List;

import com.idega.business.IBOService;
import com.idega.presentation.IWContext;

/**
 * 
 * Last modified: $Date: 2007/06/20 05:28:54 $ by $Author: alexis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.6 $
 */
public interface FocalCasesIntegration extends IBOService {

	/**
	 * Finds projects by main party (customer) id or name(probably)
	 * 
	 * @param search_txt - id or name(?)
	 * @return list of is.idega.idegaweb.egov.cases.focal.business.beans.ProjectData objects
	 * @throws UnsuccessfulStatusException - contains the cause (use getStatus()) of projects missing, if there was an objective reason for that - e.g. no customer exists, or customer has no projects
	 * @throws Exception
	 */
	public abstract List findProjects(String search_txt) throws UnsuccessfulStatusException, Exception;
	
	/**
	 * Create a CustomerPersonalInfo bean and fills it with data from the User system
	 * 
	 * @param personalID - personal number of the person
	 * @param iwc - current IWContext instance
	 * @return CustomerPersonalInfo bean containing all the data to be submitted to Focal
	 * @throws Exception
	 */
	public abstract CustomerPersonalInfo createCustomerBean(String personalID, IWContext iwc) throws Exception;
	
	/**
	 * 
	 * Creates cases under the same project
	 * 
	 * @param project_id - project to create under id
	 * @param projectName - name of the project to create under
	 * @param cases - list of is.idega.idegaweb.egov.cases.focal.business.beans.CaseArg - status may be empty as it is used on return only
	 * @return cases - the same list with status modified to each case move status
	 */
	public abstract List createCasesUnderProject(String project_id, String projectName, List cases) throws Exception;
	
	/**
	 * 
	 * Searches for customer info by customer social number or smth
	 * 
	 * @param search_txt - possibly could be customer id (social number) on focal system
	 * @return bean of customer information
	 * @throws Exception
	 */
	public abstract Customer findCustomer(String search_txt) throws Exception;
	
	/**
	 * possibly creates (if non-existent) or updates customer information on focal system
	 * 
	 * @param customer_information - information to be updated with
	 * @return - if update was successful or not (e.g. customer not found or smth dunno ;]) 
	 * @throws Exception
	 */
	public abstract Status createUpdateCustomer(CustomerPersonalInfo customer_information) throws Exception;
}