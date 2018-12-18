package com.epam.se06;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class PropertiesTest {

    @Test
    void propertiesTest() {
        Properties properties = new Properties();
        try (InputStream input = PropertiesTest.class.getResourceAsStream("test.properties")) {
            properties.load(input);


            System.out.println(properties.getProperty("key"));
            System.out.println(properties.getProperty("key2"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
