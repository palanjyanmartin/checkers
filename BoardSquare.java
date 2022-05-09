package am.aua.chess.ui;

import am.aua.chess.core.Chess;
import am.aua.chess.core.IllegalArrangementException;
import am.aua.chess.core.Move;
import am.aua.chess.core.Position;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ChessUI extends JFrame implements ActionListener {
    private Chess game;
    private JPanel titlePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JLabel textField = new JLabel();
    private BoardSquare[][] buttons = new BoardSquare[Chess.BOARD_RANKS][Chess.BOARD_FILES];
    private Position position;
    private Position destination;

    public static final int Width = 1000;
    public static final int Height = 1000;

    public ChessUI() throws IllegalArrangementException {
        super("Chess");
        this.position = null;
        setSize(Width, Height);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());//
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 100, 300);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.ORANGE);
        textField.setFont(new Font("Serif", Font.BOLD, 50));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Chess");
        buttonPanel.setLayout(new GridLayout(Chess.BOARD_RANKS, Chess.BOARD_FILES));
        //buttonPanel.setBackground(Color.BLACK);
        for (int i = 0; i < Chess.BOARD_RANKS; i++) {
            for (int j = 0; j < Chess.BOARD_FILES; j++) {
                if ((i + j) % 2 == 0) {
                    buttons[i][j] = new BoardSquare(true, i, j);
                } else {
                    buttons[i][j] = new BoardSquare(false, i, j);
                }
                buttons[i][j].setPreferredSize(new Dimension(90, 90));
                buttonPanel.add(buttons[i][j]);
                this.game = new Chess();
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

        titlePanel.add(textField);
        buttonPanel.setVisible(true);
        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void boardClicked(int[] coordinates) {
        this.position = new Position(coordinates[0], coordinates[1]);
        if (game.isEmpty(this.position)) {
            BoardSquare boardSquare = buttons[position.getRank()][position.getFile()];
            boardSquare.setHighlight(false);


        } else if (!game.isEmpty(this.position)) {
            for (int j = 0; j < Chess.BOARD_RANKS; j++) {
                for (int k = 0; k < Chess.BOARD_FILES; k++) {
                    BoardSquare boardSquare = buttons[j][k];
                    boardSquare.setHighlight(false);
                }

            }

            if ((game.getPieceAt(new Position(coordinates[0], coordinates[1])) != null) && (game.getTurn() == game.getPieceAt(new Position(coordinates[0], coordinates[1])).getPieceColor())) {
                if (game.reachableFrom(new Position(coordinates[0], coordinates[1])) != null) {
                    for (int i = 0; i < game.reachableFrom(new Position(coordinates[0], coordinates[1])).size(); i++) {
                        this.destination = game.reachableFrom(new Position(coordinates[0], coordinates[1])).get(i);
                        BoardSquare boardSquare = buttons[this.destination.getRank()][this.destination.getFile()];
                        boardSquare.setHighlight(true);
                        updatePieces();
                    }

                }


            }
            ArrayList<Position> list = game.reachableFrom(new Position(coordinates[0], coordinates[1]));
            if (list != null) {
                for (int k = 0; k < list.size(); k++) {
                    this.destination = list.get(k);
                    if (!game.performMove(new Move(this.position, this.destination))) {
                        System.out.println("Invalid position. Please try again.");

                    }
                }
            }


        }
    }

    private void updatePieces() {
        for (int i = 0; i < Chess.BOARD_RANKS; i++) {
            for (int j = 0; j < Chess.BOARD_FILES; j++) {
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

