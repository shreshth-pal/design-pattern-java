package Lecture8TicTacToe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToe {

    
    private  Queue<Player> playerQueue = new LinkedList<>();
    private int turns;
    private int numOfPlayers;
    private Board board;

    public TicTacToe() {
        this.board=new Board(3,new stratergy3N());
        for(int i=0;i<2;i++){
            playerQueue.add(new Player("Shreshth", Pieces.O));
            playerQueue.add(new Player("Riya", Pieces.X));
        }
        turns=9;
    }

    
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
            ticTacToe.startGame();
    }


    void startGame(){
        Scanner scanner = new Scanner(System.in);
        while(turns>0){
           System.out.println("Current Board is:");
           board.printBoard();
           Player player= playerQueue.peek();
           System.out.println("Please select a position "+player.getName() +" and enter \n X coordinate:");  
           int x=scanner.nextInt();
           System.out.println("\n Y coordinate:");
           int y=scanner.nextInt();
           
           if(x < board.size && y < board.size && x>=0 && y>=0 && board.getPlayingPeice(x, y)==null){
                board.setPlayingPiece(x,y,player.getPiece());
                turns--;
                if(board.checkWinner.didWin(board, x, y)){
                    System.out.println("Congrats "+player.getName()+"! you have won.");
                    scanner.close();
                    break;
                }
                playerQueue.remove();
                playerQueue.add(player);
           }
        }

        scanner.close();
        if(turns==0)
            System.out.println("That was a sad draw");
}



}

class stratergy3N implements  checkWinner{
    
    @Override
    public boolean didWin(Board board,int x,int y) {
        
            boolean dia=true,verti=true,across=true;
            
                
                for(int i=0;i<board.size;i++){
                    dia=dia&&(board.getPlayingPeice(x, y)==board.getPlayingPeice(i, i));
                    verti=verti&&(board.getPlayingPeice(x, y)==board.getPlayingPeice(i, y));
                    across=across&&(board.getPlayingPeice(x, y)==board.getPlayingPeice(x, i));
                }
                if(x!=y) dia=false;
        
                return dia||verti||across;
    }
}