package com.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerUtility {

    private LoggerUtility() {
    }

    public static Logger getLogger(Class<?> clazz){
        Logger logger=null;
        if (logger==null){
            //logger = LogManager.getLogManager().getLogger(String.valueOf(clazz));       //modified as per suggestion
            logger = LogManager.getLogger(clazz);       //recommended in the course
        }
        return logger;
    }
}