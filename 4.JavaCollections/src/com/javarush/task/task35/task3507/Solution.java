package com.javarush.task.task35.task3507;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set = new HashSet();
        File file = new File(pathToAnimals);
        File[] arrayFiles = file.listFiles();
        for (int i = 0; i < arrayFiles.length; i++) {
            if (arrayFiles[i].isFile() && arrayFiles[i].toString().endsWith(".class")) {
                Class clazz = null;
                try {
                    clazz = new ClassLoaderForAnimal().loadClass(arrayFiles[i].getAbsolutePath());
                    if (Animal.class.isAssignableFrom(clazz))
                        set.add((Animal) clazz.newInstance());
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return set;
    }
}
