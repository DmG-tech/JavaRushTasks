package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandfather1 = new Human("Name1", true, 80);
        Human grandfather2 = new Human("Name2", true, 80);
        Human grandmother1 = new Human("Name1", false, 80);
        Human grandmother2 = new Human("Name2", false, 80);
        Human father = new Human("Name1", true, 80);
        Human mother = new Human("Name2", false, 80);
        Human son1 = new Human("Name1", false, 10);
        Human son2 = new Human("Name2", false, 10);
        Human son3 = new Human("Name3", false, 10);

        mother.children.add(son1);
        mother.children.add(son2);
        mother.children.add(son3);
        father.children.add(son1);
        father.children.add(son2);
        father.children.add(son3);
        grandfather1.children.add(father);
        grandmother1.children.add(father);
        grandfather2.children.add(mother);
        grandmother2.children.add(mother);

        System.out.println(grandfather1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandmother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(son3.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, Boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
