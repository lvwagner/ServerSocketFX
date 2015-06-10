/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocketfx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wagner
 */
public class HandlerCLient implements Runnable {

    ArrayList<Socket> clientsOutPut;
    Socket socket;

    public HandlerCLient(ArrayList<Socket> clientsOutPut, Socket socket) {
        this.clientsOutPut = clientsOutPut;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String msg = reader.readLine();
                for (Socket socket : clientsOutPut) {
                    PrintWriter writter = new PrintWriter(socket.getOutputStream(), true);
                    writter.println(msg);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(HandlerCLient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
