import java.io.Serializable;

/** @author Parsa Jalilifar */

public class Login implements Serializable {

	private int Login_ID;
	private String Login_pswd;

	// Default constructor

	public Login() {

		this(0, "");

	}

	// Constructor with two arguments

	public Login(int id, String pswd) {

		setLogin_ID(id);
		setLogin_pswd(pswd);

	}

	// Displaying ids and passwords of admins

	public String toString() {

		return "Login_ID: " + getLogin_ID() + "\n" + "Login_pswd: " + getLogin_pswd();

	}

	// Returning id

	public int getLogin_ID() {

		return Login_ID;

	}

	// Setting id

	public void setLogin_ID(int login_ID) {

		this.Login_ID = login_ID;

	}

	// Returning password

	public String getLogin_pswd() {

		return Login_pswd;

	}

	// Setting password

	public void setLogin_pswd(String login_pswd) {

		this.Login_pswd = login_pswd;

	}

	/**
	 * Overriding equals method
	 */

	public boolean equals(Object a) {

		if (a instanceof Login && a != null) {

			Login l = (Login) a;

			if (Login_ID != 0 || Login_pswd != null) {
				if (Login_ID == l.getLogin_ID() && Login_pswd.equalsIgnoreCase(l.getLogin_pswd()))
					return true;

			} else {
				return false;
			}
		}

		return false;
	}


}
