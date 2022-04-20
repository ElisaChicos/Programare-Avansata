package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> letters = new ArrayList<>();

    Random rand = new Random();

    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
           letters.add(new Tile(c,rand.nextInt(11)));

        }
        System.out.println(letters.size());
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
