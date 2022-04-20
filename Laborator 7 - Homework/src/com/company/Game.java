package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();

    public Game() {
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() throws InterruptedException {
        while (bag.getLetters().size() != 0) {
            new Thread(players.get(0)).start();
            new Thread(players.get(1)).start();
            new Thread(players.get(2)).start();
        }
        sleep(500);
        int score = 0;
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getScore() > score) {
                score = player.getScore();
                winner = player;
            }
        }
        System.out.println("The winner is " + winner.getName() + " with the score:" + score);
    }
}
