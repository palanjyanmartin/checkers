import am.aua.checkers.core.IllegalArrangementException;
import am.aua.checkers.ui.CheckersUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws IllegalArrangementException {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        CheckersUI checkersUI = new CheckersUI();
        checkersUI.setVisible(true);
    }

}
