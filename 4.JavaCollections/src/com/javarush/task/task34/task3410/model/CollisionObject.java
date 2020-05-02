package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        boolean isCollision = false;
        int currentX = this.getX();
        int currentY = this.getY();
        switch (direction) {
            case UP:
                currentY = currentY - Model.FIELD_CELL_SIZE;
                break;
            case DOWN:
                currentY = currentY + Model.FIELD_CELL_SIZE;
                break;
            case LEFT:
                currentX = currentX - Model.FIELD_CELL_SIZE;
                break;
            case RIGHT:
                currentX = currentX + Model.FIELD_CELL_SIZE;
                break;
        }
        if (currentX == gameObject.getX() && currentY == gameObject.getY()) isCollision = true;
        return isCollision;
    }
}
