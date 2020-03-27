package com.javarush.task.task37.task3707;

/*Давай напишем какую-нибудь коллекцию. Пусть это будет твой собственный Set.
        Пусть этот класс позволяет вставку NULL.

        1. Создай класс AmigoSet. Пусть этот класс наследуется от AbstractSet.
        Этот сэт должен поддерживать интерфейсы Serializable и Cloneable (как же без этого??).
        Также очевидно, что он должен реализовывать интерфейс Set.

        2. Этот класс должен работать с любыми типами, поэтому сделай его дженериком: добавь тип, например, E.
        Стандартные буквы, которые используют для дженериков - это E (element), T (type), K (key), V (value).
        Названия не принципиальны, но облегчают чтение кода.

        3. Воспользуйся горячими клавишами Идеи и реализуй необходимые методы, оставь реализацию по умолчанию.

        Требования:
        •	Класс AmigoSet должен быть потомком класса AbstractSet.
        •	Класс AmigoSet должен поддерживать интерфейсы Serializable, Cloneable и Set.
        •	Класс AmigoSet должен быть дженериком.


        Изобретать механизм работы с хешем не будем, он уже реализован во многих коллекциях.

Мы возьмем коллекцию HashMap и воспользуемся ей.

1. Создай приватную константу Object PRESENT, которую инициализируй объектом Object, это будет наша заглушка.

2. Создай private transient поле HashMap<E,Object> map. Список ключей будет нашим сэтом, а вместо значений будем пихать в мапу заглушку PRESENT.

Напомню, нам нужны только ключи, а вместо значений для всех ключей будем вставлять PRESENT. Там же должно что-то быть :)

Посмотрим, что из этого получится :)

Коллекции обычно имеют несколько конструкторов, поэтому:

3. Создай конструктор без параметров, в котором инициализируй поле map.

4. Создай конструктор с одним параметром Collection<? extends E> collection.

Для инициализации поля map воспользуйся конструктором, в который передается Capacity.

Вычисли свою Capacity по такой формуле: максимальное из 16 и округленного в большую сторону значения (collection.size()/.75f)

Добавь все элементы из collection в нашу коллекцию.

Нужный метод добавления всех элементов у нас есть благодаря тому, что AbstractSet наследуется от AbstractCollection.

5. Напиши свою реализацию для метода метод add(E e): добавь в map элемент 'e' в качестве ключа и PRESENT в качестве значения.

Верни true, если был добавлен новый элемент, иначе верни false.

Требования:
•	В классе AmigoSet должно быть создано и инициализировано private static final поле PRESENT типа Object.
•	В классе AmigoSet должно быть создано private transient поле map типа HashMap.
•	В классе AmigoSet должен быть реализован в соответствии с условием конструктор без параметров.
•	В классе AmigoSet должен быть реализован в соответствии с условием конструктор с одним параметром типа Collection.
•	Метод add должен добавлять новый элемент в map используя полученный параметр в качестве ключа и объект PRESENT в качестве значения.
•	Метод add должен возвращать true в случае, если новый элемент был успешно добавлен, иначе - false

Напиши свою реализацию следующих методов при условии, что нужно работать с ключами мапы:
* Iterator<E> iterator() - очевидно, что это итератор ключей. Получи множество ключей в map, верни его итератор
* int size() - это количество ключей в map, равно количеству элементов в map
* boolean isEmpty()
* boolean contains(Object o)
* void clear()
* boolean remove(Object o)

Ничего своего писать не нужно, используй то, что уже реализовано для множества ключей map.
Используй Alt+Insert => Override methods

Требования:
•	Метод iterator должен возвращать итератор для множества ключей поля map.
•	Метод size должен возвращать то же, что и метод size поля map.
•	Метод isEmpty должен возвращать true, если map не содержит ни одного элемента, иначе - false.
•	Метод contains должен возвращать true, если map содержит анализируемый элемент, иначе - false.
•	Метод clear должен вызывать метод clear объекта map.
•	Метод remove должен удалять из map полученный в качестве параметра элемент.

Твое собственное множество AmigoSet реализует интерфейс Cloneable. Однако, не клонируется правильно.
Напиши свою реализацию метода Object clone(), сделай поверхностное клонирование.

* Клонируй множество, клонируй map.
* В случае возникновения исключений выбрось InternalError.
* Убери лишнее пробрасывание исключения.

Расширь модификатор доступа до public.

Требования:
•	В классе AmigoSet метод clone должен иметь уровень доступа public.
•	В случае возникновения исключений в процессе клонирования должно быть брошено исключение InternalError.
•	В классе AmigoSet метод clone должен быть реализован в соответствии с условием задачи.

Твое собственное множество AmigoSet реализует интерфейс Serializable. Однако, не сериализуется правильно.

1. Реализуй свою логику сериализации и десериализации.
Вспоминай, какие именно приватные методы нужно добавить, чтоб сериализация пошла по твоему сценарию.
Для сериализации:
* сериализуй сет
* сериализуй capacity и loadFactor у объекта map, они понадобятся для десериализации.
Т.к. эти данные ограничены пакетом, то воспользуйся утилитным классом HashMapReflectionHelper, чтобы достать их.

Для десериализации:
* вычитай все данные
* создай мапу используя конструктор с capacity и loadFactor

2. Помнишь, что такое transient?

Требования:
•	В классе AmigoSet должен содержаться private метод writeObject с одним параметром типа ObjectOutputStream.
•	В классе AmigoSet должен содержаться private метод readObject с одним параметром типа ObjectInputStream.
•	В методе writeObject должен быть вызван метод defaultWriteObject на объекте типа ObjectOutputStream полученном в качестве параметра.
•	В методе readObject должен быть вызван метод defaultReadObject на объекте типа ObjectInputStream полученном в качестве параметра.
•	Объект сериализованный с помощью метода writeObject должен быть равен объекту десериализованному с помощью метода readObject.

Открой исходники HashSet (если у тебя нет исходников джавы, то скачай их и подключи), сравни со своим кодом.
Быстро это можно сделать сравнив через буфер. Скопируй код класса HashSet в буфер.
Зайди в класс AmigoSet, далее правая кнопка мыши -> Compare with Clipboard.

Ты только что реализовал сет, аналогичный HashSet. Теперь будешь знать, как внутри устроен HashSet.
Молодец, теперь коллекции тебе не страшны!

Требования:
•	Поздравляю, ты написал собственную реализацию множества и изучил HashSet во всех деталях!*/

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private final static Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection <? extends E> collection) {
        int capacity = (int) Math.max(16,(collection.size()/.75f) + 1);
        this.map = new HashMap<>(capacity);
        this.addAll(collection);
    }

    @Override
    public boolean add(Object o) {
        return null == map.put((E) o, PRESENT);
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {

        return map.containsKey((E) o);
    }

    @Override
    public boolean remove(Object o) {
        return null == map.remove((E) o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet amigoSet = new AmigoSet<>();
            amigoSet.map.putAll((Map) this.map.clone());
            return amigoSet;
        }
        catch (Exception e) {
            throw new InternalError(e);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "size"));
            objectOutputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
            objectOutputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        for (E e: map.keySet()) {
            objectOutputStream.writeObject(e);
        }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream objectInputStream) {
        try {
            objectInputStream.defaultReadObject();
            int size  = objectInputStream.readInt();
            int capacity = objectInputStream.readInt();
            float loadFactor = objectInputStream.readFloat();
            map = new HashMap<>(capacity, loadFactor);
            for (int i = 0; i < size; i++){
                map.put((E) objectInputStream.readObject(), PRESENT);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}