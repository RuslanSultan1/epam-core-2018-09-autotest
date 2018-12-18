package com.epam.se01.recursion;

import java.io.File;

@SuppressWarnings("ConstantConditions")
public class FileSearcher {

    // 0 - root
    // 1 - file to find
    public static void main(String[] args) {
        String root = args[0];
        String searchedFile = args[1];

        System.out.println(find(root, searchedFile));
    }

    private static boolean find(String root, String searchedFile) {
        File file = new File(root);
        if (file.exists()) {
            if (file.getName().equals(searchedFile)) {
                return true;
            } else if (file.isDirectory()) {
                for (File subFile : file.listFiles()) {
                    if (find(subFile.getAbsolutePath(), searchedFile)) {
                        return true;
                    }
                }
            }
            return false;
        }
        throw new IllegalArgumentException();
    }
}
