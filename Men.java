package am.aua.checkers.core;

/**
 * The <code>am.aua.Checkers.core.Men</code> class contains the behaviour of Men pieces.
 * @author Martin Palanjyan
 * References Martin Palanjyan HW08
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
     * An overridden toString() method that returns "P" of type <code>String</code> if the color of the piece is WHITE
     * and returns "p" of type <code>String</code> if the color of the piece is BLACK.
     *
     * @return "P" or "p"
     */

    public String toString() {
        if (this.getPieceColor() == Checkers.PieceColor.WHITE)
            return "M";
        else
            return "m";
    }

    /**
     * Generates and returns a set of all the positions into which a Men
     * might perform a valid move from a given position in the given ongoing
     * Checkers game.
     *
     * @param checkers the ongoing <code>am.aua.Checkers.core.Checkers</code> game
     * @param p     the position of the Men
     * @return a <code>am.aua.Checkers.core.Position</code> array with all the positions
     * that a Men can move into from position <code>p</code>
     */
    public Position[] allDestinations(Checkers checkers, Position p) {
        int[] rankOfWhites = {-1, -1};
        int[] fileOfWhites = {1, -1};
        int[] rankOfBlacks = {1, 1};
        int[] fileOfBlacks = {1, -1};
        if (checkers.getTurn() == Checkers.PieceColor.WHITE) {
            Position[] result = new Position[0];
            Position current = Position.generateFromRankAndFile(p.getRank() - rankOfWhites[0], p.getPosition() - fileOfWhites[0]);
            Position current2 = Position.generateFromRankAndFile(p.getRank() - rankOfWhites[1], p.getPosition() - fileOfWhites[1]);

            if ((current != null) && ((checkers.isEmpty(current)) || (checkers.getPieceAt(p).getPieceColor() != checkers.getPieceAt(current).getPieceColor()))) {
                result = Position.appendPositionsToArray(result, current);
            }

            if (current2 != null && (checkers.getPieceAt(current2) != null) && (checkers.getPieceAt(p).getPieceColor() != checkers.getPieceAt(current2).getPieceColor())) {
                result = Position.appendPositionsToArray(result, current2);
            }

            return result;


        } else if (checkers.getTurn() == Checkers.PieceColor.BLACK) {
            Position[] result = new Position[0];
            Position current = Position.generateFromRankAndFile(p.getRank() - rankOfBlacks[0], p.getPosition() - fileOfBlacks[0]);
            Position current2 = Position.generateFromRankAndFile(p.getRank() - rankOfBlacks[1], p.getPosition() - fileOfBlacks[1]);


            if ((current != null) && (checkers.getPieceAt(current) != null) && (checkers.getPieceAt(p).getPieceColor() != checkers.getPieceAt(current).getPieceColor())) {
                result = Position.appendPositionsToArray(result, current);
            }

            if (current2 != null && (checkers.getPieceAt(current2) != null) && (checkers.getPieceAt(p).getPieceColor() != checkers.getPieceAt(current2).getPieceColor())) {
                result = Position.appendPositionsToArray(result, current2);
            }

            return result;

        }
        return new Position[0];
    }
     public void becomeKing() {
    	if(this.color==Checkers.PieceColor.WHITE) {
    		if(this.getRank()==8) {
    			this.board[this.getRank()][this.getPosition()]=(Kings)(Piece)this;
    		}
    		else if(this.color==Checkers.PieceColor.BLACK) {
        		if(this.getRank()==0) {
        			this.board[this.getRank()][this.getPosition()]=(Kings)(Piece)this;
    	}
    }
}

