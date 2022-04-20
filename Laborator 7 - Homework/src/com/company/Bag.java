package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> letters = new ArrayList<>();

    Random rand = new Random();

    public Bag() {
        for(int i =0;i<9;i++)
        {
            letters.add(new Tile('a',1));
            letters.add(new Tile('i',1));
        }
        for(int i =0;i<2;i++)
        {
            letters.add(new Tile('b',3));
            letters.add(new Tile('c',3));
            letters.add(new Tile('f',4));
            letters.add(new Tile('h',4));
            letters.add(new Tile('m',3));
            letters.add(new Tile('p',3));
            letters.add(new Tile('v',4));
            letters.add(new Tile('w',4));
            letters.add(new Tile('y',4));
        }
        for(int i =0;i<4;i++)
        {
            letters.add(new Tile('d',2));
            letters.add(new Tile('l',1));
            letters.add(new Tile('s',1));
            letters.add(new Tile('u',1));
        }
        for(int i =0;i<12;i++)
        {
            letters.add(new Tile('e',1));
        }
        for(int i =0;i<3;i++)
        {
            letters.add(new Tile('g',2));

        }
        letters.add(new Tile('j',8));
        letters.add(new Tile('k',5));
        letters.add(new Tile('q',10));
        letters.add(new Tile('x',8));
        letters.add(new Tile('z',10));
        for(int i =0;i<6;i++)
        {
            letters.add(new Tile('n',1));
            letters.add(new Tile('r',1));
            letters.add(new Tile('t',1));
        }
        for(int i =0;i<8;i++)
        {
            letters.add(new Tile('o',1));
        }
    }

    public List<Tile> getBag() {
        return letters;
    }

    public List<Tile> getLetters() {
        return letters;
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            int random = rand.nextInt(letters.size());
            extracted.add(letters.get(random));
            letters.remove(letters.get(random));
        }
        return extracted;
    }

}
