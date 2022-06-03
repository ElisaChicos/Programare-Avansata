package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Command {
    public void javapCommand(Class c) {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append(c.getName());
        result.append(newLine);

        result.append(c.getPackage().getName());
        result.append(newLine);
        result.append(" Variabile ==> ");
        result.append(newLine);

        Field[] fields = c.getClass().getDeclaredFields();
        for (Field field : fields) {
            result.append("  ");
            try {
                result.append(field.getName());
                result.append(": ");
                result.append(field.get(this));
            } catch (IllegalAccessException ex) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append(" Metode ==> ");
        result.append(newLine);

        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method m : methods) {
            result.append("  ");
            result.append(m.getName());
        }

        System.out.println(result.toString());
    }
}
