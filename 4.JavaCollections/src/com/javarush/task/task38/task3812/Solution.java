package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        boolean marked = false;
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            marked = true;
            PrepareMyTest pmt = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (String s: pmt.fullyQualifiedNames()) System.out.println(s);
        }
        return marked;
    }

    public static boolean printValues(Class c) {
        boolean marked = false;
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            marked = true;
            PrepareMyTest pmt = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class z: pmt.value()) System.out.println(z.getSimpleName());
        }
        return marked;
    }
}
