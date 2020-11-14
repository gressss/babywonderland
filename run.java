package gamebaby;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class run extends JFrame implements ActionListener {

    home home = new home();
    gameover over = new gameover();
    win win = new win();
    stage play = new stage();

    public run() {
        this.setSize(1920, 1080);
        this.add(home);
        home.btstart.addActionListener(this);
        home.btexit.addActionListener(this);
        play.btp.addActionListener(this);
        play.btplay.addActionListener(this);
        over.bth.addActionListener(this);
        win.bth.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home.btstart) {
            this.setLocationRelativeTo(null);
            this.remove(home);
            this.add(play);
            play.requestFocusInWindow();
            play.timestart = false;
            play.start = false;
            play.times = 60;
        } else if (e.getSource() == home.btexit) {
            System.exit(0);
        } else if (e.getSource() == play.btp) {
            this.setLocationRelativeTo(null);
            this.add(play);
            play.requestFocusInWindow();
            play.t.suspend();
            play.time.suspend();
            play.stg1.suspend();
            play.stg2.suspend();
            play.stbat.suspend();

        } else if (e.getSource() == play.btplay) {
            this.setLocationRelativeTo(null);
            this.add(play);
            play.requestFocusInWindow();
            play.t.resume();
            play.time.resume();
            play.stg1.resume();
            play.stg2.resume();
            play.stbat.resume();
        } else if (e.getSource() == over.bth) {
            this.setLocationRelativeTo(null);
            this.remove(over);
            this.add(home);
        } else if (e.getSource() == win.bth) {
            this.setLocationRelativeTo(null);
            this.remove(win);
            this.add(home);
        }
        this.validate();
        this.repaint();
    }

    public static void main(String[] args) {
        JFrame jf = new run();
        jf.setSize(1920, 1080);
        jf.setTitle("Baby In The Wonderland");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

}
