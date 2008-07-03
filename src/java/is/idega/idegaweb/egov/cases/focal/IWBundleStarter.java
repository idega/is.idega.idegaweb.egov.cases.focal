package is.idega.idegaweb.egov.cases.focal;

import is.idega.idegaweb.egov.cases.business.CasesBusiness;
import is.idega.idegaweb.egov.cases.util.CasesConstants;

import com.idega.block.process.business.CaseCodeManager;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWBundleStartable;
import com.idega.idegaweb.include.GlobalIncludeManager;

public class IWBundleStarter implements IWBundleStartable {
	
	public static final String IW_BUNDLE_IDENTIFIER = "is.idega.idegaweb.egov.cases.focal";

	public void start(IWBundle starterBundle) {
		GlobalIncludeManager.getInstance().addBundleStyleSheet(IW_BUNDLE_IDENTIFIER, "/style/focal.css");
		CaseCodeManager.getInstance().addCaseBusinessForCode(CasesConstants.CASE_CODE_KEY, CasesBusiness.class);
		registerCaseChangeListener(starterBundle);
	}

	public void stop(IWBundle starterBundle) {
	}
	
	private void registerCaseChangeListener(IWBundle starterBundle) {
	}

}
