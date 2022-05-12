package am.aua.checkers.ui;
import javax.swing.*;
import java.awt.*;

/**
 * A class that provides created Board Square to be used in CheckersUI class
 * <code>am.aua.checkers.ui.BoardSquare</code>.
 * @author Martin Palanjyan
 * @author Arman Khachatryan
 * @author Gor Hovakimyan
 * References
 * Martin Palanjyan's HW10
 */

public class BoardSquare extends JButton {
    public static final Color light = Color.WHITE;
    public static final Color dark = Color.GRAY;
    private int xCord;
    private int yCord;
    private Color color;

    /**
     * A constructor
     * @param color
     * @param xCord
     * @param yCord
     */

    public BoardSquare(boolean color, int xCord, int yCord) {
        super();
        if (color) {
            this.color = light;
            setBackground(Color.WHITE);
        } else {
            this.color = dark;
            setBackground(Color.GRAY);
        }
        this.xCord = xCord;
        this.yCord = yCord;

    }

    /**
     * Method that creates an array of coordinates.
     * @return
     */

    public int[] getCoordinate() {
        int[] newArray = new int[2];
        newArray[0] = this.xCord;
        newArray[1] = this.yCord;
        return newArray;
    }

    /**
     * A method that will set icons of the pieces.
     * @param letter
     */

    public void setPiece(String letter) {
        switch (letter) {
            case "M" -> {
                Icon icon = new ImageIcon("gfx/PawnW.png");
                this.setIcon(icon);
            }
            case "m" -> {
                Icon icon = new ImageIcon("gfx/PawnB.png");
                this.setIcon(icon);
            }
            case "K" -> {
                Icon icon = new ImageIcon("gfx/QueenW.png");
                this.setIcon(icon);
            }
            case "k" -> {
                Icon icon = new ImageIcon("gfx/QueenB.png");
                this.setIcon(icon);
            }
            case " " -> this.setPiece();
        }
    }

    /**
     * A method that set the icon of the piece to empty one.
     */

    public void setPiece() {
        this.setIcon(null);
    }

    /**
     * A method that highlights the square to red or keep it the same.
     * @param highlighted
     */

    public void setHighlight(boolean highlighted) {
        if (highlighted) {
            this.setBackground(Color.RED);
        } else
            this.setBackground(color);
    }
}
