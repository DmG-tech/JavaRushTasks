package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode.toUpperCase();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            sum = sum + entry.getKey() * entry.getValue();
        }
        return sum;
    }

    private void pickUpAmount (Map<Integer, Integer> currentDenominations) {
        for (Map.Entry<Integer, Integer> entry: currentDenominations.entrySet()) {
            int currentAmount = denominations.get(entry.getKey());
            int newAmount = currentAmount - entry.getValue();
            denominations.put(entry.getKey(), newAmount);
        }
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        Map<Integer, Integer> sortMap = new TreeMap<>(Collections.reverseOrder());
        sortMap.putAll(denominations);
        int resultSum = 0;
        int residue = expectedAmount;
        Iterator<Map.Entry<Integer, Integer>> iterator = sortMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int denomination = entry.getKey();
            int count = entry.getValue();
            int currentCount = 1;
            while (expectedAmount > resultSum & residue >= denomination & currentCount <= count)
            {
                resultSum = resultSum + denomination;
                residue = expectedAmount - resultSum;
                currentCount++;
                result.put(denomination, currentCount-1);
            }
        }
        if (resultSum == expectedAmount) {
            pickUpAmount(result);
            return result;
        }
        else throw new NotEnoughMoneyException();
    }

    public boolean hasMoney() {
        if (getTotalAmount() == 0) return false;
        return true;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        if (!denominations.isEmpty() && getTotalAmount() >= expectedAmount) return true;
        return false;
    }
}
