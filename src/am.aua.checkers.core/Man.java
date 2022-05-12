package am.aua.checkers.core;

import java.awt.Color;
import java.util.ArrayList;

import am.aua.checkers.core.*;
import am.aua.checkers.core.Checkers.PieceColor;

/**
 * The <code>am.aua.Checkers.core.Man</code> class contains the behaviour of Man pieces.
 *
 * @author Martin Palanjyan
 * @author Arman Khachatryan
 * @author Gor Hovakimyan
 * References Martin Palanjyan Homework 08
 */

public class Man extends Piece {
    /**
     * A no-arg constructor that relies on the constructor of the parent class Piece, which by default makes the piece color WHITE.
     */

    public Man() {
        super();
    }

    /**
     * A parameterized constructor which relies on the constructor of the parent class Piece and initializes the piece color using @param pieceColor.
     *
     * @param pieceColor
     */

    public Man(Checkers.PieceColor pieceColor) {
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
     * Generates and returns a set of all the positions into which a Man
     * might perform a valid move from a given position in the given ongoing
     * Checkers game.
     *
     * @param checkers the ongoing <code>am.aua.Checkers.core.Checkers</code> game
     * @param p        the position of the Man
     * @return a <code>am.aua.Checkers.core.Position</code> array with all the positions
     * that a Man can move into from position <code>p</code>
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
        } else if (myColor == PieceColor.BLACK){
            left = Position.generateFromRankAndFile(p.getRank() + 1, p.getPosition() - 1);
            right = Position.generateFromRankAndFile(p.getRank() + 1, p.getPosition() + 1);
            if (left != null) {
                leftEat = Position.generateFromRankAndFile(left.getRank() + 1, left.getPosition() - 1);
            }
            if (right != null) {
                rightEat = Position.generateFromRankAndFile(right.getRank() + 1, right.getPosition() + 1);
            }
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


    /**
     * Generates and returns a set of all the positions into which a Man
     * might perform a valid move from a given position in the given ongoing
     * Checkers game when making multiple captures
     *
     * @param checkers the ongoing <code>am.aua.Checkers.core.Checkers</code> game
     * @param p        the position of the Man
     * @return a <code>am.aua.Checkers.core.Position</code> array with all the positions
     * that a Man can move into from position <code>p</code>
     */

    public ArrayList<Position> eatable(Checkers checkers, Position p) {
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
