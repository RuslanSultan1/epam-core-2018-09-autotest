package com.epam.se04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFromConsole {

    // java com.epam.se04.ReadFromConsole 0> out.txt 1>/dev/null
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;

        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader lineNumberReader = new BufferedReader(inputStreamReader);

        System.out.println(lineNumberReader.readLine());
        System.out.println(lineNumberReader.readLine());
        System.out.println(lineNumberReader.readLine());
    }
}
