package am.aua.checkers.core;

/**
 * The class Position
 * This class is created to create positions that will be used in our Chess game. The user will input the position where the object will be located and the position where it should be moved.
 * @author martinpalanjyan
 * @author armankhachatryan
 * @author gorhovakimyan
 * References
 * Martin Palanjyan's Homework 07.
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
     * Method to generate and return a string representation of the position with a format like "C2" or "B8".
     *
     * @return
     */
    public String toString() {
        return this.position + "" + this.rank;

    }

    /**
     * Method that generates a new Position object from a single string representation argument like "B3".
     *
     * @param position
     * @return
     */
    public static Position generateFromString(String position) {
        if (position.length() == 2) {
            char letter = position.charAt(0);
            char number = position.charAt(1);
            int newRank = 0;
            int newPosition = 0;

            if (number == '1') {
                newRank = 7;
            } else if (number == '2') {
                newRank = 6;
            } else if (number == '3') {
                newRank = 5;
            } else if (number == '4') {
                newRank = 4;
            } else if (number == '5') {
                newRank = 3;
            } else if (number == '6') {
                newRank = 2;
            } else if (number == '7') {
                newRank = 1;
            } else if (number == '8') {
                newRank = 0;
            } else {
                return null;
            }

            if (letter == 'A' || letter == 'a') {
                newPosition = 0;
            } else if (letter == 'B' || letter == 'b') {
                newPosition = 1;
            } else if (letter == 'C' || letter == 'c') {
                newPosition = 2;
            } else if (letter == 'D' || letter == 'd') {
                newPosition = 3;
            } else if (letter == 'E' || letter == 'e') {
                newPosition = 4;
            } else if (letter == 'F' || letter == 'f') {
                newPosition = 5;
            } else if (letter == 'G' || letter == 'g') {
                newPosition = 6;
            } else if (letter == 'H' || letter == 'h') {
                newPosition = 7;
            } else {
                return null;
            }

            return new Position(newRank, newPosition);
        } else
            return null;
    }

    /**
     * Method that generates a new Position object from a pair of integer arguments for coordinates.
     *
     * @param rank
     * @param position
     * @return
     */
    public static Position generateFromRankAndFile(int rank, int position) {
        if (rightRankPosition(rank) && rightRankPosition(position)) {
            return new Position(rank, position);
        } else
            return null;
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

