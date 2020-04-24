package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        String code = currencyCode.toUpperCase();
        if (map.containsKey(code)) return map.get(code);
        CurrencyManipulator currencyManipulator = new CurrencyManipulator(code);
        map.put(code, currencyManipulator);
        return currencyManipulator;
    }

    public  static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }

    private CurrencyManipulatorFactory() {
    }
}
