package com.company;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        LoadClass cls = new LoadClass("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laborator 9 - Compulsory\\target\\classes","Country");
        Class c = cls.load();
        System.out.println(c.getName());
    }
}
