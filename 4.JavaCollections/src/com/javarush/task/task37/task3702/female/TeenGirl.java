package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.Human;

public class TeenGirl implements Human {
    public static final int MAX_AGE = 19;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TeenGirl{");
        sb.append('}');
        return sb.toString();
    }
}
