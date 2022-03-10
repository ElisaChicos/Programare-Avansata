package com.company;

public class Solution {
    private Room[] assignment;
    private Room[] rooms;
    private Event[] events;

    public Solution(Room[] rooms, Event[] events) {
        this.rooms = rooms;
        this.events = events;
    }

    public Solution(Room[] assignment) {
        this.assignment = assignment;
    }

    public Room[] getAssignment() {
        return assignment;
    }

    public void setAssignment(Room[] assignment) {
        this.assignment = assignment;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public void computeUsedRooms() {
        for(int n =0;n<assignment.length;n++)
        {
            assignment[n]=rooms[1];
        }
        for (int i = 0; i < events.length; i++) {
            for (int j = 0; j < rooms.length; j++) {
                if (events[i].getSize() == rooms[j].getCapacity()) {
                    for (int k = 0; k < assignment.length; k++) {
                        if (assignment[k] == rooms[j]) {
                            if (events[i].getStart() != events[k].getStart()) {
                                assignment[i] = rooms[j];
                            } 
                        }
                    }
                }
            }
        }
    }


}