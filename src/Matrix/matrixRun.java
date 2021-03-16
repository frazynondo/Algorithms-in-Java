package Matrix;

public class matrixRun {
    public static void main(String[] args) {

        char [][] tic = {
                {'o', ' ', 'o', 'o'}, // t[0][length - 1]
                {'x', 'o', 'o', 'x'}, // t[1][length - 2]
                {'x', 'o', 'o', ' '}, // t[2][length - 3]
                {' ', 'x', ' ', 'o'}  // t[3][length - 4]
        };

        System.out.println(TicTac_Check_For_Winner(tic));
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
