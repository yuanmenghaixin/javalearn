package pattern.structure.Flyweight.one;
/**
 * 将Author作者类设计为可共享的享元(一个作者有多本书)
 * @author Peng.lv
 *
 */
public class Author {
	// 内部状态
	private String name;

	public String getName() {
		return name;
	}

	public Author(String name) {
		this.name = name;
	}
}
