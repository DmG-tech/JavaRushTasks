package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface
    {
        private ArrayList<String> list = new ArrayList<>();
        private String filename;
        @Override
        public void run() {

            try
            {
                FileReader fileReader = new FileReader(filename);
                Scanner scanner = new Scanner(fileReader);
                while (scanner.hasNextLine())
                {
                    list.add(scanner.nextLine().trim());
                }
            }
            catch (FileNotFoundException e)
            {
                e.getMessage();
            }


        }

        @Override
        public void setFileName(String fullFileName) {
            this.filename = fullFileName;
        }

        @Override
        public String getFileContent() {
            String content = "";
            for (String line : list) {
                content = content + line + " ";
            }
            return content;
        }
    }
}
