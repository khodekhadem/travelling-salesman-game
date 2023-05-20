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
public class MyClient {

    // initialize socket and input output streams 
    private Socket socket = null;
    private DataInputStream inputStream = null;
    private DataOutputStream outputStream = null;

    public MyClient(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            JOptionPane.showMessageDialog(null, "Connection Feild !!");
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
    
    public void closeClient(){
        try {
            if (socket!=null) {
                inputStream.close();
                outputStream.close();
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
