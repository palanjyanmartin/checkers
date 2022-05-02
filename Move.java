package am.aua.checkers.core;

/**
 * The class Move
 * This class is created to get an opportunity to identify the origin position of our object and after using some methods being able to move it to the destination position.
 * @author martinpalanjyan
 * @author armankhachatryan
 * @author gorhovakimyan
 * References
 * Martin Palanjyan's Homework 07
 */

public class Move {
    /**
     * Instance variables of the class Move
     */

    private Position origin;
    private Position destination;


    /**
     * Constructor that receives two Position parameters and initializes both instance variables accordingly.
     *
     * @param origin
     * @param destination
     */
    public Move(Position origin, Position destination) {
        this.origin = new Position(origin);
        this.destination = new Position(destination);
    }

    /**
     * Copy constructor.
     *
     * @param that
     */
    public Move(Move that) {
        this.origin = new Position(that.origin);
        this.destination = new Position(that.destination);

    }

    /**
     * An accessor for the origin.
     *
     * @return
     */
    public Position getOrigin() {
        return new Position(this.origin);
    }

    /**
     * An accessor for the destination.
     *
     * @return
     */
    public Position getDestination() {
        return new Position(this.destination);
    }

   
    /**
     * Method that generates and returns a string representation of the move with a format like "C2 C4".
     *
     * @return
     */
    public String toString() {
        return this.origin.toString() + " " + this.destination.toString();


    }


}
