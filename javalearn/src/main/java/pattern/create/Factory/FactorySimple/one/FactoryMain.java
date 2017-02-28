package pattern.create.Factory.FactorySimple.one;

public class FactoryMain {
	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce("sms");
		sender.send();
//		 SendMoreFactory moreFactory = new SendMoreFactory();  
//	        Sender sender = factory.produceMail();  
//	        sender.Send(); 
		/*Sender sender = SendFactory.produceMail();  
        sender.Send(); */
	}
}
