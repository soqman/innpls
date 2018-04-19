package ru.innopolis.vasiliev.lesson7_hw;

import java.io.File;
import java.util.Scanner;

public class WordsSearcherHelper {
    private static String[] words = {"sdfssd", "fef", "sdf", "shh","bbv","sdf","gh","sdfsfsdf","mn","fgh","fgh","gadg.fg","FKJKLFSLFDKJ","#F3fef;l","vjdcrxlvn","gfmgyo","pffafsfa","Uypyr","oooqcvyqm","vkywcwzvy"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter to start");
        scanner.nextLine();
        WordsSearcher wordsSearcher = new WordsSearcher();
        wordsSearcher.getOccurrences(getSourcesPaths(ResGenerator.OUTPUT_PATH), words, ResGenerator.OUTPUT_PATH + "out.txt");
        //String[] src = {"ftp://service.confident.spb.ru/_clients/Dallas/Full/imageDL80v195.exe"};
        //wordsSearcher.getOccurrences(src, words, ResGenerator.OUTPUT_PATH + "out.txt");

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
