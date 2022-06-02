package com.company;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class LoadMethods {
    public Class cls;

    public LoadMethods(Class cls) {
        this.cls = cls;
    }

    public void Methods()
    {
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation.annotationType().equals(org.junit.Test.class)) {
                    System.out.println(method);
                }
            }
        }
        for (Method method : methods) {
            System.out.println(method);
        }

    }


}
