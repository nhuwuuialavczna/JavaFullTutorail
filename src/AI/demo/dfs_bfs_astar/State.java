package AI.demo.dfs_bfs_astar;

import java.util.List;

/**
 * @author JINX_NHI on 3/20/2018.
 */
public interface State {
    // kiểm tra xem có phải là goal chưa
    boolean isGoal();

    // lấy ra 1 danh sách các trạng thái kế tiếp của trạng thái hiện tại
    List<State> genSuccessors();

    // chi phí của 1 lần di chuyển
    double findCost();

    // in ra trạng thái hiện tại
    void print();

    // so sánh dữ liệu của 2 trạng thái
    boolean equals(State s);

}
