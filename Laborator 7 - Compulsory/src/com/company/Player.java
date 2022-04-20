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
        StringBuilder word = new StringBuilder();
        for(int i =0;i<extracted.size();i++)
        {
            word.append(extracted.get(i).getLetter());
        }

        if (extracted.isEmpty()) {
            return false;
        }
        
        game.getBoard().addWord(this, word.toString());
        sleep(50);
        return true;
    }
    public void run()
    {
        try {
            submitWord();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
