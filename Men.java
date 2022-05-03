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
        if (this.getPieceColors() == Checkers.PieceColor.WHITE)
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

            if ((current != null) && ((checkers.isEmpty(current)) || (checkers.getPieceAt(p).getPieceColors() != checkers.getPieceAt(current).getPieceColors()))) {
                result = Position.appendPositionsToArray(result, current);
            }

            if (current2 != null && (checkers.getPieceAt(current2) != null) && (checkers.getPieceAt(p).getPieceColors() != checkers.getPieceAt(current2).getPieceColors())) {
                result = Position.appendPositionsToArray(result, current2);
            }

            return result;


        } else if (checkers.getTurn() == Checkers.PieceColor.BLACK) {
            Position[] result = new Position[0];
            Position current = Position.generateFromRankAndFile(p.getRank() - rankOfBlacks[0], p.getPosition() - fileOfBlacks[0]);
            Position current2 = Position.generateFromRankAndFile(p.getRank() - rankOfBlacks[1], p.getPosition() - fileOfBlacks[1]);


            if ((current != null) && (checkers.getPieceAt(current) != null) && (checkers.getPieceAt(p).getPieceColors() != checkers.getPieceAt(current).getPieceColors())) {
                result = Position.appendPositionsToArray(result, current);
            }

            if (current2 != null && (checkers.getPieceAt(current2) != null) && (checkers.getPieceAt(p).getPieceColors() != checkers.getPieceAt(current2).getPieceColors())) {
                result = Position.appendPositionsToArray(result, current2);
            }

            return result;

        }
        return new Position[0];
    }
    
    public Position[] allDestinations(Checkers checker, Position p) {
        Position[] resultForWhite = new Position[0];
        Position[] resultForBlack = new Position[0];
        
        
        if (checker.getPieceAt(new Position((p.getRank() + 1), p.getFile() + 1)) == null && p.getRank() + 1 <= 7 && p.getFile() + 1 <= 7)
			resultForWhite = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() + 1, p.getFile() + 1));
        if (checker.getPieceAt(new Position((p.getRank() + 1), p.getFile() - 1)) == null && p.getRank() + 1 < 8 && p.getFile() - 1 >= 0)
        	resultForWhite = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() + 1, p.getFile() - 1));
    
	 
        if (checker.getPieceAt(new Position((p.getRank() - 1), p.getFile() - 1)) == null && p.getRank() - 1 >= 0 && p.getFile() - 1 >= 0)
			resultForBlack = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() - 1, p.getFile() - 1) );
        if (checker.getPieceAt(new Position((p.getRank() - 1), p.getFile() + 1)) == null && p.getRank() - 1 >= 0 && p.getFile() + 1 <= 7)
        	resultForBlack = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() - 1, p.getFile() + 1));
	 
	 
        while (checker.getPieceAt(new Position((p.getRank() + 1), p.getFile() + 1)).getPieceColor() == (Checkers.PieceColor.BLACK) 
        		&& chess.getPieceAt(new Position((p.getRank() + 2), p.getFile() + 2)) == null
        		&& p.getRank() + 2 <= 7 && p.getFile() + 2 <= 7)
        	resultForWhite = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() + 2, p.getFile() + 2));
	 
        while (checker.getPieceAt(new Position((p.getRank() + 1), p.getFile() - 1)).getPieceColor() == (Checkers.PieceColor.BLACK) 
        		&& chess.getPieceAt(new Position((p.getRank() + 2), p.getFile() - 2)) == null
        		&& p.getRank() + 2 <= 7 && p.getFile() - 2 >= 0)
        	resultForWhite = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() + 2, p.getFile() - 2));
        
        while (checker.getPieceAt(new Position((p.getRank() - 1), p.getFile() + 1)).getPieceColor() == (Checkers.PieceColor.BLACK) 
        		&& chess.getPieceAt(new Position((p.getRank() - 2), p.getFile() + 2)) == null
        		&& p.getRank() - 2 >= 0 && p.getFile() + 2 <= 7)
        	resultForWhite = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() - 2, p.getFile() + 2));
        
        while (checker.getPieceAt(new Position((p.getRank() - 1), p.getFile() - 1)).getPieceColor() == (Checkers.PieceColor.BLACK) 
        		&& chess.getPieceAt(new Position((p.getRank() - 2), p.getFile() - 2)) == null
        		&& p.getRank() - 2 >= 0 && p.getFile() - 2 >= 0)
        	resultForWhite = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() - 2, p.getFile() - 2));
        
        
        
        while (checker.getPieceAt(new Position((p.getRank() + 1), p.getFile() + 1)).getPieceColor() == (Checkers.PieceColor.WHITE) 
        		&& chess.getPieceAt(new Position((p.getRank() + 2), p.getFile() + 2)) == null
        		&& p.getRank() + 2 <= 7 && p.getFile() + 2 <= 7)
        	resultForBlack = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() + 2, p.getFile() + 2));
	 
        while (checker.getPieceAt(new Position((p.getRank() + 1), p.getFile() - 1)).getPieceColor() == (Checkers.PieceColor.WHITE) 
        		&& chess.getPieceAt(new Position((p.getRank() + 2), p.getFile() - 2)) == null
        		&& p.getRank() + 2 <= 7 && p.getFile() - 2 >= 0)
        	resultForBlack = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() + 2, p.getFile() - 2));
        
        while (checker.getPieceAt(new Position((p.getRank() - 1), p.getFile() + 1)).getPieceColor() == (Checkers.PieceColor.WHITE) 
        		&& chess.getPieceAt(new Position((p.getRank() - 2), p.getFile() + 2)) == null
        		&& p.getRank() - 2 >= 0 && p.getFile() + 2 <= 7)
        	resultForBlack = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() - 2, p.getFile() + 2));
        
        while (checker.getPieceAt(new Position((p.getRank() - 1), p.getFile() - 1)).getPieceColor() == (Checkers.PieceColor.WHITE) 
        		&& chess.getPieceAt(new Position((p.getRank() - 2), p.getFile() - 2)) == null
        		&& p.getRank() - 2 >= 0 && p.getFile() - 2 >= 0)
        	resultForBlack = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() - 2, p.getFile() - 2));
	 
	 
        if (checker.getPieceAt(p).getPieceColor() == (Checkers.PieceColor.WHITE))
        	return resultForWhite;
        else if (checker.getPieceAt(p).getPieceColor() == (Checkers.PieceColor.BLACK))
        	return resultForBlack;
        else 
        	return null;
    
    
    }
}
