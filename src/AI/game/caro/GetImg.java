package AI.game.caro;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * @author JINX_NHI on 3/15/2018.
 */
public class GetImg {

    public Image imageX, imageO;

    private static GetImg getImg = new GetImg();

    static GetImg inst = getImg;

    public GetImg() {

        try {
            imageO = ImageIO.read(this.getClass().getResourceAsStream("/game/caro/o.png"));
            imageX = ImageIO.read(this.getClass().getResourceAsStream("/game/caro/x.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
