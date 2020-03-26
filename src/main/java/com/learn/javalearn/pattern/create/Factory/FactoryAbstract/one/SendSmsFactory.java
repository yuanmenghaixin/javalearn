package pattern.create.Factory.FactoryAbstract.one;

import pattern.create.Factory.FactorySimple.one.Sender;
import pattern.create.Factory.FactorySimple.one.SmsSender;

/**
 * SendSms工厂类
 * 
 * @author Peng.lv
 *
 */
public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}
}
