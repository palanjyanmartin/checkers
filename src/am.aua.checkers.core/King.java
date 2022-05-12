package am.aua.checkers.core;

import java.util.ArrayList;
/**
 * The <code>am.aua.Checkers.core.King</code> class contains the behaviour of King pieces.
 *
 * @author Martin Palanjyan
 * @author Arman Khachatryan
 * @author Gor Hovakimyan
 * References Martin Palanjyan Homework 08
 */

public class King extends Piece {

    /**
     * A no-arg constructor that relies on the constructor of the parent class Piece, which by default makes the piece color WHITE.
     */
    

    public King() {
        super();
    }

    /**
     * A parameterized constructor which relies on the constructor of the parent class Piece and initializes the piece color using @param pieceColor.
     *
     * @param color
     */

    public King(Checkers.PieceColor color) {
        super(color);
    }

    /**
     * An overridden toString() method that returns "K" of type <code>String</code> if the color of the piece is WHITE
     * and returns "k" of type <code>String</code> if the color of the piece is BLACK.
     *
     * @return "K" or "k"
     */
    public String toString() {
        if (this.getPieceColor() == Checkers.PieceColor.WHITE) {
            return "K";
        }else
            return "k";
    }

    /**
     * Method called from abstract class Piece that will be used in the class Checkers when the destinations will be needed from the given origin
     * @param checkers
     * @param p
     * @return
     */

    public ArrayList<Position> allDestinations(Checkers checkers, Position p) {
        return King.reachablePositions(checkers, p);
    }

    /**
     * Generates and returns a set of all the positions into which a King
     * might perform a valid move from a given position in the given ongoing
     * Checkers game.
     *
     * @param checkers the ongoing <code>am.aua.Checkers.core.Checkers</code> game
     * @param p        the position of the Man
     * @return a <code>am.aua.Checkers.core.Position</code> array with all the positions
     * that a Man can move into from position <code>p</code>
     */


    public static ArrayList<Position> reachablePositions(Checkers checkers, Position p) {
        int[] newRank = {-1, -1, 1, 1};
        int[] newFile = {1, -1, 1, -1};
        ArrayList<Position> result = new ArrayList<>();

        for (int d = 0; d < 4; d++) {
            int i = p.getRank() + newRank[d];
            int j = p.getPosition() + newFile[d];
            while (i >= 0 && i < Checkers.BOARD_RANKS &&
                    j >= 0 && j < Checkers.BOARD_FILES) {
                Position current = Position.generateFromRankAndFile(i, j);

                if (current != null && checkers.isEmpty(current))
                    result.add(current);
                else {
                    if (current != null && checkers.getPieceAt(current).getPieceColor() != checkers.getPieceAt(p).getPieceColor())
                        result.add(current);
                    break;
                }
                i += newRank[d];
                j += newFile[d];
            }
        }
        return result;


    }
    /**
     * Method called from abstract class Piece that will be used in the class Checkers when the destinations will be needed from the given origin
     * @param checkers
     * @param p
     * @return
     */

    public ArrayList<Position> eatable(Checkers checkers, Position p) {
        return King.eatablePositions(checkers,p);
    }

    /**
     * Generates and returns a set of all the positions into which a King
     * might perform a valid move from a given position in the given ongoing
     * Checkers game when making multiple captures
     *
     * @param checkers the ongoing <code>am.aua.Checkers.core.Checkers</code> game
     * @param p        the position of the Man
     * @return a <code>am.aua.Checkers.core.Position</code> array with all the positions
     * that a Man can move into from position <code>p</code>
     */

    public static ArrayList<Position> eatablePositions(Checkers checkers, Position p) {
        ArrayList<Position> result = new ArrayList<>();
        Position firstEat1 = Position.generateFromRankAndFile((p.getRank() + 1), p.getPosition() + 1);
        Position toWhere1 = Position.generateFromRankAndFile((p.getRank() + 2), p.getPosition() + 2);
        Position firstEat2 = Position.generateFromRankAndFile((p.getRank() + 1), p.getPosition() - 1);
        Position toWhere2 = Position.generateFromRankAndFile((p.getRank() + 2), p.getPosition() - 2);
        Position firstEat3 = Position.generateFromRankAndFile((p.getRank() - 1), p.getPosition() + 1);
        Position toWhere3 = Position.generateFromRankAndFile((p.getRank() - 2), p.getPosition() + 2);
        Position firstEat4 = Position.generateFromRankAndFile((p.getRank() - 1), p.getPosition() - 1);
        Position toWhere4 = Position.generateFromRankAndFile((p.getRank() - 2), p.getPosition() - 2);
        if (firstEat1 != null && toWhere1 != null) {
            if (checkers.getPieceAt(firstEat1) != null) {
                if (checkers.getPieceAt(firstEat1).getPieceColor() != checkers.getPieceAt(p).getPieceColor() && checkers.isEmpty(toWhere1) && toWhere1.getRank() >= 0 && toWhere1.getRank() <= 7 && toWhere1.getPosition() >= 0 && toWhere1.getPosition() <= 7) {
                    result.add(toWhere1);
                }
            }
        }

        if (firstEat2 != null && toWhere2 != null) {
            if (checkers.getPieceAt(firstEat2) != null) {
                if (checkers.getPieceAt(firstEat2).getPieceColor() != checkers.getPieceAt(p).getPieceColor() && checkers.isEmpty(toWhere2) && toWhere2.getRank() >= 0 && toWhere2.getRank() <= 7 && toWhere2.getPosition() >= 0 && toWhere2.getPosition() <= 7) {
                    result.add(toWhere2);
                }
            }
        }
        if (firstEat3 != null && toWhere3 != null) {
            if (checkers.getPieceAt(firstEat3) != null) {
                if (checkers.getPieceAt(firstEat3).getPieceColor() != checkers.getPieceAt(p).getPieceColor() && checkers.isEmpty(toWhere3) && toWhere3.getRank() >= 0 && toWhere3.getRank() <= 7 && toWhere3.getPosition() >= 0 && toWhere3.getPosition() <= 7) {
                    result.add(toWhere3);
                }
            }
        }

        if (firstEat4 != null && toWhere4 != null) {
            if (checkers.getPieceAt(firstEat4) != null) {
                if (checkers.getPieceAt(firstEat4).getPieceColor() != checkers.getPieceAt(p).getPieceColor() && checkers.isEmpty(toWhere4) && toWhere4.getRank() >= 0 && toWhere4.getRank() <= 7 && toWhere4.getPosition() >= 0 && toWhere4.getPosition() <= 7) {
                    result.add(toWhere4);
                }
            }
        }

        return result;

    }


}
