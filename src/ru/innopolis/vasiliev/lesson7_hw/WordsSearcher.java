package ru.innopolis.vasiliev.lesson7_hw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WordsSearcher {

    public void getOccurrences(String[] sources, String[] words, String res) {
        if (sources.length == 0 || words.length == 0 || res.equals("")) {
            System.out.println("Check arguments");
            return;
        }
        int i = 0;
        long startTime=System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        deletePreviousResult(res);
        ResultSaver resultSaver = new ResultSaver(res);
        for (String source : sources) {
            executorService.submit(new SearchRunnable(source, words, "runnable-" + i++));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1,TimeUnit.HOURS);
            System.out.println("Elapsed time: "+(System.currentTimeMillis()-startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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



