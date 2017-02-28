package pattern.create.Factory.FactoryAbstract.one;

import pattern.create.Factory.FactorySimple.one.Sender;

/**
 * 供应者，提供者
 * @author Peng.lv
 *
 */
public interface Provider {
	public Sender produce();
}
