package AI.demo.tamhau.bfs;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class Node {

    State currentState;
    Node paren;
    int dept;
    int cost;
    int hcost;
    int fcost;

    public Node(State currentState, Node paren, int cost, int hcost,int dept) {
        this.currentState = currentState;
        this.paren = paren;
        this.dept = dept;
        this.cost = cost;
        this.hcost = hcost;
        this.fcost = this.cost + this.hcost;
    }

    public Node(State currentState) {
        this.currentState = currentState;
        this.paren = null;
        this.cost = 0;
        this.hcost = 0;
        this.fcost = 0;
    }
}
