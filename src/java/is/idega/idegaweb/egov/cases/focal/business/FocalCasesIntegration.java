package is.idega.idegaweb.egov.cases.focal.business;


import com.idega.presentation.IWContext;
import is.idega.idegaweb.egov.cases.focal.business.beans.CompanyInfo;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.CustomerPersonalInfo;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER;
import com.idega.business.IBOService;
import is.idega.idegaweb.egov.cases.focal.business.beans.Status;
import java.util.List;
import java.rmi.RemoteException;

public interface FocalCasesIntegration extends IBOService {
	/**
	 * @see is.idega.idegaweb.egov.cases.focal.business.FocalCasesIntegrationBean#findProjects
	 */
	public List findProjects(String search_txt) throws Exception,
			RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.cases.focal.business.FocalCasesIntegrationBean#createCompany
	 */
	public Status createCompany(CompanyInfo companyInfo) throws Exception,
			RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.cases.focal.business.FocalCasesIntegrationBean#createCustomerBean
	 */
	public CustomerPersonalInfo createCustomerBean(String personalID,
			IWContext iwc) throws Exception, RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.cases.focal.business.FocalCasesIntegrationBean#findCustomer
	 */
	public CUSTOMER findCustomer(String search_txt) throws Exception,
			RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.cases.focal.business.FocalCasesIntegrationBean#createCasesUnderProject
	 */
	public List createCasesUnderProject(String project_id, String projectName,
			List cases) throws Exception, RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.cases.focal.business.FocalCasesIntegrationBean#createUpdateCustomer
	 */
	public Status createUpdateCustomer(CustomerPersonalInfo customer)
			throws Exception, RemoteException;
}