package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    public Board(Character[][] matrix) {
        this.board = matrix;
    }
    private Character[][] board;
    private int resolveBoard() {
        int totalMoves = 0;
        for (int row = 0; row < board[0].length; row++) {
            int xCount = 0;
            int oCount = 0;
            for (int column = 0; column < board[row].length; column++) {
                 switch(board[row][column]) {
                     case 'X':
                         xCount ++;
                         totalMoves++;
                         break;
                     case 'O':
                         oCount ++;
                         totalMoves++;
                        break;
                 }
                 if (xCount == 3)
                        return 1;
                 else if (oCount == 3)
                        return 2;
            }
        }
        for (int column= 0; column < board.length; column++) {
            int xCount = 0;
            int oCount = 0;
            for(int row = 0; row < board[column].length; row++){
                switch(board[row][column]) {
                    case 'X':
                        xCount ++;
                        break;
                    case 'O':
                        oCount ++;
                        break;
                }
                if (xCount == 3)
                    return 1;
                else if (oCount == 3)
                    return 2;
            }
        }
        if ((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')||
            (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X'))
            return 1;
        else if ((board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')||
                (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O'))
            return 2;
        if (totalMoves == 9)
            return 0;
        else
        return -1;
    }

    public Boolean isInFavorOfX() {
        return resolveBoard() == 1;
    }

    public Boolean isInFavorOfO() {
        return resolveBoard() == 2;
    }

    public Boolean isTie() {
        return resolveBoard() == 0;
    }

    public String getWinner() {
        switch (resolveBoard()) {
            case 1:
                return "X";
            case 2:
                return "O";
            case 0:
                return "";
            default:
                return null;
        }
    }


}
