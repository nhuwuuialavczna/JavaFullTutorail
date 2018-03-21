package AI.demo.tamhau.bfs;

import AI.game.caro.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class TamHau implements State {
    public boolean isVisited;
    int board[][] = new int[8][8];

    public TamHau(int currentBoard[][]) {
        this.board = currentBoard;
        isVisited = false;
    }


    @Override
    public boolean isGoal() {
        List<Point> ds = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    ds.add(new Point(i, j));
                }
            }
        }
        for (Point p : ds) {
            board[p.x][p.y] = 0;
            if (coTanCongAiKhong(p.x, p.y)) {
                board[p.x][p.y] = 1;
                return false;
            } else {
                board[p.x][p.y] = 1;
            }
        }
        if (ds.size() < 8) return false;

        return true;
    }


    public void datQuanCo(int x, int y) {
        board[x][y] = 1;
    }

    public boolean coTanCongAiKhong(int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < 8; i++)
            if (board[row][i] == 1)
                return true;

        for (i = 0; i < 8; i++)
            if (board[i][col] == 1)
                return true;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return true;

         /* Check upper diagonal on right side */
        for (i = row, j = col; i >= 0 && j < 8; i--, j++)
            if (board[i][j] == 1)
                return true;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < 8; i++, j--)
            if (board[i][j] == 1)
                return true;

        /* Check lower diagonal on right side */
        for (i = row, j = col; j < 8 && i < 8; i++, j++)
            if (board[i][j] == 1)
                return true;

        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[8][8];
        a[6][0] = 1;
        a[4][1] = 1;
        a[2][2] = 1;
        a[0][3] = 1;
        a[5][4] = 1;
        a[7][5] = 1;
        a[1][6] = 1;
//        a[3][7] = 1;
//        TamHau tamHau = new TamHau(a);
//        tamHau.getSuccessors(7).get(0).print();
        Stack<Node> nodes = BFS.bfsSearch();
        for(Node node:nodes){
            System.out.println("======================");
            node.currentState.print();
        }
    }

    @Override
    public List<State> getSuccessors(int cot) {
        List<State> states = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int[][] a = copyBoar();
            TamHau tamHau = new TamHau(a);
            if(!tamHau.coTanCongAiKhong(i,cot)){
                tamHau.datQuanCo(i,cot);
                states.add(tamHau);
            }
        }
        return states;
    }

    public int[][] copyBoar() {
        int[][] re = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                re[i][j] = board[i][j];
            }
        }
        return re;
    }

    @Override
    public double findCost() {
        return 0;
    }

    @Override
    public void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(State s) {
        return false;
    }
}
