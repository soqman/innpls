package ru.innopolis.vasiliev.lesson7_hw;

import java.io.*;
import java.util.Scanner;

class SearchRunnable implements Runnable {

    private final String src;
    private final String[] words;
    private final String name;

    SearchRunnable(String src, String[] words,String name) {
        this.src = src;
        this.words = words;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("\""+name + "\" in \"" + Thread.currentThread().getName()+"\" started");
        if(src.startsWith("ftp")){
            searchFTP();
        }
        else {
            searchWithScanner();
            //searchWithBufferedReader();
        }
    }

    private void searchWithScanner(){
        String result;
        File file = new File(src);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                scanner.useDelimiter("\\. ");
                result = scanner.next();
                wordsTest(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void searchFTP(){
        //пара пара пам! фшть!
    }

    private void searchWithBufferedReader() {
        File file = new File(src);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int s;
            String sentence = "";
            while ((s = br.read()) != -1) {
                if ((char) s != '.') {
                    sentence += (char) s;
                } else {
                    wordsTest(sentence);
                    sentence = "";
                }
            }
            if (!sentence.isEmpty()) {
                wordsTest(sentence);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void wordsTest(String sentence) {
        for (String word : words
                ) {
            if (isWordInSentence(sentence, word)) {
                System.out.println("word \"" +word+"\" found!");
                ResultSaver.getInstance().saveSentence(sentence);
            }
        }
    }

    private boolean isWordInSentence(String sentence, String word) {
        if (sentence.toLowerCase().contains(" " + word.toLowerCase() + " ")) {
            return true;
        }
        return false;
    }
}