import java.io.Serializable;

public class Bill implements Serializable {

	private int Bill_ID;
	private double Amount_toPay;

	public Bill() {
		this(0, 0.00);
	}

	public Bill(int bill_ID, double amount_toPay) {

		setBill_ID(bill_ID);
		setAmount_toPay(amount_toPay);

	}

	public String toString() {

		return "Bill_ID" + getBill_ID() + "\nAmount_toPay" + getAmount_toPay();

	}

	public int getBill_ID() {
		return Bill_ID;
	}

	public void setBill_ID(int bill_ID) {
		this.Bill_ID = bill_ID;
	}

	public double getAmount_toPay() {
		return Amount_toPay;
	}

	public void setAmount_toPay(double amount_toPay) {
		this.Amount_toPay = amount_toPay;
	}

}
