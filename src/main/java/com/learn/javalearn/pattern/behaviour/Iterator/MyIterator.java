package pattern.behaviour.Iterator;

import java.util.ArrayList;

public class MyIterator {
	// 存放数据的集合
	private ArrayList<?> list;

	// 负责创建具体迭代器角色的工厂方法
	public Iterator iterator() {
		return new Itr(list);
	}

	// 作为内部类的具体迭代器角色
	private class Itr implements Iterator {
		ArrayList<?> myList;
		int position = 0;

		public Itr(ArrayList<?> list) {
			this.myList = list;
		}

		@Override
		public Object next() {
			Object obj = myList.get(position);
			position++;
			return obj;
		}

		@Override
		public boolean hasNext() {
			if (position >= myList.size()) {
				return false;
			} else {
				return true;
			}
		}

		// 不支持remove操作
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Alternating MyIterator does not support remove()");
		}
	}
}
