package AI.game.caro;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author  JINX_NHI on 3/15/2018.
 */
public interface ActionMouse extends MouseListener {
    @Override
    default void mouseClicked(MouseEvent e) {}

    @Override
    default void mousePressed(MouseEvent e) {}

    @Override
    default void mouseReleased(MouseEvent e) {}

    @Override
    default void mouseEntered(MouseEvent e) {}

    @Override
    default void mouseExited(MouseEvent e) {}
}
