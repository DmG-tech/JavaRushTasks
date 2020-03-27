package com.javarush.task.task33.task3310.tests;
/*

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date dateIdStart = new Date();
        for (String line: strings) {
            ids.add(shortener.getId(line));
        }
        Date dateIdFinish = new Date();
        return dateIdFinish.getTime() - dateIdStart.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date dateStringStart = new Date();
        for (Long key: ids) {
            strings.add(shortener.getString(key));
        }
        Date dateStringFinish = new Date();
        return dateStringFinish.getTime() - dateStringStart.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        HashSet<String> origStrings = new HashSet<>();
        HashSet<Long> origId = new HashSet<>();

        for (long element = 0L; element < 10000L; element++) {
            String temp = Helper.generateRandomString();
            origStrings.add(temp);
            origId.add(element);
        }

        long shortTime1 = getTimeToGetIds(shortener1, origStrings, origId);
        long shortTime2 = getTimeToGetIds(shortener2, origStrings, origId);

        Assert.assertTrue(shortTime1 > shortTime2);

        long shortTimeString1 = getTimeToGetStrings(shortener1, origId, origStrings);
        long shortTimeString2 = getTimeToGetStrings(shortener2, origId, origStrings);

        Assert.assertEquals(shortTimeString1, shortTimeString2, 30);
    }
}
*/
