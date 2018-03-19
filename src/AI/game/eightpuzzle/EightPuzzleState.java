package AI.game.eightpuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * EightPuzzleState defines a state for the 8puzzle problem. The board is always
 * represented by a single dimensioned array, we attempt to provide the illusion
 * that the state representation is 2 dimensional and this works very well. In
 * terms of the actual tiles, '0' represents the hole in the board, and 0 is
 * treated special when generating successors. We do not treat '0' as a tile
 * itself, it is the "hole" in the board (as we refer to it herein)
 *
 * @author JINX_NHI
 */
public class EightPuzzleState implements State {

    private final int PUZZLE_SIZE = 9;
    private int outOfPlace = 0;

    private int manDist = 0;

    private Action act;

    private final int[] GOAL = new int[]
            {1, 2, 3, 4, 5, 6, 7, 8, 0};
    private int[] curBoard;

    /**
     * Constructor for EightPuzzleState
     *
     * @param board - the board representation for the new state to be constructed
     */
    public EightPuzzleState(int[] board) {
        curBoard = board;
        setOutOfPlace();
        setManDist();
        this.act = act;
    }

    /**
     * How much it costs to come to this state
     */
    @Override
    public double findCost() {
        return 1;
    }

    /*
     * Set the 'tiles out of place' distance for the current board
     */
    private void setOutOfPlace() {
        for (int i = 0; i < curBoard.length; i++) {
            if (curBoard[i] != GOAL[i]) {
                outOfPlace++;
            }
        }
    }

    /*
     * Set the Manhattan Distance for the current board
     */
    private void setManDist() {
        // linearly search the array independent of the nested for's below
        int index = -1;

        // just keeps track of where we are on the board (relatively, can't use
        // 0 so these
        // values need to be shifted to the right one place)
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                index++;

                // sub 1 from the val to get the index of where that value
                // should be
                int val = (curBoard[index] - 1);

				/*
                 * If we're not looking at the hole. The hole will be at
				 * location -1 since we subtracted 1 before to turn val into the
				 * index
				 */
                if (val != -1) {
                    // Horizontal offset, mod the tile value by the horizontal
                    // dimension
                    int horiz = val % 3;
                    // Vertical offset, divide the tile value by the vertical
                    // dimension
                    int vert = val / 3;

                    manDist += Math.abs(vert - (y)) + Math.abs(horiz - (x));
                }
                // If we are looking at the hole, skip it
            }
        }
    }

    /*
     * Attempt to locate the "0" spot on the current board
     *
     * @return vị tri của số 0. Nghĩa là đang tìm ô trống
     */
    private int getHole() {
        int holeIndex = -1;

        for (int i = 0; i < PUZZLE_SIZE; i++) {
            if (curBoard[i] == 0)
                holeIndex = i;
        }
        return holeIndex;
    }

    /**
     * Getter for the outOfPlace value
     *
     * @return the outOfPlace h(n) value
     */
    public int getOutOfPlace() {
        return outOfPlace;
    }

    /**
     * Getter for the Manhattan Distance value
     *
     * @return the Manhattan Distance h(n) value
     */
    public int getManDist() {
        return manDist;
    }

    /*
     * Makes a copy of the array passed to it
     */
    private int[] copyBoard(int[] state) {
        int[] ret = new int[PUZZLE_SIZE];
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            ret[i] = state[i];
        }
        return ret;
    }

    public Action getAct() {
        return act;
    }

    /**
     * Is thought about in terms of NO MORE THAN 4 operations. Can slide tiles
     * from 4 directions if hole is in middle Two directions if hole is at a
     * corner three directions if hole is in middle of a row
     *
     * @return an ArrayList containing all of the successors for that state
     */
    @Override
    public List<State> genSuccessors() {
        List<State> successors = new ArrayList<>();
        int hole = getHole(); // lấy vị trí ô trống

        if (hole != 0 && hole != 3 && hole != 6) {
            swapAndStore(hole - 1, hole, successors);
        }

        if (hole != 6 && hole != 7 && hole != 8) {
            swapAndStore(hole + 3, hole, successors);
        }


        if (hole != 0 && hole != 1 && hole != 2) {
            swapAndStore(hole - 3, hole, successors);
        }

        if (hole != 2 && hole != 5 && hole != 8) {
            swapAndStore(hole + 1, hole, successors);
        }

        return successors;
    }

    /*
     * Hoán đổi giữa 2 số trong board
     */
    private void swapAndStore(int d1, int d2, List<State> s) {
        int[] cpy = copyBoard(curBoard);
        int temp = cpy[d1];
        cpy[d1] = curBoard[d2];
        cpy[d2] = temp;
        s.add((new EightPuzzleState(cpy)));
    }

    /**
     * Check to see if the current state is the goal state.
     *
     * @return - true or false, depending on whether the current state matches
     * the goal
     */
    @Override
    public boolean isGoal() {
        if (Arrays.equals(curBoard, GOAL)) {
            return true;
        }
        return false;
    }

    /**
     * Method to print out the current state. Prints the puzzle board.
     */
    @Override
    public void printState() {
        System.out.println(curBoard[0] + " | " + curBoard[1] + " | "
                + curBoard[2]);
        System.out.println("---------");
        System.out.println(curBoard[3] + " | " + curBoard[4] + " | "
                + curBoard[5]);
        System.out.println("---------");
        System.out.println(curBoard[6] + " | " + curBoard[7] + " | "
                + curBoard[8]);

    }

    /**
     * Overloaded equals method to compare two states.
     *
     * @return true or false, depending on whether the states are equal
     */
    @Override
    public boolean equals(State s) {
        if (Arrays.equals(curBoard, ((EightPuzzleState) s).getCurBoard())) {
            return true;
        } else
            return false;

    }

    /**
     * Getter to return the current board array
     *
     * @return the curState
     */
    public int[] getCurBoard() {
        return curBoard;
    }


}
