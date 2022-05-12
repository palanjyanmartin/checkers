package am.aua.checkers.ui;
import javax.swing.*;
import java.awt.*;

public class BoardSquare extends JButton {
    public static final Color light = Color.WHITE;
    public static final Color dark = Color.GRAY;
    private int xCord;
    private int yCord;
    private Color color;

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

    public int[] getCoordinate() {
        int[] newArray = new int[2];
        newArray[0] = this.xCord;
        newArray[1] = this.yCord;
        return newArray;
    }


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

    public void setPiece() {
        this.setIcon(null);
    }

    public void setHighlight(boolean highlighted) {
        if (highlighted) {
            this.setBackground(Color.RED);
        } else
            this.setBackground(color);
    }
}
