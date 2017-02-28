package pattern.create.Factory.FactoryMethod;

//宝马车工厂  
class BMWCarFactory extends CarFactory {
	@Override
	public ICar createCar() {
		return new BMWCar();
	}
}
