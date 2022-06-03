package com.company;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class LoadMethods {
    public Class cls;

    public LoadMethods(Class cls) {
        this.cls = cls;
    }

    public void staticMethods() throws ClassNotFoundException {
        int passed = 0, failed = 0;
        for (Method m : Class.forName(String.valueOf(this.cls)).getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);

    }

    public void parametersMethods() throws ClassNotFoundException {
        int passed = 0, failed = 0;

        for (Method m : Class.forName(String.valueOf(this.cls)).getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    Parameter[] parameters = m.getParameters();
                    if(parameters.length > 0)
                    {
                        m.invoke(null,1);
                        passed++;
                    }

                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }


}
