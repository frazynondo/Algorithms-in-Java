package Strings;

import java.util.ArrayList;
import java.util.List;

public class StringRun {
    public static void main(String [] args){

    }

    public boolean exist(char[][] board, String word) {

        List<Character> temp = new ArrayList<Character>();
        int count = 0;
        for(int I = 0; I < word.length(); I++){
            temp.add(word.charAt(I));
        }

        for(int I = 0; I< board.length; I++){
            for (int j = 0; j < board[I].length; j++){
                if(temp.contains(board[I][j])){
                    if(temp.size() > 0){
                        int ind = temp.indexOf((char) board[I][j]);
                        temp.remove(ind);
                        count += 1;
                    }
                    if(count == word.length()) return true;
                }
            }
        }
        return false;
    }
}
