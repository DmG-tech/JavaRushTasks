package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute()  throws InterruptOperationException {
        //Locale.setDefault(Locale.ENGLISH);
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean isCorrect = false;
        while (!isCorrect) {
            String code = ConsoleHelper.askCurrencyCode();
            CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
            CurrencyManipulator current = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
            String[] result = ConsoleHelper.getValidTwoDigits(current.getCurrencyCode());
            int value = Integer.parseInt(result[0]);
            int count = Integer.parseInt(result[1]);
            if (value > 0 && count > 0) {
                current.addAmount(value, count);
                isCorrect = true;
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), value, count));
            }
            else ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
