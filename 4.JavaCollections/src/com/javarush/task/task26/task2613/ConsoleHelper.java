package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String result = null;
        try {
            result = bis.readLine();
        } catch (IOException e) {
        }
        if (result.toUpperCase().equals("EXIT")) {
            throw new InterruptOperationException();
        }
        return result;
    }

    public static String askCurrencyCode()  throws InterruptOperationException{
        boolean correct = false;
        String code = null;
        while (!correct) {
            writeMessage(res.getString("choose.currency.code"));
            code = readString();
            Pattern pattern = Pattern.compile("^(?<value>[a-zA-Z]{3})$");
            Matcher matcher = pattern.matcher(code);
            if (!matcher.find()) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            correct = true;
        }
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        boolean correct = false;
        String[] faceValueAndCount = new String[2];
        while (!correct) {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            String temp = readString();
            Pattern pattern = Pattern.compile("^(?<value>\\d+)\\s(?<count>\\d+)$");
            Matcher matcher = pattern.matcher(temp);
            if (matcher.find()) {
                faceValueAndCount[0] = matcher.group("value");
                faceValueAndCount[1] = matcher.group("count");
                correct = true;
            }
            else {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
        }
        return faceValueAndCount;
    }

    public static Operation askOperation()  throws InterruptOperationException {
        boolean correct = false;
        Operation operation = null;
        while (!correct) {
            writeMessage(res.getString("choose.operation"));
            writeMessage(
                    " 1 - " + res.getString("operation.INFO") + ";" +
                    " 2 - " + res.getString("operation.DEPOSIT") + ";" +
                    " 3 - " + res.getString("operation.WITHDRAW") + ";" +
                    " 4 - " + res.getString("operation.EXIT") + ";"
            );
            //writeMessage("Укажите номер операции: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
            try {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                correct = true;
            }
            catch (RuntimeException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
        return operation;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
