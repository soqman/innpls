package ru.innopolis.vasiliev.lesson7_hw.generator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Main {
    static int resCount;
    static int resSize;
    static String referenceFilePath;
    static String outputFolderPath;

    public static void main(String[] args) {
        initArgs();
        generateFiles();
    }

    private static void initArgs() {
        referenceFilePath = "D://reference.txt";
        resSize = 102400;
        resCount = 1024;
        outputFolderPath = "D://resources/";
    }

    private static void generateFiles() {
        Random random = new Random();
        if (resSize < 3) {
            System.out.println("resSize is too short");
            return;
        }
        if (resCount < 1) {
            System.out.println("resCount is lower than 1");
            return;
        }
        if (!Files.exists(Paths.get(outputFolderPath))) {
            System.out.println("path is not exist");
            return;
        }
        for (int i = 0; i < resCount; i++) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFolderPath + "/file_" + i + ".txt"))) {
                int size = resSize;
                char endSymbol = '.';
                boolean toUpper = true;
                int wordLength;
                while (size > 0) {
                    if (size < 14) {
                        wordLength = size - 1;
                    } else {
                        wordLength = new Random().nextInt(8) + 2;
                    }
                    String word = "";
                    for (int j = 0; j < wordLength; j++) {
                        if (size > 1) {
                            word += String.valueOf((char) (random.nextInt(26) + 'a'));
                            size--;
                        }
                    }
                    if (toUpper) {
                        word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                    }
                    if (size == 1) {
                        bw.write(word + endSymbol);
                    } else {
                        if (random.nextInt(10) == 0) {
                            bw.write(word + endSymbol);
                            toUpper = true;
                        } else {
                            bw.write(word + " ");
                            toUpper = false;
                        }
                    }
                    size--;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException o) {
                o.printStackTrace();
            }
        }
    }
}
