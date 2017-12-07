package learn.download;

/**
 * Created by Peng.lv on 2017/11/30.
 */
public class MethodMain {
    public MethodMain() {
        try {
            DownFileInfoBean bean = new DownFileInfoBean(
                    "", "D:\\",
                    "weixin6522android1160.apk", 5,true,null);
            /*File file = new File("D:\\dan07.apk");
            DownFileInfoBean bean = new DownFileInfoBean(null, "D:\\temp",
                    "dan07.apk", 3,false,file);*/
            DownFileFetch fileFetch = new DownFileFetch(bean);
            fileFetch.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MethodMain();
    }
}