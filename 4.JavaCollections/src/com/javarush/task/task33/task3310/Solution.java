package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000L);
        testStrategy(new OurHashMapStorageStrategy(), 10000L);
        testStrategy(new FileStorageStrategy(), 1000L);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000L);
        //testStrategy(new HashBiMapStorageStrategy(), 10000L);
        //testStrategy(new DualHashBidiMapStorageStrategy(), 10000L);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        HashSet<Long> longSet = new HashSet<>();
        for (String line: strings) {
            longSet.add(shortener.getId(line));
        }
        return longSet;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        HashSet<String> stringSet = new HashSet<>();
        for (Long key: keys) {
            stringSet.add(shortener.getString(key));
        }
        return stringSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {

        Helper.printMessage(strategy.getClass().getSimpleName());
        StorageStrategy store = strategy;
        Shortener shortener = new Shortener(store);
        HashSet<Long> setID = new HashSet<>();
        HashSet<String> setString = new HashSet<>();

        for (long element = 0L; element < elementsNumber; element++) {
            String temp = Helper.generateRandomString();
            store.put(element, temp);
            setID.add(element);
            setString.add(temp);
        }

        Date dateIdStart = new Date();
        Set testId = getIds(shortener, setString);
        Date dateIdFinish = new Date();
        Helper.printMessage("Time(ms): " + (dateIdFinish.getTime() - dateIdStart.getTime()));

        Date dateStringStart = new Date();
        Set testString = getStrings(shortener, setID);
        Date dateStringFinish = new Date();
        Helper.printMessage("Time(ms): " + (dateStringFinish.getTime() - dateStringStart.getTime()));

        if (testString.equals(setString))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");

        //System.out.println(testString);
        //System.out.println(setString);
    }
}
