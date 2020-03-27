package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, ".tmp");
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getFileSize() {
        try {
            return Files.size(this.path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void putEntry(Entry entry) {
        try {
            OutputStream outputStream = Files.newOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(entry);
            outputStream.close();
            objectOutputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace(); }
    }

    public Entry getEntry() {
        if (getFileSize() == 0) return null;
        Entry entry = null;
        try {
            InputStream inputStream = Files.newInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            entry = (Entry) objectInputStream.readObject();
            inputStream.close();
            objectInputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return entry;
    }

    public void remove() {
        try {
            Files.delete(this.path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
