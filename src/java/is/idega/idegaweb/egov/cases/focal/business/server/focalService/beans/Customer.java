package is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans;

/**
 * 
 * Bean corresponding to Customer element in focal Customer xml.
 * 
 * Last modified: $Date: 2007/05/29 07:54:51 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public class Customer {
	
	private String name;
	private String avarp;
	private String title;
	private String department;
	private String contactseperator;
	private String emailaddress;
	private String homepage;
	private String language;
	private String address1;
	private String address2;
	private String postaddress;
	private String county;
	private String Country;
	private String status;
	private String phonework;
	private String phoneoffice;
	private String gsm;
	private String carphone;
	private String fax;
	private String faxoffice;
	private String beeper;
	private String phonehome;
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAvarp() {
		return avarp;
	}
	public void setAvarp(String avarp) {
		this.avarp = avarp;
	}
	public String getBeeper() {
		return beeper;
	}
	public void setBeeper(String beeper) {
		this.beeper = beeper;
	}
	public String getCarphone() {
		return carphone;
	}
	public void setCarphone(String carphone) {
		this.carphone = carphone;
	}
	public String getContactseperator() {
		return contactseperator;
	}
	public void setContactseperator(String contactseperator) {
		this.contactseperator = contactseperator;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getFaxoffice() {
		return faxoffice;
	}
	public void setFaxoffice(String faxoffice) {
		this.faxoffice = faxoffice;
	}
	public String getGsm() {
		return gsm;
	}
	public void setGsm(String gsm) {
		this.gsm = gsm;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonehome() {
		return phonehome;
	}
	public void setPhonehome(String phonehome) {
		this.phonehome = phonehome;
	}
	public String getPhoneoffice() {
		return phoneoffice;
	}
	public void setPhoneoffice(String phoneoffice) {
		this.phoneoffice = phoneoffice;
	}
	public String getPhonework() {
		return phonework;
	}
	public void setPhonework(String phonework) {
		this.phonework = phonework;
	}
	public String getPostaddress() {
		return postaddress;
	}
	public void setPostaddress(String postaddress) {
		this.postaddress = postaddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}