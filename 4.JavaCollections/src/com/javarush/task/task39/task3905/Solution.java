package com.javarush.task.task39.task3905;
/* 
Залей меня полностью
*/

import static com.javarush.task.task39.task3905.Color.BLUE;
import static com.javarush.task.task39.task3905.Color.ORANGE;
import static com.javarush.task.task39.task3905.Color.YELLOW;

public class Solution {
    public static void main(String[] args) {
        Color[][] image = new Color[][] {
                {   BLUE, ORANGE, BLUE, BLUE, BLUE, BLUE  },
                {   ORANGE, BLUE, BLUE, BLUE, BLUE, BLUE  },
                {   BLUE, BLUE, BLUE, BLUE, BLUE, BLUE},
                {   BLUE, BLUE, YELLOW, YELLOW, BLUE, BLUE  },
                {   BLUE, BLUE, BLUE, BLUE, BLUE, BLUE  },
                {   BLUE, BLUE, BLUE, BLUE, BLUE, BLUE  },
                {   BLUE, null, BLUE, BLUE, BLUE, BLUE  },
                {   BLUE, BLUE, BLUE, BLUE, BLUE, BLUE  },
        };
        new PhotoPaint().paintFill(image, 3, 2, YELLOW);

        for (Color[] colors : image) {
            for (Color color : colors) {
                System.out.print(color + "\t\t");
            }
            System.out.println();

        }
    }
}
