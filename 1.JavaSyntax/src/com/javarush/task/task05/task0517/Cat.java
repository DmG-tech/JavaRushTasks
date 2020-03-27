package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name, address,  color;
    int age, weight;

    public Cat(){
        this.weight = 1;
        this.age = 1;
        this.color = "не указан";
        this.weight = 1;
    }

    public Cat(String name){
        this();
        this.name = name;
    }

    public Cat(String name, int weight, int age){
        this(name);
        this.weight = weight;
        this.age =age;
    }

    public Cat(String name, int age){
        this(name);
        this.age = age;
    }

    public Cat(int weight, String color){
        this();
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String address){
        this();
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
