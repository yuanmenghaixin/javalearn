package learn.shift;

/**
 * 位移计算
 * Created by Peng.lv on 2017/11/28.
 */
public class ShiftMain {
    public static void main(String[] args) {
        int number = 2;
        //原始数二进制
        printInfo(number);
        //<<      :     左移运算符，num << 1,相当于num乘以2
        number = number << 1;
        //左移一位
        printInfo(number);
        number = number >> 1;
        //右移一位
        printInfo(number);
        number = number >>> 2;
        //>>>    :     无符号右移，忽略符号位，空位都以0补齐
        printInfo(number);
    }

    /**
     * 输出一个int的二进制数
     * @param num
     */
    private static void printInfo(int num){
        System.out.println("换算成10进制结果："+num);
        System.out.println("换算成2进制结果："+Integer.toBinaryString(num));
    }
}
