package com.company;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        //java -jar C:\Users\Asus\Documents\GitHub\Proiect-TicTacToe\out\artifacts\TicTacToe_jar\TicTacToe.jar
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        Game game = new Game();
        game.adaugareCategoriePlante();
        game.adaugareCategorieIstorie();
        game.adaugareCategorieAnimale();
        game.adaugareCategorieGeografie();
        game.adaugareCategorieMedicina();
        game.adaugareCategorieLiteratura();
//        Database.getConnection().close();

    }
}
