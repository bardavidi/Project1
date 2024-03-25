package test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Word {
	private Tile tiles[];
    private int row;
    private int col;
    private boolean vertical;

    public Word(Tile t[], int r, int c, boolean v){
        tiles = Arrays.copyOf(t, t.length);
        row=r;
        col=c;
        vertical=v;
    }

    public Tile getTiles(){
        return tiles;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public boolean getVertical(){
        return vertical;
    }
}
