package Lecture8TicTacToe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Board {
    Queue<Player> playerQueue = new LinkedList<>();
    Cell[][] board;
    int size;
    int turns;
    
    public Board(){
        size=3;
        board=new Cell[size][size];
        turns=size*size;
        startGame();
    }

    void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++)
                System.out.print(board[i][j]+" ");
        }
        System.err.println("");
    }

    void startGame(){
        Scanner scanner = new Scanner(System.in);
        while(turns>0){
           System.out.println("Current Board is:");
           printBoard();
           Player player= playerQueue.poll();
           System.out.println("Please select a position "+player.getName() +" and enter \n X coordinate:");  
           int x=scanner.nextInt();
           System.out.println("\n Y coordinate:");
           int y=scanner.nextInt();
           
           if(x< size && y <size && x>=0 && y>=0 && board[x][y].getCellChar()!=Pieces.empty){

           }

        }

    }



}



class Cell{
    Pieces cellChar;

    public Cell(){
        cellChar=Pieces.empty;
    }

    public Pieces getCellChar() {
        return cellChar;
    }

    public void setCellChar(Pieces cellChar) {
        this.cellChar = cellChar;
    }

    
    


}