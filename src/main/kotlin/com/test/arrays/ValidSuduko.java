package com.test.arrays;

import java.util.HashSet;

public class ValidSuduko {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();
        for (int idx = 0; idx < board.length; idx++) {
            for (int jdx = 0; jdx < board[idx].length; jdx++) {
                char value = board[idx][jdx];
                if(value != '.'){
                    if(seen.add("Seen "+value+" at row "+ idx)
                    && seen.add("Seen "+value+" at col "+ jdx)
                    && seen.add("Seen "+value+" at mat "+ idx/3+"-"+jdx/3) ){
                        continue;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSuduko suduko = new ValidSuduko();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {6, '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(suduko.isValidSudoku(board));


        // Input: board =
        //[["8","3",".",".","7",".",".",".","."]
        //,["6",".",".","1","9","5",".",".","."]
        //,[".","9","8",".",".",".",".","6","."]
        //,["8",".",".",".","6",".",".",".","3"]
        //,["4",".",".","8",".","3",".",".","1"]
        //,["7",".",".",".","2",".",".",".","6"]
        //,[".","6",".",".",".",".","2","8","."]
        //,[".",".",".","4","1","9",".",".","5"]
        //,[".",".",".",".","8",".",".","7","9"]]
        //Output: false


    }
}
