package pattern.structure.Flyweight.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 共享元工厂 lyweight享元设计模式是为了避免大量拥有相同内容的小类重复创建，而使大家共享一个类的模式。
 * Flyweight享元设计模式实质是运用一个简单工厂方法模式，外加一个单类模式实现细粒度原件的共享。
 * Flyweight享元设计模式使用对象池存放内部对象，当需要内部对象时首先判断对象池中是否存在，如果存在直接返回，如果不存在创建一个对象放入对象池中返回。
 * 
 * @author Peng.lv
 *
 */
public class AuthorFactory {
	private static Map<String, Author> authors = new HashMap<String, Author>();

	public static Author getAuthor(String name) {
		Author author = authors.get(name);
		if (author == null) {
			author = new Author(name);
			authors.put(name, author);
		}
		return author;
	}
}
