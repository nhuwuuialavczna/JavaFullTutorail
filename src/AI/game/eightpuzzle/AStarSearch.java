package AI.game.eightpuzzle;

import java.util.*;

/**
 * @author JINX_NHI
 * @since 13/3/2018
 */
public class AStarSearch {
    /**
     * @param board     - The starting state, represented as a linear array of length
     *                  9 forming 3 meta-rows.
     * @param heuristic - o is Number Out of Place , m is Manhattan Distance
     * @param d         - view debug
     */
    public static Stack<SearchNode> search(int[] board, boolean d, char heuristic) {
        SearchNode root = new SearchNode(new EightPuzzleState(board));
        Queue<SearchNode> q = new LinkedList<>();
        q.add(root);
        int searchCount = 1; // counter for number of iterations

        while (!q.isEmpty()) {
            SearchNode tempNode = q.poll();
            // if the tempNode is not the goal state
            if (!tempNode.getCurState().isGoal()) {
                // generate tempNode's immediate successors
                List<State> tempSuccessors = tempNode.getCurState().genSuccessors();
                List<SearchNode> nodeSuccessors = new ArrayList<>();

				/*
                 * Loop through the successors, wrap them in a SearchNode, check
				 * if they've already been evaluated, and if not, add them to
				 * the queue
				 */
                for (int i = 0; i < tempSuccessors.size(); i++) {
                    SearchNode checkedNode;
                    // make the node
                    if (heuristic == 'o') {
                        /*
                         * Create a new SearchNode, with tempNode as the parent,
						 * tempNode's cost + the new cost (1) for this state,
						 * and the Out of Place h(n) value
						 */
                        checkedNode = new SearchNode(tempNode,
                                tempSuccessors.get(i), tempNode.getCost()
                                + tempSuccessors.get(i).findCost(),
                                ((EightPuzzleState) tempSuccessors.get(i))
                                        .getOutOfPlace());
                    } else {
                        // See previous comment
                        checkedNode = new SearchNode(tempNode, tempSuccessors.get(i), tempNode.getCost() + tempSuccessors.get(i).findCost(), ((EightPuzzleState) tempSuccessors.get(i)).getManDist());
                    }

                    // Check for repeats before adding the new node
                    if (!checkRepeats(checkedNode)) {
                        nodeSuccessors.add(checkedNode);
                    }
                }

                // Check to see if nodeSuccessors is empty. If it is, continue
                // the loop from the top
                if (nodeSuccessors.size() == 0)
                    continue;

                SearchNode lowestNode = nodeSuccessors.get(0);

				/*
                 * This loop finds the lowest f(n) in a node, and then sets that
				 * node as the lowest.
				 */
                for (int i = 0; i < nodeSuccessors.size(); i++) {
                    if (lowestNode.getFCost() > nodeSuccessors.get(i)
                            .getFCost()) {
                        lowestNode = nodeSuccessors.get(i);
                    }
                }

                int lowestValue = (int) lowestNode.getFCost();

                // Adds any nodes that have that same lowest value.
                for (int i = 0; i < nodeSuccessors.size(); i++) {
                    if (nodeSuccessors.get(i).getFCost() == lowestValue) {
                        q.add(nodeSuccessors.get(i));
                    }
                }

                searchCount++;
            } else
            // The goal state has been found. Print the path it took to get to
            // it.
            {
                // Use a stack to track the path from the starting state to the
                // goal state
                Stack<SearchNode> solutionPath = new Stack<SearchNode>();
                solutionPath.push(tempNode);
                tempNode = tempNode.getParent();

                while (tempNode.getParent() != null) {
                    solutionPath.push(tempNode);
                    tempNode = tempNode.getParent();
                }
                solutionPath.push(tempNode);

//                // The size of the stack before looping through and emptying it.
//                int loopSize = solutionPath.size();
//
//                for (int i = 0; i < loopSize; i++) {
//                    tempNode = solutionPath.pop();
//                    tempNode.getCurState().printState();
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
                return solutionPath;
            }
        }

        // This should never happen with our current puzzles.
        System.out.println("Error! No solution found!");
        return null;

    }

    /*
     * Helper Test.method to check to see if a SearchNode has already been evaluated.
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

}
