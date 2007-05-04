package is.idega.idegaweb.egov.cases.focal.business.beans;

/**
 * 
 * Last modified: $Date: 2007/05/04 09:22:19 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public class ProjectData {

	private String project_id;
	private String project_name;
	private String first_party_id;
	private String first_party_name;
	
	public String getFirstPartyId() {
		return first_party_id;
	}
	public void setFirstPartyId(String first_party_id) {
		this.first_party_id = first_party_id;
	}
	public String getFirstPartyName() {
		return first_party_name;
	}
	public void setFirstPartyName(String first_party_name) {
		this.first_party_name = first_party_name;
	}
	public String getProjectId() {
		return project_id;
	}
	public void setProjectId(String project_id) {
		this.project_id = project_id;
	}
	public String getProjectName() {
		return project_name;
	}
	public void setProjectName(String project_name) {
		this.project_name = project_name;
	}
}