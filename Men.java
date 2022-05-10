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
    
     private ArrayList<Position> result = new ArrayList<Position>();
    
    public ArrayList<Position> allDestinations(Checkers checkers, Position p) {
        ArrayList<Position> result = new ArrayList<>();
        Checkers.PieceColor myColor = checkers.getPieceAt(p).getPieceColor();

        Position left = null;
        Position right = null;
        Position leftEat = null;
        Position rightEat=null;
        Position leftBackEat=null;
        Position rightBackEat=null;
        

        if (myColor == Checkers.PieceColor.WHITE) {
            left = Position.generateFromRankAndFile(p.getRank() - 1, p.getPosition() - 1);
            right = Position.generateFromRankAndFile(p.getRank() - 1, p.getPosition() + 1);
            leftEat= Position.generateFromRankAndFile(left.getRank()-1, left.getPosition()-1);
            rightEat= Position.generateFromRankAndFile(right.getRank()-1, right.getPosition()+1);
            leftBackEat=Position.generateFromRankAndFile(left.getRank()-1, left.getPosition()-1);
            rightBackEat= Position.generateFromRankAndFile(left.getRank()-1, left.getPosition()-1);
        } else {
            left = Position.generateFromRankAndFile(p.getRank() + 1, p.getPosition() - 1);
            right = Position.generateFromRankAndFile(p.getRank() + 1, p.getPosition() + 1);
        }
        if (left != null && left.getRank() >= 0 && left.getRank() <= 7 && left.getPosition() >= 0 && left.getPosition() <= 7 && checkers.isEmpty(left)) {
            result.add(left);
        }
        if (right != null && right.getRank() >= 0 && right.getRank() <= 7 && right.getPosition() >= 0 && right.getPosition() <= 7 && checkers.isEmpty(right)) {
            result.add(right);
        }


        return result;
    }

	public boolean eatable(Checkers checkers, Position p) {
			
		
			if (checkers.getPieceAt(new Position((p.getRank() + 1), p.getPosition() + 1)).getPieceColor() != checkers.getPieceAt(p).getPieceColor()
                 && checkers.isEmpty(new Position((p.getRank() + 2), p.getPosition() + 2))
                  && p.getRank() + 2 <= 7 && p.getPosition() + 2 <= 7) 
              return true;
			
          
          if (checkers.getPieceAt(new Position((p.getRank() + 1), p.getPosition() - 1)).getPieceColor() != checkers.getPieceAt(p).getPieceColor()
                  && checkers.isEmpty(new Position((p.getRank() + 2), p.getPosition() - 2))
                  && p.getRank() + 2 <= 7 && p.getPosition() - 2 >= 0) 
              return true;
          
          if (checkers.getPieceAt(new Position((p.getRank() - 1), p.getPosition() + 1)).getPieceColor() != checkers.getPieceAt(p).getPieceColor()
                  && checkers.isEmpty(new Position((p.getRank() - 2), p.getPosition() + 2))
                  && p.getRank() - 2 >= 0 && p.getPosition() + 2 <= 7) 
              return true;
          
          if (checkers.getPieceAt(new Position((p.getRank() - 1), p.getPosition() - 1)).getPieceColor() != checkers.getPieceAt(p).getPieceColor()
                  && checkers.isEmpty(new Position((p.getRank() - 2), p.getPosition() - 2))
                  && p.getRank() - 2 >= 0 && p.getPosition() - 2 >= 0) 
              return true;
          return false;
		}


}
