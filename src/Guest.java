import java.io.Serializable;

public class Guest implements Serializable {

	private int Guest_ID;
	private String Title;
	private String First_name;
	private String Last_name;
	private String Address;
	private long Phone;
	private String Email;

	public Guest() {

		this(0, "", "", "", "", 0, "");

	}

	public Guest(int id, String title, String first_name, String last_name, String address, long phone, String email) {

		setGuest_ID(id);
		setTitle(title);
		setFirst_name(first_name);
		setLast_name(last_name);
		setAddress(address);
		setPhone(phone);
		setEmail(email);

	}

	public String toString() {
		return "Guest_ID: " + getGuest_ID() + "\nTitle: " + getTitle() + "\nFirst Name: " + getFirst_name()
				+ "\nLast Name: " + getLast_name() + "\nAddress: " + getAddress() + "\nPhone: " + getPhone()
				+ "\nEmail: " + getEmail();
	}

	public int getGuest_ID() {
		return Guest_ID;
	}

	public void setGuest_ID(int guest_ID) {
		this.Guest_ID = guest_ID;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		this.First_name = first_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		this.Last_name = last_name;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public long getPhone() {
		return Phone;
	}

	public void setPhone(long phone) {
		this.Phone = phone;
	}

}
