package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String person = fileScanner.nextLine();
            String[] dataPerson = person.split(" ", 4);
            SimpleDateFormat sf = new SimpleDateFormat("dd MM yyyy");
            Date date = sf.parse( dataPerson[3]);
            return new Person(dataPerson[1], dataPerson[2], dataPerson[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
