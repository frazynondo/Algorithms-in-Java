package Matrix;

public class matrixRun {
    public static void main(String[] args) {

        char [][] tic = {
                {'o', ' ', 'o', 'o'}, // t[0][length - 1]
                {'x', 'o', 'o', 'x'}, // t[1][length - 2]
                {'x', 'o', 'o', ' '}, // t[2][length - 3]
                {' ', 'x', ' ', 'o'}  // t[3][length - 4]
        };

        int [][]spiral = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        spiralPrint(spiral);
//        System.out.println(TicTac_Check_For_Winner(tic));
    }
    /**************************************************************/
    //Leetcode 79. Word Search
    public boolean exist(char[][] board, String word) {

        if(board.length == 0 || word.length() == 0) return false;

        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[y].length; x++){
                if(board[y][x] == word.charAt(0) && search(board, y, x, word, 0)) return true;
            }
        }

        return false;
    }

    public static boolean search(char [][] board, int y, int x, String word, int index){

        if(index == word.length()) return true;
        if(y < 0 || y >= board.length || x  < 0 || x >= board[y].length || board[y][x] != word.charAt(index)){
            return false;
        }

        char temp = board[y][x];
        board[y][x] = ' ';

        boolean found = search(board, y + 1, x, word, index + 1) || search(board, y - 1, x, word, index + 1)
                || search(board, y, x + 1, word, index + 1) || search(board, y, x - 1, word, index + 1);

        board[y][x] = temp;

        return found;

    }

    /**************************************************************/

    public static void spiralPrint(int [][] array){

        int colLen = array[0].length-1, rowLen = array.length-1;
        int colStart = 0, rowStart = 0;

        while(rowStart <= rowLen && colStart <= colLen){

            for(int I = colStart; I<=colLen; I++){
                System.out.println(array[rowStart][I]);
            }

            for(int I = rowStart+1; I<=rowLen; I++){
                System.out.println(array[I][rowLen]);
            }

            for(int I = colLen - 1; I>= colStart; I--){
                System.out.println(array[colLen][I]);
            }

            for(int I = rowLen - 1; I > rowStart; I--){
                System.out.println(array[I][colStart]);
            }


            rowStart += 1;
            rowLen -= 1;
            colStart += 1;
            colLen -= 1;



        }

    }

    /********************************************************************/

    public static String TicTac_Check_For_Winner(char[][]tic){
        int K = 0, len = tic.length, c_Forward1 = 0, c_Forward2 = 0, c_Reverse1 = 0, c_Reverse2 = 0;
        char player1 = 'o', player2 = 'x';
        String winner = "The WINNER is ";

        while(K < len){
           /** Let's check if the index at tic[0][0] has a value for a cross |X| search
            {'o', ' ', 'o', 'o'}, from tic[0][length - 1] & from tic[0][0]
            {'x', 'o', 'o', 'x'}, tic[1][length - 2] & tic[1][1]
            {'x', 'o', 'o', ' '}, tic[2][length - 3] & tic[2][2]
            {' ', 'x', ' ', 'o'}  tic[3][length - 4] & tic[3][3]
            **/
            if(tic[0][0] == player1 || tic[0][0] == player2) {
                if(tic[K][K] == player1){
                    c_Forward1 += 1;
                }
                if(tic[K][K] == player2){
                    c_Forward2 += 1;
                }
            }

            if(tic[K][tic.length - 1 - K] == player1){
                c_Reverse1 += 1;
            }

            if(tic[K][tic.length - 1 - K] == player2){
                c_Reverse2 += 1;
            }

            K++;
        }

        // Check if the length are equal to the count of chars we have a winner
        if(c_Forward1 == len || c_Reverse1 == len || WinnerHelper(tic, player1)) return winner + player1;
        if(c_Forward2 == len || c_Reverse2 == len || WinnerHelper(tic, player2)) return winner + player2;

        return "No winner yet";
    }

    public static boolean WinnerHelper(char [][] tic, int player){
        for(int I=0; I< tic.length; I++){
            int j = 0;
            int countRow1 = 0;
            int countCol1 = 0;

            while(j < tic[I].length && tic[I][j] == player) {
                j++;
                countRow1 += 1;
            }

            if(countRow1 == tic[I].length) return true;

            j = 0;
            while(j < tic[I].length && tic[j][I] == player){
                j++;
                countCol1 += 1;
            }
            if(countCol1 == tic[I].length) return true;

        }

        return false;
    }

    /********************************************************************/
}
