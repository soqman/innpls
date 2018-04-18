package ru.innopolis.vasiliev.lesson7_hw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WordsSearcher {

    public void getOccurrences(String[] sources, String[] words, String res) {
        if (sources.length == 0 || words.length == 0 || res.equals("")) {
            System.out.println("Check arguments");
            return;
        }
        int i = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        deletePreviousResult(res);
        for (String source : sources) {
            executorService.submit(new SearchRunnable(source, words, res, "runnable-" + i++));
        }
        executorService.shutdown();
    }

    private void deletePreviousResult(String res) {
        if (Files.exists(Paths.get(res))) {
            try {
                Files.delete(Paths.get(res));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



