package is.idega.idegaweb.egov.cases.focal.business.beans;

/**
 * 
 * Last modified: $Date: 2007/06/20 14:07:15 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.2 $
 */
public class Status {
	
	public static final int success 				= 0;
	public static final int unknown_fail 			= 1;
	public static final int no_customer 			= 2;
	public static final int no_projects 			= 3;
	public static final int failed_to_save 			= 6;
	
	/*
	 * "1" = Error with getting a support document. A more detailed error message comes within "errorText"
		"2" =  errorText = "Error: User does not have access to use this webservice"
		"3" = errorText = "Error: Database was not found on "| + strServer + | " - " |  + strPath +|"|
		"6" = errorText = " Error: The saving of a document in the document system was not successful" + Cstr(Err) + "   -   " + Error  (A more detailed explanation comes why saving was not successful)
		"0" = OK, no errorText sent with
		"100" = errorText = "Error  " + Cstr(Err) + "   -   " + Error   (These are errors that I can not forsee, and therefore here come direct error messages from Notes in errorText) 
	 */
	
	private int status = -1;
	
	public Status(int status) {
		
		if(status < 0 || (status > 3 && status != 6))
			throw new RuntimeException("Value not supported: "+status);
		
		this.status = status;
	}
	
	public Integer getStatus() {
		
		return new Integer(status);
	}
}