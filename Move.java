public class Move {
	private Position initial;
	private Position result;
	
	/** constructor with two positions
	*/
	public Move(Position ini,Position res) {
		this.initial = new Position(ini);
		this.result = new Position(res);
	}
	/** copy constructor */
	public Move(Move a) {
		this.initial = new Position(a.initial);
		this.result = new Position(a.result);
		
	}
	/** getter for initial position*/
	public Position getInitial() {
		return this.initial;
	}
	/** getter for resulting position*/
	public Position getResult() {
		return this.result;
	}
	/** string representation of the position*/
	public String toString() {
	 return this.initial.toString(this.initial) + " " + this.result.toString(this.result);
		
	}
	
	//setter for the initial
	// public void setInitial(Position newInitial) {
       // this.initial = new Position(newInitial);
   // }
	

}

