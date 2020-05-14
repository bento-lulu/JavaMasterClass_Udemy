package arraylists;

public class Contact {
	
	private String name;
	private String contact;
	
	public Contact( String name, String contact ) {
		this.name = name;
		this.contact = contact;
	}
	
	public String getName() {
		return name;
	}
	
	public String getContact() {
		return contact;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Contact && ((Contact)obj).getName().equalsIgnoreCase(name) ) {
			return true;
		}
		return false;
	}
}
