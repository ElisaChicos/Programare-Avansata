package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8100;

    public Server(){
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
//                socket.setSoTimeout(10);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
