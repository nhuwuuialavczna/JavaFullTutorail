package AI.demo.dfs_bfs_astar;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class BFS {
    private static boolean checkRepeats(Node n) {
        boolean retValue = false;
        Node checkNode = n;
        // While n's parent isn't null, check to see if it's equal to the node
        // we're looking for.
        while (n.parent != null && !retValue) {
            if (n.parent.currentState.equals(checkNode.currentState)) {
                retValue = true;
            }
            n = n.parent;
        }
        return retValue;
    }

    public static Stack<Node> search(int[][] board) {
        Node root = new Node(new EigPuzz(board));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        return performSearch(q);
    }

    private static Stack<Node> performSearch(Queue<Node> q) {int searchCount = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (!node.currentState.isGoal()) {
                List<State> states = node.currentState.genSuccessors();
                for (State state : states) {
                    Node nodeNew = new Node(state, node, node.cost + state.findCost(), 0.0d);
                    if (!checkRepeats(nodeNew)) {
                        q.add(nodeNew);
                    }
                }
            } else {
                Stack<Node> solutionPath = new Stack<>();
                solutionPath.push(node);
                node = node.parent;
                while (node.parent != null) {
                    solutionPath.push(node);
                    node = node.parent;
                }
                solutionPath.push(node);
                return solutionPath;
            }
        }
        return null;
    }

}
