package collection.hashcode;

import java.util.HashMap;

/**
 * Created by Peng.lv on 2017/6/21.
 */
public class HashCodeMain {
    transient final int hashSeed = sun.misc.Hashing.randomHashSeed(this);
    final  int hash(Object k) {
        int h = 0;
        if (true) {
            if (k instanceof String) {
                return sun.misc.Hashing.stringHash32((String) k);
            }
            h = hashSeed;
        }

        h ^= k.hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public static void main (String[] args){
        System.out.println("字符串A的stringHash32："+sun.misc.Hashing.stringHash32("A"));
        System.out.println("字符串B的stringHash32："+sun.misc.Hashing.stringHash32("B"));
        System.out.println("字符串C的stringHash32："+sun.misc.Hashing.stringHash32("C"));
        System.out.println("字符串A1的stringHash32："+sun.misc.Hashing.stringHash32("A1"));
        System.out.println("字符串B1的stringHash32："+sun.misc.Hashing.stringHash32("B1"));
        System.out.println("字符串C1的stringHash32："+sun.misc.Hashing.stringHash32("C1"));
        System.out.println("字符串AA的stringHash32："+sun.misc.Hashing.stringHash32("AA"));
        System.out.println("字符串BB的stringHash32："+sun.misc.Hashing.stringHash32("BB"));
        System.out.println("字符串CC的stringHash32："+sun.misc.Hashing.stringHash32("CC"));
        System.out.println("字符串'你好'的stringHash32："+sun.misc.Hashing.stringHash32("你好"));
        System.out.println("字符串1的stringHash32："+sun.misc.Hashing.stringHash32("1"));
        System.out.println("字符串2的stringHash32："+sun.misc.Hashing.stringHash32("2"));
        System.out.println("字符串3的stringHash32："+sun.misc.Hashing.stringHash32("3"));
        System.out.println("*****************************************************");
        System.out.println("字符串A的HashCode："+new HashCodeMain().hash("A"));
        System.out.println("字符串B的HashCode："+new HashCodeMain().hash("B"));
        System.out.println("字符串C的HashCode："+new HashCodeMain().hash("C"));
        System.out.println("字符串A的HashCode："+new HashCodeMain().hash("A"));
        System.out.println("字符串B的HashCode："+new HashCodeMain().hash("B"));
        System.out.println("字符串C的HashCode："+new HashCodeMain().hash("C"));
        System.out.println("*****************************************************");
        System.out.println("字符串1的HashCode："+new HashCodeMain().hash(1));
        System.out.println("字符串2的HashCode："+new HashCodeMain().hash(2));
        System.out.println("字符串3的HashCode："+new HashCodeMain().hash(3));
        System.out.println("字符串1的HashCode："+new HashCodeMain().hash(1));
        System.out.println("字符串2的HashCode："+new HashCodeMain().hash(2));
        System.out.println("字符串3的HashCode："+new HashCodeMain().hash(3));
        System.out.println("*****************************************************");
        System.out.println("字符串A的HashCode："+"A".hashCode());
        System.out.println("字符串B的HashCode："+"B".hashCode());
        System.out.println("字符串C的HashCode："+"C".hashCode());
        System.out.println("字符串AA的HashCode："+"AA".hashCode());
        System.out.println("字符串BB的HashCode："+"BB".hashCode());
        System.out.println("字符串CC的HashCode："+"CC".hashCode());
        System.out.println("Integer1的HashCode："+new Integer(1).hashCode());
        System.out.println("Integer2的HashCode："+new Integer(2).hashCode());
        System.out.println("Integer3的HashCode："+new Integer(3).hashCode());
        System.out.println("Double1.0的HashCode："+new Double(1.0).hashCode());
        System.out.println("Double2.0的HashCode："+new Double(2.0).hashCode());
        System.out.println("Double3.0的HashCode："+new Double(1.00).hashCode());


    }
}
