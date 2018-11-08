package com.sysco.qe.utils;

import org.apache.log4j.Logger;

public class Log {

    public static Logger log = Logger.getLogger(Log.class);

    public static void logInfo(String message){
        log.info(message);
    }
}
