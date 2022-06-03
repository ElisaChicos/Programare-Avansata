package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Scanner;

public class Command {
    public int a = 6;
    private int b;

    private String ex1(String s)
    {
        return s.toLowerCase(Locale.ROOT);
    }

    protected Integer ex2(Integer a, Integer b)
    {
        return a+b;
    }

    public void javapCommand(Class c) throws NoSuchMethodException {
        System.out.println("Optiunile disponibile sunt: -l, -public, -private, -p, -classpath");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        result.append(c.getName());
        result.append(newLine);
        result.append(c.getPackage().getName());
        result.append(newLine);
        if(input.toLowerCase(Locale.ROOT).equals("-l"))
        {

            result.append(" Variabile ==> ");
            result.append(newLine);

            Field[] fields = c.getClass().getDeclaredFields();
            for (Field field : fields) {
                result.append("  ");
                result.append(field.getName());
                result.append(newLine);
                System.out.println(result.toString());
            }
        }else{
            if(input.toLowerCase(Locale.ROOT).equals("-public"))
            {
                result.append(" Variabile ==> ");
                result.append(newLine);
                Field[] fields = c.getClass().getDeclaredFields();
                for (Field field : fields) {
                    result.append("  ");
                    result.append(field.getName());

                    result.append(newLine);
                }
                result.append(" Metode ==> ");
                result.append(newLine);

                Method[] methods = c.getClass().getDeclaredMethods();
                for (Method m : methods) {
                    result.append("  ");
                    result.append(m.getName());
                    result.append(newLine);
                }
                System.out.println(result.toString());
            }
            else{
                if(input.toLowerCase(Locale.ROOT).equals("-private")){
                    Tested t = new Tested();
                    Method m = t.getClass().getDeclaredMethod("ex1", String.class);
                    m.setAccessible(true);
                    result.append(" Metode private  ==> ");
                    result.append(newLine);
                    result.append("  ");
                    result.append(m.getName());
                    System.out.println(result.toString());

                }
                else{
                    if(input.toLowerCase(Locale.ROOT).equals("-p")){
                        result.append(" Variabile ==> ");
                        result.append(newLine);
                        Field[] fields =c.getClass().getDeclaredFields();
                        for (Field field : fields) {
                            result.append("  ");
                            result.append(field.getName());
                            result.append(newLine);
                        }
                        result.append(" Metode ==> ");
                        result.append(newLine);

                        Method[] methods = c.getClass().getDeclaredMethods();
                        for (Method m : methods) {
                            result.append("  ");
                            result.append(m.getName());
                            result.append(newLine);
                        }
                        Tested t = new Tested();
                        Method m = t.getClass().getDeclaredMethod("ex1", String.class);
                        m.setAccessible(true);
                        result.append(" Metode private  ==> ");
                        result.append(newLine);
                        result.append("  ");
                        result.append(m.getName());
                        System.out.println(result.toString());
                    }
                }
            }
        }


    }

//    public void javapCommand(Class c) {
//        StringBuilder result = new StringBuilder();
//        String newLine = System.getProperty("line.separator");
//
//        result.append(c.getName());
//        result.append(newLine);
//
//        result.append(c.getPackage().getName());
//        result.append(newLine);
//        result.append(" Variabile ==> ");
//        result.append(newLine);
//
//        Field[] fields = c.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            result.append("  ");
//            try {
//                result.append(field.getName());
//                result.append(": ");
//                result.append(field.get(this));
//            } catch (IllegalAccessException ex) {
//                System.out.println(ex);
//            }
//            result.append(newLine);
//        }
//        result.append(" Metode ==> ");
//        result.append(newLine);
//
//        Method[] methods = this.getClass().getDeclaredMethods();
//        for (Method m : methods) {
//            result.append("  ");
//            result.append(m.getName());
//        }
//
//        System.out.println(result.toString());
//    }
}
