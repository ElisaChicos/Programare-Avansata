package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<String> words= new ArrayList<>();

    public Board() {
    }

    public List<String> getWords() {
        return words;
    }

    public void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }
    @Override
    public String toString() {
        return words.toString();
    }

}
