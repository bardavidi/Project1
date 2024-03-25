package test;

import java.util.Random;

public class Tile {

	public final char letter;
    public final int score;

    private Tile(char l, int s) {
        letter = l;
        score = s;
    }

    public static class Bag {
        private static Bag b = null;
        private final int letterCountDefine[] = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,};
        public int letterCount[] = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,};
        public int letterScore[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
        public Tile tiles[] = new Tile[26];

        private Bag(){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < letterCount[i]; j++){
                    tiles[i] = new Tile((char)(i + 1), letterScore[i]);
                }  
            }
        }

        public Tile getRand(){
            if (size() == 0)
                return null;

            boolean isExist = false;
            while(isExist == false){
                Random random = new Random();
                int randomTile = random.nextInt(26);
                if(letterCount[randomTile] != 0){
                    isExist = true;
                    letterCount[randomTile]--;
                    return tiles[randomTile];
                }
            }

            return null;
        }

        public Tile getTile(char c){
            int ndx = (int)(c)-1;
            if (size() == 0)
                return null;
            if(letterCount[ndx] == 0)
                return null;
            else{
                letterCount[ndx]--;
                return tiles[ndx];
            }
        }

        public void put(Tile t){
            int ndx = (int)(t.letter)-1;
            if(letterCount[ndx]+1>letterCountDefine[ndx])
                return;
            letterCount[ndx]++;
        }

        public int size(){
            int count=0;
            for(int i = 0; i < 26; i++)
                count+=letterCount[i];
            return count;
        }

        public int[] getQuantities(){
            int[] copy = new int[26];
            for(int i = 0; i < 26; i++)
                copy[i]=letterCount[i];
            return copy;
        }

        public static Bag getBag(){
            if (b == null)
                b = new Bag();
            return b;
        }
    }

}
