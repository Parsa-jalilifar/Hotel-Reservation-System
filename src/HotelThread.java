import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class HotelThread extends Thread {

    private Socket socket;

    public HotelThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            // receiving and sending strings
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
//			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // receiving and sending objs
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // This array list is responsible to store ids and passwords of admins
            ArrayList<Login> admins = new ArrayList<Login>();
            admins.add(new Login(1234, "admin1"));
            admins.add(new Login(9876, "admin2"));

            while (true) {

                Login userLoginRequest = (Login) in.readObject();
                output.println(checkAdmin(admins, userLoginRequest));
                output.flush();

            }

        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Server Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Check admin authorization
    public static String checkAdmin(ArrayList<Login> admins, Login l) {

        String status = "false";

        for (Login a : admins)
            if (a.getLogin_ID() == l.getLogin_ID() && a.getLogin_pswd().equals(l.getLogin_pswd()))
                status = "true";
        return status;
    }

}
