package ru.job4j.gc.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
      cache.putIfAbsent(key, new SoftReference<V>(value));
    }
    
    public V get(K key) {
        V value = cache.getOrDefault(key, new SoftReference<V>(null)).get();
        if (value == null) {
            value = load(key);
            put(key, value);
        }
        return value;
    }

    protected abstract V load(K key);
}
