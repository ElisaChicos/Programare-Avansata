package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;

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

    private boolean submitWord() throws InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
//        create a word with all the extracted tiles;

        String word = "" ;
        game.getBoard().addWord(this, word);
        sleep(50);
        return true;
    }
    public void run()
    {

    }
}
