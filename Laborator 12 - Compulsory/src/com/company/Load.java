package com.company;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class Load {

    private Class cls;

    public void load() throws IOException {
        File file = new File("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laborator 9 - Compulsory\\target\\classes");

        try {
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};

            ClassLoader cl = new URLClassLoader(urls);

            cls = cl.loadClass("Cities");

            System.out.println(cls.getPackage().getName());

            Method[] met = cls.getMethods();

            for (Method method : met) {
                System.out.println(method);
            }


        } catch (MalformedURLException e) {
        } catch (ClassNotFoundException e) {
        }
    }

    @Test
    void invokeStaticMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = cls.getMethod("Print", String.class);

        method.setAccessible(true);

        Object result = method.invoke(null);

        System.out.println(result);
    }
}
