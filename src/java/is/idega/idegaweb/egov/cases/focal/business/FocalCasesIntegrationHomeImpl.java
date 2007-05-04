package is.idega.idegaweb.egov.cases.focal.business;


import javax.ejb.CreateException;
import com.idega.business.IBOHomeImpl;

/**
 * 
 * Last modified: $Date: 2007/05/04 09:22:19 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public class FocalCasesIntegrationHomeImpl extends IBOHomeImpl implements FocalCasesIntegrationHome {

	private static final long serialVersionUID = -8350283595156018241L;

	public Class getBeanInterfaceClass() {
		return FocalCasesIntegration.class;
	}

	public FocalCasesIntegration create() throws CreateException {
		return (FocalCasesIntegration) super.createIBO();
	}
}