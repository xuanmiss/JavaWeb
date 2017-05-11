package util;

import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ymcvalu on 2017/5/10.
 */
public class DiskUtil {
    public static void write(String desUrl,String srcUrl)throws IOException{
        write(new File(desUrl),new File(srcUrl));
    }

    public static void write(String desUrl, File src)throws IOException{
       write(new File(desUrl),src);
    }
    public static void write(File des,File src)throws IOException{
        if(des==null||src==null)
            return;
        File parent=new File(des.getParent());
        if(parent!=null&&!parent.exists())
            parent.mkdirs();
        try(FileOutputStream fos=new FileOutputStream(des);
            FileInputStream fis=new FileInputStream(src)){
            byte[]buffer=new byte[1024];
            int len=0;
            while((len=fis.read(buffer))>0)
                fos.write(buffer,0,len);
        }
    }

    public static String getRealPath(String path){
        return ServletActionContext.getServletContext().getRealPath(path);
    }
}
