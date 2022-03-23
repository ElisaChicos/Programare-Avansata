//package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        var nodes = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Intersections("v" + i))
                .toArray(Intersections[]::new);

        List<Intersections> intersectionList = new ArrayList<>(Arrays.asList(nodes));
        System.out.println(intersectionList);
        List<Streets> streetList = new ArrayList<>();
        Streets s1 = new Streets("s1", 2, "v1", "v2");
        Streets s2 = new Streets("s2", 3, "v2", "v3");
        Streets s3 = new Streets("s3", 1, "v3", "v4");
        Streets s4 = new Streets("s4", 2, "v4", "v5");
        Streets s5 = new Streets("s5", 3, "v5", "v6");
        Streets s6 = new Streets("s6", 3, "v6", "v7");
        Streets s7 = new Streets("s7", 2, "v7", "v1");
        Streets s8 = new Streets("s8", 2, "v1", "v8");
        Streets s9 = new Streets("s9", 2, "v2", "v8");
        Streets s10 = new Streets("s10", 1, "v7", "v8");
        Streets s11 = new Streets("s11", 2, "v6", "v8");
        Streets s12 = new Streets("s12", 1, "v3", "v6");
        Streets s13 = new Streets("s13", 1, "v4", "v9");
        Streets s14 = new Streets("s14", 2, "v3", "v5");
        Streets s15 = new Streets("s15", 1, "v5", "v9");
        Streets s16 = new Streets("s16", 2, "v8", "v9");

        streetList.add(s1);
        streetList.add(s2);
        streetList.add(s3);
        streetList.add(s4);
        streetList.add(s5);
        streetList.add(s6);
        streetList.add(s7);
        streetList.add(s8);
        streetList.add(s9);
        streetList.add(s10);
        streetList.add(s11);
        streetList.add(s12);
        streetList.add(s13);
        streetList.add(s14);
        streetList.add(s15);
        streetList.add(s16);

//        System.out.println(streetList);
//      Collections.sort(streetList, Comparator.comparing(Streets::getLenght));


        List<Streets> newSortedList = streetList.stream()
                .sorted(Comparator.comparing(Streets::getLenght))
                .collect(Collectors.toList());

        System.out.println(newSortedList);

        Set<Intersections> intersection_set = new HashSet<Intersections>();

        for (int i = 0; i < intersectionList.toArray().length; i++)
            intersection_set.add(intersectionList.get(i));

        for (Intersections e : intersection_set) {
            int occurrences = Collections.frequency(intersection_set, e);
            if (occurrences>1) {
                System.out.println("Contine duplicate");
            }
        }

    }
}