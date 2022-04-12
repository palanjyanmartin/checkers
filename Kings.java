package am.aua.checkers.core;

/**
 * The <code>am.aua.checkers.core.Kings</code> class contains the behaviour of Kings pieces.
 * @author Martin Palanjyan
 * References
 * Martin Palanjyan's HW08.
 */

public class Kings extends Piece {

    /**
     * A no-arg constructor that relies on the constructor of the parent class Piece, which by default makes the piece color WHITE.
     */
    public Kings() {
        super();
    }

    /**
     * A parameterized constructor which relies on the constructor of the parent class Piece and initializes the piece color using @param pieceColor.
     *
     * @param pieceColor
     */


    public Kings(Checkers.PieceColor pieceColor) {
        super(pieceColor);
    }

    /**
     * An overridden toString() method that returns "B" of type <code>String</code> if the color of the piece is WHITE
     * and returns "b" of type <code>String</code> if the color of the piece is BLACK.
     *
     * @return "B" or "b"
     */

    public String toString() {
        if (this.getPieceColors() == Checkers.PieceColor.WHITE)
            return "B";
        else
            return "b";
    }

    /**
     * A method that returns an array of type <code>Position</code> which is a set of all the positions into which a Kings
     * might perform a valid move from a given position in the given ongoing checkers game.
     *
     * @param checkers the ongoing <code>am.aua.checkers.core.checkers</code> game
     * @param p     the position of the Kings
     * @return a <code>am.aua.checkers.core.Position</code> array with all the positions
     * that a Kings can move into from position <code>p</code>
     */

    public Position[] allDestinations(Checkers checkers, Position p) {
        return Kings.reachablePositions(checkers, p);
    }

    /**
     * Generates and returns a set of all the positions into which a Kings
     * might perform a valid move from a given position in the given ongoing
     * checkers game.
     *
     * @param checkers the ongoing <code>am.aua.checkers.core.checkers</code> game
     * @param p     the position of the Kings
     * @return a <code>am.aua.checkers.core.Position</code> array with all the positions
     * that a Kings can move into from position <code>p</code>
     */

    public static Position[] reachablePositions(Checkers checkers, Position p) {
          public static Position[] reachablePositions(Checkers checkers, Position p) {
            int[] newRank = {-1, -1, 1, 1};
            int[] newFile = {1, -1, 1, -1};
            Position[] result = new Position[0];

            for (int d = 0; d < 4; d++) {
                int i = p.getRank() + newRank[d];
                int j = p.getFile() + newFile[d];
                while (i >= 0 && i < checkers.BOARD_RANKS &&
                        j >= 0 && j < checkers.BOARD_FILES) {
                    Position current = Position.generateFromRankAndFile(i, j);

                    if (checkers.isEmpty(current))
                        result = Position.appendPositionsToArray(result, current);
                    else {
                        if (checkers.getPieceAt(current).getPieceColors() != checkers.getPieceAt(p).getPieceColors())
                            result = Position.appendPositionsToArray(result, current);
                        break;
                    }
                    i += newRank[d];
                    j += newFile[d];
                }
            }
            return result;

    }


}
