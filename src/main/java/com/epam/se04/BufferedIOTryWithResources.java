package com.epam.se04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedIOTryWithResources {

    public static void main(String[] args) {
        try {
            doIt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void doIt() throws IOException {
        try (InputStream input = new WrongInputStream(); OutputStream output = new WrongOutputStream()) {
            int countBytes = 0;
            int current;
            while ((current = input.read()) >= 0) {
                System.out.println(current);
                output.write(current);
                ++countBytes;
            }
            System.out.println(countBytes);
        }
    }

    private static class WrongInputStream extends InputStream {

        @Override
        public int read() throws IOException {
            throw new IOException("WrongInputStream::read");
        }

        @Override
        public void close() throws IOException {
            System.out.println("WrongInputStream::close");
            throw new IOException("WrongInputStream::close");
        }
    }

    private static class WrongOutputStream extends OutputStream {

        @Override
        public void write(int b) throws IOException {
            throw new IOException("WrongOutputStream::write");
        }

        @Override
        public void close() throws IOException {
            System.out.println("WrongOutputStream::close");
            throw new IOException("WrongOutputStream::close");
        }
    }

}
