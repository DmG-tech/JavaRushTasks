package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        //Locale.setDefault(Locale.ENGLISH);
        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        boolean isCorrect = false;
        String answer = null;
        while (!isCorrect) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            answer = ConsoleHelper.readString();
            Pattern pattern = Pattern.compile("^(?<value>\\d+)$");
            Matcher matcher = pattern.matcher(answer);
            if (matcher.find()) {
                int sum = Integer.parseInt(answer);
                if (sum > 0) {
                    if (currencyManipulator.isAmountAvailable(sum)) {
                        try {
                            giveOutMoney(currencyManipulator, sum);
                            isCorrect = true;
                        } catch (NotEnoughMoneyException e) {
                            ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                        }
                    }
                    else ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                }
                else ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } else ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
        }
    }

    private void giveOutMoney(CurrencyManipulator manipulator, int sum) throws NotEnoughMoneyException {
        Map<Integer, Integer> result = manipulator.withdrawAmount(sum);
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            ConsoleHelper.writeMessage("    " + entry.getKey() + " - " + entry.getValue());
        }
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum, manipulator.getCurrencyCode()));
    }
}
