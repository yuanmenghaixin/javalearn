package collection;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by Peng.lv on 2017/6/20.
 * 哈希表(哈希表)
 　　A)【定义】　　
 　　　　Hashtable的类提供了一种在用户定义键结构的基础上来组织数据的手段。
 　　　　例如,在地址列表的哈希表中,你可以根据邮政编码作为键来存储和排序数据,而不是通过人名。
 */
public class HashtableMain {
    public static void main(String args []){//创建一个哈希映射
        Hashtable balance = new Hashtable();
        //枚举名称
        Enumeration names;
        String str;
        balance.put("Zara",new Double(3434.34));
        balance.put("Mahnaz",new Double(123.22));
        balance.put("Ayan",new Double(1378.00));
        balance.put("Daisy",new Double(99.22));
        balance.put("Qadir",new Double(-19.08)); //显示哈希表中的所有余额。
        names = balance.keys();
        while(names.hasMoreElements()){
            str =(String)names.nextElement();
            System.out.println(str +"："+
                    balance.get(str));
        }
        System.out.println(); //将1,000存入Zara的帐户
        Double bal =((Double)balance.get("Zara")).doubleValue();
        balance.put("Zara",new Double(bal + 1000));
        System.out.println("Zara的新余额："+ balance.get("Zara"));
    }
}
