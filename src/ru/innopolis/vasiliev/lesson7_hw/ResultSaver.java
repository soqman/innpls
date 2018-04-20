package ru.innopolis.vasiliev.lesson7_hw;

import com.sun.istack.internal.NotNull;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ResultSaver {
    private static String resultPath;
    private static String output;
    private static ResultSaver instance = new ResultSaver(resultPath);
    private static final int THRESHOLD=10_000;

    public ResultSaver(String resultPath) {
        this.resultPath=resultPath;
    }

    public static ResultSaver getInstance(){
        return instance;
    }

    public static synchronized void saveSentence(@NotNull String sentence) {
        output+=sentence+". ";
        if(output.length()>THRESHOLD){
            saveToFile();
            output="";
        }
    }

    private static void saveToFile(){
        System.out.println("Save");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultPath, true))) {
            bufferedWriter.write(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }
}
