package ru.innopolis.vasiliev.lesson15;

import org.apache.log4j.Logger;

public class Main {
    final static Logger logger=Logger.getLogger(Main.class);
    public static void main(String[] args) {
        logger.debug("some debug message");
        logger.info("some info message");
        logger.warn("some warning message");
        logger.error("some error message");
        logger.fatal("some fatal message");
        logger.info("somethink happened:"+"");
        try{
            throw new Exception("test exception");
        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }
}
