package com.epam.se02.clone;

import java.util.Arrays;
import java.util.Objects;

public class Pen implements Cloneable {

    private int price;
    private String manufaturerName;

    public Pen(int price, String manufaturerName) {
        this.price = price;
        this.manufaturerName = manufaturerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return price == pen.price &&
                Objects.equals(manufaturerName, pen.manufaturerName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(price, manufaturerName);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufaturerName() {
        return manufaturerName;
    }

    public void setManufaturerName(String manufaturerName) {
        this.manufaturerName = manufaturerName;
    }

    @Override
    protected Pen clone() {
        try {
            return (Pen) super.clone();
        } catch (CloneNotSupportedException ignore) {
            throw new RuntimeException(ignore);
        }
    }

    @Override
    public String toString() {
        return "Pen{" +
                "price=" + price +
                ", manufaturerName='" + manufaturerName + '\'' +
                '}';
    }
}

class PencilCase implements Cloneable {

    private Pen[] pens = new Pen[10];
    private int cursor = 0;

    public void add(Pen pen) {
        pens[cursor] = pen;
        cursor++;
    }

    public Pen[] getPens() {
        return pens;
    }

    @Override
    protected PencilCase clone() {
        try {
            PencilCase clone = (PencilCase) super.clone();
            Pen[] copyPens = Arrays.copyOf(this.pens, this.pens.length);
            for (int i = 0; i < copyPens.length; ++i) {
                if (copyPens[i] != null) {
                    copyPens[i] = copyPens[i].clone();
                }
            }
            clone.pens = copyPens;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Launcher {

    public static void main(String[] args) {
        Pen kores = new Pen(10, "kores");
        Pen kores2 = new Pen(-10, "kores2");

        PencilCase pCase = new PencilCase();
        pCase.add(kores);

        PencilCase clone = pCase.clone();

        System.out.println(pCase.getPens() == clone.getPens());
        clone.getPens()[0].setPrice(11);

        System.out.println(pCase.getPens()[0].getPrice());
    }
}











