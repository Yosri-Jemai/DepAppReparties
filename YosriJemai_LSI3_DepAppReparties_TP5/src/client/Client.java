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
            InetAddress serverAddress = InetAddress.getByName("192.168.199.207");
            InetSocketAddress serverSocketAddress = new InetSocketAddress(serverAddress, 1234);

            Socket clientSocket = new Socket();

            clientSocket.connect(serverSocketAddress);

        } catch (Exception e) {
            System.out.println("Client: An error occurred - " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}