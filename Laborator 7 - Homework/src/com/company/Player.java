package com.company;

import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private String name;
    private Game game;
    private final Dictionary dictionary = new Dictionary();
    private boolean running;
    private Integer score = 0;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

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


    public String getName() {
        return name;
    }

    private synchronized boolean submitWord() throws InterruptedException, IOException {

        while (!(game.getTurn() == getId())) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<Tile> extracted = game.getBag().extractTiles(5);
        StringBuilder word = new StringBuilder();
        for (Tile tile : extracted) {
            word.append(tile.getLetter());
        }

        if (extracted.isEmpty()) {
            return false;
        }

        if (dictionary.isWord(word.toString())) {

            sleep(50);

            for (int i = 0; i < word.length(); i++) {
                score = score + extracted.get(i).getPoints();
            }
            game.getBoard().addWord(this, word.toString());
            if (game.getTurn() == 3)
                game.setTurn(1);
            else {
                game.setTurn(game.getTurn() + 1);
            }
            notifyAll();
            return true;

        } else {
            extracted = game.getBag().extractTiles(5);
            if (game.getTurn() == 3)
                game.setTurn(1);
            else {
                game.setTurn(game.getTurn() + 1);
            }
            notifyAll();
        }
        return false;
    }

    public void run() {
        try {
            submitWord();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

}
