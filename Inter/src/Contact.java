
public class Contact implements ContactInfo{

	private String name;
	private String phoneNumber;
	private String email;
	
	// These are the constructors 
	public Contact(String name, String phoneNumber, String email){
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		
	}
	
	public Contact(ContactInfo contactInfo) {
		this.name = contactInfo.getName();
		this.phoneNumber = contactInfo.getPhoneNumber();
		this.email = contactInfo.getEmailAddress();
	}
	// These are the methods implemented by the interface 
	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return email;
	}
}
