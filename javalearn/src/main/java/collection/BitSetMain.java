package collection;

import java.util.BitSet;

/**
 * Created by Peng.lv on 2017/6/20.
 * 位集合(位集合)

 * A)【定义】
 * 位集合类实现了一组可以单独设置和清除的位或标志。该类在处理一组布尔值的时候非常有用，你只需要给每个值赋值一 "位"，然后对位进行适当的设置或清除，就可以对布尔值进行操作了。
 * 如果你想学习Java可以来这个群，首先是二二零，中间是一四二，最后是九零六，里面有大量的学习资料可以下载。
 */
public class BitSetMain {

    public static void main(String args []){
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);
        //设置一些位
     for(int i = 0; i <16; i ++){
         if((i%2)==0)bits1.set(i);
         if((i%5)!= 0)bits2.set(i);
        }
        System.out.println("bit1：bits中的初始模式");
        System.out.println(bits1);
        System.out.println("\n Initial pattern in bits2：");
        System.out.println(bits2); // AND bits
        bits2.and(bits1);
        System.out.println("\n bits2 AND bits1：");
        System.out.println(bits2); // OR
        bits2.or(bits1);
        System.out.println("\n bits2 OR bits1：");
        System.out.println(bits2); // XOR bits
        bits2.xor(bits1);
        System.out.println("\n bits2 XOR bits1：");
        System.out.println(bits2);
    }
}
