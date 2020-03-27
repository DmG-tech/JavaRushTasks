package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

public class TeenBoy implements Human {
    public static final int MAX_AGE = 19;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TeenBoy{");
        sb.append('}');
        return sb.toString();
    }
}
