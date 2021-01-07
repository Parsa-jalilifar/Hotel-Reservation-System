import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HotelClient {

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 5050)) {

            // sending and receiving objs
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // sending and receiving strings
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            /***** Login Phase ******/

            Scanner scan = new Scanner(System.in);

            String loginResponse = "";
            Login l = null;

            do {
                System.out.println("Hotel Reservation System");
                System.out.print("User Id: ");
                int id = scan.nextInt();
                System.out.print("User password: ");
                String pass = scan.next();
                l = new Login(id, pass);

                out.writeObject(l);
                loginResponse = input.readLine().toString();
                System.out.println(loginResponse);

            } while (loginResponse.equals("false"));

            System.out.println("\nlogin successful");

        } catch (IOException e) {
            System.out.println("Error from client " + e.getMessage());
            e.printStackTrace();
        }

    }

}
