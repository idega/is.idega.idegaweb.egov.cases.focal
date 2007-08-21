package is.idega.idegaweb.egov.cases.focal.business;


import javax.ejb.CreateException;
import com.idega.business.IBOHomeImpl;

/**
 * 
 * Last modified: $Date: 2007/08/21 12:57:27 $ by $Author: alexis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.2 $
 */
public class ExportCasesManagementHomeImpl extends IBOHomeImpl implements ExportCasesManagementHome {

	private static final long serialVersionUID = -8350283595156018241L;

	public Class getBeanInterfaceClass() {
		return ExportCasesManagement.class;
	}

	public ExportCasesManagement create() throws CreateException {
		return (ExportCasesManagement) super.createIBO();
	}
}