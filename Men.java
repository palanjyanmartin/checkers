package am.aua.checkers.core;

/**
 * The <code>am.aua.Checkers.core.Men</code> class contains the behaviour of Men pieces.
 *
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
     * @param p        the position of the Men
     * @return a <code>am.aua.Checkers.core.Position</code> array with all the positions
     * that a Men can move into from position <code>p</code>
     */
    public Position[] allDestinations(Checkers checkers, Position p) {
        Checkers.PieceColor myColor = checkers.getPieceAt(p).getPieceColor();
        int[] rankOfWhites = {-1, -1};
        int[] fileOfWhites = {1, -1};
        int[] rankOfBlacks = {1, 1};
        int[] fileOfBlacks = {1, -1};
        Position[] result = new Position[0];
        Position current;
        Position current2;
        if (myColor == Checkers.PieceColor.WHITE) {
            //System.out.println("1");
            current = Position.generateFromRankAndFile(p.getRank() - rankOfWhites[0], p.getPosition() + fileOfWhites[0]);
            //System.out.println("2");
            current2 = Position.generateFromRankAndFile(p.getRank() - rankOfWhites[1], p.getPosition() + fileOfWhites[1]);

            if ((current != null) && ((checkers.isEmpty(current)) || (checkers.getPieceAt(p).getPieceColor() != checkers.getPieceAt(current).getPieceColor()))) {
                result = Position.appendPositionsToArray(result, current);
            }

            if ((current2 != null) && ((checkers.isEmpty(current2)) || (checkers.getPieceAt(p).getPieceColor() != checkers.getPieceAt(current2).getPieceColor()))) {
                result = Position.appendPositionsToArray(result, current2);
            }

            if (p.getRank() == 8) {
                Kings kings = new Kings(Checkers.PieceColor.WHITE);
                kings.allDestinations(checkers,p);

            }


        } else {
            current = Position.generateFromRankAndFile(p.getRank() - rankOfBlacks[0], p.getPosition() - fileOfBlacks[0]);
            current2 = Position.generateFromRankAndFile(p.getRank() - rankOfBlacks[1], p.getPosition() - fileOfBlacks[1]);


            if ((current != null) && ((checkers.isEmpty(current)) || (checkers.getPieceAt(p).getPieceColor() != checkers.getPieceAt(current).getPieceColor()))) {
                result = Position.appendPositionsToArray(result, current);
            }

            if ((current2 != null) && ((checkers.isEmpty(current2)) || (checkers.getPieceAt(p).getPieceColor() != checkers.getPieceAt(current2).getPieceColor()))) {
                result = Position.appendPositionsToArray(result, current2);
            }

            if (p.getRank() == 0) {
                Kings kings = new Kings(Checkers.PieceColor.BLACK);
                kings.allDestinations(checkers,p);
            }

        }
        return result;
    }
    
    
    
    Position[] result = new Position[0];
    
    public Position[] destination1(Chess chess, Position p) {
    	
    	if (chess.getPieceAt(new Position((p.getRank() + 1), p.getFile() + 1)) == chess.getPieceAt(p)
        		|| chess.isEmpty(new Position((p.getRank() + 2), p.getFile() + 2)) == false
        		|| p.getRank() + 2 > 7 || p.getFile() + 2 > 7)
    		 result = Position.appendPositionsToArray(result, new Position(p.getRank() + 2, p.getFile() + 2));
    	
    	destination1(chess, new Position(p.getRank() + 2, p.getFile() + 2));
    	
    	
    	return result;
		
    }
    

    public Position[] destination2(Chess chess, Position p) {
    	
    	if (chess.getPieceAt(new Position((p.getRank() + 1), p.getFile() - 1)) == chess.getPieceAt(p)
        		|| chess.isEmpty(new Position((p.getRank() + 2), p.getFile() - 2)) == false
        		|| p.getRank() + 2 > 7 || p.getFile() - 2 < 0)
    		 result = Position.appendPositionsToArray(result, new Position(p.getRank() + 2, p.getFile() - 2));
    	
    	destination2(chess, new Position(p.getRank() + 2, p.getFile() - 2));
		return result;
    }
    
    

    public Position[] destination3(Chess chess, Position p) {
	
	
    	if (chess.getPieceAt(new Position((p.getRank() - 1), p.getFile() - 1)) == chess.getPieceAt(p)
    		|| chess.isEmpty(new Position((p.getRank() - 2), p.getFile() - 2)) == false
    		|| p.getRank() - 2 < 0 || p.getFile() - 2 < 0)
		 result = Position.appendPositionsToArray(result, new Position(p.getRank() - 2, p.getFile() - 2));
	
	
    	destination3(chess, new Position(p.getRank() - 2, p.getFile() - 2));
    	return result;
    	
	
    }  


    public Position[] destination4(Chess chess, Position p) {
	
    	if (chess.getPieceAt(new Position((p.getRank() - 1), p.getFile() + 1)) == chess.getPieceAt(p)
    		|| chess.isEmpty(new Position((p.getRank() - 2), p.getFile() + 2)) == false
    		|| p.getRank() - 2 < 0 || p.getFile() + 2 > 7)
    		result = Position.appendPositionsToArray(result, new Position(p.getRank() - 2, p.getFile() + 2));
	
    	destination4(chess, new Position(p.getRank() - 2, p.getFile() + 2));
    	return result;
	
    }
    
    
    
    
    
    public Position[] allDestinations(Chess chess, Position p) {
        Position[] resultForWhite = new Position[0];
        Position[] resultForBlack = new Position[0];
        
        
        if (chess.isEmpty(new Position((p.getRank() + 1), p.getFile() + 1)) == true && p.getRank() + 1 <= 7 && p.getFile() + 1 <= 7)
			resultForWhite = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() + 1, p.getFile() + 1));
        if (chess.isEmpty(new Position((p.getRank() + 1), p.getFile() - 1)) == true && p.getRank() + 1 < 8 && p.getFile() - 1 >= 0)
        	resultForWhite = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() + 1, p.getFile() - 1));
    
	 
        if (chess.isEmpty(new Position((p.getRank() - 1), p.getFile() - 1)) == true && p.getRank() - 1 >= 0 && p.getFile() - 1 >= 0)
			resultForBlack = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() - 1, p.getFile() - 1) );
        if (chess.isEmpty(new Position((p.getRank() - 1), p.getFile() + 1)) == true && p.getRank() - 1 >= 0 && p.getFile() + 1 <= 7)
        	resultForBlack = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() - 1, p.getFile() + 1));
        
        
        resultForWhite = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() + 2, p.getFile() + 2));
        resultForWhite = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() - 2, p.getFile() - 2));
        resultForWhite = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() + 2, p.getFile() - 2));
        resultForWhite = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() - 2, p.getFile() + 2));
        
        
        resultForBlack = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() + 2, p.getFile() + 2));
        resultForBlack = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() - 2, p.getFile() - 2));
        resultForBlack = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() + 2, p.getFile() - 2));
        resultForBlack = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() - 2, p.getFile() + 2));
	 
	 
        if (chess.getPieceAt(p).getPieceColor() == (Chess.PieceColor.WHITE))
        	return resultForWhite;
        else if (chess.getPieceAt(p).getPieceColor() == (Chess.PieceColor.BLACK))
        	return resultForBlack;
        else 
        	return null;
    
    
    }
    


}
