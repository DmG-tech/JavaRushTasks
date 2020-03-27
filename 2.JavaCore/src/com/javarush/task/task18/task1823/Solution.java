package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String filename = reader.readLine();
            if (filename.equals("exit"))
                break;
            Thread thread = new ReadThread(filename);
            thread.start();
        }
        //for (Map.Entry<String, Integer> pair : resultMap.entrySet()){
       //System.out.println(pair.getValue() + " " + pair.getKey());}
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            FileInputStream file = null;
            try {
                file = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            byte[] buffer = new byte[0];
            try {
                buffer = new byte[file.available()];
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                file.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //for (int j = 0; j < buffer.length; j++)
                //System.out.println((int) buffer[j]);

            int count = 0;
            int[] mas = new int[256];
            for (int i = 0; i < mas.length; i++){
                for (int j = 0; j < buffer.length; j++){
                    if (i == (int) buffer[j])
                        count++;}
                mas[i] = count;
                count = 0;}

            //for (int j = 0; j < mas.length; j++)
                //if (mas[j] != 0)
                //System.out.println(j + " " + mas[j]);

            int maxIndex = 0;
            int maxValue = 0;
            for (int i = 0; i < mas.length; i++)
            {
                if (mas[i] > maxValue){
                    maxIndex = i;
                    maxValue = mas[i];}
            }

            resultMap.put(fileName, maxIndex);
        }
    }
}
