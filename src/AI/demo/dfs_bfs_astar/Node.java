package AI.demo.dfs_bfs_astar;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class Node implements Comparable<Node>{
    State currentState;
    Node parent;
    double cost; // g(n)
    double hCost; // chi phí heuristic
    double fCost; // f(n) = g(n) + h(n)

    public Node(State currentState, Node parent, double cost, double hCost) {
        this.currentState = currentState;
        this.parent = parent;
        this.cost = cost;
        this.hCost = hCost;
        this.fCost = cost + hCost;
    }

    public Node(State currentState) {
        this.currentState = currentState;
        this.parent = null;
        this.cost = 0;
        this.hCost = 0;
        this.fCost = 0;
    }

    @Override
    public int compareTo(Node o) {
        if (fCost > o.fCost) return 1;
        if (fCost < o.fCost) return -1;
        return 0;
    }
}
