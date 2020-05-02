package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader;

    public Model() {
        levelLoader = new LevelLoader(Paths.get("D:\\JAVA\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task34\\task3410\\res\\levels.txt"));
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction)) return;
        if (checkBoxCollisionAndMoveIfAvailable(direction)) return;
        moveObject(player, direction);
        checkCompletion();
    }

    //Проверка столкновения со стеной
    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        //Мое решение
        return checkCollisionForGameObjects(gameObject, gameObjects.getWalls(), direction);
    }

    //Проверка столкновения с ящиками
    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        boolean isCollision = false;
        Player player = gameObjects.getPlayer();
        Set<Box> boxes = gameObjects.getBoxes();
        for (Box box : gameObjects.getBoxes()) {
            if (player.isCollision(box, direction)) {
                if (!checkWallCollision(box, direction) && !checkCollisionForGameObjects(box, boxes, direction)) {
                    moveObject(box, direction);
                } else isCollision = true;
            }
        }
        return isCollision;
    }

    //Проверяет пройден ли уровень (на всех ли домах стоят ящики, их координаты должны совпадать)
    public void checkCompletion() {
        boolean isCurrentHomeHasBox = false;
        boolean isLevelCompleted = true;
        for (Home home : gameObjects.getHomes()) {
            for (Box box : gameObjects.getBoxes()) {
                if (home.getX() == box.getX() && home.getY() == box.getY()) isCurrentHomeHasBox = true;
            }
            if (!isCurrentHomeHasBox) {
                isLevelCompleted = false;
                break;
            }
            isCurrentHomeHasBox = false;
        }
        if (isLevelCompleted) eventListener.levelCompleted(currentLevel);
    }

    //Вспомогательный метод. Передвигает объект в указанном направлении
    private void moveObject(Movable movable, Direction direction) {
        switch (direction) {
            case UP:
                movable.move(0, -FIELD_CELL_SIZE);
                break;
            case DOWN:
                movable.move(0, FIELD_CELL_SIZE);
                break;
            case LEFT:
                movable.move(-FIELD_CELL_SIZE, 0);
                break;
            case RIGHT:
                movable.move(FIELD_CELL_SIZE, 0);
                break;
        }
    }

    //Вспомогательный метод. Првоеряет текущий объект на коллизии со списком переданных объектов
    private <T> boolean checkCollisionForGameObjects(CollisionObject currentObject, Set<T> collisionObjects, Direction direction) {
        for (T gameObject : collisionObjects) {
            if (currentObject.isCollision((CollisionObject) gameObject, direction)) return true;
        }
        return false;
    }
}