package test;

import test.Tile.Bag;

public class Board {
    private Tile[][] board;

    public Board(){
        board=new Tile[15][15];
    }
    private static Board b = null;

    public static Board getBoard(){
        if (b == null)
            b = new Board();
        return b;
    }

    public Tile[][] getTiles(){
        Tile[][] copyBoard = new Tile[15][15];
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                if(board[i][j]==null)
                    copyBoard[i][j]=null;
                else
                    copyBoard[i][j]=board[i][j];
            }
        }
        return copyBoard;
    }

    public boolean boardLegal(Word word){
        return true;
    }

    public boolean dictionaryLegal(Word word){
        return true;
    }
    
}
