package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        String firstFileName = ReadOfConsole();
        String secondFileName = ReadOfConsole();

        allLines = ReadOfFile(firstFileName);
        forRemoveLines = ReadOfFile(secondFileName);
        Solution solution = new Solution();
        solution.joinData();

    }

    public static String ReadOfConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return line;
    }

    public static List<String> ReadOfFile(String filename) {
        List<String> list = new ArrayList<>();
        String line;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);
            try {
                line = reader.readLine();
                while (line != null) {
                    list.add(line);
                    line = reader.readLine();
                }
                reader.close();
                fileReader.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return list;
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
