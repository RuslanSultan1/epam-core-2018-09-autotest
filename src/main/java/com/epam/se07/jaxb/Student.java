package com.epam.se07.jaxb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Student", propOrder = {"name", "telephone", "address"})
public class Student {

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String login;

    @XmlElement(required = true)
    private String name;

    @XmlAttribute(required = true)
    private String faculty;

    @XmlElement(required = true)
    private int telephone;

    @XmlElement(required = true)
    private Address address = new Address();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlRootElement
    public static class Address {// внутренний класс
        private String country;
        private String city;
        private String street;
    }
}
