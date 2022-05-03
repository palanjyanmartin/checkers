package am.aua.checkers.core;

/**
 * The <code>am.aua.checkers.core.checkers</code> class encapsulates the state of an ongoing game of
 * checkers.
 *
 * @authors Martin Palanjyan, Gor Hovakimyan
 * References Martin Palanjyan's HW08
 */
public class Checkers implements Cloneable {
    
    //mutable, e.g. performMove modifies state
    /**
     * The number of board ranks in checkers.
     */
    public static final int BOARD_RANKS = 8;
    /**
     * The number of boagetPosition()s in checkers.
     */
    public static final int BOARD_FILES = 8;

    // an instance variable for the board and pieces on it
    private Piece[][] board;

    /**
     * Adding an enumerated class PieceColor that will represent the colors of the pieces belonging to the two players.
     */
    public enum PieceColor {WHITE, BLACK}

    ;
    //instance variable
    private Checkers.PieceColor color;

    /**
     * Constructs a new <code>am.aua.checkers.core.checkers</code> so that
     * the board is filled with the standard initial configuration of the checkers board given by the string and the color
     * which indicates which player is about to make a move.
     */
    public Checkers() throws IllegalArrangementException {
       " M M M MM M M M  M M M M                m m m m  m m m mm m m m "
    }


    /**
     * Constructs a new <code>am.aua.checkers.core.checkers</code> so that given a string with length 64
     * represents the positioning of the different pieces on the board, and fills the board with the white,
     * black or empty elements. It indicates which player is about to make the move.
     * Besides, it insures that there is exactly one black and exactly one white king present on the board.
     *
     * @param represent
     * @param pieceColor
     */

    public Checkers(String represent, Checkers.PieceColor pieceColor) throws IllegalArrangementException{
        this.board = new Piece[BOARD_RANKS][BOARD_FILES];
        int index = 0;
        for (int i = 0; i < BOARD_RANKS; i++) {
            for (int j = 0; j < BOARD_FILES; j++) {
                if (represent.charAt(index) == 'M') {
                    this.board[i][j] = new Men(PieceColor.WHITE);
                    index++;
                } else if (represent.charAt(index) == 'm') {
                    this.board[i][j] = new Men(PieceColor.BLACK);
                    index++;
                } else if (represent.charAt(index) == 'K') {
                    this.board[i][j] = new Kings(PieceColor.WHITE, true);
                    index++;
                } else if (represent.charAt(index) == 'k') {
                    this.board[i][j] = new Kings(PieceColor.BLACK, true);
                }
            }
            this.color = pieceColor;
        }

    }
    
    /**
    * Creats the clone of type Checkers.
    */
    public Checkers clone() {
        try {
            Checkers copy = (Checkers) super.clone();
            copy.board = this.getBoard();
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
        /**
         * Returns a <code>Piece</code> matrix representing the game board and the
         * pieces on it.
         *
         * @return the board as a <code>Piece</code> matrix
         */

        public Piece[][] getBoard() {
            //returns deep copy
            Piece[][] board = new Piece[BOARD_RANKS][BOARD_FILES];
            for (int i = 0; i < BOARD_RANKS; i++)
                for (int j = 0; j < BOARD_FILES; j++)
                    board[i][j] = (Piece) this.board[i][j].clone();
            return board;
        }

        /**
         * Returns color which indicates white's or black's turn, respectively.
         *
         * @return color
         */
        public Checkers.PieceColor getTurn () {
            return color;
        }

        /**
         * Checks if the game is over or if it still continues.
         * <p>
         * Current version always returns <code>false</code>. The functionality will
         * be fixed in future versions.
         *
         * @return true if and only if the game is over
         */
        public boolean isGameOver () {
            return false;
        }


        /**
         * Checks if a given position on the board is empty.
         *
         * @param p the position that should be tested
         * @return true if and only if <code>p</code> is null
         */
        public boolean isEmpty(Position p){
            return this.board[p.getRank()][p.getPosition()] == null;
        }

      
        /**
         * Returns the <code>Piece</code> representing the piece on a given position
         * on the board.
         *
         * @param p the position on the board
         * @return the <code>Piece</code> representing the piece on
         * <code>p</code>
         */
        public Piece getPieceAt (Position p){
            return this.board[p.getRank()][p.getPosition()];
        }

        /**
         * Identifies and returns the set of all positions that can serve as
         * destinations for a move from the given origin.
         * <p>
         * If the origin is not a real object or is empty, the method just returns
         * <code>null</code>. Otherwise, it returns a listing of all eligible
         * destinations based on the type of piece in origin
         *
         * @param origin the origin position on the board
         * @return the array with the set of reachable positions
         */
        public Position[] reachableFrom (Position origin){
            if (origin == null || this.isEmpty(origin)) {
                return null;
            } else
                return getPieceAt(origin).allDestinations(this, origin);
        }


        /**
         * Attempts to make a given <code>am.aua.checkers.core.Move</code>. If the move is valid, i.e.
         * the destination is in the set reachable from the origin, the method
         * correctly updates the state of <code>am.aua.checkers.core.checkers</code> and returns
         * <code>true</code>. Otherwise, the method returns <code>false</code>.
         *
         * @param m the move attempted
         * @return true if and only if the move was successfully made
         */
        public boolean performMove (Move m){
            Position origin = m.getOrigin();
            Position destination = m.getDestination();
            Position[] reachable = this.reachableFrom(origin);
            if (reachable != null) {
                for (int i = 0; i < reachable.length; i++)
                    if (destination.getRank() == reachable[i].getRank()
                            && destination.getPosition() == reachable[i].getPosition()) {
                        this.board[destination.getRank()][destination.getPosition()] =
                                this.board[origin.getRank()][origin.getPosition()];
                        this.board[origin.getRank()][origin.getPosition()] = null;
                        if (this.board[destination.getRank()][destination.getPosition()].getPieceColor() == PieceColor.WHITE) {
                            color = PieceColor.BLACK;
                            return true;
                        } else if (this.board[destination.getRank()][destination.getPosition()].getPieceColor() == PieceColor.BLACK) {
                            color = PieceColor.WHITE;
                            return true;
                        }
                        return false;
                    }
                return false;
            }
            return false;
        }
    }






