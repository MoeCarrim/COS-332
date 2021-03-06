/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author User
 */
public class TelnetServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException
    {
        final int portNumber = 81;
        System.out.println("Creating server socket on port " + portNumber);
        ServerSocket serverSocket = new ServerSocket(portNumber);
        while (true) 
        {
                Socket socket = serverSocket.accept();
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);
                pw.println("What's you name?");

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = br.readLine();

                pw.println("Hello, " + str);
                pw.close();
                socket.close();

                System.out.println("Just said hello to:" + str);
        }
    }
}
