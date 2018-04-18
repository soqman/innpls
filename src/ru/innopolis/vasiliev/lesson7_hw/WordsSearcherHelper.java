package ru.innopolis.vasiliev.lesson7_hw;

import java.io.File;

public class WordsSearcherHelper {
    private static String[] words = {"sdsdsd", "sdssd", "ewrwe", "erer","sdfwegwg","f4334gf4g","Fdbre","dglhfm","fehhh","m,nmnpmrt","bkdlkgnmlke","gadg.fg","FKJKLFSLFDKJ","#F3fef;l"};

    public static void main(String[] args) {
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
