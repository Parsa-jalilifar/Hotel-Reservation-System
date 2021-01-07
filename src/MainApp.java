
/** @author Parsa Jalilifar */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws IOException {

		// This array list is responsible to store ids and passwords of admins

		ArrayList<Login> admins = new ArrayList<Login>();

		admins.add(new Login(1234, "admin1"));
		admins.add(new Login(9876, "admin2"));

		// Receiving id and pass from user and then checking it if id and pass are match
		// to give access to user

		Login l = null;
		Scanner input = new Scanner(System.in);

		do {

			System.out.println("Hotel Reservation System");
			System.out.print("User Id: ");
			int id = input.nextInt();
			System.out.print("User password: ");
			String pass = input.next();

			l = new Login(id, pass);

		} while (checkAdmin(admins, l).equals("false"));

		ArrayList<Guest> hotelGuest = new ArrayList<Guest>();
		ArrayList<Reservation> hotelReservation = new ArrayList<Reservation>();
		ArrayList<Bill> hotelBills = new ArrayList<Bill>();
		ArrayList<Integer> guestStayingDuration = new ArrayList<Integer>();

		ArrayList<Room> HotelRooms = new ArrayList<Room>();

		// adding single rooms
		for (int i = 0; i < 6; i++)
			HotelRooms.add(new Single_room(CreateIdNumber()));

		// adding double rooms
		for (int i = 0; i < 5; i++)
			HotelRooms.add(new Double_room(CreateIdNumber()));

		// adding Delux rooms
		for (int i = 0; i < 3; i++)
			HotelRooms.add(new Delux_room(CreateIdNumber()));

		// adding pent house
		HotelRooms.add(new Pent_house(CreateIdNumber()));

		ArrayList<Room> reservedRooms = new ArrayList<Room>();
		ArrayList<Integer> numOfRoomReservedByEachGuest = new ArrayList<Integer>();

		
		
		
		
		
		int choice = 0;

		do {

			// Menu

			System.out.println(
					"\nHotel Reservation System\n[1] Book a room\n[2] Bill service\n[3] Current bookings\n[4] Available rooms\n[5] Exit");

			System.out.print("\nPlease enter your choice> ");
			choice = input.nextInt();

			switch (choice) {

			case 1:

				System.out.println("\nHotel Reservation System");
				System.out.print("No of guests: ");
				int guestNumber = input.nextInt();

				// Showing room option according number of guest

				String info = "Show the room available for the guests: ";
				if (guestNumber > 0 && guestNumber < 3)
					info += "One single room";
				else if (guestNumber > 2 && guestNumber < 4)
					info += "One double room or two single rooms";
				else
					info += "Multiple Double or combination of Double and single rooms";
				System.out.println(info);

				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Choose the room type: ");
				String roomType = reader.readLine();

				// making room just by adding the type of room

				double total_rate = 0;

				ArrayList<Room> r = new ArrayList<Room>();

				if (roomType.equalsIgnoreCase("S")) {

					for (int i = 0; i < ((guestNumber + 1) / 2); ++i) {
						for (Room room : HotelRooms) {
							if (room.getRoom_type().equals("Single")) {
								reservedRooms.add(room);
								r.add(room);
								total_rate += room.getRate();
								HotelRooms.remove(room);
								break;
							}
						}
					}

				} else if (roomType.equalsIgnoreCase("D")) {
					if (guestNumber > 4) {
						for (int i = 0; i < ((guestNumber - 1) / 2); ++i) {
							for (Room room : HotelRooms) {
								if (room.getRoom_type().equals("Double")) {
									reservedRooms.add(room);
									r.add(room);
									total_rate += room.getRate();
									HotelRooms.remove(room);
									break;
								}

							}
						}
					} else {
						for (Room room : HotelRooms) {
							if (room.getRoom_type().equals("Double")) {
								reservedRooms.add(room);
								r.add(room);
								total_rate += room.getRate();
								HotelRooms.remove(room);
								break;
							}

						}
					}

				}

				numOfRoomReservedByEachGuest.add(r.size());

				System.out.print("No of days to be booked for: ");
				int noOfDays = input.nextInt();

				guestStayingDuration.add(noOfDays);
				System.out.println("Rate to be offered /day: " + total_rate);

				// guest information

				System.out.println("\nHotel Reservation System");
				System.out.print("Title: ");
				String title = input.next();
				System.out.print("First Name: ");
				String fName = input.next();
				System.out.print("Last Name: ");
				String lName = input.next();
				System.out.print("Address: ");
				String address = input.next();
				System.out.print("Phone: ");
				long phone = input.nextLong();
				String email = "";
				do {
					System.out.print("Email: ");
					email = input.next();
				} while (!email.contains("@") || !email.contains(".com"));

				Guest g1 = new Guest(CreateGuestIdNumber(), title, fName, lName, address, phone, email);
				hotelGuest.add(g1);

//				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date bookDate = new Date();
				Reservation res1 = new Reservation(CreateBookIdNumber(), bookDate);
				hotelReservation.add(res1);

				break;
			case 2:
				System.out.println("\nHotel Reservation System");

				// entering book_id again and again to enter correct book id
				int bookId = 0;

				do {

					System.out.print("Enter Booking ID: ");
					bookId = input.nextInt();

				} while (!checkBookId(hotelReservation, bookId));

				System.out.println("\nHotel Reservation System");
				System.out.println("Booking ID: " + bookId);

				double pay = 0;

				for (int j = 0; j < hotelReservation.size(); j++) {

					if (hotelReservation.get(j).getBook_ID() == bookId) {

						System.out.println("Guest Name: " + hotelGuest.get(j).getFirst_name() + " "
								+ hotelGuest.get(j).getLast_name());
						System.out.println("No of rooms booked: " + numOfRoomReservedByEachGuest.get(j));
						System.out.println("Type of rooms: " + reservedRooms.get(j).getRoom_type());
						System.out.println("Rate per night: " + reservedRooms.get(j).getRate());
						System.out.print("Discounts(5-25): % ");
						int discount = input.nextInt();
						pay = reservedRooms.get(j).totalRate(guestStayingDuration.get(j), discount);
						System.out.print("Total Amount:" + pay + "\n");
					}

				}

				Bill b = new Bill(CreateBillIdNumber(), pay);
				hotelBills.add(b);

				break;
			case 3:

				System.out.println("\nHotel Reservation System");
				System.out.println("No of current bookings are: " + hotelReservation.size() + "\n");

				System.out.println("Booking#    Customer Name         Room Type     No of Rooms     No of Days");

				for (int i = 0; i < hotelReservation.size(); i++) {
					System.out.println(hotelReservation.get(i).getBook_ID()
							+ space(digitCalcuter(hotelReservation.get(i).getBook_ID()), 12)
							+ hotelGuest.get(i).getFirst_name() + " " + hotelGuest.get(i).getLast_name()
							+ space((hotelGuest.get(i).getFirst_name().length()
									+ hotelGuest.get(i).getLast_name().length() + 1), 22)
							+ reservedRooms.get(i).getRoom_type()
							+ space(reservedRooms.get(i).getRoom_type().length(), 14)
							+ numOfRoomReservedByEachGuest.get(i)
							+ space(digitCalcuter(numOfRoomReservedByEachGuest.get(i)), 16)
							+ guestStayingDuration.get(i));

				}

				break;
			case 4:

				System.out.println("\nHotel Reservation System");
				System.out.println("No of Available rooms: " + HotelRooms.size());

				System.out.println("\nRoom ID	  Room Type ");
				for (Room room : HotelRooms)
					System.out.println(room.getRoom_ID() + "	  " + room.getRoom_type());

				break;

			}

		} while (choice != 5);

		input.close();

	}

	// Check admin authorization

	public static String checkAdmin(ArrayList<Login> admins, Login l) {

		String status = "false";

		for (Login a : admins)
			if (a.getLogin_ID() == l.getLogin_ID() && a.getLogin_pswd().equals(l.getLogin_pswd()))
				status = "true";

		return status;
	}

	// Check book id in side of reservation object

	private static boolean checkBookId(ArrayList<Reservation> res, int book_Id) {

		Boolean status = false;

		for (Reservation r : res)
			if (r.getBook_ID() == book_Id)
				status = true;

		return status;
	}

	// Calculating a unique number for our rooms

	private static int roomIdCounter = 1;

	public static int CreateIdNumber() {
		return roomIdCounter++;
	}

	// Calculating a unique number for each guest

	private static int guestIdCounter = 1;

	public static int CreateGuestIdNumber() {
		return guestIdCounter++;
	}

	// Calculating a unique number for each Book

	private static int bookIdCounter = 1;

	public static int CreateBookIdNumber() {
		return bookIdCounter++;
	}

	// Calculating a unique number for each Bill

	private static int billIdCounter = 1;

	public static int CreateBillIdNumber() {
		return billIdCounter++;
	}

	// Calculating number of digits

	public static int digitCalcuter(int num) {
		int count = 0;

		while (num != 0) {
			num /= 10;
			++count;

		}
		return count;
	}

	// Calculating number of spaces

	public static String space(int sizeOfWord, int width) {

		int space = width - sizeOfWord;
		String str = "";

		for (int i = 0; i < space; i++) {
			str += " ";
		}

		return str;
	}
}