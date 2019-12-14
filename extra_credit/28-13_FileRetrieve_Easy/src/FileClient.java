/*
Name: Addison Armstrong
Project Name: 28-13_FileRetrieve_Easy
Project Class: FileClient
Description: Makes the connection between the client and the server, then will ask for a file name to send to the server
 */

// Importing all newtween java tools
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * FileClient class that creates the client side of the project
 */
public class FileClient {
    // Global variables socket and readIn
    private static Socket socket = null;
    Scanner readIn = new Scanner(System.in);

    // Constructor
    public FileClient(){

        // Infinite loop to keep asking for the file name
        while(true) {
            // Trys to make connection and get file name
            try {
                // Getting address and make new socket
                InetAddress address = InetAddress.getByName("localhost");
                socket = new Socket(address, 5000);

                // Initializing the output/input Streams, writers, and bufferwriter/reader
                OutputStream output = socket.getOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(output);
                BufferedWriter buffer = new BufferedWriter(writer);
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputReader = new InputStreamReader(inputStream);
                BufferedReader buffRead = new BufferedReader(inputReader);

                // Asking user for the file name, then reading it in to fileName, then sending it to the Server
                System.out.println("Client: Type in the file path you would like to get access to. ");
                System.out.print("Client: ");
                String fileName = readIn.next();
                String sendMessage = fileName + "\n";
                buffer.write(sendMessage);
                buffer.flush();

                // Prints off what the server sent back
                System.out.println("Server: " + buffRead.readLine());
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                // After program is done, close socket
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
