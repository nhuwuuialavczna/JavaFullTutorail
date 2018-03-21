package AI.demo.dfs_bfs_astar;

import java.util.*;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class AStar {
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

    public static Stack<Node> search(int[][] board, char heuristic) {
        Node root = new Node(new EigPuzz(board));
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(root);
        int searchCount = 1; // counter for number of iterations

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (!node.currentState.isGoal()) {
                List<State> states = node.currentState.genSuccessors();
                List<Node> nodeSuccessors = new ArrayList<>();
                for (State s : states) {
                    Node checkedNode = null;
                    if (heuristic == 'o') {
                        int soOKoDungViTri = ((EigPuzz) s).soOKoDungViTri;
                        checkedNode = new Node(s, node, node.cost + s.findCost(), soOKoDungViTri);
                    }
                    if (!checkRepeats(checkedNode)) {
                        q.add(checkedNode);
                    }
                }
//                if (!nodeSuccessors.isEmpty()) {
//                    Node lowestNode = nodeSuccessors.get(0);
//                    for (int i = 0; i < nodeSuccessors.size(); i++) {
//                        if (lowestNode.fCost > nodeSuccessors.get(i).fCost) {
//                            lowestNode = nodeSuccessors.get(i);
//                        }
//                    }
//                    int lowestValue = (int) lowestNode.fCost;
//
//                    for (int i = 0; i < nodeSuccessors.size(); i++) {
//                        if (nodeSuccessors.get(i).fCost == lowestValue) {
//                            q.add(nodeSuccessors.get(i));
//                        }
//                    }
//                }
                searchCount++;

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
