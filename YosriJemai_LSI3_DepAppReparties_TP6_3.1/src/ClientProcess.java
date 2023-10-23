import java.io.IOException;
import java.net.Socket;

public class ClientProcess extends Thread {
    Socket socket;
    int ord = 0;
    public ClientProcess(Socket socket , int ord){
        super();
        this.socket = socket;
        this.ord = ord;
    }


    public void run() {
        System.out.println("Le client est connecté "+socket.getRemoteSocketAddress()+" à l'ordre "+ord);
        try {

            socket.close();
        }
        catch (IOException e)
        {e.getMessage();}
    }


}