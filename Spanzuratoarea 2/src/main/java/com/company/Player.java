package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
   private String name;
   private Game game;
   private Integer id;

    public Player(String name, Integer id) {
        this.name = name;
        this.id = id;
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

    public synchronized List<Integer> cautareLitera(String litera, String cuvant) {
        List<Integer> list = new ArrayList<>();
        char[] c = cuvant.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == litera.charAt(0)) {
                list.add(i);
            }
        }
        return list;
    }


    @Override
    public void run() {

    }
}
