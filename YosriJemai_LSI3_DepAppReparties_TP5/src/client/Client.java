package client;

import object.Operation;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // Define the server's IP address and port
            InetAddress ia = InetAddress.getByName("172.17.0.1");
            InetSocketAddress isa = new InetSocketAddress(ia, 1234);

            Socket client = new Socket();

            client.connect(isa);
            Operation op = new Operation(12,5,'*');

            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();

            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(op);

            ObjectInputStream ois = new ObjectInputStream(is);
            op=(Operation) ois.readObject();
            System.out.println(op.getRes());

        } catch (Exception e) {
            System.out.println("Client: An error occurred - " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}