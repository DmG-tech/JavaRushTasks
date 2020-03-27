package com.javarush.task.task08.task0820;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код
        HashSet<Cat> cats = new HashSet<>();
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());

        return cats;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        HashSet<Dog> dogs = new HashSet<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());
        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        HashSet<Object> pets = new HashSet<>();
        pets.addAll(cats);
        pets.addAll(dogs);
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш кода
        for (Cat s : cats){
            pets.remove(s);
        }
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for (Object x : pets){
            System.out.println(x);
        }
    }

    //напишите тут ваш код
    public static class Cat{}

    public static class Dog{}
}
