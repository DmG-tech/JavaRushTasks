package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCommand implements Command{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
       //Locale.setDefault(Locale.ENGLISH);
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean isCorrect = false;
        while (!isCorrect) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String currentCardNumber = ConsoleHelper.readString();
            //ConsoleHelper.writeMessage("Enter pin");
            String currentPin = ConsoleHelper.readString();
            if (!checkCardNumber(currentCardNumber) | !checkPin(currentPin)) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            if (!validCreditCards.containsKey(currentCardNumber) | !validCreditCards.getString(currentCardNumber).equals(currentPin)) {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), currentCardNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), currentCardNumber));
            isCorrect = true;
        }
    }

    private boolean checkCardNumber (String cardNumber) {
        Pattern pattern = Pattern.compile("^\\d{12}$");
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.find();
    }

    private boolean checkPin(String pin) {
        Pattern pattern = Pattern.compile("^\\d{4}$");
        Matcher matcher = pattern.matcher(pin);
        return matcher.find();
    }
}
