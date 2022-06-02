package com.company;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class LoadClass{

    private Class cls;
    private String path;
    private String name;

    public LoadClass(String path, String name) {
        this.path = path;
        this.name = name;
    }
    public LoadClass()
    {

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class load() throws IOException {

        File file  = new File(this.getPath());

        try {
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};

            ClassLoader cl = new URLClassLoader(urls);

            cls = cl.loadClass(this.getName());

            System.out.println(cls.getPackage().getName());

            Method[] met = cls.getMethods();

            for (Method method : met) {
                System.out.println(method);
            }


        } catch (MalformedURLException e) {
        } catch (ClassNotFoundException e) {
        }

        return cls;
    }


}
