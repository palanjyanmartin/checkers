package am.aua.checkers.ui;
import javax.swing.*;
import java.awt.*;

public class BoardSquare extends JButton {
    public static final Color dark = Color.BLACK;
    public static final Color light = Color.WHITE;
    private int xCord;
    private int yCord;
    private Color color;

    public BoardSquare(boolean color, int xCord, int yCord) {
        super();
        if (color) {
            this.color = dark;
            setBackground(Color.BLACK);
        } else {
            this.color = light;
            setBackground(Color.WHITE);
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
        if (letter.equals("M")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/pics/ManW.png");
            this.setIcon(icon);
        } else if (letter.equals("m")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/pics/ManB.png");
            this.setIcon(icon);
        } else if (letter.equals("K")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/pics/KingW.png");
            this.setIcon(icon);
        } else if (letter.equals("k")) {
            Icon icon = new ImageIcon(System.getProperty("user.dir") + "/src/pics/KingB.png");
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
