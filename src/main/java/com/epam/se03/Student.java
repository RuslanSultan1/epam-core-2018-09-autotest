package com.epam.se03;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Student {
    int age;
    String name;
    String surname;
}

