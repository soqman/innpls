package ru.innopolis.vasiliev.lesson7_hw;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class WordsSearcher {
    public void getOccurencies(String[] sources, String[] words, String res){
        for (String word :words){
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(word))) {
                Scanner scanner = new Scanner(bufferedReader);
                while(scanner.hasNext()){
                    scanner.next(word);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
