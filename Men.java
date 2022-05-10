package am.aua.checkers.core;

import java.awt.Color;
import java.util.ArrayList;

import am.aua.checkers.core.*;
import am.aua.checkers.core.Checkers.PieceColor;

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
        ArrayList<Position> result = new ArrayList<>();
        Checkers.PieceColor myColor = checkers.getPieceAt(p).getPieceColor();

        Position left = null;
        Position right = null;
        Position leftEat = null;
        Position rightEat = null;


        if (myColor == Checkers.PieceColor.WHITE) {
            left = Position.generateFromRankAndFile(p.getRank() - 1, p.getPosition() - 1);
            right = Position.generateFromRankAndFile(p.getRank() - 1, p.getPosition() + 1);
            if (left != null) {
                leftEat = Position.generateFromRankAndFile(left.getRank() - 1, left.getPosition() - 1);
            }
            if (right != null) {
                rightEat = Position.generateFromRankAndFile(right.getRank() - 1, right.getPosition() + 1);
            }
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
        if (left != null) {
            if (leftEat != null && checkers.isEmpty(leftEat) && checkers.getPieceAt(left) != null) {
                if (leftEat.getRank() >= 0 && leftEat.getRank() <= 7 && leftEat.getPosition() >= 0 && leftEat.getPosition() <= 7 && checkers.getPieceAt(left).getPieceColor() != checkers.getPieceAt(p).getPieceColor()) {
                    result.add(leftEat);
                }
            }
        }
        if (checkers.getPieceAt(p) != null && checkers.getPieceAt(right) != null) {
            if (rightEat != null && checkers.isEmpty(rightEat) && rightEat.getRank() >= 0 && rightEat.getRank() <= 7 && rightEat.getPosition() >= 0 && rightEat.getPosition() <= 7 && checkers.getPieceAt(right).getPieceColor() != myColor) {
                result.add(rightEat);
            }
            return result;
        }
        return result;
    }


    public ArrayList<Position> eatable(Checkers checkers, Position p) {
        ArrayList<Position> result = new ArrayList<>();
        if (checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() + 1), p.getPosition() + 1)) != null && checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() + 2), p.getPosition() + 2)) != null) {
            if (Position.generateFromRankAndFile((p.getRank() + 2), p.getPosition() + 2) != null && Position.generateFromRankAndFile((p.getRank() + 1), p.getPosition() + 1) != null) {
                if (checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() + 1), p.getPosition() + 1)).getPieceColor() != checkers.getPieceAt(p).getPieceColor()
                        && checkers.isEmpty(Position.generateFromRankAndFile((p.getRank() + 2), p.getPosition() + 2))
                        && p.getRank() + 2 <= 7 && p.getPosition() + 2 <= 7) {
                    result.add(Position.generateFromRankAndFile((p.getRank() + 2), p.getPosition() + 2));
                }
            }
        }
        if (checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() + 1), p.getPosition() - 1)) != null && checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() + 2), p.getPosition() - 2)) != null) {
            if (Position.generateFromRankAndFile((p.getRank() + 2), p.getPosition() - 2) != null && Position.generateFromRankAndFile((p.getRank() + 1), p.getPosition() - 1) != null) {
                if (checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() + 1), p.getPosition() - 1)).getPieceColor() != checkers.getPieceAt(p).getPieceColor()
                        && checkers.isEmpty(Position.generateFromRankAndFile((p.getRank() + 2), p.getPosition() - 2))
                        && p.getRank() + 2 <= 7 && p.getPosition() - 2 >= 0) {
                    result.add(Position.generateFromRankAndFile((p.getRank() + 2), p.getPosition() - 2));
                }
            }
        }
        if (checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() - 1), p.getPosition() + 1)) != null && checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() - 2), p.getPosition() + 2)) != null) {
            if (Position.generateFromRankAndFile((p.getRank() - 2), p.getPosition() + 2) != null && Position.generateFromRankAndFile((p.getRank() - 1), p.getPosition() + 1) != null) {
                if (checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() - 1), p.getPosition() + 1)).getPieceColor() != checkers.getPieceAt(p).getPieceColor()
                        && checkers.isEmpty(Position.generateFromRankAndFile((p.getRank() - 2), p.getPosition() + 2))
                        && p.getRank() - 2 >= 0 && p.getPosition() + 2 <= 7) {
                    result.add(Position.generateFromRankAndFile((p.getRank() - 2), p.getPosition() + 2));
                }
            }
        }
        if (checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() - 1), p.getPosition() - 1)) != null && checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() - 2), p.getPosition() - 2)) != null) {
            if (Position.generateFromRankAndFile((p.getRank() - 2), p.getPosition() - 2) != null && Position.generateFromRankAndFile((p.getRank() - 1), p.getPosition() - 1) != null) {
                if (checkers.getPieceAt(Position.generateFromRankAndFile((p.getRank() - 1), p.getPosition() - 1)).getPieceColor() != checkers.getPieceAt(p).getPieceColor()
                        && checkers.isEmpty(Position.generateFromRankAndFile((p.getRank() - 2), p.getPosition() - 2))
                        && p.getRank() - 2 >= 0 && p.getPosition() - 2 >= 0) {
                    result.add(Position.generateFromRankAndFile((p.getRank() - 2), p.getPosition() - 2));
                }
            }
            return result;
        }
        return result;
    }
}

//    Checkers.PieceColor myColor = checkers.getPieceAt(p).getPieceColor();
//    int[] rankOfWhites = {-1, -1, 1, 1};
//    int[] fileOfWhites = {1, -1, 1, -1};
//    int[] rankOfBlacks = {1, 1, -1, -1};
//    int[] fileOfBlacks = {1, -1, 1, -1};
//    ArrayList<Position> result = new ArrayList<>();
//    Position current;
//    Position currentEat;
//    Position current2;
//    Position current2Eat;
//    int counter = 0;
//        if (myColor == Checkers.PieceColor.WHITE) {
//                //System.out.println("1");
//                current = Position.generateFromRankAndFile(p.getRank() - rankOfWhites[0], p.getPosition() + fileOfWhites[0]);
//                //System.out.println("2");
//                current2 = Position.generateFromRankAndFile(p.getRank() - rankOfWhites[1], p.getPosition() + fileOfWhites[1]);
//                currentEat = Position.generateFromRankAndFile(current.getRank() - rankOfWhites[0], current.getPosition() + fileOfWhites[0]);
//                current2Eat = Position.generateFromRankAndFile(current2.getRank() - rankOfWhites[0], current2.getPosition() + fileOfWhites[0]);
//
//                if (checkers.isEmpty(current) || myColor != checkers.getPieceAt(current).getPieceColor()) {
//                result.add(current);
//                }
//                if (checkers.getPieceAt(current).getPieceColor() == Checkers.PieceColor.BLACK && checkers.isEmpty(currentEat)) {
//                result.add(currentEat);
//                counter++;
//                }
//                if (checkers.isEmpty(current2) || myColor != checkers.getPieceAt(current2).getPieceColor()) {
//                result.add(current2);
//                }
//                if (counter > 0) {
//                for (int i = 0; i < 4; i++) {
//        current2 = Position.generateFromRankAndFile(current2.getRank() - rankOfWhites[i], current2.getPosition() + fileOfWhites[i]);
//        current2Eat = Position.generateFromRankAndFile(current2.getRank() - rankOfWhites[i], current2.getPosition() + fileOfWhites[i]);
//        if (checkers.getPieceAt(current2).getPieceColor() == Checkers.PieceColor.BLACK && checkers.isEmpty(current2Eat)) {
//        result.add(current2Eat);
//        }
//        }
//        }
//        if (checkers.getPieceAt(current2).getPieceColor() == Checkers.PieceColor.BLACK && checkers.isEmpty(current2Eat)) {
//        result.add(current2Eat);
//        counter++;
//        }
//        if (p.getRank() == 8) {
//        Kings kings = new Kings(Checkers.PieceColor.WHITE);
//        kings.allDestinations(checkers, p);
//        }
//
//
//        }
//        // move of black pieces
//        else {
//        current = Position.generateFromRankAndFile(p.getRank() - rankOfBlacks[0], p.getPosition() - fileOfBlacks[0]);
//        current2 = Position.generateFromRankAndFile(p.getRank() - rankOfBlacks[1], p.getPosition() - fileOfBlacks[1]);
//        currentEat = Position.generateFromRankAndFile(current.getRank() - rankOfWhites[0], current.getPosition() + fileOfWhites[0]);
//        current2Eat = Position.generateFromRankAndFile(current2.getRank() - rankOfWhites[1], current2.getPosition() + fileOfWhites[1]);
//
//
//        if (checkers.isEmpty(current) || myColor != checkers.getPieceAt(current).getPieceColor()) {
//        result.add(current);
//        } else if (checkers.getPieceAt(current).getPieceColor() == Checkers.PieceColor.WHITE && checkers.isEmpty(currentEat)) {
//        result.add(currentEat);
//        counter++;
//        }
//        if (checkers.isEmpty(current2) || myColor != checkers.getPieceAt(current2).getPieceColor()) {
//        result.add(current2);
//        } else if (counter > 0) {
//        for (int i = 0; i < 4; i++) {
//        current2 = Position.generateFromRankAndFile(current.getRank() - rankOfWhites[i], current.getPosition() + fileOfWhites[i]);
//        current2Eat = Position.generateFromRankAndFile(current.getRank() - rankOfWhites[i], current.getPosition() + fileOfWhites[i]);
//        if ((current2 != null && checkers.getPieceAt(current).getPieceColor() == Checkers.PieceColor.WHITE) && checkers.isEmpty(current2Eat)) {
//        result.add(current2Eat);
//        }
//        }
//        } else if (checkers.getPieceAt(current2).getPieceColor() == Checkers.PieceColor.WHITE && checkers.isEmpty(current2Eat)) {
//        result.add(current2Eat);
//        counter++;
//        }
//        if (p.getRank() == 0) {
//        Kings kings = new Kings(Checkers.PieceColor.BLACK);
//        kings.allDestinations(checkers, p);
//        }
//
//        }
//        return result;
//        }
////    public int eatablePositions(Checkers checkers, Position p ){
////    	int[] rank= {1,1,-1,-1};
////    	int[] position= {1,-1,1,-1};
////    	int c=0;
////    	Position current2;
////    	Position current2Eat;
////    	for(int i=0; i<4; i++) {
////    		current2 = Position.generateFromRankAndFile(current2.getRank() - rank[i], current2.getPosition() + position[i]);
////    		current2Eat = Position.generateFromRankAndFile(current2.getRank() - rank[i], current2.getPosition() + position[i]);
////    		if((current2 !=null && checkers.getPieceAt(current2).getPieceColor() == Checkers.PieceColor.BLACK) && checkers.isEmpty(current2Eat)){
////
////    		}
////    	}
////    }
//        }

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



//        if (right != null && checkers.getPieceAt(right) != null && checkers.getPieceAt(right).getPieceColor() != this.getPieceColor()) {
//            result.add(right);
//        }
//
//        return result;



//    public boolean canJump(Checkers checkers, Position p) {
//        int rank = p.getRank();
//        int pos = p.getPosition();
//
//        PieceColor color = checkers.getPieceAt(p).getPieceColor();
//        int[] ranks = {-1, -1, 1, 1};
//        int[] poses = {1, -1, 1, -1};
//        for (int i = 0; i < 4; i++) {
//            Position destination = Position.generateFromRankAndFile(rank + ranks[i], pos + poses[i]);
//            Position check = Position.generateFromRankAndFile(rank + 2 * ranks[i], pos + 2 * poses[i]);
//            if (destination != null && !(checkers.isEmpty(destination))
//                    && color != checkers.getPieceAt(destination).getPieceColor()
//                    && check != null && checkers.isEmpty(check)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public ArrayList<Position> captureDiagonal(Checkers checkers, Position p) {
//        int rank = p.getRank();
//        int pos = p.getPosition();
//        ArrayList<Position> possibleDestinations = new ArrayList<Position>();
//        if (checkers.getPieceAt(p) != null) {
//            PieceColor color = checkers.getPieceAt(p).getPieceColor();
//            int[] ranks = {-1, -1, 1, 1};
//            int[] poses = {1, -1, 1, -1};
//            for (int i = 0; i < 4; i++) {
//                Position destination = Position.generateFromRankAndFile(rank + ranks[i], pos + poses[i]);
//                Position check = Position.generateFromRankAndFile(rank + 2 * ranks[i], pos + 2 * poses[i]);
//                if (destination != null && !(checkers.isEmpty(destination))
//                        && color != checkers.getPieceAt(destination).getPieceColor()
//                        && check != null && checkers.isEmpty(check)) {
//                    possibleDestinations.add(check);
//                }
//            }
//        }
//        return possibleDestinations;
//    }


