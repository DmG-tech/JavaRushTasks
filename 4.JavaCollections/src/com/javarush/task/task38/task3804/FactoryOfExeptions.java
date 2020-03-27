package com.javarush.task.task38.task3804;

public class FactoryOfExeptions {
    public static Throwable getExeption(Enum e) {
        if (e == null) return new IllegalArgumentException();
        Throwable exeption = new Throwable();
        StringBuilder stringBuilder = new StringBuilder(e.toString().replace("_"," "));
        String message = stringBuilder.toString().substring(0,1).concat(stringBuilder.toString().substring(1).toLowerCase());
        if (e.getClass().getSimpleName().equals("ApplicationExceptionMessage")) {
            exeption = new Exception(message); }
        else if (e.getClass().getSimpleName().equals("DatabaseExceptionMessage"))
            exeption = new RuntimeException(message);
        else if (e.getClass().getSimpleName().equals("UserExceptionMessage"))
            exeption = new Error(message);
        else exeption = new IllegalArgumentException();
        return exeption;
    }
}
