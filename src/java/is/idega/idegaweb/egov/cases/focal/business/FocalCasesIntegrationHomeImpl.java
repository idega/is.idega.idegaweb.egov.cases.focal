package is.idega.idegaweb.egov.cases.focal.business;


import javax.ejb.CreateException;
import com.idega.business.IBOHomeImpl;

public class FocalCasesIntegrationHomeImpl extends IBOHomeImpl implements FocalCasesIntegrationHome {
	public Class getBeanInterfaceClass() {
		return FocalCasesIntegration.class;
	}

	public FocalCasesIntegration create() throws CreateException {
		return (FocalCasesIntegration) super.createIBO();
	}
}