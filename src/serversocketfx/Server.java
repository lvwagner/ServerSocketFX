package serversocketfx;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author wagner
 */
public class Server implements Runnable {

    static ArrayList<Socket> clientOutPut;
    Socket socket;
    Thread trd;

    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, "Servidor on-line");
        clientOutPut = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(2222);
            while (true) {
                Socket clientsocket = serverSocket.accept();
                trd = new Thread(new HandlerCLient(clientOutPut, clientsocket));
                clientOutPut.add(clientsocket);
                trd.start();
//                clientOutPut.get(0).getInputStream().toString();
            }
        } catch (Exception e) {
            System.out.println("Não foi possível inicializar o servidor.");
            e.printStackTrace();
        }
    }
}
