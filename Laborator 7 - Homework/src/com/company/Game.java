package com.company;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();
    private int turn;

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

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
        DaemonThread daemon = new DaemonThread();
        daemon.setDaemon(true);
        daemon.start();
        long startTime = System.nanoTime();
        long start = System.currentTimeMillis();
        long end = start + 30 * 1000;
        turn = players.get(0).getId();

        while (System.currentTimeMillis() < end && bag.getLetters().size() != 0) {
            new Thread(players.get(0)).start();
            new Thread(players.get(1)).start();
            new Thread(players.get(2)).start();
        }

        long stopTime = System.nanoTime();
        int score = 0;
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getScore() > score) {
                score = player.getScore();
                winner = player;
            }
        }
        System.out.println("The winner is " + winner.getName() + " with the score:" + score);
        System.out.println("Time: " + (stopTime - startTime)/1000);
        System.exit(-1);
    }
}
