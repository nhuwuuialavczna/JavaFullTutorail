package AI.demo.tamhau.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class BFS {

    public static Stack<Node> bfsSearch() {
        int[][] board = new int[8][8];
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(new TamHau(board));
        root.dept = 0;
        q.add(root);
        int countNodes = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (!node.currentState.isGoal()) {
                List<State> successors = node.currentState.getSuccessors(node.dept);
                for (State s : successors) {
                    Node node1 = new Node(s, node, 0, 0, node.dept + 1);
                    q.add(node1);
                    countNodes++;
                }
            } else {
                Stack<Node> solutionPath = new Stack<>();
                solutionPath.push(node);
                node = node.paren;
                while (node.paren != null) {
                    solutionPath.push(node);
                    node = node.paren;
                }
                solutionPath.push(node);
                System.out.println(countNodes);
                return solutionPath;
            }

        }
        return null;
    }

}
