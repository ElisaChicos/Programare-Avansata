package com.company;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.List;

class ClientThread extends Thread {
    private final Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            System.out.println("Connected");
            while (true) {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                String message = "Available comands: 1. register name  2. login name  3. friend name1 name2 ... namek  4. send message  5. read  6. exit  7. stop Command: ";
                out.println(message);
                out.flush();

                String request = in.readLine();
                StringBuilder response = new StringBuilder();

                if (request.contains("exit")) {
                    response.append("Goodbye");
                } else if (request.contains("stop")) {
                    response.append("Server stopped");
                } else if (!request.contains("exit") && !request.contains("stop") &&
                        !request.contains("register") && !request.contains("login") &&
                        !request.contains("friends") && !request.contains("send") && !request.contains("read")) {
                    response.append("Unrecognized command.");
                } else {
                    response.append("Server received the request: ");
                    response.append(request);
                    response.append(".");
                }


                if (request.contains("register")) {
                    List<String> params = Arrays.asList(request.split(" "));
                    FileReader fr = new FileReader("register.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    int ex = 0;
                    while ((line = br.readLine()) != null) {
                        if (line.equals(params.get(1))) {

                            response.append("This name already exists.");
                            ex = 1;
                        }
                    }
                    fr.close();
                    if (ex == 0) {
                        FileWriter fw = new FileWriter("register.txt", true);
                        fw.write(params.get(1) + "\n");
                        fw.close();
                        response.append("Added");
                    }
                }

                if (request.contains("login")) {
                    List<String> params = Arrays.asList(request.split(" "));
                    FileReader fr = new FileReader("register.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.equals(params.get(1))) {

                            response.append("Logged!");
                        }
                    }
                    fr.close();
                }






                out.println(response.toString());
                out.flush();

                if (request.equals("exit")) {
                    break;
                } else if (request.equals("stop")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}