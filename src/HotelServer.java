import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class HotelServer {

	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(5050)) {

			System.out.println("Server is running");

			while (true) {

				new HotelThread(serverSocket.accept()).start();
				System.out.println("Client Connected");

			}

		} catch (IOException e) {
			System.out.println("Server Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
