package com.epam.se02.annotations;

import java.lang.reflect.Method;

public class TestEngine {

    public static void main(String[] args) throws Exception {
        for (String fullClassName : args) {
            Class<?> clazz = Class.forName(fullClassName);
            System.out.println("Loaded " + clazz);

            Object testObject = clazz.newInstance();

            for (Method method : clazz.getMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    try {
                        method.invoke(testObject);
                        System.out.println("Test " + method.getName() + " passed!");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("Test " + method.getName() + " failed!");
                    }
                }
            }
        }
    }
}
