package ru.innopolis.vasiliev.lesson7_hw;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WordsSearcher {
    private final int THREADS_COUNT_IN_POOL=10;
    //private final long THRESHOLD=1_000_000;

    public void getOccurrences(String[] sources, String[] words, String res) {
        if (sources.length == 0 || words.length == 0 || res.equals("")) {
            System.out.println("Check arguments");
            return;
        }
        int i = 0;
        ResultSaver.initResultPath(res);
        long startTime=System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT_IN_POOL);
        deletePreviousResult(res);
        for (String source : sources) {
            executorService.submit(new SearchRunnable(source, words, "runnable-" + i++,0,0));
            /*File file=new File(source);
            *//*if(file.length()<THRESHOLD){
                executorService.submit(new SearchRunnable(source, words, "runnable-" + i++,0,file.length()));
            }
            else{
                long divCount=file.length()/THRESHOLD;
                for(int j=0;j<divCount;j++){
                    executorService.submit(new SearchRunnable(source, words, "runnable-" + i++,j*THRESHOLD,THRESHOLD));
                }
            }*/
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1,TimeUnit.HOURS);
            ResultSaver.saveImmediately();
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



