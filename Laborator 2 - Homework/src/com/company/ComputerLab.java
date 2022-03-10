package com.company;

public class ComputerLab extends Room {
    private String OperatingSistem;
    /*
        Constructorul clasei ComputerLab
        @param name numele laboratorului
        @param capacity capacitatea laboratorului
        @parm operatinsSistem sistemul de operare care exista pe computerele din laborator
        @see ComputerLab
     */
    public ComputerLab(String name, int capacity, String operatingSistem) {
        super(name, capacity);
        OperatingSistem = operatingSistem;
    }

    /*
        Getterul variabilei OperatingSistem
        @returns un String cu numele sistemului de operare disponibil in laborator
        @see ComputerLab
     */
    public String getOperatingSistem() {
        return OperatingSistem;
    }

    /*
        Setterul variabilei OperatingSistem
        @param operatingSistem numele sistemului de operare(Linux,Windows)
        @see ComputerLab
     */
    public void setOperatingSistem(String operatingSistem) {
        OperatingSistem = operatingSistem;
    }
}
