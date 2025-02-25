package Lecture8TicTacToe;

public class PlayingPeice {
    Pieces piece;

    public PlayingPeice(Pieces piece) {
        this.piece = piece;
    }

    public Pieces getPiece() {
        return piece;
    }
    
}

class PlayingPeiceX extends  PlayingPeice{

    public PlayingPeiceX() {
        super(Pieces.X);
    }

}

class PlayingPeiceO extends  PlayingPeice{

    public PlayingPeiceO() {
        super(Pieces.O);
    }

}