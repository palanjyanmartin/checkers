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

public class CheckersUI extends JFrame implements ActionListener {
    private Checkers game;
    private JPanel titlePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JLabel textField = new JLabel();
    private BoardSquare[][] buttons = new BoardSquare[Checkers.BOARD_RANKS][Checkers.BOARD_FILES];
    private Position position;
    private Position destination;

    public static final int Width = 1000;
    public static final int Height = 1000;

    public CheckersUI() throws IllegalArrangementException {
        super("Checkers");
        this.position = null;
        setSize(Width, Height);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        buttonPanel.setLayout(new GridLayout(Checkers.BOARD_RANKS, Checkers.BOARD_FILES));
        for (int i = 0; i < Checkers.BOARD_RANKS; i++) {
            for (int j = 0; j < Checkers.BOARD_FILES; j++) {
                if ((i + j) % 2 == 0) {
                    buttons[i][j] = new BoardSquare(true, i, j);
                } else {
                    buttons[i][j] = new BoardSquare(false, i, j);
                }
                buttons[i][j].setPreferredSize(new Dimension(95, 95));
                buttonPanel.add(buttons[i][j]);
                this.game = new Checkers();
                if (game.getBoard()[i][j] != null) {
                    buttons[i][j].setPiece(game.getPieceAt(new Position(i, j)).toString());
                }
                buttons[i][j].setVisible(true);
                buttons[i][j].addActionListener(e -> {
                    BoardSquare button = (BoardSquare) e.getSource();
                    boardClicked(button.getCoordinate());
                    updatePieces();
                });
                buttonPanel.add(buttons[i][j]);
            }
        }

        buttonPanel.setVisible(true);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void boardClicked(int[] coordinates) {
        this.position = new Position(coordinates[0], coordinates[1]);
        if (game.isEmpty(this.position)) {
            BoardSquare boardSquare = buttons[position.getRank()][position.getPosition()];
            boardSquare.setHighlight(false);


        } else if (!game.isEmpty(this.position)) {
            for (int j = 0; j < Checkers.BOARD_RANKS; j++) {
                for (int k = 0; k < Checkers.BOARD_FILES; k++) {
                    BoardSquare boardSquare = buttons[j][k];
                    boardSquare.setHighlight(false);
                }

            }

            if ((game.getPieceAt(new Position(coordinates[0], coordinates[1])) != null) && (game.getTurn() == game.getPieceAt(new Position(coordinates[0], coordinates[1])).getPieceColor())) {
                if (game.reachableFrom(new Position(coordinates[0], coordinates[1])) != null) {
                    for (int i = 0; i < game.reachableFrom(new Position(coordinates[0], coordinates[1])).size(); i++) {
                        this.destination = game.reachableFrom(new Position(coordinates[0], coordinates[1])).get(i);
                        BoardSquare boardSquare = buttons[this.destination.getRank()][this.destination.getPosition()];
                        boardSquare.setHighlight(true);
                        updatePieces();
                    }

                }


            }
            ArrayList<Position> list = game.reachableFrom(new Position(coordinates[0], coordinates[1]));
            if (list != null) {
                for (Position value : list) {
                    this.destination = value;
                    if (!game.performMove(new Move(this.position, this.destination))) {
                        System.out.println("Invalid position. Please try again.");

                    }
                }
            }


        }
    }

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


    public void actionPerformed(ActionEvent e) {
    }
}
