package am.aua.chess.ui;
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
        if (letter.equals("R")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/RookW.png");
            this.setIcon(icon);
        } else if (letter.equals("r")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/RookB.png");
            this.setIcon(icon);
        } else if (letter.equals("Q")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/QueenW.png");
            this.setIcon(icon);
        } else if (letter.equals("q")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/QueenB.png");
            this.setIcon(icon);
        } else if (letter.equals("P")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/PawnW.png");
            this.setIcon(icon);
        } else if (letter.equals("p")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/PawnB.png");
            this.setIcon(icon);
        } else if (letter.equals("N")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/KnightW.png");
            this.setIcon(icon);
        } else if (letter.equals("n")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/KnightB.png");
            this.setIcon(icon);
        } else if (letter.equals("B")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/BishopW.png");
            this.setIcon(icon);
        } else if (letter.equals("b")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/BishopB.png");
            this.setIcon(icon);
        } else if (letter.equals("S")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/RookW.png");
            this.setIcon(icon);
        } else if (letter.equals("s")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/RookB.png");
            this.setIcon(icon);
        } else if (letter.equals("K")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/KingW.png");
            this.setIcon(icon);
        } else if (letter.equals("k")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/KingB.png");
            this.setIcon(icon);
        } else if (letter.equals("L")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/KingW.png");
            this.setIcon(icon);
        } else if (letter.equals("l")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/gfx/KingB.png");
            this.setIcon(icon);
        } else if (letter.equals(" ")) {
            this.setPiece();
        } else
            System.out.println();
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
