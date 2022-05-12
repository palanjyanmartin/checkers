package am.aua.checkers.ui;

import am.aua.checkers.core.Checkers;
import am.aua.checkers.core.IllegalArrangementException;
import am.aua.checkers.core.Move;
import am.aua.checkers.core.Position;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * A class that created GUI for the program
 * <code>am.aua.checkers.ui.CheckersUI</code>.
 *
 * @author Martin Palanjyan
 * @author Arman Khachatryan
 * @author Gor Hovakimyan
 * References
 * Martin Palanjyan's HW10
 */

public class CheckersUI extends JFrame implements ActionListener {
    private boolean flag;
    private boolean isHighlighted;
    private boolean success2;
    private Checkers game;
    private JPanel titlePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JLabel textField = new JLabel();
    private BoardSquare[][] buttons = new BoardSquare[Checkers.BOARD_RANKS][Checkers.BOARD_FILES];
    private Position position;
    private ArrayList<Position> positions = new ArrayList<>();

    public static final int Width = 1000;
    public static final int Height = 1000;

    /**
     * A no-arg constructor that contains all the visual style of the program
     *
     * @throws IllegalArrangementException
     */

    public CheckersUI() throws IllegalArrangementException {
        super("Checkers");
        this.position = null;
        setSize(Width, Height);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());//
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 100, 300);
        buttonPanel.setLayout(new GridLayout(Checkers.BOARD_RANKS, Checkers.BOARD_FILES));
        for (int i = 0; i < Checkers.BOARD_RANKS; i++) {
            for (int j = 0; j < Checkers.BOARD_FILES; j++) {
                if ((i + j) % 2 == 0) {
                    buttons[i][j] = new BoardSquare(true, i, j);
                } else {
                    buttons[i][j] = new BoardSquare(false, i, j);
                }

                buttons[i][j].setPreferredSize(new Dimension(90, 90));
                buttonPanel.add(buttons[i][j]);
                this.game = new Checkers();
                if (game.getBoard()[i][j] != null) {
                    buttons[i][j].setPiece(game.getPieceAt(new Position(i, j)).toString());
                }
                buttons[i][j].setVisible(true);
                buttons[i][j].addActionListener(e -> {
                    BoardSquare button = (BoardSquare) e.getSource();
                    boardClicked(button.getCoordinate());
                });
                buttonPanel.add(buttons[i][j]);
            }
        }

        buttonPanel.setVisible(true);
        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    /**
     * A method that performs the action when the click is made by the user.
     * @param coordinates
     */

    private void boardClicked(int[] coordinates) {
        this.position = new Position(coordinates[0], coordinates[1]);
        positions.add(this.position);
        if (!flag) {
            if (game.getPieceAt(this.position) != null) {
                if (game.isEmpty(this.position)) {
                    BoardSquare boardSquare = buttons[position.getRank()][position.getPosition()];
                    boardSquare.setHighlight(false);
                } else {
                    for (int j = 0; j < Checkers.BOARD_RANKS; j++) {
                        for (int k = 0; k < Checkers.BOARD_FILES; k++) {
                            BoardSquare boardSquare = buttons[j][k];
                            boardSquare.setHighlight(false);
                        }
                    }
                }

                ArrayList<Position> reachableSquares = game.reachableFrom(this.position);
                ArrayList<Position> eatableSquares = game.eatableFrom(this.position);

                for (int i = 0; i < Checkers.BOARD_RANKS; i++) {
                    for (int j = 0; j < Checkers.BOARD_FILES; j++) {

                        if (this.position != null &&
                                this.position.getRank() == i && this.position.getPosition() == j)
                            isHighlighted = true;
                        for (int k = 0; reachableSquares != null &&
                                k < reachableSquares.size(); k++)
                            if (reachableSquares.get(k).getRank() == i &&
                                    reachableSquares.get(k).getPosition() == j) {
                                buttons[i][j].setHighlight(true);
                                flag = true;
                                break;
                            }

                        for (int k = 0; eatableSquares != null &&
                                k < eatableSquares.size(); k++)
                            if (eatableSquares.get(k).getRank() == i &&
                                    eatableSquares.get(k).getPosition() == j) {
                                buttons[i][j].setHighlight(true);
                                flag = true;
                                break;
                            }
                    }
                }
            }
        } else {
            this.position = new Position(coordinates[0], coordinates[1]);
            positions.add(this.position);
            success2 = game.performMove(new Move(positions.get(0), positions.get(1)));
            for (int j = 0; j < Checkers.BOARD_RANKS; j++) {
                for (int k = 0; k < Checkers.BOARD_FILES; k++) {
                    BoardSquare boardSquare = buttons[j][k];
                    boardSquare.setHighlight(false);
                }
            }
            updatePieces();
            if (!success2) {
                System.out.println("Invalid");
            }
            flag = false;
            positions.clear();

        }
    }

    /**
     * A method that updates the pieces on the board
     */
    private void updatePieces() {
        for (int i = 0; i < Checkers.BOARD_RANKS; i++) {
            for (int j = 0; j < Checkers.BOARD_FILES; j++) {
                if (game.isEmpty(new Position(i, j))) {
                    buttons[i][j].setPiece();
                } else {
                    buttons[i][j].setPiece(game.getPieceAt(new Position(i, j)).toString());
                }
            }

        }
    }

    /**
     * A method for giving an action to the button.
     * @param e
     */


    public void actionPerformed(ActionEvent e) {
    }
}
