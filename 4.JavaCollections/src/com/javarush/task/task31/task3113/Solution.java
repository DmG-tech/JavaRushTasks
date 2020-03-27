package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    private int countOfDirectory;
    private int countOfFiles;
    private  long sizeOfDirectory;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        if (!Files.isDirectory(Paths.get(fileName)))
            System.out.println(Paths.get(fileName).toString() + " - не папка");
        else {
            Solution solution = new Solution();
            Files.walkFileTree(Paths.get(fileName), solution);
            System.out.println("Всего папок - " + (solution.countOfDirectory - 1));
            System.out.println("Всего файлов - " + solution.countOfFiles);
            System.out.println("Общий размер - " + solution.sizeOfDirectory);
        }
    }

    protected Solution() {
        super();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        countOfDirectory++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        countOfFiles++;
        sizeOfDirectory = sizeOfDirectory + attrs.size();
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
