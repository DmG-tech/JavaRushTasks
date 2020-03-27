package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Cat TomCat = new Cat("Tom",30,10);
        Dog RexDog = new Dog("Rex", "black", 50);
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat {
        String name;
        int height;
        int tail;

        public Cat(String name, int height, int tail){
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog {
        String name;
        String color;
        int weight;

        public Dog(String name, String color, int weight){
            this.name = name;
            this.color = color;
            this.weight = weight;
        }
    }

    //напишите тут ваш код
}
