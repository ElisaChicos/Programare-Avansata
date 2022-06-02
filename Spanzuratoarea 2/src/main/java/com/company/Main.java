package com.company;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        Game game = new Game();
        game.addPlayer(new Player("Player 1",1));
        game.addPlayer(new Player("Player 2",2));

        game.adaugareCategoriePlante();
        game.adaugareCategorieIstorie();
        game.adaugareCategorieAnimale();
        game.adaugareCategorieGeografie();
        game.adaugareCategorieMedicina();
        game.adaugareCategorieLiteratura();
        game.play();


//        Database.getConnection().close();

    }
}
