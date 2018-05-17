package io;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Peng.lv on 2018/5/16.
 */
public class SaveFile {
    /**
     * 将字节流转换成文件
     * @param filename
     * @param data
     * @throws Exception
     */
    public static void saveFile(String filename,byte [] data)throws Exception{
        if(data != null){
            String filepath ="D:\\" + filename;
            File file  = new File(filepath);
            if(file.exists()){
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data,0,data.length);
            fos.flush();
            fos.close();
        }
    }
}
