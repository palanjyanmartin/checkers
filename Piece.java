package am.aua.checkers.core;
/**
 * @author Gor Hovakimyan
* References Martin Palanjyan's HW09
 */
public abstract class Piece {
	
/** represent the color of piece */
	private Chess.PieceColor color;
	
	/**
     * A no-arg constructor, initializes with WHITE .
     */
	public Piece() {
	 this.color = color.WHITE;
	}
	
	 /**
     * A copy constructor, initializes according to another
     * <code>Chess.PieceColor</code> enum variable.
     */
    public abstract Position[] allDestinations(Chess chess, Position p);

    /**
     * An accessor for the color that cannot be overriden.
     *
     * @return
     */

    public final Chess.PieceColor getPieceColor() {
        return this.color;
    }


    public Piece clone() {
        try {
            Piece copy = (Piece) super.clone();
            copy.color = color;
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }


    }

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            Piece otherPiece = (Piece) otherObject;
            return (this.color.equals(otherPiece.getPieceColor()));
        }


    }
}
