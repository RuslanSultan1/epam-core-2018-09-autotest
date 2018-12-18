package com.epam.se04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedIOOldStyle {

    public static void main(String[] args) {
        String inputFile = "C:\\projects\\tmp\\chat.log";
        String outputFile = "C:\\projects\\tmp\\chatOut.log";
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new BufferedInputStream(new FileInputStream(inputFile));
            output = new BufferedOutputStream(new FileOutputStream(outputFile));

            int countBytes = 0;
            int current;
            while ((current = input.read()) >= 0) {
                System.out.println(current);
                output.write(current);
                ++countBytes;
            }
            System.out.println(countBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }
}
