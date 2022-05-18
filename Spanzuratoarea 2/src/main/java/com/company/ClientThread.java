package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Random;

class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public String generareCuvant(String tabel) throws SQLException {
        var categorii = new CategoriesDao();
        int idMax = categorii.idMaxim(tabel);
        Random rand = new Random();
        int idRandom = rand.nextInt(idMax);
        return categorii.findById(idRandom, tabel);

    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String table = in.readLine();
            System.out.println(table);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns = generareCuvant(table);
            out.println(raspuns);
            out.flush();
        } catch (IOException | SQLException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
