package AI.game.eightpuzzle;

import java.util.List;

/**
 * @author JINX_NHI
 */
public interface State {
    /**
     * Xác định nếu trạng thái là goal
     */
    boolean isGoal();

    // tạo các trạng thái con của trạng thái hiện tại
    List<State> genSuccessors();

    // Xác định chi phí của trạng thái hiện tại
    double findCost();


    // in ra trạng thái hiện tại
    void printState();

    // so sánh dữ liệu của 2 trạng thái
    boolean equals(State s);
}
