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
        this.board=new Board(3);
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
           Player player= playerQueue.poll();
           System.out.println("Please select a position "+player.getName() +" and enter \n X coordinate:");  
           int x=scanner.nextInt();
           System.out.println("\n Y coordinate:");
           int y=scanner.nextInt();
           
           if(x < board.size && y < board.size && x>=0 && y>=0 && board.getPlayingPeice(x, y)!=Pieces.empty){
                board[x][y].setCellChar(player.getPiece());
                turns--;
                if(checkWinner(x, y)){
                    System.out.println("Congrats "+player.getName()+"! you have won.");
                    scanner.close();
                    break;
                }
                playerQueue.add(player);
           }
        }
}


interface checkWinner{
    boolean didWin(Board board,int x,int y);
}


class stratergy3N implements  checkWinner{

    @Override
    public boolean didWin(Board board,int x,int y) {
        
            boolean dia=true,verti=true,across=true;
            
                
                for(int i=0;i<board.size;i++){
                    dia=dia||(board.getPlayingPeice(x, y)==board.getPlayingPeice(i, i));
                    verti=verti||(board.getPlayingPeice(x, y)==board.getPlayingPeice(i, y));
                    across=across||(board.getPlayingPeice(x, y)==board.getPlayingPeice(x, i));
                }
                if(x!=y) dia=false;
        
                return dia||verti||across;
            
            
    }

}