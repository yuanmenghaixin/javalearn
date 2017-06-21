package collection;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Peng.lv on 2017/6/20.
 * 向量（Vector）
 　　A）【定义】
 　　　　向量（向量）类和传统数组非常相似，但是矢量的大小能根据需要动态的变化。
 　　　　和数组一样，矢量对象的元素也能通过索引访问。
 　　　　使用矢量类最主要的好处就是在创建对象的时候不必给对象指定大小，它的大小会根据需要动态的变化。
 */
public class VectorMain {
        public static void main(String args []){//初始大小为3,增量为2 

        Vector v = new Vector(3,2);
        System.out.println("初始大小："+ v.size());
        System.out.println("初始容量："+
                v.capacity());
        v.addElement(new Integer(1));
        v.addElement(new Integer(2));
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));
        System.out.println("四个添加后的容量："+ v.capacity());
        v.addElement(new Double(5.45));
        System.out.println("Current capacity："+ v.capacity());
        v.addElement(new Double(6.08));
        v.addElement(new Integer(7));
        System.out.println("Current capacity："+ v.capacity());
        v.addElement(new Float(9.4));
        v.addElement(new Integer(10));
        System.out.println("Current capacity："+ v.capacity());
        v.addElement(new Integer(11));
        v.addElement(new Integer(12));
        System.out.println("First element："+ (Integer)v.firstElement());
        System.out.println("Last element："+ (Integer)v.lastElement());
        if(v.contains(new Integer(3)))
        System.out.println("Vector contains 3"); //枚举向量中的元素。
        //枚举
        Enumeration vEnum = v.elements();
        System.out.println("\n Elements in vector：");
        while(vEnum.hasMoreElements()){
            System.out.print(vEnum.nextElement()+"");
            System.out.println();
        }

    }
    }
