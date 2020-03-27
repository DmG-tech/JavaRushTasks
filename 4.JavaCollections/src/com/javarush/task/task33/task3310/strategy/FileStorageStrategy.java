package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy{
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000L;
    FileBucket[] table;
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public FileStorageStrategy() {
        table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
        for(int i = 0; i < table.length; ++i)
            table[i] = new FileBucket();
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    int hash(Long k) {
        k ^= (k >>> 20) ^ (k >>> 12);
        return (int)(k ^ (k >>> 7) ^ (k >>> 4));
    }

    int indexFor(int hash, int length) {
        return hash & (length-1);
    }

    Entry getEntry(Long key) {
        int h = hash(key);
        int index = indexFor(h, table.length);
        Entry entry = table[index].getEntry();
        for (Entry e = entry; e != null; e = e.next) {
            if (e.hash == h && (e.key == key || key.equals(e.key)))
                return e;
        }
        return null;
    }

    void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry e = table[i].getEntry();
            while (e != null) {
                int h = hash(e.key);
                int newIndex = indexFor(h, newCapacity);
                newTable[newIndex].putEntry(e);
                e = e.next;
            }
            table[i].remove();
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        createEntry(hash, key, value, bucketIndex);
        if (table[bucketIndex].getFileSize() >= DEFAULT_BUCKET_SIZE_LIMIT)
            resize(table.length * 2);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
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
            for (Entry e = table[i].getEntry(); e != null; e = e.next) {
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
        for (Entry e = table[index].getEntry(); e!= null; e = e.next) {
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
            for (Entry e = table[i].getEntry(); e != null; e = e.next) {
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
