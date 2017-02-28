package pattern.behaviour.State.one;

public class CreatureState {
	 //状态接口  
    private interface State{  
          String response();  
    }  
    private class Forg implements State{  
          @Override
		public String response(){  
			return "Ribbet!";  
          }  
    }  
    private class Prince implements State{  
          @Override
		public String response(){  
       return "Darling!";  
          }  
    }  
    private State state = new Forg();  
    public void greet(){  
          System.out.println(state.response());  
    }  
    public void kiss(){  
          state = new Prince();  
    }  
    public static void main(String[] args){  
    	CreatureState creature = new CreatureState();  
          creature.greet();  
          creature.kiss();  
          creature.greet();  
    }   
}
