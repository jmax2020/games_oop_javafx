package ru.job4j.puzzle;

public class Win {

    public static boolean horizontal(int[][] mass, int row) {
        boolean rsl = true;
        for (int i = 0; i < mass[0].length; i++) {
            if (mass[row][i] == 0) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean vertical(int[][] mass, int column) {
        boolean rsl = true;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i][column] == 0) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][i] == 1 && (horizontal(board, i) || vertical(board, i))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}
