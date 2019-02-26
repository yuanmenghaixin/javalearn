package pattern.create.Factory.FactoryAbstract.one;

import pattern.create.Factory.FactorySimple.one.Sender;

/**
 * 工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则，
 * 所以，从设计角度考虑，有一定的问题，
 * 如何解决？就用到抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码
 *
 * @author Peng.lv
 * @seejava.util.ResourceBundle#getBundle()
 * @seejava.nio.charset.Charset#forName()
 * @see java.util.Calendar#getInstance()
 * @see java.util.Arrays#asList()
 * @see java.net.URL#openConnection()
 * @see java.sql.DriverManager#getConnection()
 * @see java.sql.Connection#createStatement()
 * @see java.sql.Statement#executeQuery()
 * @see java.text.NumberFormat#getInstance()
 * @see java.lang.management.ManagementFactory (強桳getXXX()曽朄)
 * @see javax.xml.parsers.DocumentBuilderFactory#newInstance()
 * @see javax.xml.transform.TransformerFactory#newInstance()
 * @see javax.xml.xpath.XPathFactory#newInstance()
 */
public class FactoryAbstractTest {

    public static void main(String[] args) {
        //TODO to java.util.Calendar.getInstance();
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
