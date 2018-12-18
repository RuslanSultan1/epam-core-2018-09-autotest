package com.epam.se02.object;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Pen {

    private int price;
    private String manufaturerName;

    public Pen(int price, String manufaturerName) {
        this.price = price;
        this.manufaturerName = manufaturerName;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Pen pen = (Pen) o;
//
//        if (price != pen.price) return false;
//        return manufaturerName != null ? manufaturerName.equals(pen.manufaturerName) : pen.manufaturerName == null;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (price != pen.price) return false;
        return manufaturerName != null ? manufaturerName.equals(pen.manufaturerName) : pen.manufaturerName == null;
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (manufaturerName != null ? manufaturerName.hashCode() : 0);
        return result;
    }
}

class Launcher {

    public static void main(String[] args) {

        Pen abc = new Pen(55, "abc");


        System.out.println(abc.hashCode());
//        Pen erichCrause = new Pen(10, "ErichKrause");
//        Pen kores = new Pen(20, "Kores");
//        Pen kores2 = new Pen(20, "Kores");
//
//        System.out.println(erichCrause.equals(kores));  // false
//        System.out.println(kores.equals(kores2));       // true
//
//        System.out.println(kores.hashCode());
//        System.out.println(kores2.hashCode());
//        System.out.println(kores.hashCode() == kores2.hashCode()); // false
//
//        Map<Pen, String> map = new HashMap<>();
//        map.put(kores, "123");
//        System.out.println(map.get(kores));
//        System.out.println(map.get(kores2));
    }
}

