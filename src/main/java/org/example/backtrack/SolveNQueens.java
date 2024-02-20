package org.example.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/18 15:43
 */
// 51  n 皇后问题
public class SolveNQueens {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
        }
        int row = 0;
        backtrack(board, 0);
        return res;
    }

    void backtrack(List<String> board, int row) {
        if(row == board.size()) {
            res.add(board);
            return;
        }
        for(int col = 0; col < board.size(); col++) {
            if (!isValid(row, col, board)) {
                continue;
            }
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());
            backtrack(board, row + 1);
            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }
    }

    /* 是否可以在 board[row][col] 放置皇后？ */
    public boolean isValid(int row, int col, List<String> board) {
        return false;
        // todo 检查row, col坐标点的列，左上方,右上方是否有皇后
    }
}
