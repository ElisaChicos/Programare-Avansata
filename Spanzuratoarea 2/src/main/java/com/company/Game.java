package com.company;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

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

    public String generareCuvant(String tabel) throws SQLException {
        var categorii = new CategoriesDao();
        int idMax = categorii.idMaxim(tabel);
        Random rand = new Random();
        int idRandom = rand.nextInt(idMax);
        return categorii.findById(idRandom, tabel);

    }

    public List<Integer> cautareLitera(String litera, String cuvant) {
        List<Integer> list = new ArrayList<>();
        char[] c = cuvant.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == litera.charAt(0)) {
                list.add(i);
            }
        }
        return list;
    }

}
//    private static int turn;
//    private List<Player> players;
//    private List<Square> squares;
//    private Map<Square, Player> positions;
//    private int playingCode;
//
//    public Game() {
//    }
//
//    public Game(List<Player> players, List<Square> squares, Map<Square, Player> positions, int playingCode) {
//        this.turn = 1;
//        this.players = players;
//        this.squares = squares;
//        this.positions = positions;
//        this.playingCode = playingCode;
//    }
//
//    public List<Player> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(List<Player> players) {
//        this.players = players;
//    }
//
//    public Map<Square, Player> getPositions() {
//        return positions;
//    }
//
//    public void setPositions(Map<Square, Player> positions) {
//        this.positions = positions;
//    }
//
//    public List<Square> getSquares() {
//        return squares;
//    }
//
//    public void setSquares(List<Square> squares) {
//        this.squares = squares;
//    }
//
//    public int getPlayingCode() {
//        return playingCode;
//    }
//
//    public void setPlayingCode(int playingCode) {
//        this.playingCode = playingCode;
//    }
//
//    @Override
//    public String toString() {
//        return "Game{" +
//                "players=" + players +
//                ", squares=" + squares +
//                ", positions=" + positions +
//                ", playingCode=" + playingCode +
//                '}';
//    }
