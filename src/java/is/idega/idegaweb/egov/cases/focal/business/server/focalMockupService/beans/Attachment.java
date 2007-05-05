package is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.beans;

/**
 * 
 * <p>Currently file is transfered in soap envelope using base64. That's not too efficient, but whole lot simpler.
 * If this becomes an issue (e.g. there are lots of files transfered occasionally or they are big), 
 * try to implement it in effective way.
 * </p> 
 * @see http://www.mail-archive.com/axis-user@xml.apache.org/msg08732/Fear_of_Attachments.pdf
 * 
 * Last modified: $Date: 2007/05/05 15:19:08 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.2 $
 */
public class Attachment {

	public String getFName() { return null; }
	public void setFName(String f_name) { }
	public byte[] getFile() { return null; }
	public void setFile(byte[] file) { }
	public long getFileSize() { return 0; }
	public void setFileSize(long file_size) { }
}