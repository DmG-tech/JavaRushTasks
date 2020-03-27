package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String family;
        private boolean sex;
        private int growth;
        private int weight;
        private int IMT;

        public Human (String name, String family, boolean sex, int growth, int weight, int IMT)
        {
            this.name = name;
            this.family = family;
            this.sex = sex;
            this.growth = growth;
            this.weight = weight;
            this.IMT = IMT;
        }
        public Human (String name, String family, boolean sex, int growth, int weight)
        {
            this.name = name;
            this.family = family;
            this.sex = sex;
            this.growth = growth;
            this.weight = weight;
        }
        public Human (String name, String family, boolean sex, int growth)
        {
            this.name = name;
            this.family = family;
            this.sex = sex;
            this.growth = growth;
        }
        public Human (String name, String family, boolean sex)
        {
            this.name = name;
            this.family = family;
            this.sex = sex;
        }
        public Human (String name, String family)
        {
            this.name = name;
            this.family = family;
        }
        public Human (String name)
        {
            this.name = name;
        }
        public Human (boolean sex, int growth, int weight, int IMT)
        {
            this.sex = sex;
            this.growth = growth;
            this.weight = weight;
            this.IMT = IMT;
        }
        public Human (String name, String family, int growth, int weight, int IMT)
        {
            this.name = name;
            this.family = family;
            this.growth = growth;
            this.weight = weight;
            this.IMT = IMT;
        }
        public Human (String name, boolean sex, int growth, int weight, int IMT)
        {
            this.name = name;
            this.sex = sex;
            this.growth = growth;
            this.weight = weight;
            this.IMT = IMT;
        }
        public Human (String name, boolean sex, int growth, int weight)
        {
            this.name = name;
            this.sex = sex;
            this.growth = growth;
            this.weight = weight;
        }
    }
}
