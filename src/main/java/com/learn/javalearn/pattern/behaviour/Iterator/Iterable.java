package pattern.behaviour.Iterator;

/**
 * 容器迭代化接口，凡是实现此接口的集合容器距可以生成相应的迭代器
 * 
 * @author Peng.lv
 *
 * @param <T>
 */
public interface Iterable<T> {
	// 产生迭代器，将容器对象转换为迭代器对象
	/**
	 * Returns an iterator over a set of elements of type T.
	 *
	 * @return an Iterator.
	 */
	Iterable<T> iterator();
}
