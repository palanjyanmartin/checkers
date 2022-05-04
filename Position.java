package am.aua.checkers.core;

/**
 * The class Position
 * This class is created to create positions that will be used in our Chess game. The user will input the position where the object will be located and the position where it should be moved.
 * @author martinpalanjyan
 * @author armankhachatryan
 * @author gorhovakimyan
 * References
 * Martin Palanjyan's Homework 08.
 */

public class Position {
    /**
     * Instance variables of the class Position.
     */
    private int rank;
    private int position;

    /**
     * No-arg constructor that will initialize the position of the top-left corner of the chessboard.
     */

    public Position() {
        this.rank = 0;
        this.position = 0;
    }

    /**
     * Copy Constructor.
     *
     * @param position
     */

    public Position(Position position) {
        this.setRank(position.rank);
        this.setPosition(position.position);

    }

    /**
     * Constructor that initializes instance variables rank and filePosition to first and second of type int.
     *
     * @param newRank
     * @param newPosition
     */
    public Position(int newRank, int newPosition) {
        this.setRank(newRank);;
        this.setPosition(newPosition);

    }

    /**
     * An accessor for the rank.
     *
     * @return
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * An accessor for the filePosition.
     *
     * @return
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * A mutator for the rank, which gives an access to change the value of rank to newRank that is of type int.
     *
     * @param newRank
     */
    public void setRank(int newRank) {
        if (rightRankPosition(newRank)) {
            this.rank = newRank;
        }
    }

    /**
     * A mutator for the filePosition, which gives an access to change the value of filePosition to newFilePosition that is of type int.
     *
     * @param newPosition
     */
    public void setPosition(int newPosition) {
        if (rightRankPosition(newPosition)) {
            this.position = newPosition;
        }


    }

    /**
     * Mutator method for the file of the position.
     * @return A string representation of the position on the board.
     */
    public String toString() {
        return "" + (char)('A' + this.position) + (Checkers.BOARD_RANKS - this.rank);
    }

    /**
     * <p>A static method that given a valid string indicating a chessboard square in chess notation,
     * e.g. "a8" or "A8", creates a position object after verification. Returns null otherwise.
     * Such methods are known as static factory methods and are advantageous in a multitude of ways.</p>
     *
     * @param s The name of the chessboard square, such as "A8"
     * @return A position object or null.
     */
    public static Position generateFromString(String s) {
        s = s.toLowerCase();
        if (s.length() != 2
                || (s.charAt(0) < 'a' || s.charAt(0) >= 'a' + Checkers.BOARD_FILES)
                || (s.charAt(1) < '1' || s.charAt(1) >= '1' + Checkers.BOARD_RANKS)
        )
            return null;
        return generateFromRankAndFile(Checkers.BOARD_RANKS - s.charAt(1) + '0',
                s.charAt(0) - 'a');
    }

    /**
     * Method that generates a new Position object from a pair of integer arguments for coordinates.
     *
     * @param rank
     * @return
     */
    public static Position generateFromRankAndFile(int rank, int file) {
        Position result = null;
        if (rank >= 0 && rank < Checkers.BOARD_RANKS
                && file >= 0 && file < Checkers.BOARD_FILES)
            result = new Position(rank, file);
        return result;
    }

    /**
     * Methods that checks whether rank and filePosition are valid, which means that their range is from 0 to 7.
     *
     * @param number
     * @return
     */
    private static boolean rightRankPosition(int number) {
        if ((number >= 0) && (number <= 7)) {
            return true;
        } else
            System.exit(0);
        return false;
    }

    /**
     * Method that appends a given position to the end of an array.
     *
     * @param arr
     * @param p
     * @return
     */
    public static Position[] appendPositionsToArray(Position[] arr, Position... p) {
        // Intentionally shallow
        int index = 0;
        Position[] result = new Position[arr.length + p.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

        for (int i = arr.length; i < result.length; i++) {
            result[i] = p[index++];
        }

        return result;
    }


}


