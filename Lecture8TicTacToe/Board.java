package Lecture8TicTacToe;

import java.util.LinkedList;
import java.util.Queue;

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

        while(turns>0){
           System.out.println("Current Board is:");
           printBoard();
           System.out.println("Please select a position and gives its X and Y cooridnates");
           Player player= playerQueue.poll();

        }

    }



}



class Cell{
    char cellChar;

    public Cell(){
        cellChar='|'; 
    }

    public char getCellChar() {
        return cellChar;
    }

    public void setCellChar(char cellChar) {
        this.cellChar = cellChar;
    }

    
    


}