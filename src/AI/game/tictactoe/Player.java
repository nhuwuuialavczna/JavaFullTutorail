package AI.game.tictactoe;

/**
 * @author JINX_NHI on 3/14/2018.
 */
public enum Player {

    ONE(1), TWO(2), NONE(0);

    int id;

    Player(int i) {
        this.id = i;
    }

    public int getId() {
        return id;
    }

    /**
     * ĐỔi player
     * */
    public Player changePlayer() {
        if (id == 1) {
            return Player.TWO;
        } else return Player.ONE;
    }

    @Override
    public String toString() {
        return id + "";
    }


}
