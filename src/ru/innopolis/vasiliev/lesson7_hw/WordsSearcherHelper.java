package ru.innopolis.vasiliev.lesson7_hw;

import java.io.File;
import java.io.FilenameFilter;

public class WordsSearcherHelper {
    private static String []words= {"dfsdfsdfd","sdsdsd","sdsdafsdgrgolk","kjgekjglkjeg","oekpgrgeopvkrv"};

    public static void main(String[] args) {
        //WordsSearcher.getOccurencies(getSourcesPaths(ResGenerator.OUTPUT_PATH),words,ResGenerator.OUTPUT_PATH+"out");
    }

    static String[] getSourcesPaths(String path){
        File dir = new File(path);
        File[] matches = dir.listFiles(new FilenameFilter()
        {
            public boolean accept(File dir, String name)
            {
                return name.startsWith(ResGenerator.SOURCES_FILEPREFIX) && name.endsWith(ResGenerator.SOURCES_FILEEXT);
            }
        });
        String[] sources=new String[matches.length];
        for (int i = 0; i < sources.length; i++) {
            sources[i]=matches[i].getAbsolutePath();
        }
        return sources;
    }
}
