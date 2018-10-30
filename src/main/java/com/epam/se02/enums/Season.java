package com.epam.se02.enums;

public enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN;

    static {
        System.out.println("Season loaded");
    }
}

//class SeasonChild extends Season {
//
//}

class Launcher {

    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(4000);
        Season winter = Season.WINTER;
        System.out.println(winter instanceof Season);
        System.out.println(winter instanceof Enum);


        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }

        Season autumn = Season.valueOf("AUTUMN");
        Season autumn1 = Enum.valueOf(Season.class, "AUTUMN");
        Season autumn2 = Season.AUTUMN;
        System.out.println(autumn == autumn1);
        System.out.println(autumn1 == autumn2);
        System.out.println(autumn2 == autumn);
    }
}













