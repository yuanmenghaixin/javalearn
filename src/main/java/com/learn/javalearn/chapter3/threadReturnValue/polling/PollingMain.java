package networkCode.chapter3.threadReturnValue.polling;

import networkCode.chapter3.ThreadReturnValue;

/**
 *
 */
public class PollingMain {
    public static void main(String[] args) {
        ThreadReturnValue t = new ThreadReturnValue("123");
        t.start();
        int a = 0;
        while (true) {
            a++;
            System.out.println("轮训次数：" + a);
            if (null != t.getValue2()) {
                System.out.println(t.getValue2());
                break;
            }
        }

    }
}
