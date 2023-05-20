package Game;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author eby
 */
public class MyServer {
    //initialize socket and input stream 

    private Socket socket;
    private ServerSocket server;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    // constructor with port 
    public MyServer(int port) {
        // starts server and waits for a connection 
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");
            // takes input from the client socket 
            inputStream = new DataInputStream((socket.getInputStream()));
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException i) {
            JOptionPane.showMessageDialog(null, "Connection Feild !!");
        }
    }

    public DataInputStream getInputStream() {
        return inputStream;
    }

    public DataOutputStream getOutputStream() {
        return outputStream;
    }
    public void closeServer(){
        try {
            if (server!=null) {
                inputStream.close();
                outputStream.close();
                server.close();
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
