package com.company;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Locale;


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


        } catch (MalformedURLException e) {
        } catch (ClassNotFoundException e) {
        }

        return cls;
    }

    public Class loadDirectory(File dir)
    {
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("directory:" + file.getCanonicalPath());
                    loadDirectory(file);
                } else {
                    String s = file.getCanonicalPath();
                    String[] parts = s.split("\\\\");
                    System.out.println(parts[parts.length-1]);
                    String[] p = parts[parts.length-1].split("\\.");

                    if(p[0].toLowerCase(Locale.ROOT).equals(this.getName().toLowerCase(Locale.ROOT)))
                    {
                        File f = new File(file.getAbsolutePath());
                        URL url = f.toURI().toURL();
                        URL[] urls = new URL[]{url};
                        ClassLoader cl = new URLClassLoader(urls);
                        cls = cl.loadClass(this.getName());
                    }
                    else
                    {
                        System.out.println("     file:" + file.getCanonicalPath());
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cls;
    }

}
