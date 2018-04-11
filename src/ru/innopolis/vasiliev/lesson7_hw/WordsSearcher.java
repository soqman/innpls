package ru.innopolis.vasiliev.lesson7_hw;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class WordsSearcher {

    String resultPath;

    public void getOccurencies(String[] sources, String[] words, String res) {
        resultPath=res;
        searchWord(sources[0],words[0]);
    }

    private String searchWord(String src, String word){
        String result=null;
        File file = new File(src);

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNext()){
                scanner.useDelimiter("\\. ");
                result=scanner.next();
                if(result.contains(word)){
                    System.out.println(result);
                    saveSentence(result);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void saveSentence(@NotNull String s){
        try (OutputStream oos = new BufferedOutputStream(new FileOutputStream(resultPath))) {
            oos.write(s.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }
}
