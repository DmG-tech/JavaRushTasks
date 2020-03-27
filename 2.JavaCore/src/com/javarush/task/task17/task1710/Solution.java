package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception{
        //start here - начни тут
        switch (args[0])
        {
            case "-c":
                String tempName = args[1];
                SimpleDateFormat tempFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date tempDate = tempFormat.parse(args[3]);
                if (args[2].equals("м"))
                    allPeople.add(Person.createMale(tempName, tempDate));
                else allPeople.add(Person.createFemale(tempName, tempDate));
                System.out.println(allPeople.indexOf(allPeople.get(allPeople.size()-1)));
                break;
            case "-u":
                int temID = Integer.parseInt(args[1]);
                tempName = args[2];
                tempFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                tempDate = tempFormat.parse(args[4]);
                allPeople.get(temID).setName(tempName);
                allPeople.get(temID).setBirthDate(tempDate);
                if (args[3].equals("м"))
                    allPeople.get(temID).setSex(Sex.MALE);
                else allPeople.get(temID).setSex(Sex.FEMALE);
                break;
            case "-d":
                temID = Integer.parseInt(args[1]);
                allPeople.get(temID).setName(null);
                allPeople.get(temID).setBirthDate(null);
                allPeople.get(temID).setSex(null);
                break;
            case "-i":
                temID = Integer.parseInt(args[1]);
                tempFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
                System.out.print(allPeople.get(temID).getName());
                System.out.print(allPeople.get(temID).getSex().equals(Sex.MALE) ? " м " : " ж ");
                System.out.print(tempFormat.format(allPeople.get(temID).getBirthDate()));
                break;
        }
    }
}
