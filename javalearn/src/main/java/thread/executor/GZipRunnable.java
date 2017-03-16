package thread.executor;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Administrator on 2017/3/7.
 */
public class GZipRunnable implements Runnable{
    private final File input;

    public GZipRunnable(File input) {
        this.input = input;
    }

    public void run() {
        //不压缩已经压缩的文件
        if(!input.getName().endsWith(".giz")){
            File output= new File(input.getParent(),input.getName()+".giz");
            if(!output.exists()){//不覆盖已经存在的文件
                try {
                    InputStream in= new BufferedInputStream(new FileInputStream(input));
                    try {
                        OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)));
                        int b;
                        while((b=in.read())!=-1){
                            out.write(b);
                        }
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
