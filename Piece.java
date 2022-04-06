/**
 * @author Gor Hovakimyan <a href="mailto:gor_hovakimyan@edu.aua.am">gor_hovakimyan@edu.aua.am</a>
 * @version 1.0
 * @since 1.0
 */
public class Piece {
	
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
	public Piece(Chess.PieceColor color) {
		this.color = color;
	}
	

    /**
     * Accessor method for the color of the piece.
     *
     * @return          the color of the piece
     */
	public Chess.PieceColor getPiece() {
		return this.color;
	}
	
	/** In this moment it just returns null. */
	public Position[] allDestinations(Chess chess, Position p) {
		return null;
	}
}
