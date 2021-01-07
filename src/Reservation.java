import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {

	private int Book_ID;
	private Date Book_date;
	private Date Check_in;
	private Date Check_out;

	public Reservation() {
		Book_ID = 0;
		Book_date = null;
		Check_in = null;
		Check_out = null;
	}

	public Reservation(int book_ID, Date book_date) {

		setBook_ID(book_ID);
		setBook_date(book_date);

	}

	public String toString() {

		return "Book_ID: " + getBook_ID() + "\nBook_date: " + getBook_date();

	}

	public int getBook_ID() {
		return Book_ID;
	}

	public void setBook_ID(int book_ID) {
		Book_ID = book_ID;
	}

	public Date getBook_date() {
		return Book_date;
	}

	public void setBook_date(Date book_date) {
		Book_date = book_date;
	}

	public Date getCheck_in() {
		return Check_in;
	}

	public void setCheck_in(Date check_in) {
		Check_in = check_in;
	}

	public Date getCheck_out() {
		return Check_out;
	}

	public void setCheck_out(Date check_out) {
		Check_out = check_out;
	}

}
