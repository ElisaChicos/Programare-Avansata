//package com.company;

public class Streets implements Comparable<Streets> {
    private String name;
    private int lenght;
    private String i1, i2;

    public Streets(String name, int lenght, String i1, String i2) {
        this.name = name;
        this.lenght = lenght;
        this.i1 = i1;
        this.i2 = i2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public String getI1() {
        return i1;
    }

    public void setI1(String i1) {
        this.i1 = i1;
    }

    public String getI2() {
        return i2;
    }

    public void setI2(String i2) {
        this.i2 = i2;
    }

    @Override
    public String toString() {
        return "Streets{" +
                "name='" + name + '\'' +
                ", lenght=" + lenght +
                ", i1=" + i1 +
                ", i2=" + i2 +
                "}\n";
    }
    //comparable
    @Override
    public int compareTo(Streets other) {
        if (this.getName() != null && other.getName() != null)
            return this.name.compareTo(other.name);
        else {
            System.out.println("Null name!");
            return 0;
        }
    }
    //Comparare lungime
    public boolean compareLenght(Streets other) {
        if (this.getLenght() != 0 && other.getLenght() != 0)
            return this.lenght > other.getLenght();
        else {
            System.out.println("Null name!");
            return false;
        }
    }
}