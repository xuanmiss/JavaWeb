package util;

/**
 * Created by ymcvalu on 2017/5/9.
 */
public class StringUtil {
    public static boolean isEmptyString(String str){

        if(str==null||str.equals("")||str.isEmpty())
            return true;
        else
            return false;
    }
}
