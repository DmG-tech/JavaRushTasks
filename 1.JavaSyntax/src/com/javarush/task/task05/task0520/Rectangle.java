package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


import java.io.Reader;

public class Rectangle {
    //напишите тут ваш код
    int top, left, width, height;

    public Rectangle(int top, int left, int widht, int height){
        this.top = top;
        this.left = left;
        this.width = widht;
        this.height = height;
    }

    public Rectangle(int top, int left){
        this.top = top;
        this.left = left;
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(int top, int left, int widht){
        this.top = top;
        this.left = left;
        this.width = widht;
        this.height = widht;
    }

    public Rectangle(){
        this.top = 1;
        this.left = 1;
        this.width = 1;
        this.height = 1;
    }



    public static void main(String[] args) {

    }
}
