package com.epam.se07.dom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String login;
    private String name;
    private String faculty;
    private Integer telephone;
    private Address address;
}

