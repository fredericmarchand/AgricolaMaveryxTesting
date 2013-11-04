package agricola;
//Author: Robert Souter 100802267
//Supervisor: Jean-Pierre Corriveau Ph.D.
//Carleton University
//School of Computer Science
//COMP 4905
//Winter 2013

public class Space {
	private boolean square;
	private boolean valid;
	private char type;
	private int stack;
	
	public Space(){
		type='e';
		square=false;
		valid=true;
		stack=0;
		//e= empty, w=wood room, p=pasture, c=clay room, t=stone room, f=field, x=fence, v=vertical pasture, h=horizontal pasture, V=vertical pasture
		
	}
	
	public boolean setType(char t){
		if (type!='p'){
		
			if (t=='V'&&type=='h'){
				type='p';
				return true;
			}
			else if (type=='V'&&t=='h'){
				type='p';
				return true;
			}
			else{
				type=t;
				return false;
			}
		}
		else if (t=='s'){
			
			type='s';
			return false;
		}
		else
			return false;
	}
	
	public void setStack(int i){
		stack=i;
	}
	
	public void decStack(){
		stack--;
	}
	
	public int getStack(){
		return stack;
	}
	
	public void setSquare(){
		square=true;
	}
	
	public void setValid(){
		valid=false;
	}
	
	public boolean isSquare(){
		return square;
	}
	public boolean isValid(){
		return valid;
	}
	
	
	public char getType(){
		return type;
	}
	

		
}