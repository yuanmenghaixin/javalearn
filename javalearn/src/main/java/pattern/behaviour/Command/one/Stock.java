package pattern.behaviour.Command.one;

public class Stock {
	private String name = "ABC";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int quantity = 10;

	public void buy(){
	      System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
	   }

	public void sell(){
	      System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
	   }
}
