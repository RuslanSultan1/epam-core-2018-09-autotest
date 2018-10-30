package com.epam.se02.inheritance;

public class Example2 {

    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setHeight(10);
        rectangle.setWidth(20);

        System.out.println(rectangle.getHeight() == 10);
        System.out.println(rectangle.getWidth() == 20);
    }
}

// S
// Open-closed principle
// Liskov substitution principle
// I
// D
class Rectangle {

    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Square extends Rectangle {

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
}