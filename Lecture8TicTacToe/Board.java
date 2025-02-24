package Lecture8TicTacToe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Board {
    Queue<Player> playerQueue = new LinkedList<>();
    PlayingPeice[][] board;
    int size;
    int turns;
    int numOfPlayers;
    
    public int getSize(){
        return size;
    }
    public Board(int size){
        this.size=size;
        numOfPlayers=2;
        board=new PlayingPeice[size][size];
        turns=size*size;
        for(int i=0;i<numOfPlayers;i++){
            playerQueue.add(new Player("Shreshth", Pieces.O));
            playerQueue.add(new Player("Riya", Pieces.X));
        }

    }
    public PlayingPeice getPlayingPeice(int x,int y){
        return board[x][y]; 
    }

    void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++)
                System.out.print(board[i][j]+" ");
            System.out.println("");
        }
        
    }

    
    

    
        scanner.close();
        if(turns==0)
            System.out.println("The game was a draw");

    }



}



abstract class Cell{
    Pieces cellChar;

    public Pieces getCellChar() {
        return cellChar;
    }

    public void setCellChar(Pieces cellChar) {
        this.cellChar = cellChar;
    }

}