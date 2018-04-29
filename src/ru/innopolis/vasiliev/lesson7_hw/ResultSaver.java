package ru.innopolis.vasiliev.lesson7_hw;

import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
class ResultSaver {
    private static String resultPath;
    private static String output="";
    private static final int THRESHOLD=10_000;
    public final static Logger logger=Logger.getLogger(ResultSaver.class);
    public final static Logger errorsEX=Logger.getLogger("errorsEX");

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
        logger.info("Save");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultPath, true))) {
            bufferedWriter.write(output);
        } catch (FileNotFoundException e) {
            errorsEX.error(e.getMessage());
        } catch (IOException o) {
            errorsEX.error(o.getMessage());
        }
    }

    public static void saveImmediately(){
        if(!output.isEmpty()) saveToFile();
    }
}
