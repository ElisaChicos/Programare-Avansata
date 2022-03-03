package com.company;

public class Event {
    private String name;
    private int size, end, start;

    public Event(String name, int size, int end, int start) {
        this.name = name;
        this.size = size;
        this.end = end;
        this.start = start;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", end=" + end +
                ", start=" + start +
                '}';
    }
}
