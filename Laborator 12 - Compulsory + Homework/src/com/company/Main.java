package com.company;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        LoadClass cls = new LoadClass("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laborator 12 - Compulsory + Homework\\out\\production\\Laborator 12 - Compulsory\\com\\company","Exemplu");
        Class c = cls.load();
//        System.out.println(c.getName());
//        System.out.println(c.getPackage().getName());

//        LoadClass cls2 = new LoadClass("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laborator 12 - Compulsory + Homework\\out\\production\\Laborator 12 - Compulsory\\com\\company","Tested");
//        LoadClass cls2 = new LoadClass("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\here","Tested");

//        Class c = cls2.loadDirectory(new File(cls2.getPath()));

//
//        LoadMethods load = new LoadMethods(c);
//        load.staticMethods();
//        load.parametersMethods();

        Command com = new Command();
//        com.javapCommand(c);
        com.javapCommand(c);
    }

}
