package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = "D:\\\\\\\\JAVA RUSH\\\\\\\\data.txt";//reader.readLine();
        String fileName2 = "D:\\\\\\\\JAVA RUSH\\\\\\\\result.txt";//reader.readLine();
        reader.close();

        List<String> file1 = getListFile(fileName1);
        List<String> file2 = getListFile(fileName2);

        for (int i = 0; (i < file1.size()) && (i < file2.size()); i++) {
            if (file1.get(i).equals(file2.get(i))) {
                lines.add(new LineItem(Type.SAME, file1.get(i)));
            }
        }

        for (int i = 0; i < lines.size(); i++)
            System.out.println(lines.get(i).toString());
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return this.type + " " + this.line;
        }
    }

    public static List<String> getListFile (String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> listFile = new ArrayList<>();
        while (bufferedReader.ready())
            listFile.add(bufferedReader.readLine());
        bufferedReader.close();
        fileReader.close();
        return listFile;
    }
}
