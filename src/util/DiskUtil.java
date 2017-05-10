package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ymcvalu on 2017/5/10.
 */
public class DiskUtil {
    public static void write(String desUrl, File source)throws IOException{
        FileOutputStream fos=new FileOutputStream(desUrl);
        FileInputStream fis=new FileInputStream(source);
        try{
            byte[]buffer=new byte[1024];
            int len=0;
            while((len=fis.read(buffer))>0)
                fos.write(buffer,0,len);
        }catch (Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
    }
}
