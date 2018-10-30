package com.epam.se02.java8.interfaces;

public class IntSummator implements Summator<Integer> {

    @Override
    public Integer sum(Integer left, Integer right) {
        return left + right;
    }
}
