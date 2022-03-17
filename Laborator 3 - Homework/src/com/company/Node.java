package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    private String name;
    private String MACAddress;
    private String MAPlocation;
    private Map<Node, Integer> cost = new HashMap<>();

    public Node() {
        this.name = "";
        this.MACAddress = "";
        this.MAPlocation = "";
    }

    public Node(String name, String MACAddress, String MAPlocation) {
        this.name = name;
        this.MACAddress = MACAddress;
        this.MAPlocation = MAPlocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMACAddress() {
        return MACAddress;
    }

    public void setMACAddress(String MACAddress) {
        this.MACAddress = MACAddress;
    }

    public String getMAPlocation() {
        return MAPlocation;
    }

    public void setMAPlocation(String MAPlocation) {
        this.MAPlocation = MAPlocation;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<Node, Integer> cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", hardwareAddress='" + MACAddress + '\'' +
                ", location='" + MAPlocation + '\'' +
                '}';
    }

    @Override
    public int compareTo(Node other) {
        if (this.getName() != null && other.getName() != null)
            return this.name.compareTo(other.name);
        else {
            System.out.println("Null name!");
            return 0;
        }
    }
    public int compareByAdress(Node node){
        if(node instanceof Identifiable)
        {
            if (this.getMACAddress() != null && node.getMACAddress() != null)
                return this.getMACAddress().compareTo(node.getMACAddress());
            else {
                System.out.println("Null adress!");
                return 0;
            }
        }
        return 0;
    }

}
