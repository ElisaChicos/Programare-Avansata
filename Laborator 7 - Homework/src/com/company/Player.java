package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private String name;
    private Game game;
    private Dictionary dictionary = new Dictionary();
    private boolean running;
    private Integer score = 0;

    public Player(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Player(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    private boolean submitWord() throws InterruptedException, IOException {
        List<Tile> extracted = game.getBag().extractTiles(5);
        StringBuilder word = new StringBuilder();
        for (Tile tile : extracted) {
            word.append(tile.getLetter());
        }

        if (extracted.isEmpty()) {
            return false;
        }

        if(dictionary.isWord(word.toString()))
        {

            sleep(50);

            for(int i =0;i<word.length();i++)
            {
                score = score + extracted.get(i).getPoints();
            }
//            System.out.println(score);
            game.getBoard().addWord(this, word.toString());
            return true;

        }
        else
        {
            extracted = game.getBag().extractTiles(5);
        }
        return false;
    }

    public void run()
    {
        try {
            submitWord();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
