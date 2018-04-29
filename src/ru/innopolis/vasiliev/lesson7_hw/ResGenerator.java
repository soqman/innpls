package ru.innopolis.vasiliev.lesson7_hw;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;

class ResGenerator {
    static int count;
    static long filessize;
    static final String SOURCES_FILEPREFIX = "file_";
    static final int WORD_MAX_LENGTH = 12;
    static final String SOURCES_FILEEXT = ".txt";
    static final String OUTPUT_PATH = "D://J//res/";
    public final static Logger logger=Logger.getLogger(ResGenerator.class);
    public final static Logger errorsEX=Logger.getLogger("errorsEX");


    public static void main(String[] args) {
        initArgs();
        logger.info("please wait...");
        generateFiles();
        logger.info("done!");
    }

    private static void initArgs() {
        if (!Files.exists(Paths.get(OUTPUT_PATH))) {
            logger.error("hard-coded output file path is not exist");
            System.exit(0);
        }
        Predicate<String> digitPredicate = (s) -> s.matches("[0-9]+");
        Scanner scanner = new Scanner(System.in);
        logger.info("input files size");
        String input = scanner.nextLine();
        while (!digitPredicate.test(input) || Long.parseLong(input) < 3) {
            logger.error("not correct");
            input = scanner.nextLine();
        }
        filessize = Long.parseLong(input);
        logger.info("input files count");
        input = scanner.nextLine();
        while (!digitPredicate.test(input) || Integer.parseInt(input) < 1) {
            logger.error("not correct");
            input = scanner.nextLine();
        }
        count = Integer.parseInt(input);
    }

    private static void generateFiles() {
        Random random = new Random();
        char endSymbol = '.';
        for (int i = 0; i < count; i++) {
            long size = filessize;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_PATH + SOURCES_FILEPREFIX + i + SOURCES_FILEEXT))) {
                boolean upper = true;
                long length;
                while (size > 0) {
                    if (size < WORD_MAX_LENGTH + 2) {
                        length = size - 1;
                    } else {
                        length = new Random().nextInt(8) + 2;
                    }
                    String word = generateWord(length, upper);
                    size -= length;
                    if (size == 1) {
                        bw.write(word + endSymbol);
                    } else {
                        if (random.nextInt(10) == 0) {
                            bw.write(word + endSymbol + " ");
                            size--;
                            upper = true;
                        } else {
                            bw.write(word + " ");
                            upper = false;
                        }
                    }
                    size--;
                }
            } catch (FileNotFoundException e) {
                errorsEX.error(e.getMessage());
            } catch (IOException o) {
                errorsEX.error(o.getMessage());
            }
            logger.info("file_"+i+" created");
        }
    }

    private static String generateWord(long length, boolean upper) {
        String word = new String();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            if (upper) {
                word = String.valueOf((char) (random.nextInt(26) + 'A'));
                upper = false;
            } else word += String.valueOf((char) (random.nextInt(26) + 'a'));
        }
        return word;
    }
}
