package com.company;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        LoadClass cls = new LoadClass("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laborator 9 - Compulsory\\target\\classes\\","Exemplu");
//        Class c = cls.load();
//        System.out.println(c.getName());

//        System.out.println(c.getName());
        LoadClass cls2 = new LoadClass("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laborator 9 - Compulsory\\target","Cities");

//        C:\Users\chico\Documents\GitHub\Programare-Avansata\Laborator 9 - Compulsory\out\artifacts\Laborator_9___Compulsory_jar\Laborator 9 - Compulsory_jar.jar

        Class c = cls2.loadDirectory(new File(cls2.getPath()));


//        LoadMethods load = new LoadMethods(c);
//        load.Methods();

    }

}
