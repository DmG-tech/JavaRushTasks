package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);

        String tempLine;
        String name = "";
        String date = "";
        SimpleDateFormat format = new SimpleDateFormat("d M yyyy");

        while (reader.ready()) {
            tempLine = reader.readLine();
            Pattern patternName = Pattern.compile("(\\D+\\s).*?");
            Matcher matcherName = patternName.matcher(tempLine);
            Pattern patternDate = Pattern.compile("\\d.*\\d");
            Matcher matcherDate = patternDate.matcher(tempLine);
            while (matcherDate.find() & matcherName.find()) {
                name = matcherName.group();
                date = matcherDate.group();
            }
            PEOPLE.add(new Person(name.trim(), format.parse(date)));
        }
        reader.close();
        fileReader.close();
    }
}
