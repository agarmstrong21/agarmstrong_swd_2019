/*
Name: Addison Armstrong
Project Name: 28-13_FileRetrieve_Easy
Project Class: FileServer
Description: Gets connection from Client and finds the file that the Client asked for, once done, will send back
    contents of file
 */

//Importing Java network tools and Scanners
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Creation of the FileServer Class that finds the file that the client wants
 */
public class FileServer {
    // Global variables Socket and Filein
    private static Socket socket;
    private static Scanner fileIn = null;

    // Constructor
    public FileServer() {
        // Trying to run the logic and make connection to the Socket
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while(true) {
                // Making the Connection
                socket = serverSocket.accept();

                // Initializing the output/input Streams, writers, and bufferwriter/reader
                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputWriter = new OutputStreamWriter(outputStream);
                BufferedWriter buffWrite = new BufferedWriter(outputWriter);
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputReader = new InputStreamReader(inputStream);
                BufferedReader buffRead = new BufferedReader(inputReader);

                // Grabs the message from the Client and reads it
                String fileName = buffRead.readLine();
                System.out.println("Client: " + fileName);
                String returnMessage = "";

                // Attempts to see if it is a valid file
                try {
                    fileIn = new Scanner(new File(fileName));
                    returnMessage = fileIn.nextLine() + "\n";
                } catch(Exception e) {
                    returnMessage = "Invalid File directory.\n";
                }

                // Sends back the contents of the file
                buffWrite.write(returnMessage);
                System.out.println("Client: " + returnMessage);
                buffWrite.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Closes Socket
            try {
                socket.close();
            } catch(Exception e){}
        }
    }
}
