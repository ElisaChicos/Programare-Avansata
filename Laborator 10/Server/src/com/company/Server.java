package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {
    public static final int PORT = 8100;

    public Server() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
                User user1 = new User();
                user1.setAdress(socket.getLocalAddress().getHostAddress());

                socket.setSoTimeout(100 * 1000);

            }

        } catch (SocketTimeoutException e) {
            System.out.println("Disconnected");
        }
    }
}
