package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    int hash(Long k) {
        int h;
        return (k == 0) ? 0 : (h = Long.hashCode(k)) ^ (h >>> 16);
    }

    int indexFor(int hash, int length) {
        return hash & (length-1);
    }

    Entry getEntry(Long key) {
        int h = hash(key);
        int index = indexFor(h, table.length);
        for (Entry e = table[index]; e != null; e = e.next) {
            if (e.hash == h && (e.key == key || key.equals(e.key)))
                return e;
        }
        return null;
    }

    void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == DEFAULT_INITIAL_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    void transfer(Entry[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry next = e.next;
                    int i = indexFor( e.hash, newCapacity );
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        createEntry(hash, key, value, bucketIndex);
        if (size >= threshold)
            resize(2*table.length);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return false;
        for (int i = 0; i < table.length; i++) {
            for (Entry e = table[i]; e != null; e = e.next) {
                if (value.equals(e.value))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int h = hash(key);
        int index = indexFor(h, table.length);
        for (Entry e = table[index]; e!= null; e = e.next) {
            if (e.hash == h && (e.key == key || key.equals(e.key))) {
                e.value = value;
                return;
            }
        }
        addEntry(h, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            for (Entry e = table[i]; e != null; e = e.next) {
                if (value.equals(e.value))
                    return e.key;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry e = getEntry(key);
        if (e != null)
            return e.value;
        return null;
    }

}
