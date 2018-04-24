package ru.innopolis.vasiliev.lesson7_hw;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.Scanner;

public class WordsSearcherHelper {
    private static String[] words = {"sd","gfg","fg","fgf","kyk","nm","fhfgh","dghj"};
    public final static Logger logger=Logger.getLogger(SearchRunnable.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter to start");
        scanner.nextLine();
        WordsSearcher wordsSearcher = new WordsSearcher();
        wordsSearcher.getOccurrences(getSourcesPaths(ResGenerator.OUTPUT_PATH), words, ResGenerator.OUTPUT_PATH + "out.txt");

    }

    static String[] getSourcesPaths(String path) {
        File dir = new File(path);
        File[] matches = dir.listFiles((dir1, name) -> name.startsWith(ResGenerator.SOURCES_FILEPREFIX) && name.endsWith(ResGenerator.SOURCES_FILEEXT));
        String[] sources = new String[matches.length];
        for (int i = 0; i < sources.length; i++) {
            sources[i] = matches[i].getAbsolutePath();
        }
        return sources;
    }
}
