package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        String sep = System.getProperty("file.separator");
        String pathName = packageName;
        if(!(packageName.endsWith(sep))){
            pathName = pathName.concat(sep);
        }
        File file = new File(pathName);
        File[] files = file.listFiles();
        for (File f: files) {
            if (f.getName().endsWith(".class")) {
                Class clazz =  new MyClassLoader().loadClass(f.getAbsolutePath());
                if (HiddenClass.class.isAssignableFrom(clazz) ||
                        HiddenClass.class.isAssignableFrom(clazz.getSuperclass())) {
                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for (Constructor constructor: constructors) {
                        if (constructor.getParameterCount() == 0)
                            hiddenClasses.add(clazz);
                    }
                }
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        Object o = null;
        for (Class clazz: hiddenClasses) {
            String simpleName = clazz.toString().toLowerCase();
            if (simpleName.contains(key)) {
                Constructor constructor = null;
                try {
                    constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    o = constructor.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return (HiddenClass) o;
    }

    public class MyClassLoader extends java.lang.ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            Path path = Paths.get(name);
            byte[] buffer = new byte[0];
            try {
                buffer = Files.readAllBytes(path);
            } catch (IOException e) {
                System.out.println("FAIL");
                e.printStackTrace();
            }
            return defineClass(null, buffer, 0, buffer.length);
        }
    }
}