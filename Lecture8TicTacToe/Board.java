package Lecture8TicTacToe;

public class Board {
   
    Pieces[][] board;
    checkWinner checkWinner;
    int size;
    
    public int getSize(){
        return size;
    }
    public Board(int size,checkWinner stratergy){
        this.checkWinner=stratergy;
        this.size=size;
        board=new Pieces[size][size];
        

    }
    public Pieces getPlayingPeice(int x,int y){
        return board[x][y]; 
    }
    void setPlayingPiece(int x,int y,Pieces p){

        board[x][y]=p;

    }

    void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++)
                System.out.print(board[i][j]+" ");
            System.out.println("");
        }
        
    }

    

    
    

    
        // scanner.close();
        // if(turns==0)
        //     System.out.println("The game was a draw");

    }







    interface checkWinner{
        boolean didWin(Board board,int x,int y);
    }
    
    
  
    
    