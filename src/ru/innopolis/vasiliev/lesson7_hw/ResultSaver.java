package ru.innopolis.vasiliev.lesson7_hw;

import com.sun.istack.internal.NotNull;
import ru.innopolis.vasiliev.lesson7_hw.loggers.LogInfo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
class ResultSaver {
    private static String resultPath;
    private static String output="";
    private static final int THRESHOLD=10_000;

    public static synchronized void saveSentence(@NotNull String sentence) {
        output+=sentence+". ";
        if(output.length()>THRESHOLD){
            saveToFile();
            output="";
        }
    }

    public static void initResultPath(String _resultPath){
        resultPath=_resultPath;
    }

    private static void saveToFile(){
        LogInfo.logger.info("Save");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultPath, true))) {
            bufferedWriter.write(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }

    public static void saveImmediately(){
        if(!output.isEmpty()) saveToFile();
    }
}
