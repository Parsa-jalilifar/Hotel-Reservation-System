import java.io.Serializable;

/** @author Parsa Jalilifar */

public abstract class Room implements Serializable {

	private int Room_ID;
	private String Room_type;
	private double Rate;

	public Room() {
		this(0, "", 0.00);
	}

	public Room(int room_id, String room_type, double rate) {

		setRoom_ID(room_id);
		setRoom_type(room_type);
		setRate(rate);

	}

	public String toString() {
		return "Room_ID: " + getRoom_ID() + "\nRoom_Type: " + getRoom_type() + "\nRate: " + getRate();
	}

	// it is responsible to calculate total price after using discount precent if it
	// is less or equal 25%

	public double totalRate(int day, int discountPercent) {
		double total = 0;

		total = getRate() * day;

		if (discountPercent <= 25)
			total = total - (total * discountPercent / 100);

		return total;

	}

	public int getRoom_ID() {
		return Room_ID;
	}

	public void setRoom_ID(int room_ID) {
		Room_ID = room_ID;
	}

	public String getRoom_type() {
		return Room_type;
	}

	public void setRoom_type(String room_type) {
		Room_type = room_type;
	}

	public double getRate() {
		return Rate;
	}

	public void setRate(double rate) {
		Rate = rate;
	}

}

class Single_room extends Room implements Serializable {

	private static double Rate = 100;

	public Single_room(int roomId) {
		super(roomId, "Single", Rate);
	}

}

class Double_room extends Room implements Serializable {

	private static double Rate = 150;

	public Double_room(int roomId) {
		super(roomId, "Double", Rate);
	}
}

class Delux_room extends Room implements Serializable {

	private static double Rate = 200;

	public Delux_room(int roomId) {
		super(roomId, "Delux", Rate);
	}
}

class Pent_house extends Room implements Serializable {

	private static double Rate = 400;

	public Pent_house(int roomId) {
		super(roomId, "Pent_house", Rate);
	}

}