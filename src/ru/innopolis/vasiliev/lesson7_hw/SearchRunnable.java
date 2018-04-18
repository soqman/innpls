package ru.innopolis.vasiliev.lesson7_hw;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.util.Scanner;

class SearchRunnable implements Runnable {

    private final String src;
    private final String[] words;
    private final String resultPath;
    private final String name;

    SearchRunnable(String src, String[] words, String resultPath, String name) {
        this.src = src;
        this.words = words;
        this.resultPath = resultPath;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        String result;
        File file = new File(src);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                scanner.useDelimiter("\\. ");
                result = scanner.next();
                for (String word : words
                        ) {
                    if ((result.substring(0, 1).toLowerCase() + result.substring(1)).contains(" " + word + " ")) {
                        System.out.println("word found!");
                        ResultSaver.saveSentence(result, resultPath);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(name + " in " + Thread.currentThread().getName());
    }


}