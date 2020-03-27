package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandfather1 = new Human("Terry", true, 50);
        Human grandfather2 = new Human("Henry", true, 60);
        Human grandmother1 = new Human("Merry", false, 60);
        Human grandmother2 = new Human("Ola", false, 70);
        Human mother = new Human("Polina", false, 25, grandfather1,grandmother1);
        Human father = new Human("Dima", true, 30, grandfather2,grandmother2);
        Human son1 = new Human("Max", true, 5, father,mother);
        Human son2 = new Human("Petya", true, 6, father,mother);
        Human son3 = new Human("Vasya", true, 7, father,mother);

        ArrayList list = new ArrayList();
        list.add(grandfather1);
        list.add(grandfather2);
        list.add(grandmother1);
        list.add(grandmother2);
        list.add(father);
        list.add(mother);
        list.add(son1);
        list.add(son2);
        list.add(son3);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}