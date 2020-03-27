package com.javarush.task.task37.task3712;

abstract public class Game {
    abstract void prepareForTheGame();
    abstract void playGame();
    abstract void congratulateWinner();
    void run() {
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }
}
