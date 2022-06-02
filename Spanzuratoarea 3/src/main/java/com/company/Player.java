package com.company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
   private String name;
   private Game game;
   private Integer id;
   private String cuvant;
   private String litera;
   private String tabel;

    public String getTabel() {
        return tabel;
    }

    public void setTabel(String tabel) {
        this.tabel = tabel;
    }

    public Player(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getCuvant() {
        return cuvant;
    }

    public void setCuvant(String cuvant) {
        this.cuvant = cuvant;
    }

    public String getLitera() {
        return litera;
    }

    public void setLitera(String litera) {
        this.litera = litera;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public synchronized List<Integer> cautareLitera() {
        List<Integer> list = new ArrayList<>();
        char[] c = this.getCuvant().toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == this.getLitera().charAt(0)) {
                list.add(i);
            }
        }
        return list;
    }
    public String generareCuvant() throws SQLException {
        var categorii = new CategoriesDao();
        int idMax = categorii.idMaxim(this.getTabel());
        Random rand = new Random();
        int idRandom = rand.nextInt(idMax);
        return categorii.findById(idRandom, this.getTabel());

    }

    @Override
    public void run() {
        try {
            boolean isRunning = true;
            while(isRunning)
            {
                generareCuvant();
                isRunning = false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
