public class IllegalMoveException extends Exception{
  public IllegalMoveException(){
    Super("Cant perform the given move.");
  }
  public IllegalMoveException(String message){
    super(message);
  }
