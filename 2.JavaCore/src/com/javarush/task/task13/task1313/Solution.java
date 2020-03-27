package com.javarush.task.task13.task1313;

import java.awt.*;

/* 
Лисица — это такое животное
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        default Color getColor()
        {
            Color color = new Color(00,22,46);
            return color;
        }
    }

    public static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }
}