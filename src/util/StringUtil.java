package util;

/**
 * Created by ymcvalu on 2017/5/9.
 */
public class StringUtil {
    public static String ignoreSpace(String str){
        String _str=null;
        if(!isEmptyString(str))
            for (int i=0;i<str.length();i++){
                if(str.charAt(i)!=' '){
                    _str=str.substring(i,str.length());
                    break;
            }
        }
        return _str;
    }
    public static boolean isEmptyString(String str){
        if(str==null||str.equals("")||str.isEmpty())
            return true;
        return false;
    }
}
