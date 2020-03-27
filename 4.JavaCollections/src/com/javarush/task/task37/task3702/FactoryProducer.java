package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {
    public enum HumanFactoryType {MALE, FEMALE}

    public static AbstractFactory getFactory(HumanFactoryType sex) {
        AbstractFactory abstractFactory = null;
        if (sex == HumanFactoryType.MALE) abstractFactory = new MaleFactory();
        if (sex == HumanFactoryType.FEMALE) abstractFactory = new FemaleFactory();
        return abstractFactory;
    }
}
