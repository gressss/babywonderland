package gamebaby;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.*;

public class ghost1 {

    public Image im;
    public int x = 0;
    public int y = (int) ((Math.random() * 500) + 20);
    public int count = 0;

    ghost1() {

        URL imageURL = this.getClass().getResource("g0.png");
        im = Toolkit.getDefaultToolkit().getImage(imageURL);

        run.start();
    }
    Thread run = new Thread(new Runnable() {
        public void run() {
            while (true) {
                x += 2;
                if (x >= 25000) {
                    im = null;
                    run = null;
                    x = -100;
                }
                try {

                    run.sleep(10);

                } catch (InterruptedException e) {
                }
            }
        }
    });

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y,  100,100));
    }

    public Image getImage() {
        return im;
    }
}
