package collection;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Peng.lv on 2017/6/20.
 * 哈希表（哈希表）
 　　A）【定义】
 　　　　属性继承于Hashtable.Properties类表示了一个持久的属性集。属性列表中每个键及其对应值都是一个字符串。
 　　　　属性类被许多Java类使用。例如，在获取环境变量时它们就作为System.getProperties（）方法的返回值。
 */
public class PropertiesMain {
    public static void main(String args []){
        Properties capitals = new Properties();
        Set states;
        String str;
        capitals.put("Illinois","Springfield");
        capitals.put("密苏里州","杰斐逊城");
        capitals.put("华盛顿","奥林匹亚");
        capitals.put("California","Sacramento");
        capitals.put("Indiana","Indianapolis"); //在哈希表中显示所有州和首都。
        states = capitals.keySet(); //获取键的set-view 
        Iterator itr = states.iterator();
        while(itr.hasNext()){
            str =(String)itr.next();
            System.out.println(""+
                    str + "的大写是"+ capitals.getProperty(str)+"。");
        }
        System.out.println(); //寻找状态不在列表中 - 指定默认的
        str = capitals.getProperty("Florida","Not Found");
        System.out.println("佛罗里达的首都是" + str +"。");
    }
}
