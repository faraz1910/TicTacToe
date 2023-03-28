import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char board[][] = new char[3][3];
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board.length; col++){
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner in = new Scanner(System.in);
        int count = 0;

        while(!gameOver && count < 9){
            printBoard(board);
            System.out.print("Player " + player + " enter: ");
            int row = in.nextInt();
            int col = in.nextInt();
            System.out.println();

            if (board[row][col] == ' '){
                board[row][col] = player;
                count++;
//                System.out.println(count);
                gameOver = hasWon(board, player);
                if (gameOver){
                    System.out.println("Player " + player + " has won.");
                }
                else {
                    player = player == 'X' ? 'O' : 'X';
                }
            }
            else{
                System.out.println("Invalid Move. Try Again!");
            }
        }
        printBoard(board);
        System.out.println("---------GAME OVER---------");
    }

    private static boolean hasWon(char[][] board, char player) {
        //Checking rows
        for (int row = 0; row < board.length; row++){
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        //Checking cols
        for (int col = 0; col < board.length; col++){
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        //Checking diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board.length; col++){
                System.out.print(board[row][col] + "|");
            }
            System.out.println();
        }
    }
}
