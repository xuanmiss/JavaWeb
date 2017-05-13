package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/14.
 */
public class IdentityUtil {

    public static Date getBirthdayByIdentiy(String id){

        Date birthdate = null;

        try {
            birthdate = new SimpleDateFormat("yyyyMMdd")
                    .parse(id.substring(6, 14));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date birthday = birthdate;
        return birthday;
    }
}
