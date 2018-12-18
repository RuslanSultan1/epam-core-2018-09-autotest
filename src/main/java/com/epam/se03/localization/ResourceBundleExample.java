package com.epam.se03.localization;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class ResourceBundleExample {

    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("com.epam.se03.localization.strings");

        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(bundle.getString(key));
        }
    }
}
