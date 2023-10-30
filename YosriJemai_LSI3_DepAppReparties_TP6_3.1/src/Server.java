import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {
    public static void main(String[] args) {
        int ord = 0 ;

        try {

            ServerSocket socketServeur = new ServerSocket(1234);
            System.out.println(" Le serveur attend la connexion d'un client ");
            while(true){
                Socket socket = socketServeur.accept();
                System.out.println(" un client est connecte ");
                ClientProcess client = new ClientProcess(socket, ++ord);

                client.start();

                //socket.close();

            }
        } catch (IOException e) {
            e.getMessage();
        }

    }

}
