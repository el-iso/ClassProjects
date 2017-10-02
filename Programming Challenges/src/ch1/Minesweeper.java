package ch1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ID: 10189
class Minesweeper {

    public static void incrementAround(int[][] board, int row, int col){
            for(int i = Math.max(0,row-1); i< Math.min(row+2, board.length); i++) {
                for (int j = Math.max(0, col-1); j < Math.min(col+2, board[0].length); j++) {
                    if (board[i][j] != -1) {
                        board[i][j]++;
                    }
                }
            }
    }
    public static void printBoard(int[][] board, int rows, int cols, int field){
        System.out.println("Field #" + field +":");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == -1)
                    System.out.print("*");
                else
                    System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main( String args[] ) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line;

        int field = 1;
        while((line=br.readLine()) != null){
            if(line.length() == 0){
                line = br.readLine();
            }
            StringTokenizer stringToken = new StringTokenizer(line);

            int rows = 0;
            int cols = 0;
            if(stringToken.hasMoreElements()) {
                rows = Integer.parseInt(stringToken.nextToken());
                cols = Integer.parseInt(stringToken.nextToken());
            }

            if(rows == 0){
                break;
            }

            int[][] board = new int[rows][cols];

            for(int i = 0; i < rows; i++){
                char[] nextLine = br.readLine().toCharArray();
                for(int j = 0; j < cols; j++){
                    if(nextLine[j] == '*'){
                        board[i][j] = -1;
                    }
                }
            }

            for(int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == -1) {
                        incrementAround(board, i, j);
                    }
                }
            }

            if(field > 1)
                System.out.println();
            printBoard(board,rows, cols, field);
            field++;
        }
        System.out.println();
    }
}
