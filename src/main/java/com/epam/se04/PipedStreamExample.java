package com.epam.se04;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;

public class PipedStreamExample {

    public static void main(String[] args) {
        try {
            PipedInputStream pipeIn = new PipedInputStream();
            PipedOutputStream pipeOut = new PipedOutputStream();
            pipeIn.connect(pipeOut);
//            pipeOut.connect(pipeIn);

            for (int i = 0; i < 20; i++) {
                pipeOut.write(i);
            }
            byte[] buffer = new byte[pipeIn.available()];

            if (pipeIn.read(buffer) != buffer.length) {
                throw new IllegalStateException();
            }

            System.out.print(Arrays.toString(buffer));
        } catch (IOException e) {
            System.out.println("Impossible IOException occur: ");
            e.printStackTrace();
        }
    }
}

