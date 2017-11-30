package learn.download;

/**
 * Created by Peng.lv on 2017/11/30.
 */
public class DownLoadTest {
    /**
     * @param args
     */
    public static void main(String[] args) {

        String filepath = "http://dldir1.qq.com/weixin/Windows/WeChatSetup.exe";
        MultiTheradDownLoad load = new MultiTheradDownLoad(filepath ,4);
        load.downloadPart();
    }
}
