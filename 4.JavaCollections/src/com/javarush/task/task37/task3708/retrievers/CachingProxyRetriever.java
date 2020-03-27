package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

import java.util.LinkedHashMap;

public class CachingProxyRetriever implements Retriever{
    private OriginalRetriever originalRetriever;
    LRUCache lruCache = new LRUCache(10);

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object obj = lruCache.find(id);
        if (obj == null) {
            obj = originalRetriever.retrieve(id);
            lruCache.set(id, obj);
        }
        return obj;
    }
}
