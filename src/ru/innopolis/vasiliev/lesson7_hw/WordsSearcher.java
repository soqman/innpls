package ru.innopolis.vasiliev.lesson7_hw;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WordsSearcher {
    private final int THREADS_COUNT_IN_POOL=10;
    public final static Logger infoParsingTiming=Logger.getLogger("infoParsingTiming");
    public final static Logger logger=Logger.getLogger(SearchRunnable.class);
    public final static Logger errorsEX=Logger.getLogger("errorsEX");
    //private final long THRESHOLD=1_000_000;

    public void getOccurrences(String[] sources, String[] words, String res) {
        if (sources.length == 0 || words.length == 0 || res.equals("")) {
           logger.error("Check arguments");
            return;
        }
        int i = 0;
        ResultSaver.initResultPath(res);
        long startTime=System.currentTimeMillis();
        infoParsingTiming.info("parsing started");
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
            infoParsingTiming.info("Elapsed time: "+(System.currentTimeMillis()-startTime));
        } catch (InterruptedException e) {
            errorsEX.error(e.getMessage());
        }
    }

    private void deletePreviousResult(String res) {
        if (Files.exists(Paths.get(res))) {
            try {
                Files.delete(Paths.get(res));
            } catch (IOException e) {
                errorsEX.error(e.getMessage());
            }
        }
    }
}



