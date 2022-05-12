package am.aua.checkers.cli;

import am.aua.checkers.core.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that provides a command line interface for the class
 * <code>am.aua.Checkers.core.Checkers</code>.
 * @author Martin Palanjyan
 * @author Arman Khachatryan
 * @author Gor Hovakimyan
 * References
 * Martin Palanjyan's Homework 08
 */
public class CheckersConsole {
    // an instance variable for a am.aua.Checkers.core.Checkers object
    private Checkers game;

    /**
     * Initializes the game and contains the core loop of the game.
     * Ensures the correct turn-taking of the game.
     */
    public void play() throws IllegalArrangementException {
        Scanner sc = new Scanner(System.in);
        String inputLine;
        game = new Checkers();
        print();

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

                if (input.length>=2)

                    if (input[0].equals("debug")) {
                        print();
                        continue;
                    }

                p1 = Position.generateFromString(input[0]);

                if (p1 == null || game.getPieceAt(p1) == null) {
                    System.out.println("Invalid position. Please try again.");
                    continue;
                }

                if (input.length == 1) {
                    // Players are informed about wrong turns, but the squares for
                    // the opponent's piece are still highlighted
                    if (game.getPieceAt(p1).getPieceColor() != game.getTurn())
                        System.out.println("That piece belongs to the opponent.");
                    print(p1);
                }
                else if (input.length == 2) {
                    if (game.getPieceAt(p1).getPieceColor() != game.getTurn()) {
                        System.out.println("That piece belongs to the opponent.");
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
                        System.out.println("Invalid move. Please try again.");

                    print();
                }
            } else
                System.out.println("An invalid Request");
        }
    }

    /**
     * Prints the board and the pieces on it, while highlighting a selected
     * piece, along with the squares to which it can move to.
     *
     * @param origin the position of the selected piece
     */
    public void print(Position origin) {
        ArrayList<Position> reachableSquares = game.reachableFrom(origin);
        ArrayList<Position> eatableSquares = game.eatableFrom(origin);

        for (int i = 0; i < Checkers.BOARD_RANKS; i++) {
            System.out.print((Checkers.BOARD_RANKS - i) + " ");

            for (int j = 0; j < Checkers.BOARD_FILES; j++) {
                boolean isHighlighted = false;

                if (origin != null &&
                        origin.getRank() == i && origin.getPosition() == j)
                    isHighlighted = true;

                for (int k = 0; reachableSquares != null &&
                        k < reachableSquares.size(); k++)
                    if (reachableSquares.get(k).getRank() == i &&
                            reachableSquares.get(k).getPosition() == j) {
                        isHighlighted = true;
                        break;
                    }

                for (int k = 0; eatableSquares != null &&
                        k < eatableSquares.size(); k++)
                    if (eatableSquares.get(k).getRank() == i &&
                            eatableSquares.get(k).getPosition() == j) {
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
