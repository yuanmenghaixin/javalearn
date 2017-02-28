package pattern.create.Factory.FactoryMethod;

//奔驰车工厂  
class BenzCarFactory extends CarFactory {
	@Override
	public ICar createCar() {
		return new BenzCar();
	}
}
