package ru.innopolis.vasiliev.lesson7_hw;

import java.io.*;
import java.util.Scanner;

class SearchRunnable implements Runnable {

    private final String src;
    private final String[] words;
    private final String name;
    private final long startByte;
    private long bytesLength;

    SearchRunnable(String src, String[] words,String name, long startByte, long bytesLength){
        this.src = src;
        this.words = words;
        this.name = name;
        this.startByte=startByte;
        this.bytesLength=bytesLength;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("\""+name + "\" in \"" + Thread.currentThread().getName()+"\" started");
        System.out.println("startByte "+startByte);
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
        System.out.println("not yet");
    }

    private void searchWithBufferedReader() {
        File file = new File(src);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int s;
            String sentence = "";
            br.skip(startByte);
            while ((s = br.read()) != -1 && bytesLength-->0) {
                //sentence divide!!!
                if ((char) s != '.') {
                    sentence += (char) s;
                } else {
                    wordsTest(sentence.trim());
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
                ResultSaver.saveSentence(sentence);
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