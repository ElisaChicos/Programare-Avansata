package com.company;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Load file = new Load();
        file.load();
        file.invokeStaticMethod();
    }
}
