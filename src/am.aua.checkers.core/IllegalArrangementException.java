package am.aua.checkers.core;
/**
 * Exception
 * @author Martin Palanjyan
 * @author Arman Khachatryan
 * @author Gor Hovakimyan
 * References
 * Martin Palanjyan's Homework 09
 */

public class IllegalArrangementException extends Exception{

    public IllegalArrangementException() {
            super("The string does not represent a valid arrangement of pieces on a board.");
        }

        public IllegalArrangementException(String message) {
            super(message);
        }
    }

