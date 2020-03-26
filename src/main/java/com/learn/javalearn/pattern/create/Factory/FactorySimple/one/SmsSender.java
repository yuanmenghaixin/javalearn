package pattern.create.Factory.FactorySimple.one;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is sms sender!");
	}
}