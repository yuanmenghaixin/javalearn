package pattern.behaviour.State.one;
//状态实现类1 
public class Implementation1 implements State {
	@Override
	public void operation1(){  
        System.out.println("Implementation1.operation1()");  
    }

	@Override
	public void operation2(){  
        System.out.println("Implementation1.operation2()");  
    }

	@Override
	public void operation3(){  
        System.out.println("Implementation1.operation3()");  
    }
}
