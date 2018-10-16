package com.epam.se02.logical;

@SuppressWarnings("all")
public class LogicBlock {

    {
        System.out.println("1: " + this.x); // 0
        x = 10;
        System.out.println("2: " + this.x); // 10
    }

    private int x = 89;

        {
        System.out.println("3: " + x);  // 89
        x = 20;
    }

    public LogicBlock() {

    }

    public LogicBlock(int y) {
        System.out.println("In constructor: " + this.x);
        this.x = y;
    }

    public int getX() {
        return x;
    }
}

class Launcher {

    public static void main(String[] args) {
        LogicBlock ref1 = new LogicBlock();
        System.out.println(ref1.getX());

        LogicBlock ref2 = new LogicBlock(10);
        System.out.println(ref2.getX());
    }
}
