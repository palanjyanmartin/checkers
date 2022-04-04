public class Move {
	public Position initial=new Position();
	public Position result=new Position();
	/** constructor with two psoitions*/
	public Move(Position ini,Position res) {
		this.initial=ini;
		this.result=res;
	}
	/** copy constructor */
	public Move(Move a) {
		this.initial=a.initial;
		this.result=a.result;
		
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
	 return initial.toString(this.initial) +" "+ result.toString(this.result);
		
	}
	

}

