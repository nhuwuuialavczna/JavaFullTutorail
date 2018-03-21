package AI.demo.minimax;

import AI.game.caro.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author JINX_NHI on 3/20/2018.
 */
public class TicTacToe {
    int[][] board;

    public TicTacToe() {
        board = new int[3][3];
    }

    public void danhCo(int x, int y, int player) {
        board[x][y] = player;
    }

    public Point getBestMove(String type) {
        if (type.equals("M")) {
            minimax(0, 1);
        } else {
            minimaxA(0, 1, -1000, 1000);

        }
        int MAX = -100000;
        int best = -1;

        for (int i = 0; i < diemVaViTri.size(); ++i) {
            if (MAX < diemVaViTri.get(i).diem) {
                MAX = diemVaViTri.get(i).diem;
                best = i;
            }
        }
        System.out.println("Số lần gọi minimax tương ứng với số nodes: " + cout);
        return diemVaViTri.get(best).point;
    }

    ArrayList<DiemVaVT> diemVaViTri = new ArrayList<DiemVaVT>();
    int cout = 0;

    public int minimax(int dept, int turn) {
        cout++;
        if (has1Won()) return 10;
        if (has2Won()) return -10;
        List<Point> conChoDi = conChoDi();
        List<Integer> score = new ArrayList<>();
        if (conChoDi.isEmpty()) {
            return evalute();
        }
        for (Point point : conChoDi) {
            int x = point.x;
            int y = point.y;
            if (turn == 1) {
                danhCo(x, y, 1);
                int currentScore = minimax(dept + 1, 2);
                score.add(currentScore);
                if (dept == 0) {
                    diemVaViTri.add(new DiemVaVT(point, currentScore));
                }
            } else {
                danhCo(x, y, 2);
                score.add(minimax(dept + 1, 1));
            }
            removeCo(x, y);

        }
        return (turn == 1) ? max(score) : min(score);
    }


    ArrayList<DiemVaVT> diemVaViTriA = new ArrayList<DiemVaVT>();
    int coutA = 0;

    public int minimaxA(int dept, int turn, int alpha, int beta) {
        cout++;
        if (has1Won()) return 10;
        if (has2Won()) return -10;
        List<Point> conChoDi = conChoDi();
        List<Integer> score = new ArrayList<>();
        if (conChoDi.isEmpty()) {
            return evalute();
        }
        for (Point point : conChoDi) {
            int x = point.x;
            int y = point.y;
            if (turn == 1) {
                danhCo(x, y, 1);
                int currentScore = minimaxA(dept + 1, 2, alpha, beta);
                if (currentScore > alpha) alpha = currentScore;
                if (dept == 0)
                    diemVaViTri.add(new DiemVaVT(point, alpha));
            } else {
                danhCo(x, y, 2);
                int currentScore = minimaxA(dept + 1, 1, alpha, beta);
                if (currentScore < beta) beta = currentScore;
            }
            removeCo(x, y);
            if (alpha >= beta) break;  // beta cut-off
        }
        return (turn == 1) ? alpha : beta;
    }


    public int max(List<Integer> list) {
        return Collections.max(list);
    }

    public int min(List<Integer> list) {
        return Collections.min(list);
    }


    public void removeCo(int x, int y) {
        board[x][y] = 0;
    }

    public List<Point> conChoDi() {
        List<Point> ds = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) ds.add(new Point(i, j));
            }
        }
        return ds;
    }

    /**
     * Tinh số đường thắng của máy
     */
    public int evalute() {
        int soDuongThangCuaMay = 0;
        int soDuongThangCuaTa = 0;
        // có tổng cộng 8 đường thắng
        if (board[0][0] != 2 && board[0][1] != 2 && board[0][2] != 2) {
            soDuongThangCuaMay++;
        }
        if (board[1][0] != 2 && board[1][1] != 2 && board[1][2] != 2) {
            soDuongThangCuaMay++;
        }
        if (board[2][0] != 2 && board[2][1] != 2 && board[2][2] != 2) {
            soDuongThangCuaMay++;
        }
        if (board[0][0] != 2 && board[1][0] != 2 && board[2][0] != 2) {
            soDuongThangCuaMay++;
        }
        if (board[0][1] != 2 && board[1][1] != 2 && board[2][1] != 2) {
            soDuongThangCuaMay++;
        }
        if (board[0][2] != 2 && board[1][2] != 2 && board[2][2] != 2) {
            soDuongThangCuaMay++;
        }
        if (board[0][0] != 2 && board[1][1] != 2 && board[2][2] != 2) {
            soDuongThangCuaMay++;
        }
        if (board[2][0] != 2 && board[1][1] != 2 && board[0][2] != 2) {
            soDuongThangCuaMay++;
        }

        if (board[0][0] != 1 && board[0][1] != 1 && board[0][2] != 1) {
            soDuongThangCuaTa++;
        }
        if (board[1][0] != 1 && board[1][1] != 1 && board[1][2] != 1) {
            soDuongThangCuaTa++;
        }
        if (board[2][0] != 1 && board[2][1] != 1 && board[2][2] != 1) {
            soDuongThangCuaTa++;
        }
        if (board[0][0] != 1 && board[1][0] != 1 && board[2][0] != 1) {
            soDuongThangCuaTa++;
        }
        if (board[0][1] != 1 && board[1][1] != 1 && board[2][1] != 1) {
            soDuongThangCuaTa++;
        }
        if (board[0][2] != 1 && board[1][2] != 1 && board[2][2] != 1) {
            soDuongThangCuaTa++;
        }
        if (board[0][0] != 1 && board[1][1] != 1 && board[2][2] != 1) {
            soDuongThangCuaTa++;
        }
        if (board[2][0] != 1 && board[1][1] != 1 && board[0][2] != 1) {
            soDuongThangCuaTa++;
        }
        return soDuongThangCuaMay - soDuongThangCuaTa;

    }

    public boolean has1Won() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) ||
                (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
                return true;
            }
        }
        return false;
    }

    public boolean has2Won() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2) || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2)) {
                return true;
            }
        }
        return false;
    }

}
