package com.epam.se04.serialization;

import java.io.Serializable;

public class Point implements Serializable {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ") reference = " + super.toString();
    }
}

