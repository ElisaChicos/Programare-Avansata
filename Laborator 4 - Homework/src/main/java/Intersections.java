//package com.company;
public class Intersections {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intersections(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Intersections{" +
                "name='" + name + '\'' +
                '}';
    }


}