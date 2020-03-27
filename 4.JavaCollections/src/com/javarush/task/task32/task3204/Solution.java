package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        boolean correctPassword = false;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        do {
            String password = new Random().ints(48, 123)
                    .filter(i -> (i <= 57 || (i >= 65 && i <= 90) || i >= 97))
                    .limit(8)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            Pattern pattern = Pattern.compile(".*[A-Z]+.*[0-9]+.*[a-z]+.*");
            Matcher matcher = pattern.matcher(password);
            if (matcher.find()) {
                try {
                    byteArrayOutputStream.write(password.getBytes());
                    correctPassword = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        while (!correctPassword);
        return  byteArrayOutputStream;
    }
}