package com.company;

import java.util.Objects;

public class Event {
    private String name;
    private int size, end, start;

    /*
        Constructoul clase Event
        @param name numele evenimentului(curs sau laborator)
        @param size numarul de studenti care vor participa
        @param start ora la care incepe evenimentul
        @param end ora la care se termina evenimentul
        @see Event
    */
    public Event(String name, int size, int end, int start) {
        this.name = name;
        this.size = size;
        this.end = end;
        this.start = start;
    }

    /*
        Setter al variabilei name
        @param name numele evenimentului
        @see Event
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
        Setter al variabilei size
        @param size numarul de participanti
        @see Event
     */
    public void setSize(int size) {
        this.size = size;
    }

    /*
       Setter al variabilei end
       @param end ora la care se termina evenimentul
       @see Event
    */
    public void setEnd(int end) {
        this.end = end;
    }

    /*
      Setter al variabilei start
      @param start ora la care incepe evenimentul
      @see Event
    */
    public void setStart(int start) {
        this.start = start;
    }

    /*
      Getter al variabilei name
      @return numele evenimentului
      @see Event
    */
    public String getName() {
        return name;
    }
    /*
      Getter al variabilei size
      @return numarul participantilor
      @see Event
    */
    public int getSize() {
        return size;
    }
    /*
      Getter al variabilei end
      @return ora la care se termina evenimentul
      @see Event
    */
    public int getEnd() {
        return end;
    }
    /*
      Getter al variabilei start
      @return ora la care incepe evenimentul
      @see Event
    */
    public int getStart() {
        return start;
    }
    /*
        Metoda toString returneaza un mesaj care contine toate datele clasei Event
        @return mesaj care contine toate valorile variabilelor clasei Event
    */
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", end=" + end +
                ", start=" + start +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return size == event.size && end == event.end && start == event.start && name.equals(event.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, end, start);
    }
}
