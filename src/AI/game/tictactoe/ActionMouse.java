package AI.game.tictactoe;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.annotation.Documented;

/**
 * @author  JINX_NHI on 3/14/2018.
 */
public interface ActionMouse extends MouseListener {

    /**
     * @param e - Lấy tọa độ x, y để đánh cờ
     * */
    @Override
    default void mouseClicked(MouseEvent e) {

    }

    @Override
    default void mousePressed(MouseEvent e) {}

    @Override
    default void mouseReleased(MouseEvent e) {}

    @Override
    default void mouseEntered(MouseEvent e) {}

    @Override
    default void mouseExited(MouseEvent e) {}
}
