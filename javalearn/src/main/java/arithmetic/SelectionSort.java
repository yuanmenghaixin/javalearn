package arithmetic;

/**
 * 选择排序
 * 每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。
 * ) 举例：数组 int[] arr={5,2,8,4,9,1};
 * <p>
 * -------------------------------------------------------
 * <p>
 * 第一趟排序： 原始数据：5  2  8  4  9  1
 * <p>
 * 最小数据1，把1放在首位，也就是1和5互换位置，
 * <p>
 * 排序结果：1  2  8  4  9  5
 * <p>
 * -------------------------------------------------------
 * <p>
 * 第二趟排序：
 * <p>
 * 第1以外的数据{2  8  4  9  5}进行比较，2最小，
 * <p>
 * 排序结果：1  2  8  4  9  5
 * Created by Peng.lv on 2018/11/7.
 */
//选择排序
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {12, 3, 2, 45, 65, 33, 1};
        System.out.println("《交换之前》：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        //选择排序的优化
        for (int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for (int j = k + 1; j < arr.length; j++) {// 选最小的记录
                if (arr[j] < arr[k]) {
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != k) {  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
            System.out.println();
            System.out.println(i + 1 + "次交换后：");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.println("《交换后》：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
