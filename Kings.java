package am.aua.checkers.core;

import java.util.ArrayList;

public class Kings extends Piece {

    public Kings() {
        super();
    }

    public Kings(Checkers.PieceColor color) {
        super(color);
    }

    public String toString() {
        if (this.getPieceColor() == Checkers.PieceColor.WHITE) {
                return "K";
        }else
                return "k";
    }


    public ArrayList<Position> allDestinations(Checkers checkers, Position p) {
        return Kings.reachablePositions(checkers, p);
    }

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
}
