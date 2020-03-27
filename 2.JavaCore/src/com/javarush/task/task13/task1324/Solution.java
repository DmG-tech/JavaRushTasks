package com.javarush.task.task13.task1324;

import java.awt.*;

/* 
Один метод в классе
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        int age = 0;
        String color = null;
        default Color getColor()
        {
            return new Color(0,0,0);
        }

        default Integer getAge()
        {
            return age;
        }
    }

    public static class Fox implements Animal{
        public String getName() {
            return "Fox";
        }
    }
}
