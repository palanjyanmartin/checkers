package am.aua.checkers;

import am.aua.checkers.cli.*;
import am.aua.checkers.core.IllegalArrangementException;


public class Main {
    public static void main(String[] args) throws IllegalArrangementException {

        CheckersConsole checkersConsole = new CheckersConsole();
        checkersConsole.play();
    }
}
