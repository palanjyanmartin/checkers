package am.aua.checkers.core;

/**
 * The <code>am.aua.checkers.core.Men</code> class contains the behaviour of Men pieces.
 * @author Arman Khachatryan
 * References
 * Martin Palanjyan's HW08.
 */

public class Men extends Piece {

    /**
     * A no-arg constructor that relies on the constructor of the parent class Piece, which by default makes the piece color WHITE.
     */
    public Men() {
        super();
    }

    /**
     * A parameterized constructor which relies on the constructor of the parent class Piece and initializes the piece color using @param pieceColor.
     *
     * @param pieceColor
     */


    public Men(Checkers.PieceColor pieceColor) {
        super(pieceColor);
    }

    /**
     * An overridden toString() method that returns "M" of type <code>String</code> if the color of the piece is WHITE
     * and returns "m" of type <code>String</code> if the color of the piece is BLACK.
     *
     * @return "M" or "m"
     */

    public String toString() {
        if (this.getPieceColors() == Checkers.PieceColor.WHITE)
            return "M";
        else
            return "m";
    }

    /**
     * A method that returns an array of type <code>Position</code> which is a set of all the positions into which a Men
     * might perform a valid move from a given position in the given ongoing checkers game.
     *
     * @param checkers the ongoing <code>am.aua.checkers.core.checkers</code> game
     * @param p     the position of the Men
     * @return a <code>am.aua.checkers.core.Position</code> array with all the positions
     * that a Men can move into from position <code>p</code>
     */

    public Position[] allDestinations(Checkers checkers, Position p) {
        return Men.reachablePositions(checkers, p);
    }

    /**
     * Generates and returns a set of all the positions into which a Men
     * might perform a valid move from a given position in the given ongoing
     * checkers game.
     *
     * @param checkers the ongoing <code>am.aua.checkers.core.checkers</code> game
     * @param p     the position of the Men
     * @return a <code>am.aua.checkers.core.Position</code> array with all the positions
     * that a Men can move into from position <code>p</code>
     */

    public static Position[] reachablePositions(Checkers checkers, Position p) {
    		/** 
    		 * work in progress
    		 */


}
}
