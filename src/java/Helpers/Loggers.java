package Helpers;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by mathias on 10/11/2016.
 */
public class Loggers {
    private static Loggers ourInstance = new Loggers();

    public static Loggers getInstance() {
        return ourInstance;
    }

    private Logger debugLog;

    private Loggers() {
        debugLog = Logger.getLogger("DebugLog");

        FileHandler fh;

        try {
            fh = new FileHandler("/Users/mathias/Desktop/TEMP/LejeAdminDebugLog.log", true);


            debugLog.addHandler(fh);

            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
            debugLog.setUseParentHandlers(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message){
        debugLog.info(message);
    }
}
