package com.company;

public class Main {

    public static void main(String[] args) {
        // L3(size=30, start=10, end=12),
        Room[] rooms = new Room[10];
        rooms[0] = new ComputerLab("405", 30, "Linux");
        rooms[1] = new ComputerLab("401", 30, "Windows");
        rooms[2] = new ComputerLab("403", 30, "Windows");
        rooms[3] = new LectureHall("309", 100, true);
        Event[] events = new Event[10];
        events[0] = new Event("C1", 100, 10, 8);
        events[1] = new Event("C2",100,12,10);
        events[2] = new Event("L1",30,10,8);
        events[3] = new Event("L2",30,10,8);
        events[4] = new Event("L1",30,12,10);
        Problem problem = new Problem(events,rooms);
        Solution solution = new Solution(problem.getRooms(),problem.getEvents());
        Room[] result;
        result = solution.getAssignment();
        for(int i =0;i<solution.getAssignment().length;i++)
        {
            System.out.println(result[i]);
        }
    }
}

