package gamebaby;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.*;

public class baby {

    public ImageIcon[] im = new ImageIcon[3];
    public int x, y;
    public int count = 0;

    baby() {
        for (int i = 1; i <= im.length; i++) {
            im[i-1] = new ImageIcon(this.getClass().getResource("b"+i+".png"));
        
        }
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(1500, y,128, 100));
    }
    
}
