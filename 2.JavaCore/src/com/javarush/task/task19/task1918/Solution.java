package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader  = new BufferedReader(fileReader);

        String s = "";
        while (bufferedReader.ready()) s = s+bufferedReader.readLine();
        bufferedReader.close();
        fileReader.close();

        String teg = args[0];
        Pattern pattern1 = Pattern.compile("<" + teg + ".*?" + "<" + teg + ".*?" + "</" + teg + ">.*?" + "</" + teg + ">");
        Matcher matcher1 = pattern1.matcher(s);
        while (matcher1.find()) System.out.println(matcher1.group());

        Pattern pattern3 = Pattern.compile("<"+teg+">"+"\\w*\\s*\\w*"+"</"+teg+">");
        Matcher matcher3 = pattern3.matcher(s);
        while (matcher3.find()) System.out.println(matcher3.group());
    }
}
