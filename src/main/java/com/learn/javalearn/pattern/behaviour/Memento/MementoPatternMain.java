package pattern.behaviour.Memento;

/**
 * 主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，个人觉得叫备份模式更形象些，通俗的讲下：假设有原始类A，A中有各种属性，
 * A可以决定需要备份的属性，备忘录类B是用来存储A的一些内部状态，类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作。
 * Memento备忘录设计模式 Memento备忘录设计模式是一个保存另外一个对象内部状态拷贝的对象，这样以后就可以将该对象恢复到以前保存的状态
 * Memento备忘录设计模式有以下3个重要角色： Originator：需要保存内部状态的对象。
 * Caretaker：为Originator保存并恢复状态的对象。 Memento：存放Originator内部状态的对象。
 * 
 * @author Peng.lv
 *
 */
public class MementoPatternMain {
	public static void main(String[] args) {
		/*Originator originator = new Originator("State1");//创建原始的备忘对象
		Storage storage = new Storage();//创建保存备忘对象的栈
		storage.addMemento(originator.createMemento(originator.getState()));
		originator.setState("State2");
		String restore = storage.getMemento().getState();//最初的状态
		System.out.println("Current originator state=" + originator.getState() + ",restore state=" + restore);*/
		
		// 创建原始类  
		Originator origi = new Originator("egg");  
        // 创建备忘录  
        Storage storage = new Storage(origi.createMemento("egg"));  
        // 修改原始类的状态  
        System.out.println("初始化状态为：" + origi.getState());  
        origi.setState("niu");  
        System.out.println("修改后的状态为：" + origi.getState());  
  
        // 回复原始类的状态  
        origi.restoreMemento(storage.getMemento2());  
        System.out.println("恢复后的状态为：" + origi.getState());  
	}
}
