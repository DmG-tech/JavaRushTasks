package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String filename = reader.readLine();
            FileInputStream file = new FileInputStream(filename);
            if (file.available() < 1000)
            {
                file.close();
                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
