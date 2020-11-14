package gamebaby;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class gameover extends JPanel implements ActionListener {

    private ImageIcon over = new ImageIcon(this.getClass().getResource("over.jpg"));
    private ImageIcon h = new ImageIcon(this.getClass().getResource("hover.png"));
    public JButton bth = new JButton(h);
    home hh = new home();
    
    gameover() {
        setLayout(null);
        bth.setBounds(900, 0, 267, 306);
        bth.setOpaque(false);
        bth.setContentAreaFilled(false);
        bth.setBorderPainted(false);
        add(bth);
        this.bth.addActionListener(this);
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(over.getImage(), 0, 0, 1920, 1080, this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bth) {
            this.setLayout(null);
            this.remove(bth);
            this.add(hh);
            hh.setBounds(0, 0, 1920, 1080);
        }
    }
}
