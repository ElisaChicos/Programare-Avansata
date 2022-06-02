package com.company;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final List<Player> players = new ArrayList<>();

    public Game()
    {

    }

    public void play()
    {
        while (true) {
            new Thread(players.get(0)).start();
            new Thread(players.get(1)).start();
            new Thread(players.get(2)).start();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void adaugareCategoriePlante() throws IOException, SQLException {
        var categoryDao = new CategoriesDao();
        File file = new File("plante.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int index = 0;

        while ((line = br.readLine()) != null) {
            Categories category = new Categories(index, line);
            index++;
            categoryDao.addtoPlante(category);
            Database.getConnection().commit();
        }
    }

    public void adaugareCategorieAnimale() throws IOException, SQLException {
        var categoryDao = new CategoriesDao();
        File file = new File("animale.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int index = 0;

        while ((line = br.readLine()) != null) {
            Categories category = new Categories(index, line);
            index++;
            categoryDao.addtoAnimale(category);
            Database.getConnection().commit();
        }
    }

    public void adaugareCategorieGeografie() throws IOException, SQLException {
        var categoryDao = new CategoriesDao();
        File file = new File("geografie.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int index = 0;

        while ((line = br.readLine()) != null) {
            Categories category = new Categories(index, line);
            index++;
            categoryDao.addtoGeografie(category);
            Database.getConnection().commit();
        }
    }

    public void adaugareCategorieIstorie() throws IOException, SQLException {
        var categoryDao = new CategoriesDao();
        File file = new File("istorie.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int index = 0;

        while ((line = br.readLine()) != null) {
            Categories category = new Categories(index, line);
            index++;
            categoryDao.addtoIstorie(category);
            Database.getConnection().commit();
        }
    }

    public void adaugareCategorieLiteratura() throws IOException, SQLException {
        var categoryDao = new CategoriesDao();
        File file = new File("literatura.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int index = 0;

        while ((line = br.readLine()) != null) {
            Categories category = new Categories(index, line);
            index++;
            categoryDao.addtoLiteratura(category);
            Database.getConnection().commit();
        }
    }

    public void adaugareCategorieMedicina() throws IOException, SQLException {
        var categoryDao = new CategoriesDao();
        File file = new File("medicina.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int index = 0;

        while ((line = br.readLine()) != null) {
            Categories category = new Categories(index, line);
            index++;
            categoryDao.addtoMedicina(category);
            Database.getConnection().commit();
        }
    }





}