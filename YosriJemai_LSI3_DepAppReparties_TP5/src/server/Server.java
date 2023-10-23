package server;

import object.Operation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1234)) {
            Socket clientSocket = ss.accept();

            InputStream input = clientSocket.getInputStream();
            ObjectInputStream oi = new ObjectInputStream(input);


            Operation op = (Operation) oi.readObject();

            int nb1 = op.getNb1();
            int nb2 = op.getNb2();
            char ops = op.getOp();

            int res = 0;

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
            }

            // result in the Operation object
            op.setRes(res);

            // Set up output stream to send the modified Operation object
            OutputStream output = clientSocket.getOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(output);

            oo.writeObject(op);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}