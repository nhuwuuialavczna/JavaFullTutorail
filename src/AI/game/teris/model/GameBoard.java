package AI.game.teris.model;

import AI.game.teris.controller.IController;

import java.awt.*;
import java.util.Random;

public class GameBoard implements Runnable, IModel {
    public static final int COLS = 10;
    public static final int ROWS = 22;
    public static final int BLOCK_SIZE = 30;
    private int score;
    private int highScore;
    public int level;
    private int[][] matrixBoard;
    private int[][] tempMatrixBoard;
    private int[][] matrixNextBlock;
    private Block currentBlock;
    private Block nextBlock;
    private boolean start;
    private IController controller;

    public GameBoard(IController controller) {
        this.controller = controller;
        init();
    }

    public void init() {
        start = true;
        score = 0;
        highScore = 0;
        matrixBoard = new int[ROWS][COLS];
        tempMatrixBoard = new int[ROWS][COLS];
        for (int i = 0; i < matrixBoard.length; i++) {
            for (int j = 0; j < matrixBoard[i].length; j++) {
                matrixBoard[i][j] = -1;
                tempMatrixBoard[i][j] = -1;
            }
        }
        setCurrentBlock();
    }

    public void setNextBlock() {
        nextBlock = randomBlock();
        matrixNextBlock = new int[4][4];
        for (int i = 0; i < nextBlock.coord.length; i++) {
            matrixNextBlock[nextBlock.coord[i].getX() + 2][nextBlock.coord[i].getY() + 1] = 2;
        }
    }


    public void setCurrentBlock() {
        if (nextBlock == null) {
            setNextBlock();
        }
        currentBlock = nextBlock;
        setNextBlock();
    }

    public Block randomBlock() {
        Random r = new Random();
        Block block = null;
        int blockNumber = r.nextInt(2);
        switch (blockNumber) {
            case 0:
                block = new OBlock(this);
                break;
            case 1:
                block = new IBlock(this);
                break;

            default:
                break;
        }
        return block;
    }

    @Override
    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            if (start) {
                drop();
            }
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void spin() {
        currentBlock.performSpin();
    }

    @Override
    public void drop() {
        currentBlock.drop();
    }

    @Override
    public void moveLeft() {
        currentBlock.moveLeft();
    }

    @Override
    public void moveRight() {
        currentBlock.moveRight();
    }

    @Override
    public void moveDown() {
        currentBlock.moveDown();
    }

    public void update() {
        controller.setChange();
    }

    @Override
    public void fastDown() {
        currentBlock.fastDown();
    }


    @Override
    public void draw(Graphics g) {
        drawBoard(g);
    }

    public void drawBoard(Graphics g) {

        for (int i = 0; i < matrixBoard.length; i++) {
            for (int j = 0; j < matrixBoard[i].length; j++) {
                int color = matrixBoard[i][j];
                switch (color) {
                    case 0:
                        g.setColor(Color.BLUE);
                        break;
                    case 1:
                        g.setColor(Color.RED);
                        break;
                    default:
                        if ((i + j) % 2 == 0) {
                            g.setColor(Color.BLACK);
                        } else {
                            g.setColor(Color.GRAY);
                        }
                        break;
                }
//                g.fillRect(i * BLOCK_SIZE + 1, j * BLOCK_SIZE + 1, 28, 28);
                g.fillRect(10 + (j) * BLOCK_SIZE, 10 + (i) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
//                g.setColor(new Color(66, 66, 66, 180));
//                g.drawRoundRect(10 + (j) * BLOCK_SIZE, 10 + (i-2) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 5, 5);
//                Graphics2D g2 = (Graphics2D) g;
//                g2.setStroke(new BasicStroke(6));
//                g2.drawRoundRect(5, 5, BLOCK_SIZE * 10 + 10, BLOCK_SIZE * 20 + 10, 5, 5);
//                g2.setStroke(new BasicStroke(2));
            }
        }
    }


    public void fixedBlockAndSetBlock() {
        clear();
        for (int i = 0; i < matrixBoard.length; i++) {
            for (int j = 0; j < matrixBoard[i].length; j++) {
                tempMatrixBoard[i][j] = matrixBoard[i][j];
            }
        }

        setCurrentBlock();
    }


    public boolean isLose() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < matrixBoard[i].length; j++) {
                if (matrixBoard[i][j] != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * add position to array
     */
    public void addPosition(Position position, int value) {
        matrixBoard[position.getX()][position.getY()] = value;
    }

    /**
     * check location block is exist or out array
     */
    public boolean isExistOrOutArray(Position position) {
        if (position.getX() > ROWS - 1) {
            return true;
        }
        if (position.getY() < 0) {
            return true;
        }
        if (position.getY() > COLS - 1) {
            return true;
        }
        if (matrixBoard[position.getX()][position.getY()] != -1) {
            return true;
        }
        return false;
    }

    /**
     * check collistion when spin
     */
    public boolean isCollistionSpin(Position position) {
        if (position.getX() > ROWS - 1) {
            return true;
        }
        if (position.getX() < 0) {
            return true;
        }
        if (position.getY() < 0) {
            return true;
        }
        if (position.getY() > COLS - 1) {
            return true;
        }
        if (matrixBoard[position.getX()][position.getY()] != -1) {
            return true;
        }
        return false;
    }

    /**
     * revert matrix to previous state
     */
    public void revertMatrix() {
        for (int i = 0; i < matrixBoard.length; i++) {
            for (int j = 0; j < matrixBoard[i].length; j++) {
                matrixBoard[i][j] = tempMatrixBoard[i][j];
            }
        }
    }

    /**
     * clear line
     */
    public void clear() {
        for (int i = 0; i < matrixBoard.length; i++) {
            if (isFullRow(i)) {
                delete(i);
                score += 10;
            }
        }
        update();
    }

    /**
     * delete line
     */
    public void delete(int line) {
        int[][] temp = new int[line][COLS];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < matrixBoard[i].length; j++) {
                temp[i][j] = matrixBoard[i][j];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                matrixBoard[i + 1][j] = temp[i][j];
            }
        }
    }

    /**
     * check is full row
     */
    public boolean isFullRow(int line) {
        for (int i = 0; i < matrixBoard[line].length; i++) {
            if (matrixBoard[line][i] == -1) {
                return false;
            }
        }
        return true;
    }

}
