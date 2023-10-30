
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost",500);
        System.out.println("Je suis connecté");

        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();

        ObjectInputStream ois = new ObjectInputStream(is);
        ObjectOutputStream oos = new ObjectOutputStream(os);

        Operation op = new Operation(5,3,'+');
        oos.writeObject(op);

        op = (Operation) ois.readObject();

        System.out.println(op.getRes());
    }
}
