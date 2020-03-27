package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassLoaderForAnimal extends ClassLoader{
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Path path = Paths.get(name);
        byte[] buffer = new byte[0];
        try {
            buffer = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(null, buffer, 0, buffer.length);
    }


}
