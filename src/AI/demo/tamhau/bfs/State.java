package AI.demo.tamhau.bfs;

import java.util.List;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public interface State {
    /**
     * Kiểm tra trạng thái có là đích chưa - đích : là trạng thái ko có quân hậu nào được ăn nhau
     */
    boolean isGoal();

    /**
     * Lấy các nước đặt khả dĩ
     * */
    List<State> getSuccessors(int cot);

    double findCost();

    // in ra trạng thái hiện tại
    void print();


    // so sánh dữ liệu của 2 trạng thái
    boolean equals(State s);

}
