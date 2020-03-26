package collection;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Peng.lv on 2017/6/20.
 * 栈（堆栈）
 　　A）【定义】
 　　　　栈（堆栈）实现了一个后进先出（LIFO）的数据结构。
 　　　　你可以把栈理解为对象的垂直分布的栈，当你添加一个新元素时，就将新元素放在其他元素的顶部。
 　　　　当你从栈中取元素的时候，就从栈顶取一个元素。换句话说，最后进栈的元素最先被取出。
 */
public class StackMain {
    public static void showpush(Stack st, int a){
        st.push(new Integer(a));
        System.out.println("入栈：push("+ a +")");
        System.out.println("stack："+ st);
    } static void showpop(Stack st){
        System.out.print("出栈操作： pop  - >");
        int a =(int)st.pop();
        System.out.println("一");
        System.out.println("出栈的值：stack："+ a);
    } public static void main(String args []){
        Stack st = new Stack();
        System.out.println("stack："+ st);
        showpush(st,42);
        showpush(st,66);
        showpush(st,99);
        showpop(st);
        showpop(st);
        showpop(st);
        try{
            showpop(st);
        } catch(EmptyStackException e){
            System.out.println("empty stack");
        }
    }
}
