package Helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mathias on 13/10/2016.
 */
public class GeneralHelper {
    public static boolean isNullOrEmpty(String stringToCheck){
        return stringToCheck == null || stringToCheck.equals("");
    }
    public static String getDateAsString(Date date){
        if (date == null)
            return null;
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
    }
}
