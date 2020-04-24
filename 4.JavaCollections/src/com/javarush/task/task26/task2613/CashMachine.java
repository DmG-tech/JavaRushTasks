package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

public class CashMachine {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) {
        try {
            CommandExecutor.execute(Operation.LOGIN);
            Operation current = null;
            while (current != Operation.EXIT) {
                current = ConsoleHelper.askOperation();
                CommandExecutor.execute(current);
            }
        }
        catch (InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        }

        /*CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode("usd");
        manipulator.addAmount(500, 2);
        manipulator.addAmount(200, 3);
        manipulator.addAmount(100, 1);
        manipulator.addAmount(50, 12);
        try {
            manipulator.withdrawAmount(600);
        } catch (NotEnoughMoneyException nem) {
            System.out.println("NotEnoughMoneyException");
        }*/
    }
}