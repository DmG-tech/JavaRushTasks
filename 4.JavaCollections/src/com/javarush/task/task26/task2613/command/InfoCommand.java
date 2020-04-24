package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    //Мой метод
    /*@Override
    public void execute() {
        //Locale.setDefault(Locale.ENGLISH);
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (manipulators.isEmpty()) ConsoleHelper.writeMessage(res.getString("no.money"));
        else {
            for (CurrencyManipulator manipulator : manipulators) {
                if (manipulator.hasMoney())
                    ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }
    }*/

    //Для валидатора
    @Override
    public void execute() {
        boolean flag = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        for (CurrencyManipulator manipulator : manipulators) {
            if (manipulator.hasMoney()) {
                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
                flag = true;
            }
        }
        if (!flag) ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
