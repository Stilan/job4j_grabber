package ru.job4j.gc.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
       String str = " ";
        try {
            str = Files.readString(Path.of(key));
        } catch (IOException e) {
            e.printStackTrace();
        }
       return str;
    }
}
