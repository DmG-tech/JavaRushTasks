package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    private FileInputStream original;

    @Override
    public int read() throws IOException {
       return original.read();
    }

    @Override
    public long skip(long n) throws IOException {
        return original.skip(n);
    }

    @Override
    public int available() throws IOException {
        return original.available();
    }

    @Override
    public int read(byte[] b) throws IOException {
       return original.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return original.read(b, off, len);
    }

    @Override
    public void close() throws IOException {
        original.close();
    }

    public TxtInputStream (String fileName) throws UnsupportedFileNameException, FileNotFoundException {
        super(fileName);
        if (fileName.endsWith(".txt")) {
            try {
                this.original = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else
        {
            try {
                super.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) {
    }
}

