package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        try {
            load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileInputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        if (properties != null){
            for (Map.Entry<String, String> pair : properties.entrySet()){
                Properties properties = new Properties();
                properties.setProperty(pair.getKey(),pair.getValue());
                properties.store(outputStream, "comments");
            }
        }
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties = new Properties();
        properties.load(inputStream);
        for (String name : properties.stringPropertyNames())
            this.properties.put(name, properties.getProperty(name));
        inputStream.close();
    }

    public static void main(String[] args) {

    }
}
