package server;

import object.Operation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1234)) {
            Socket client = ss.accept();

            InputStream is = client.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);


            Operation op = (Operation) ois.readObject();

            int nb1 = op.getNb1();
            int nb2 = op.getNb2();
            char ops = op.getOp();

            int res;

            switch (ops) {
                case '+':
                    res = nb1 + nb2;
                    break;
                case '-':
                    res = nb1 - nb2;
                    break;
                case '*':
                    res = nb1 * nb2;
                    break;
                case '/':
                    res = nb1 / nb2;
                    break;
                default:res=0;
            }

            OutputStream os = client.getOutputStream();

            op.setRes(res);

            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(op);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}