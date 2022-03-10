package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Computer v1 = new Computer("", 125);
        Router v2 = new Router("");
        Switch v3 = new Switch();
        Switch v4 = new Switch();
        Router v5 = new Router("");
        Computer v6 = new Computer("", 45);

        v1.setName("A");
        v2.setName("A");
        v3.setName("A");
        v4.setName("B");
        v5.setName("B");
        v6.setName("B");

        List<Node> networkNodes = new ArrayList<>();
        networkNodes.add(v1);
        networkNodes.add(v2);
        networkNodes.add(v3);
        networkNodes.add(v4);
        networkNodes.add(v5);
        networkNodes.add(v6);

        Network network = new Network(networkNodes);
        System.out.println(network.toString());

    }
}
