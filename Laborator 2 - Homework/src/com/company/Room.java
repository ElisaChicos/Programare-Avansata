package com.company;

import java.util.Objects;

public abstract class Room {
    protected String name;
    private int capacity;

    /*
        Constructorul clasei Room
        @param name numele salii
        @param capacity capacitatea salii
        @see Room
     */
    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
    /*
        Getterul variabilei name
        @return numele salii
        @see Room
     */
    public String getName() {
        return name;
    }

     /*
        Setterul variabilei name
        @param name numele salii
        @see Room
     */
    public void setName(String name) {
        this.name = name;
    }
    /*
       Getterul variabilei capacity
       @return capacitatea salii
       @see Room
    */
    public int getCapacity() {
        return capacity;
    }
    /*
        Setterul variabilei capacity
        @param capacity capacitatea salii
        @see Room
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

     /*
        Metoda toString returneaza un mesaj care contine toate datele clasei Room
        @return mesaj care contine toate valorile variabilelor clasei
    */
    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return capacity == room.capacity && name.equals(room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity);
    }
}
