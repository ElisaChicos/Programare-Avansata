//package com.company;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        var nodes = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersections("v" + i) )
                .toArray(Intersections[]::new);

        List<Intersections> nodeList = new ArrayList<>(Arrays.asList(nodes));
        System.out.println(nodeList);
        List<Streets> streetList = new ArrayList<>();
        streetList.add("s1");
        streetList.add("s2");
        streetList.add("s3");


        Map<Intersections, List<Streets>> cityMap = new HashMap<>();


//        var streets = IntStream.rangeClosed(0, 6)
//                .mapToObj(i -> new Streets("s" + i))
//                .toArray(Streets[]::new);


    }
}