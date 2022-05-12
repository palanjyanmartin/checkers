package am.aua.checkers.core;

import java.util.ArrayList;

/**
 * The <code>am.aua.checkers.core.Piece</code> class.
 *
 * @author Martin Palanjyan
 * @author Arman Khachatryan
 * @author Gor Hovakimyan
 * References Martin Palanjyan Homework 08
 */

public abstract class Piece implements Cloneable {
    private Checkers.PieceColor color;


    /**
     * A constructor
     * @param color
     */

    public Piece(Checkers.PieceColor color) {
        this.color = color;
    }

    /**
     * No-arg constructor
     */

    public Piece() {
        this(Checkers.PieceColor.WHITE);
    }

    /**
     * An abstract method
     *
     * @param checkers
     * @param p
     * @return
     */

    public abstract ArrayList<Position> allDestinations(Checkers checkers, Position p);

    /**
     *  An abstract method
     * @param checkers
     * @param p
     * @return
     */
    public abstract ArrayList<Position> eatable(Checkers checkers, Position p);
    /**
     * An accessor for the color that cannot be overriden.
     *
     * @return
     */

    public final Checkers.PieceColor getPieceColor() {
        return this.color;
    }

    /**
     * Overriden method clone
     * @return
     */

    public Piece clone() {
        try {
            return (Piece) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * Method equals for checking whether the colors are same
     * @param otherObject
     * @return
     */
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

