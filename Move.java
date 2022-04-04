public class Move {
	public Position initial=new Position();
	public Position result=new Position();
	/** 
	*constructor with two positions
	*@param ini,res:Initial and Result position type variables
	*/
	public Move(Position ini,Position res) {
		this.initial=ini;
		this.result=res;
	}
	/** 
	*copy constructor
	*@param a: Move type variable
	*/
	public Move(Move a) {
		this.initial=a.initial;
		this.result=a.result;
		
	}
	/**
	*getter for initial position
	*@return Initial position:
	*/
	public Position getInitial() {
		return this.initial;
	}
	/**
	*getter for resulting position
	*@return Result position:
	*/
	public Position getResult() {
		return this.result;
	}
	/** 
	*string representation of the position
	*@result String innterpretation of the given position e.g. [0,0]="A8":
	*/
	public String toString() {
	 return initial.toString(this.initial) +" "+ result.toString(this.result);
		
	}
	

}

