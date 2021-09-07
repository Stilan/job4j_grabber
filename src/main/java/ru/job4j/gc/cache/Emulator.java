package ru.job4j.gc.cache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Emulator {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Укажите кэшируемую директорию");
        String dir = bufferedReader.readLine();
        DirFileCache dirFileCache = new DirFileCache(dir);
        System.out.println("Загрузить содержимое файла в кэш да/нет?");
        String downloadStr = bufferedReader.readLine();
        while (downloadStr.equals("да")) {
            System.out.println("Введите путь к файлу в директории");
            String key = bufferedReader.readLine();
            dirFileCache.put(key, dirFileCache.load(key));
            System.out.println("Загрузить содержимое файла в кэш да/нет?");
            downloadStr = bufferedReader.readLine();
        }
        System.out.println("Получить содержимое файла из кэша да/нет?");
        String receiveStr = bufferedReader.readLine();
        while (receiveStr.equals("да")) {
            System.out.println("Введите путь к файлу в директории");
            String key = bufferedReader.readLine();
            System.out.println(dirFileCache.get(key));
            System.out.println("Получить содержимое файла из кэша да/нет?");
            receiveStr = bufferedReader.readLine();
        }





    }
}
