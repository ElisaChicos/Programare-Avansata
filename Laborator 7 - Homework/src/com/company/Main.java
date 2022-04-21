package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.addPlayer(new Player("Player 1",1));
        game.addPlayer(new Player("Player 2",2));
        game.addPlayer(new Player("Player 3",3));
        game.play();
    }
}
