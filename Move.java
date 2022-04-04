public class Move {
	/** 
	*constructor with two positions
	*@param ini,res:Initial and Result position type variables
  */
	private Position initial;
	private Position result;
	
	/** constructor with two positions
	*/
	public Move(Position ini,Position res) {
		this.initial = new Position(ini);
		this.result = new Position(res);
	}
	/** 
	*copy constructor
	*@param a: Move type variable
	*/
	public Move(Move a) {
		this.initial = new Position(a.initial);
		this.result = new Position(a.result);
		
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
	 return this.initial.toString(this.initial) + " " + this.result.toString(this.result);
		
	}
	
	//setter for the initial
	// public void setInitial(Position newInitial) {
       // this.initial = new Position(newInitial);
   // }
	

}

