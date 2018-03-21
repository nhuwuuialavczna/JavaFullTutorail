package AI.demo.dfs_bfs_astar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class EigPuzz implements State {
    private static final int[][] GOAL = new int[][]
            {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    int soOKoDungViTri;
    int[][] currentBoard;

    public EigPuzz(int[][] currentBoard) {
        this.currentBoard = currentBoard;
        setSoOKoDungViTri();
    }

    public void setSoOKoDungViTri() {
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard[i].length; j++) {
                if (currentBoard[i][j] != GOAL[i][j]) {
                    soOKoDungViTri++;
                }
            }
        }
    }

    public Point viTriCuaOTrong() {
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard[i].length; j++) {
                if (currentBoard[i][j] == 0) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    @Override
    public boolean isGoal() {
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard[i].length; j++) {
                if (currentBoard[i][j] != GOAL[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List<State> genSuccessors() {
        List<State> successor = new ArrayList<>();
        Point viTriOTrong = viTriCuaOTrong();
        int x = viTriOTrong.x;
        int y = viTriOTrong.y;

        if (y == 0 || y == 1) {
            diChuyenSangPhai(viTriOTrong, successor);
        }
        if (y == 1 || y == 2) { // sang trai được nếu x > 0
            diChuyenSangTrai(viTriOTrong, successor);
        }

        if (x == 1 || x == 2) { // đi lên
            diChuyenLenTren(viTriOTrong, successor);
        }
        if (x == 0 || x == 1) { // sang trai được nếu x > 0
            diChuyenLenXuong(viTriOTrong, successor);
        }

        return successor;
    }

    public void diChuyenSangTrai(Point point, List<State> successor) {
        int[][] cpy = copyBoar();
        int x = point.x;
        int y = point.y;
        int temp = cpy[x][y - 1];
        cpy[x][y - 1] = currentBoard[x][y];
        cpy[x][y] = temp;
        successor.add((new EigPuzz(cpy)));
    }

    public void diChuyenSangPhai(Point point, List<State> successor) {
        int[][] cpy = copyBoar();
        int x = point.x;
        int y = point.y;
        int temp = cpy[x][y + 1];
        cpy[x][y + 1] = currentBoard[x][y];
        cpy[x][y] = temp;
        successor.add((new EigPuzz(cpy)));
    }

    public void diChuyenLenTren(Point point, List<State> successor) {
        int[][] cpy = copyBoar();
        int x = point.x;
        int y = point.y;
        int temp = cpy[x - 1][y];
        cpy[x - 1][y] = currentBoard[x][y];
        cpy[x][y] = temp;
        successor.add((new EigPuzz(cpy)));
    }


    public void diChuyenLenXuong(Point point, List<State> successor) {
        int[][] cpy = copyBoar();
        int x = point.x;
        int y = point.y;
        int temp = cpy[x + 1][y];
        cpy[x + 1][y] = currentBoard[x][y];
        cpy[x][y] = temp;
        successor.add((new EigPuzz(cpy)));
    }

    public static void main(String[] args) {
        int[][] a = {{1, 3, 4}, {2, 5, 0}, {6, 7, 8}};
        Stack<Node> search = AStar.search(a,'o');
        for (Node node : search) {
            System.out.println("====================================");
            node.currentState.print();
        }
        // trai, trai, trai, xuong, phai, phai, len
        System.out.println(search.size());
    }

    public int[][] copyBoar() {
        int[][] re = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                re[i][j] = currentBoard[i][j];
            }
        }
        return re;
    }


    @Override
    public double findCost() {
        return 1;
    }

    @Override
    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(currentBoard[i][j] + "   ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(State s) {
        int[][] c = ((EigPuzz) s).currentBoard;
        for (int i = 0; i < this.currentBoard.length; i++) {
            for (int j = 0; j < this.currentBoard[i].length; j++) {
                if (this.currentBoard[i][j] != c[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
