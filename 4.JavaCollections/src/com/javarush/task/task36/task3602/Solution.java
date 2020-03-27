package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/


public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class result = null;
        Class[] arrayOfClass = Collections.class.getDeclaredClasses();
        for (Class clazz: arrayOfClass) {
            if ((List.class.isAssignableFrom(clazz) ||
            List.class.isAssignableFrom(clazz.getSuperclass())) &&
                    Modifier.isPrivate(clazz.getModifiers()) &&
                    Modifier.isStatic(clazz.getModifiers())) {
                Method method = null;
                try {
                    method = clazz.getDeclaredMethod("get", int.class);
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    //e.printStackTrace();
                }
                Constructor constructor = null;
                try {
                    constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    //e.printStackTrace();
                }
                try {
                    if (constructor != null)
                    method.invoke(constructor.newInstance(),0);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    if (e.getCause().toString().contains("IndexOutOfBoundsException"))
                        result = clazz;
                    else
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }
}
