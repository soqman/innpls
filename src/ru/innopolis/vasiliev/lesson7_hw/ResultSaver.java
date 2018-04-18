package ru.innopolis.vasiliev.lesson7_hw;

import com.sun.istack.internal.NotNull;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ResultSaver {

    public static synchronized void saveSentence(@NotNull String s, String resultPath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultPath, true))) {
            bufferedWriter.write(s + ". ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }
}
