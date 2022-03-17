package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Computer v1 = new Computer("2", 125);
        Router v2 = new Router("9");
        Switch v3 = new Switch(true);
        Switch v4 = new Switch(false);
        Router v5 = new Router("1");
        Computer v6 = new Computer("4", 45);

//        System.out.println(v1.StorageByte(v1.getStorageCapacity()));
//        System.out.println(v1.StorageKilobyte(v1.getStorageCapacity()));
//        System.out.println(v1.StorageMegabyte(v1.getStorageCapacity()));
        v1.setName("A");
        v2.setName("A");
        v3.setName("A");
        v4.setName("B");
        v5.setName("B");
        v6.setName("B");

        v1.setMACAddress("5");
        v2.setMACAddress("3");
        v5.setMACAddress("1");
        v6.setMACAddress("2");


        List<Node> networkNodes = new ArrayList<>();
        networkNodes.add(v1);
        networkNodes.add(v2);
        networkNodes.add(v3);
        networkNodes.add(v4);
        networkNodes.add(v5);
        networkNodes.add(v6);

        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,20);
        v3.setCost(v4,10);
        v4.setCost(v5,30);
        v4.setCost(v6,10);
        v5.setCost(v6,20);


//        for (Node networkNode : networkNodes) {
////            System.out.println(networkNode);
//            System.out.println(networkNode.getCost());
//        }

        Collections.sort(networkNodes, Node::compareByAdress);
        for (Node networkNode : networkNodes) {
           System.out.println(networkNode +"    "+ networkNode.getMACAddress());
        }

    }
}
