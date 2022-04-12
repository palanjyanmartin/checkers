/**
 * The class Checkers
 * This class is one of the most important classes because it has the highest functionality. It identifies the board, the pieces on it and performs the move.
 * @author Martin Palanjyan
 * @author Arman Khachatryan
 * @author Gor Hovakimyan
 * References
 * Martin Palanjyan's Homework 07
 */

public class Checkers {
    /**
     * Static class
     */
    private static int turn = 0;
   /**
   * Constant class variables
   */
    private static final char empty = '\u0000';
    private static final int dimension = 8;

    /**
     * Adding an enumerated class PieceColor that will represent the colors of the pieces belonging to the two playes
     */
    public enum PieceColor {WHITE, BLACK};

    /**
     * Instance variables of the class Checkers
     */
    private char[][] board;
    private char piece;

    /**
     * No-arg constructor
     */
    public Checkers() {
        this.piece = empty;
        this.board = new char[size][size];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = empty;
            }
        }
       //Stegh avelacnumei qarerin
    }

    /**
     * Copy constructor
     *
     * @param that
     */
    public Checkers(Checkers that) {
        this.piece = that.piece;
        this.board = that.board;
    }

    /**
     * An accessor method that generates and returns a deep copy of the board.
     *
     * @return
     */
    public char[][] getBoard() {
        char[][] newArray = new char[size][size];
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                newArray[i][j] = this.board[i][j];
            }
        }
        return newArray;
    }

    /**
     * An accessor that,using the current number moves, returns either 0 or 1 to indicate white's or black's turn.
     *
     * @return
     */
    public int getTurn() {
        if (turn % 2 == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    /**
     * Method that checks if the game is over or if it still continues.
     *
     * @return
     */
    public boolean isGameOver() {
        return false;

    }

    /**
     * Method that,given a position,checks if that position on the board is empty.
     *
     * @param position
     * @return
     */

    public boolean isEmpty(Position position) {
        return this.board[position.getRank()][position.getPosition()] == empty;
    }

    /**
     * An accessor, that given a position,returns the character representing the piece at that position on the board.
     *
     * @param position
     * @return
     */

    public char getPieceAt(Position position) {

        return this.board[position.getRank()][position.getPosition()];
    }

    /**
     * Method that identifies the set of all positions that can serve as destinations for a move from the given origin.
     *
     * @param origin
     * @return
     */
    public Position[] reachableFrom(Position origin) {
        if (origin == null) {
            return null;
        } else
           return // Here we will work with men and kings reachable positions Men.reachablePositions(this, origin);
          
          //We need a perform move method

    }

  }

}
