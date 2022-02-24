package com.company;

import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        //main.compulsory();
        main.homework(args);

    }

    void compulsory() {
        System.out.println("Hello World!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        int binary = Integer.parseInt("10101", 2);
        int hex = Integer.parseInt("FF", 16);
        n = n + binary + hex;
        n = n * 6;

        int s = 0;
        while (n > 0) {
            int c = n % 10;
            s = s + c;
            n = n / 10;
        }

        if (s > 10) {
            while (s > 0) {
                int c = s % 10;
                n = n + c;
                s = s / 10;
            }
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);

    }

    private String createRandomWord(int len, char[] alphabet) {
        StringBuilder word = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int k = rand.nextInt(alphabet.length);
            word.append(alphabet[k]);
        }
        return word.toString();
    }

    private Integer neighbors(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            char s = s1.charAt(i);
            for (int j = 0; j < s2.length(); j++) {
                char c = s2.charAt(j);
                if (s == c)
                    return 1;
            }
        }
        return 0;
    }

    void homework(String[] args) {
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        int m = args.length - 2;
        String[] words = new String[n];
        char[] alphabet = new char[m];
        for (int i = 0; i < m; i++) {
            alphabet[i] = args[i + 2].charAt(0);
        }
        for (int i = 0; i < n; i++) {
            String w = createRandomWord(p, alphabet);
            words[i] = w;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(words[i]);
        }
        Boolean[][] adjacency = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (neighbors(words[i], words[j]) == 1 && !words[i].equals(words[j]))
                    adjacency[i][j] = Boolean.TRUE;
                else
                    adjacency[i][j] = Boolean.FALSE;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjacency[i][j]+" ");
            }
            System.out.println();
        }

        String[][] dict = new String[n][n];
        for(int i =0 ;i<n;i++){
            for(int j = 0;j<n;j++){
                if(neighbors(words[i],words[j])==1 && !words[i].equals(words[j])){
                    dict[i][j]=words[j];
                }
                else
                    dict[i][j]="";
            }
        }
        for(int i =0 ;i<n;i++){
            for(int j = 0;j<n;j++){
               System.out.print(dict[i][j]+" ");
            }
            System.out.println();
        }

    }
}
