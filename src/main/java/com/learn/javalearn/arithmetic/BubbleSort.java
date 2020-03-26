package arithmetic;

/**
 * 冒泡排序
 * 相邻连个位置的树比较，并互换位置
 * Created by Peng.lv on 2018/11/7.
 */
public class BubbleSort {
    private static void fromForwardsToBackwards(int[] score){//从右边最小的开始往左排序
        for(int i =0;i < score.length - 1;i++) {
            for(int j = 0;j <  score.length - 1-i;j++){// j开始等于0，
                if(score[j] < score[j+1]) {
                    int temp = score[j];
                    score[j] = score[j+1];
                    score[j+1] = temp;
                }
            }
            System.out.println();
            System.out.println(i + 1 + "次交换后：");
            for (int num : score) {
                System.out.print(num + " ");
            }
        }
    }
    private static void fromBackwardsToForwards(int[] score){//从左边最大的开始往右排序
        for(int i =0;i < score.length - 1;i++) {
            for(int j = (score.length - 2);j >= i;j--) {
                if(score[j] < score[j+1])
                {
                    int temp = score[j];
                    score[j] = score[j+1];
                    score[j+1] = temp;
                }
            }
            System.out.println();
            System.out.println(i + 1 + "次交换后：");
            for (int num : score) {
                System.out.print(num + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[] arr_1 = {12, 3, 2, 45, 65, 33, 1};
        System.out.println("《第一种方法交换之前》：");
        for (int num : arr_1) {
            System.out.print(num + " ");
        }
        fromForwardsToBackwards(arr_1);
        System.out.println();
        System.out.println("《第一种方法交换后》：");
        for (int num : arr_1) {
            System.out.print(num + " ");
        }
        int[] arr_2 = {12, 3, 2, 45, 65, 33, 1};
        System.out.println();
        System.out.println("《第二种方法交换之前》：");
        for (int num : arr_2) {
            System.out.print(num + " ");
        }
        fromBackwardsToForwards(arr_2);
        System.out.println();
        System.out.println("《第二种方法交换后》：");
        for (int num : arr_2) {
            System.out.print(num + " ");
        }
    }
}
