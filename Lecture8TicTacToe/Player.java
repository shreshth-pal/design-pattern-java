package Lecture8TicTacToe;

public class Player {
    private  String name;
    private Pieces piece;
    public Player(String name, Pieces piece) {
        this.name = name;
        this.piece = piece;
    }
    
    public String getName() {
        return name;
    }
    
    public Pieces getPiece() {
        return piece;
    }
    

    
    

}
