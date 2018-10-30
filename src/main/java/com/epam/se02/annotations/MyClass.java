package com.epam.se02.annotations;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * My super-class!
 * @author Nikolai
 */
@Setter
@Getter
@MyAnnotation(param = "abc")
public class MyClass {

    @MyAnnotation(param = "~~~")
    private int field;
    private final boolean active = true;

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Object object = new MyClass();

        Class<?> clazz = object.getClass();
        System.out.println(clazz.isAnnotationPresent(MyAnnotation.class));
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.param());
        System.out.println(clazz.isAnnotationPresent(Setter.class));

        Field field = clazz.getDeclaredField("field");
        MyAnnotation fieldAnnotation = field.getAnnotation(MyAnnotation.class);
        System.out.println(fieldAnnotation.param());

    }

    private static void example(Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Class<?> clazz = object.getClass();
        Method sayHello = clazz.getMethod("sayHello");

        sayHello.invoke(object);

//        Class<Boolean> booleanClass = boolean.class;
//        Method setterActive = clazz.getMethod("setActive", booleanClass);
//        setterActive.invoke(object, true);
//
//        Method getterActive = clazz.getMethod("isActive");
//        System.out.println(getterActive.invoke(object));

        Field active = clazz.getDeclaredField("active");
        active.setAccessible(true);
        active.set(object, false);
        System.out.println(active.get(object));
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
