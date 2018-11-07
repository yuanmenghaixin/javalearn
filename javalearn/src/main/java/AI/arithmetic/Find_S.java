package AI.arithmetic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 寻找极大特殊假设
 * Created by Peng.lv on 2018/7/26.
 */
public class Find_S {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int maxTrain = 4;
        int maxLen = 7;
        int i = 0;
        String temp = null;
        String yes = new String("Yes");
        String[][] state = new String[maxTrain][maxLen];
        String[] concept = new String[maxLen];
        FileReader fr = new FileReader("E:\\project\\java\\javalearn\\javalearn\\src\\main\\java\\AI\\arithmetic\\Find_s_train.txt");
        BufferedReader br = new BufferedReader(fr);
        while ((temp = br.readLine()) != null && i < 4) {
            state[i] = temp.split(" ");
            i++;
        }
        for (int j = 1; j < maxLen; j++) {
            concept[j] = state[0][j];
        }
        for (i = 1; i < maxTrain; i++) {
            if (state[i][maxLen - 1].equals(yes)) {
                for (int k = 1; k < maxLen - 1; k++) {
                    if (!state[i][k].equals(concept[k])) {
                        concept[k] = "?";
                    }
                }
            }
        }
        System.out.print("The concept is : ");
        for (i = 1; i < maxLen - 1; i++) {
            System.out.print(concept[i] + " ");
        }
        br.close();
        return;
    }
}
