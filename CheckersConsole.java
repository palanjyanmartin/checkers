/**
 * A class that provides a command line interface for the class
 * <code>am.aua.Checkers.core.Checkers</code>.
 * @author Martin Palanjyan
 * @author Arman Khachatryan
 * @author Gor Hovakimyan
 * References
 * Martin Palanjyan's HW08
 */
public class CheckersConsole {
    // an instance variable for a am.aua.Checkers.core.Checkers object
    private Checkers game;

    /**
     * Initializes the game and contains the core loop of the game.
     * Ensures the correct turn-taking of the game.
     */
    public void play() {
        Scanner sc = new Scanner(System.in);
        String inputLine;

        print();
        try{

        while (!game.isGameOver()) {
            if (game.getTurn() == Checkers.PieceColor.WHITE)
                System.out.println("White's move: ");
            else
                System.out.println("Black's move: ");

            inputLine = sc.nextLine();
            String[] input = inputLine.split(" ");

            Position p1 = null, p2 = null;

            if (input.length >= 1) {
                if (input[0].equals("resign")) {
                    System.out.println(game.getTurn() + " has resigned.");
                    return;
                }

                if (input[0].equals("debug")) {
                    debug();
                    print();
                    continue;
                }

                p1 = Position.generateFromString(input[0]);

                if (p1 == null || game.getPieceAt(p1) == null) {
                    throw new IllegalMoveException;
                    continue;
                }

                if (input.length == 1) {
                    // Players are informed about wrong turns, but the squares for
                    // the opponent's piece are still highlighted
                    if (game.getPieceAt(p1).getPieceColor() != game.getTurn())
                        throw new IllegalMoveException;
                    print(p1);
                }
                else if (input.length == 2) {
                    if (game.getPieceAt(p1).getPieceColor() != game.getTurn()) {
                        throw new IllegalMoveException;
                        continue;
                    }

                    boolean success = false;

                    p2 = Position.generateFromString(input[1]);

                    // checking if p1 != null is not necessary
                    // its negation is already checked on line 59
                    if (p2 != null) {
                        Move m = new Move(p1, p2);
                        success = game.performMove(m);
                    }
                    if (!success)
                        throw new IllegalMoveException;
                }catch (IllegalMoveException e){}

                    print();
                }
            }
        }
    }

    /**
     * Prints the board and the pieces on it, while highlighting a selected
     * piece, along with the squares to which it can move to.
     *
     * @param origin the position of the selected piece
     */
    public void print(Position origin) {
        Position[] reachableSquares = game.reachableFrom(origin);

        for (int i = 0; i < Checkers.BOARD_RANKS; i++) {
            System.out.print((Checkers.BOARD_RANKS - i) + " ");

            for (int j = 0; j < Checkers.BOARD_FILES; j++) {
                boolean isHighlighted = false;

                if (origin != null &&
                        origin.getRank() == i && origin.getFile() == j)
                    isHighlighted = true;

                for (int k = 0; reachableSquares != null &&
                        k < reachableSquares.length; k++)
                    if (reachableSquares[k].getRank() == i &&
                            reachableSquares[k].getFile() == j) {
                        isHighlighted = true;
                        break;
                    }

                if (isHighlighted)
                    System.out.print("\u001b[31m");

                System.out.print("[");

                Position current = Position.generateFromRankAndFile(i, j);
                if (game.isEmpty(current))
                    System.out.print(" ");
                else
                    System.out.print(game.getPieceAt(current));

                System.out.print("]");

                if (isHighlighted)
                    System.out.print("\u001b[0m");
            }
            System.out.println();
        }
        System.out.println("   A  B  C  D  E  F  G  H ");
        System.out.println();
    }

    /**
     * Prints the board and the pieces on it.
     */
    public void print() {
        print(null);
    }
}

