package com.epam.se05;

//                    Exception
// RuntimeException              IOException

import lombok.ToString;

@ToString
public class Parent {

    private int field = 10;

    {
        System.out.println("Init-block 1");
    }

    public Parent(int field) throws NoSuchMethodException {
        if (field < 0) {
            throw new NoSuchMethodException();
        }
        this.field = field;
    }

    {
        System.out.println("Init-block 2: " + field);
    }

    public void process() throws RuntimeException {
        System.out.println("Parent::process");
    }
}

class Child extends Parent {

    Child(int value) throws Exception {
        super(value);
    }

    @Override
    public void process() throws NullPointerException, IllegalArgumentException, IllegalStateException {
        System.out.println("Child::process");
    }
}

class Launcher {

    public static void main(String[] args) {
        Parent parent = null;
        try {
            parent = new Child(-1);
            parent.process();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
//            parent = new Child(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(parent);
    }
}