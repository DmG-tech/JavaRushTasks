package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setFoundFiles(List<Path> foundFiles) {
        this.foundFiles = foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        boolean containtsName = true;
        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) {
            containtsName = false;
        }

        boolean containsContent = true;
        String content = new String(Files.readAllBytes(file));
        if (partOfContent != null && !content.contains(partOfContent)) {
            containsContent = false;
        }

        boolean containsMinSize = true;
        if (minSize != 0 && !(Files.size(file) > minSize)) {
            containsMinSize = false;
        }

        boolean containsMaxSize = true;
        if (maxSize != 0 && !(Files.size(file) < maxSize)) {
            containsMaxSize = false;
        }

        if (containtsName && containsContent && containsMaxSize && containsMinSize)
            foundFiles.add(file);

        return super.visitFile(file, attrs);
    }
}
