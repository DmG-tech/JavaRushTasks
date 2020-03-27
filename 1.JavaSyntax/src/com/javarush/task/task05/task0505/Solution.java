package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat cat1 = new Cat("Вася",5,3, 10);
        Cat cat2 = new Cat("Тузик",10,7, 7);
        Cat cat3 = new Cat("Мурзик",1,1, 15);

        Boolean rez1 = cat1.fight(cat2);
        Boolean rez2 = cat2.fight(cat3);
        Boolean rez3 = cat1.fight(cat3);

        System.out.println(rez1);
        System.out.println(rez2);
        System.out.println(rez3);
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageAdvantage = this.age > anotherCat.age ? 1 : 0;
            int weightAdvantage = this.weight > anotherCat.weight ? 1 : 0;
            int strengthAdvantage = this.strength > anotherCat.strength ? 1 : 0;

            int score = ageAdvantage + weightAdvantage + strengthAdvantage;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
