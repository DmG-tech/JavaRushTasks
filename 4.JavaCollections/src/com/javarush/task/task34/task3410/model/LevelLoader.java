package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        //Тестовые данные
        /*Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(20, 40));  walls.add(new Wall(20, 60));  walls.add(new Wall(20, 80));
        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(80, 80));
        boxes.add(new Box(100, 100));
        boxes.add(new Box(140, 140));
         Set<Home> homes = new HashSet<>();
         homes.add(new Home(60, 60));
        homes.add(new Home(120, 120));
        Player player = new Player(20, 20);
        return new GameObjects(walls, boxes, homes, player);*/

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = new Player(0, 0);
        if (level >= 61) level = level % 60;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()));
            String s = null;
            while ((s = reader.readLine()) != null) {
                //Ищем нужный уровень
                Pattern pattern = Pattern.compile("Maze: (?<level>\\d+)");
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    int readLevel = Integer.parseInt(matcher.group("level"));
                    if (readLevel == level) {
                        //Ищем начало схемы уровня
                        do {
                            s = reader.readLine();
                        }
                        while (!s.equals(""));
                        //Начинаем считывание объектов
                        int currentX = Model.FIELD_CELL_SIZE / 2;
                        int currentY = Model.FIELD_CELL_SIZE / 2;
                        while (!(s = reader.readLine()).equals("")) {
                            char[] line = s.toCharArray();
                            for (Character character : line) {
                                readGameObject(character, currentX, currentY, walls, boxes, homes, player);
                                currentX = currentX + Model.FIELD_CELL_SIZE;
                            }
                            currentY = currentY + Model.FIELD_CELL_SIZE;
                            currentX = Model.FIELD_CELL_SIZE / 2;
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GameObjects(walls, boxes, homes, player);
    }

    private void readGameObject(char character, int currentX, int currentY, Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player) {
        switch (character) {
            case ' ':
                break;
            case 'X':
                walls.add(new Wall(currentX, currentY));
                break;
            case '*':
                boxes.add(new Box(currentX, currentY));
                break;
            case '.':
                homes.add(new Home(currentX, currentY));
                break;
            case '&':
                homes.add(new Home(currentX, currentY));
                boxes.add(new Box(currentX, currentY));
                break;
            case '@':
                player.setX(currentX);
                player.setY(currentY);
                break;
        }
    }
}
