package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (checkBorders(image, x, y) && !isSameColor(image[y][x], desiredColor)) {
            Color currentColor = image[y][x];
            image[y][x] = desiredColor;
            try {
                if (isSameColor(currentColor, image[x + 1][y])) paintFill(image, x + 1, y, desiredColor);
                if (isSameColor(currentColor, image[x][y + 1])) paintFill(image, x, y + 1, desiredColor);
                if (isSameColor(currentColor, image[x - 1][y])) paintFill(image, x - 1, y, desiredColor);
                if (isSameColor(currentColor, image[x][y - 1])) paintFill(image, x, y - 1, desiredColor);
            }
            catch (ArrayIndexOutOfBoundsException e) { }
                return true;
        }
        return false;
    }

    private boolean checkBorders(Color[][] image, int x, int y) {
        if (image != null && x >= 0 && y >= 0 && y < image.length && x < image[y].length) return true;
        return false;
    }
    private boolean isSameColor (Color currentColor, Color desiredColor) {
        if (currentColor == desiredColor) return true;
        return false;
    }
}
