package com.javarush.task.task33.task3310.tests;
/*

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String s1 = Helper.generateRandomString();
        String s2 = Helper.generateRandomString();
        String s3 = s1;

        long id1 = shortener.getId(s1);
        long id2 = shortener.getId(s2);
        long id3 = shortener.getId(s3);

        Assert.assertNotEquals(s1, s2);
        Assert.assertNotEquals(s3, s2);
        Assert.assertEquals(s1,s3);

        String s1new = shortener.getString(id1);
        String s2new = shortener.getString(id2);
        String s3new = shortener.getString(id3);

        Assert.assertEquals(s1, s1new);
        Assert.assertEquals(s2, s2new);
        Assert.assertEquals(s3, s3new);
    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);

    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }

}
*/
