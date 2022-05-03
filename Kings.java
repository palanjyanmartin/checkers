package am.aua.checkers.core;

/**
 * The <code>am.aua.checkers.core.Kings</code> class contains the behaviour of Kings pieces.
 * @author Martin Palanjyan
 * References
 * Martin Palanjyan's HW08.
 */

public class Kings extends Piece {
    private boolean moved;

    public Kings() {
        this(Checkers.PieceColor.WHITE);
    }

    public Kings(Checkers.PieceColor color) {
        this(color, false);
    }

    public Kings(Checkers.PieceColor color, boolean moved) {
        super(color);
        this.moved = moved;
    }

    public boolean getHasMoved() {
        return this.moved;
    }

    public void setHasMoved(boolean moved) {
        this.moved = moved;
    }


    public String toString() {
        if (this.getPieceColor() == Checkers.PieceColor.WHITE) {
            if (this.moved) {
                return "L";
            } else
                return "K";
        }else {
            if (this.moved) {
                return "l";
            } else
                return "k";
        }
    }


    public Position[] allDestinations(Checkers checkers, Position p) {
        return Kings.reachablePositions(checkers, p);
    }

    public static Position[] reachablePositions(Checkers checkers, Position p) {
        int[] newRank = {-1, -1, 1, 1};
        int[] newFile = {1, -1, 1, -1};
        Position[] result = new Position[0];

        for (int d = 0; d < 4; d++) {
            int i = p.getRank() + newRank[d];
            int j = p.getPosition() + newFile[d];
            while (i >= 0 && i < Checkers.BOARD_RANKS &&
                    j >= 0 && j < Checkers.BOARD_FILES) {
                Position current = Position.generateFromRankAndFile(i, j);

                if (current != null && checkers.isEmpty(current))
                    result = Position.appendPositionsToArray(result, current);
                else {
                    if (current != null && checkers.getPieceAt(current).getPieceColor() != checkers.getPieceAt(p).getPieceColor())
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
