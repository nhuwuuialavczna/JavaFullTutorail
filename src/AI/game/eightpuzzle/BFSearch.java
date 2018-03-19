package AI.game.eightpuzzle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Defines a Bredth-First search to be performed on a qualifying puzzle.
 * Currently supports 8puzzle and FWGC.
 *
 * @author Michael Langston && Gabe Ferrer
 */
public class BFSearch {
    static List<Action> actionList = new LinkedList<>();

    /**
     * Initialization function for 8puzzle BFSearch
     *
     * @param board - The starting state, represented as a linear array of length
     *              9 forming 3 meta-rows.
     */
    public static Stack<SearchNode> search(int[] board, boolean d) {
        SearchNode root = new SearchNode(new EightPuzzleState(board));
        Queue<SearchNode> queue = new LinkedList<>();
        queue.add(root);
        return performSearch(queue, d);
    }

    /*
     * Helper method to check to see if a SearchNode has already been evaluated.
     * Returns true if it has, false if it hasn't.
     */
    private static boolean checkRepeats(SearchNode n) {
        boolean retValue = false;
        SearchNode checkNode = n;

        // While n's parent isn't null, check to see if it's equal to the node
        // we're looking for.
        while (n.getParent() != null && !retValue) {
            if (n.getParent().getCurState().equals(checkNode.getCurState())) {
                retValue = true;
            }
            n = n.getParent();
        }

        return retValue;
    }

    /**
     * Performs a BFSearch using q as the search space
     *
     * @param q - A SearchNode queue to be populated and searched
     */
    public static Stack<SearchNode> performSearch(Queue<SearchNode> q, boolean d) {

        int searchCount = 1;
        while (!q.isEmpty()) {
            SearchNode tempNode = q.poll();

            if (!tempNode.getCurState().isGoal()) {
                List<State> tempSuccessors = tempNode.getCurState().genSuccessors();

				/*
                 * Loop through the successors, wrap them in a SearchNode, check
				 * if they've already been evaluated, and if not, add them to
				 * the queue
				 */
                for (int i = 0; i < tempSuccessors.size(); i++) {
                    // second parameter here adds the cost of the new node to
                    // the current cost total in the SearchNode
                    SearchNode newNode = new SearchNode(tempNode,
                            tempSuccessors.get(i), tempNode.getCost()
                            + tempSuccessors.get(i).findCost(), 0);

                    if (!checkRepeats(newNode)) {
                        q.add(newNode);
                    }
                }
                searchCount++;
            } else
            // The goal state has been found. Print the path it took to get to
            // it.
            {
                // Use a stack to track the path from the starting state to the
                // goal state
                Stack<SearchNode> solutionPath = new Stack<>();
                solutionPath.push(tempNode);
                tempNode = tempNode.getParent();

                while (tempNode.getParent() != null) {
                    solutionPath.push(tempNode);
                    tempNode = tempNode.getParent();
                }
                solutionPath.push(tempNode);
                return solutionPath;
                // The size of the stack before looping through and emptying it.
//                int loopSize = solutionPath.size();
//
//                for (int i = 0; i < loopSize; i++) {
//                    tempNode = solutionPath.pop();
//                    tempNode.getCurState().printState();
//                    System.out.println();
//                    System.out.println();
//                    System.out.println();
//                }
//                System.out.println("The cost was: " + tempNode.getCost());
//                if (d) {
//                    System.out.println("The number of nodes examined: "
//                            + searchCount);
//                }
//
//                System.exit(0);
            }
        }

        // This should never happen with our current puzzles.
        return null;
    }
}
