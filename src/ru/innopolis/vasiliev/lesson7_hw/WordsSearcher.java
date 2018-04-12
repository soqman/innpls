package ru.innopolis.vasiliev.lesson7_hw;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class WordsSearcher {

    public void getOccurrences(String[] sources, String[] words, String res) {
        if (sources.length == 0 || words.length==0 || res.equals("")) {
            System.out.println("Check arguments");
            return;
        }
        int i = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (String source : sources) {
            executorService.submit(new SearchRunnable(source, words, res, "runnable-" + i++));
        }
        executorService.shutdown();
    }
}

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
                        saveSentence(result);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(name + " in " + Thread.currentThread().getName());
    }

    private synchronized void saveSentence(@NotNull String s) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultPath, true))) {
            bufferedWriter.write(s + ". ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }
}

