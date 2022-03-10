package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.homework();
    }

    void homework() {
        Room[] rooms = new Room[2];
        rooms[0]=new ComputerLab("405",30,"Linux");
        rooms[1]=new LectureHall("309",100,true);
    }
}

