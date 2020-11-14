package gamebaby;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class home extends JPanel{
        private ImageIcon feild = new ImageIcon(this.getClass().getResource("home.jpg"));
	private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));
	private ImageIcon start = new ImageIcon(this.getClass().getResource("start.png"));
	public JButton btstart = new JButton(start);
	public JButton btexit  = new JButton(exit);
	home(){
            setLayout(null);
            btexit.setBounds(1340, 570, 393,107);
            btexit.setOpaque(false);
            btexit.setContentAreaFilled(false);
            btexit.setBorderPainted(false);
            add(btexit);
            
            btstart.setBounds(1250,400,329,95);
            btstart.setOpaque(false);
            btstart.setContentAreaFilled(false);
            btstart.setBorderPainted(false);
            add(btstart);
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,1920,1080,this);
	}
        
}