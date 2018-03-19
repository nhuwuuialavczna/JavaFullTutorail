package AI.game.eightpuzzle;

/**
 * @author JINX_NHI
 * @since 12/3/2018
 */
public class SearchNode {

    private State curState;
    private SearchNode parent;
    private double cost; // g(n)
    private double hCost; // chi phí heuristic
    private double fCost; // f(n) = g(n) + h(n)

    /**
     * @param s the state passed in
     */
    public SearchNode(State s) {
        curState = s;
        parent = null;
        cost = 0;
        hCost = 0;
        fCost = 0;
    }

    /**
     * Constructor for all other SearchNodes
     *
     * @param prev the parent node
     * @param s    the state
     * @param c    the g(n) cost to get to this node
     * @param h    the h(n) cost to get to this node
     */
    public SearchNode(SearchNode prev, State s, double c, double h) {
        this.parent = prev;
        this.curState = s;
        this.cost = c;
        this.hCost = h;
        this.fCost = this.cost + this.hCost;
    }

    /**
     * @return the curState
     */
    public State getCurState() {
        return this.curState;
    }

    /**
     * @return the parent
     */
    public SearchNode getParent() {
        return this.parent;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return this.cost;
    }

    /**
     * @return the heuristic cost
     */
    public double getHCost() {
        return this.hCost;
    }

    /**
     * @return the f(n) cost for A*
     */
    public double getFCost() {
        return this.fCost;
    }
}
