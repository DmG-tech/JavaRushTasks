package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception{
        //start here - начни тут
        SimpleDateFormat formatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat formatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (args[0])
        {
            case "-c" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        if (args[i + 1].contains("м"))
                            allPeople.add(Person.createMale(args[i], formatIn.parse(args[i + 2])));
                        else allPeople.add(Person.createFemale(args[i], formatIn.parse(args[i + 2])));
                        System.out.println(allPeople.indexOf(allPeople.get(allPeople.size() - 1)));
                    }
                }
                break;
            case "-u" :
                synchronized (allPeople)
                {
                    for (int i = 1; i < args.length; i += 4) {
                        allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(formatIn.parse(args[i+3]));
                        if (args[i + 2].contains("м"))
                            allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                        else allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                    }
                }
                break;
            case "-d" :
                synchronized (allPeople) {
                    for (int i = 0; i < getlistID(args).length; i++) {
                        allPeople.get(getlistID(args)[i]).setName(null);
                        allPeople.get(getlistID(args)[i]).setSex(null);
                        allPeople.get(getlistID(args)[i]).setBirthDate(null);
                    }
                }
                break;
            case "-i" :
                synchronized (allPeople) {
                    for (int i = 0; i < getlistID(args).length; i++) {
                        System.out.print(allPeople.get(getlistID(args)[i]).getName());
                        System.out.print(allPeople.get(getlistID(args)[i]).getSex().equals(Sex.MALE) ? " м " : " ж ");
                        System.out.print(formatOut.format(allPeople.get(getlistID(args)[i]).getBirthDate()) + "\n");
                    }
                }
                break;
        }
    }

    public static int[] getlistID(String[] args)
    {
        int [] tempArray = new int[args.length-1];
        for (int i = 1; i < args.length; i++ )
            tempArray[i-1] = Integer.parseInt(args[i]);
        return tempArray;
    }
}
