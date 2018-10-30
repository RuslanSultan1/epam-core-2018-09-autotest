package com.epam.se02.enums;

import java.util.Date;

public enum Direction {

    FORWARD(1.0) {

        @Override
        public Direction opposite() {
            return BACKWARD;
        }
    },
    BACKWARD(2.0) {

        @Override
        public Direction opposite() {
            return FORWARD;
        }
    };

    private double ratio;

    Direction(double r) {
        ratio = r;
    }

    public double getRatio() {
        return ratio;
    }

    public abstract Direction opposite();

    public static Direction byRatio(double r) {
        if (r == 1.0) return FORWARD;
        else if (r == 2.0) return BACKWARD;
        else throw new IllegalArgumentException();
    }
}

class Launcher2 {

    public static void main(String[] args) {
        Date date = new Date() {

            public void method() {

            }
        };

        Direction.BACKWARD.opposite();
    }
}
