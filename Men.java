package am.aua.checkers.core;

import java.util.ArrayList;

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
    public ArrayList<Position> allDestinations(Checkers checkers, Position p) {
        Checkers.PieceColor myColor = checkers.getPieceAt(p).getPieceColor();
        int[] rankOfWhites = {-1, -1, 1, 1};
        int[] fileOfWhites = {1, -1, 1, -1};
        int[] rankOfBlacks = {1, 1, -1, -1};
        int[] fileOfBlacks = {1, -1, 1, -1};
        ArrayList<Position> result = new ArrayList<>();
        Position current;
        Position currentEat;
        Position current2;
        Position current2Eat;
        int counter = 0;
        if (myColor == Checkers.PieceColor.WHITE) {
            //System.out.println("1");
            current = Position.generateFromRankAndFile(p.getRank() - rankOfWhites[0], p.getPosition() + fileOfWhites[0]);
            //System.out.println("2");
            current2 = Position.generateFromRankAndFile(p.getRank() - rankOfWhites[1], p.getPosition() + fileOfWhites[1]);
            currentEat = Position.generateFromRankAndFile(current.getRank() - rankOfWhites[0], current.getPosition() + fileOfWhites[0]);
            current2Eat = Position.generateFromRankAndFile(current2.getRank() - rankOfWhites[0], current2.getPosition() + fileOfWhites[0]);

            if (checkers.isEmpty(current) || myColor != checkers.getPieceAt(current).getPieceColor()) {
                result.add(current);
            }
            if (checkers.getPieceAt(current).getPieceColor() == Checkers.PieceColor.BLACK && checkers.isEmpty(currentEat)) {
                result.add(currentEat);
                counter++;
            }
            if (checkers.isEmpty(current2) || myColor != checkers.getPieceAt(current2).getPieceColor()) {
                result.add(current2);
            }
            if (counter > 0) {
                for (int i = 0; i < 4; i++) {
                    current2 = Position.generateFromRankAndFile(current2.getRank() - rankOfWhites[i], current2.getPosition() + fileOfWhites[i]);
                    current2Eat = Position.generateFromRankAndFile(current2.getRank() - rankOfWhites[i], current2.getPosition() + fileOfWhites[i]);
                    if (checkers.getPieceAt(current2).getPieceColor() == Checkers.PieceColor.BLACK && checkers.isEmpty(current2Eat)) {
                        result.add(current2Eat);
                    }
                }
            }
            if (checkers.getPieceAt(current2).getPieceColor() == Checkers.PieceColor.BLACK && checkers.isEmpty(current2Eat)) {
                result.add(current2Eat);
                counter++;
            }
            if (p.getRank() == 8) {
                Kings kings = new Kings(Checkers.PieceColor.WHITE);
                kings.allDestinations(checkers, p);
            }


        }
        // move of black pieces
        else {
            current = Position.generateFromRankAndFile(p.getRank() - rankOfBlacks[0], p.getPosition() - fileOfBlacks[0]);
            current2 = Position.generateFromRankAndFile(p.getRank() - rankOfBlacks[1], p.getPosition() - fileOfBlacks[1]);
            currentEat = Position.generateFromRankAndFile(current.getRank() - rankOfWhites[0], current.getPosition() + fileOfWhites[0]);
            current2Eat = Position.generateFromRankAndFile(current2.getRank() - rankOfWhites[1], current2.getPosition() + fileOfWhites[1]);


            if (checkers.isEmpty(current) || myColor != checkers.getPieceAt(current).getPieceColor()) {
                result.add(current);
            } else if (checkers.getPieceAt(current).getPieceColor() == Checkers.PieceColor.WHITE && checkers.isEmpty(currentEat)) {
                result.add(currentEat);
                counter++;
            }
            if (checkers.isEmpty(current2) || myColor != checkers.getPieceAt(current2).getPieceColor()) {
                result.add(current2);
            } else if (counter > 0) {
                for (int i = 0; i < 4; i++) {
                    current2 = Position.generateFromRankAndFile(current.getRank() - rankOfWhites[i], current.getPosition() + fileOfWhites[i]);
                    current2Eat = Position.generateFromRankAndFile(current.getRank() - rankOfWhites[i], current.getPosition() + fileOfWhites[i]);
                    if ((current2 != null && checkers.getPieceAt(current).getPieceColor() == Checkers.PieceColor.WHITE) && checkers.isEmpty(current2Eat)) {
                        result.add(current2Eat);
                    }
                }
            } else if (checkers.getPieceAt(current2).getPieceColor() == Checkers.PieceColor.WHITE && checkers.isEmpty(current2Eat)) {
                result.add(current2Eat);
                counter++;
            }
            if (p.getRank() == 0) {
                Kings kings = new Kings(Checkers.PieceColor.BLACK);
                kings.allDestinations(checkers, p);
            }

        }
        return result;
    }
//    public int eatablePositions(Checkers checkers, Position p ){
//    	int[] rank= {1,1,-1,-1};
//    	int[] position= {1,-1,1,-1};
//    	int c=0;
//    	Position current2;
//    	Position current2Eat;
//    	for(int i=0; i<4; i++) {
//    		current2 = Position.generateFromRankAndFile(current2.getRank() - rank[i], current2.getPosition() + position[i]);
//    		current2Eat = Position.generateFromRankAndFile(current2.getRank() - rank[i], current2.getPosition() + position[i]);
//    		if((current2 !=null && checkers.getPieceAt(current2).getPieceColor() == Checkers.PieceColor.BLACK) && checkers.isEmpty(current2Eat)){
//
//    		}
//    	}
//    }
}
  
// 
//<<<<<<< Mendestinationbyrecursia
//
//
//
//            Position[] result = new Position[0];
//
//    public Position[] destination1(Chess chess, Position p) {
//
//        if (chess.getPieceAt(new Position((p.getRank() + 1), p.getFile() + 1)) == chess.getPieceAt(p)
//                || chess.isEmpty(new Position((p.getRank() + 2), p.getFile() + 2)) == false
//                || p.getRank() + 2 > 7 || p.getFile() + 2 > 7)
//            result = Position.appendPositionsToArray(result, new Position(p.getRank() + 2, p.getFile() + 2));
//
//        destination1(chess, new Position(p.getRank() + 2, p.getFile() + 2));
//
//
//        return result;
//
//    }
//
//
//    public Position[] destination2(Chess chess, Position p) {
//
//        if (chess.getPieceAt(new Position((p.getRank() + 1), p.getFile() - 1)) == chess.getPieceAt(p)
//                || chess.isEmpty(new Position((p.getRank() + 2), p.getFile() - 2)) == false
//                || p.getRank() + 2 > 7 || p.getFile() - 2 < 0)
//            result = Position.appendPositionsToArray(result, new Position(p.getRank() + 2, p.getFile() - 2));
//
//        destination2(chess, new Position(p.getRank() + 2, p.getFile() - 2));
//        return result;
//    }
//
//
//
//    public Position[] destination3(Chess chess, Position p) {
//
//
//        if (chess.getPieceAt(new Position((p.getRank() - 1), p.getFile() - 1)) == chess.getPieceAt(p)
//                || chess.isEmpty(new Position((p.getRank() - 2), p.getFile() - 2)) == false
//                || p.getRank() - 2 < 0 || p.getFile() - 2 < 0)
//            result = Position.appendPositionsToArray(result, new Position(p.getRank() - 2, p.getFile() - 2));
//
//
//        destination3(chess, new Position(p.getRank() - 2, p.getFile() - 2));
//        return result;
//
//
//    }
//
//
//    public Position[] destination4(Chess chess, Position p) {
//
//        if (chess.getPieceAt(new Position((p.getRank() - 1), p.getFile() + 1)) == chess.getPieceAt(p)
//                || chess.isEmpty(new Position((p.getRank() - 2), p.getFile() + 2)) == false
//                || p.getRank() - 2 < 0 || p.getFile() + 2 > 7)
//            result = Position.appendPositionsToArray(result, new Position(p.getRank() - 2, p.getFile() + 2));
//
//        destination4(chess, new Position(p.getRank() - 2, p.getFile() + 2));
//        return result;
//
//    }
//
//
//
//
//
//    public Position[] allDestinations(Chess chess, Position p) {
//        Position[] resultForWhite = new Position[0];
//        Position[] resultForBlack = new Position[0];
//
//
//        if (chess.isEmpty(new Position((p.getRank() + 1), p.getFile() + 1)) == true && p.getRank() + 1 <= 7 && p.getFile() + 1 <= 7)
//            resultForWhite = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() + 1, p.getFile() + 1));
//        if (chess.isEmpty(new Position((p.getRank() + 1), p.getFile() - 1)) == true && p.getRank() + 1 < 8 && p.getFile() - 1 >= 0)
//            resultForWhite = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() + 1, p.getFile() - 1));
//
//
//        if (chess.isEmpty(new Position((p.getRank() - 1), p.getFile() - 1)) == true && p.getRank() - 1 >= 0 && p.getFile() - 1 >= 0)
//            resultForBlack = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() - 1, p.getFile() - 1) );
//        if (chess.isEmpty(new Position((p.getRank() - 1), p.getFile() + 1)) == true && p.getRank() - 1 >= 0 && p.getFile() + 1 <= 7)
//            resultForBlack = Position.appendPositionsToArray(resultForWhite, new Position(p.getRank() - 1, p.getFile() + 1));
//
//
//        resultForWhite = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() + 2, p.getFile() + 2));
//        resultForWhite = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() - 2, p.getFile() - 2));
//        resultForWhite = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() + 2, p.getFile() - 2));
//        resultForWhite = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() - 2, p.getFile() + 2));
//
//
//        resultForBlack = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() + 2, p.getFile() + 2));
//        resultForBlack = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() - 2, p.getFile() - 2));
//        resultForBlack = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() + 2, p.getFile() - 2));
//        resultForBlack = Position.appendPositionsToArray(destination1(chess, p), new Position(p.getRank() - 2, p.getFile() + 2));
//
//
//        if (chess.getPieceAt(p).getPieceColor() == (Chess.PieceColor.WHITE))
//            return resultForWhite;
//        else if (chess.getPieceAt(p).getPieceColor() == (Chess.PieceColor.BLACK))
//            return resultForBlack;
//        else
//            return null;
//
//
//    }
//    
//
//
//=======
//        >>>>>>> main
//}
    
    
    
    
    //Armani grace
    
    
    
//                while (number != another) {
//                    another = 0;
//                    if (checkers.getPieceAt(new Position((p.getRank() + 1), p.getPosition() + 1)).getPieceColor() == (Checkers.PieceColor.WHITE)
//                            && checkers.isEmpty(new Position((p.getRank() + 2), p.getPosition() + 2))
//                            && p.getRank() + 2 <= 7 && p.getPosition() + 2 <= 7) {
//                        result = Position.appendPositionsToArray(result, new Position(p.getRank() + 2, p.getPosition() + 2));
//                    }else {
//                        another++;
//                    }
//                    if (checkers.getPieceAt(new Position((p.getRank() + 1), p.getPosition() - 1)).getPieceColor() == (Checkers.PieceColor.WHITE)
//                            && checkers.isEmpty(new Position((p.getRank() + 2), p.getPosition() - 2))
//                            && p.getRank() + 2 <= 7 && p.getPosition() - 2 >= 0) {
//                        result = Position.appendPositionsToArray(result, new Position(p.getRank() + 2, p.getPosition() - 2));
//                    }else {
//                        another++;
//                    }
//                    if (checkers.getPieceAt(new Position((p.getRank() - 1), p.getPosition() + 1)).getPieceColor() == (Checkers.PieceColor.WHITE)
//                            && checkers.isEmpty(new Position((p.getRank() - 2), p.getPosition() + 2))
//                            && p.getRank() - 2 >= 0 && p.getPosition() + 2 <= 7) {
//                        result = Position.appendPositionsToArray(result, new Position(p.getRank() - 2, p.getPosition() + 2));
//                    }else {
//                        another++;
//                    }
//                    if (checkers.getPieceAt(new Position((p.getRank() - 1), p.getPosition() - 1)).getPieceColor() == (Checkers.PieceColor.WHITE)
//                            && checkers.isEmpty(new Position((p.getRank() - 2), p.getPosition() - 2))
//                            && p.getRank() - 2 >= 0 && p.getPosition() - 2 >= 0) {
//                        result = Position.appendPositionsToArray(result, new Position(p.getRank() - 2, p.getPosition() - 2));
//                    }else {
//                        another++;
//                    }


//                while (number != another) {
//                    another = 0;
//                    if (checkers.getPieceAt(new Position((p.getRank() + 1), p.getPosition() + 1)).getPieceColor() == (Checkers.PieceColor.WHITE)
//                            && checkers.isEmpty(new Position((p.getRank() + 2), p.getPosition() + 2))
//                            && p.getRank() + 2 <= 7 && p.getPosition() + 2 <= 7) {
//                        result = Position.appendPositionsToArray(result, new Position(p.getRank() + 2, p.getPosition() + 2));
//                    }else {
//                        another++;
//                    }
//                    if (checkers.getPieceAt(new Position((p.getRank() + 1), p.getPosition() - 1)).getPieceColor() == (Checkers.PieceColor.WHITE)
//                            && checkers.isEmpty(new Position((p.getRank() + 2), p.getPosition() - 2))
//                            && p.getRank() + 2 <= 7 && p.getPosition() - 2 >= 0) {
//                        result = Position.appendPositionsToArray(result, new Position(p.getRank() + 2, p.getPosition() - 2));
//                    }else {
//                        another++;
//                    }
//                    if (checkers.getPieceAt(new Position((p.getRank() - 1), p.getPosition() + 1)).getPieceColor() == (Checkers.PieceColor.WHITE)
//                            && checkers.isEmpty(new Position((p.getRank() - 2), p.getPosition() + 2))
//                            && p.getRank() - 2 >= 0 && p.getPosition() + 2 <= 7) {
//                        result = Position.appendPositionsToArray(result, new Position(p.getRank() - 2, p.getPosition() + 2));
//                    }else {
//                        another++;
//                    }
//                    if (checkers.getPieceAt(new Position((p.getRank() - 1), p.getPosition() - 1)).getPieceColor() == (Checkers.PieceColor.WHITE)
//                            && checkers.isEmpty(new Position((p.getRank() - 2), p.getPosition() - 2))
//                            && p.getRank() - 2 >= 0 && p.getPosition() - 2 >= 0) {
//                        result = Position.appendPositionsToArray(result, new Position(p.getRank() - 2, p.getPosition() - 2));
//                    }else {
//                        another++;
//                    }
//                }

