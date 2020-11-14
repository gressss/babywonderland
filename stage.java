package gamebaby;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

public class stage extends JPanel implements ActionListener {

    private final ImageIcon st1 = new ImageIcon(this.getClass().getResource("dan11.jpg"));
    private final ImageIcon st2 = new ImageIcon(this.getClass().getResource("dan2222.jpg"));
    private final ImageIcon pause = new ImageIcon(this.getClass().getResource("p.png"));
    private final ImageIcon play = new ImageIcon(this.getClass().getResource("play.png"));
    private final ImageIcon homebt = new ImageIcon(this.getClass().getResource("homebt.png"));

    baby b = new baby();
    home h = new home();
    win w = new win();
    gameover o = new gameover();

    public JButton btp = new JButton(pause);
    public JButton btplay = new JButton(play);
    public JButton bth = new JButton(homebt);

    public ArrayList<baby> baby = new ArrayList<baby>();
    public ArrayList<nom> nom = new ArrayList<nom>();
    //--------- dan 1 -------------
    public ArrayList<ghost1> g1 = new ArrayList<ghost1>();
    public ArrayList<ghost2> g2 = new ArrayList<ghost2>();
    public ArrayList<bat> bat = new ArrayList<bat>();
    //---------- dan 2 ------------
    public ArrayList<rock1> r1 = new ArrayList<rock1>();
    public ArrayList<rock2> r2 = new ArrayList<rock2>();
    public ArrayList<rock3> r3 = new ArrayList<rock3>();

    public int times;
    public int hp = 100;
    public int score = 0;

    boolean timestart = true;
    boolean start = false;
    boolean paralyze1 = false;
    int time_paralyze = 5;

    Thread time = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {

                    Thread.sleep(10);

                } catch (Exception e) {
                }

                if (timestart == false) {
                    repaint();
                }
            }
        }
    });

    Thread timebaby = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    timebaby.sleep(500);
                    b.y = b.y + 100;
                } catch (InterruptedException e) {
                }
            }
        }
    });

    Thread stnom = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (start == false) {

                        Thread.sleep((long) (Math.random() * 18000) + 100);

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (start == false) {
                    nom.add(new nom());
                }
            }
        }
    });
    //---------------------------------- dan 1 --------------------------------
    Thread stg1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (start == false) {

                        Thread.sleep((long) (Math.random() * 18000) + 100);

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (start == false) {
                    g1.add(new ghost1());
                }
            }
        }
    });

    Thread stg2 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (start == false) {
                        Thread.sleep((long) (Math.random() * 18000) + 100);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (start == false) {
                    g2.add(new ghost2());
                }
            }
        }
    });

    Thread stbat = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (start == false) {
                        Thread.sleep((long) (Math.random() * 18000) + 100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (start == false) {
                    bat.add(new bat());
                }
            }
        }
    });
    //------------------------------- dan 2 ----------------------------------
    Thread str1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (start == false) {

                        Thread.sleep((long) (Math.random() * 18000) + 100);

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (start == false) {
                    r1.add(new rock1());
                }
            }
        }
    });

    Thread str2 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (start == false) {
                        Thread.sleep((long) (Math.random() * 18000) + 100);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (start == false) {
                    r2.add(new rock2());
                }
            }
        }
    });

    Thread str3 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (start == false) {
                        Thread.sleep((long) (Math.random() * 18000) + 100);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (start == false) {
                    r3.add(new rock3());
                }
            }
        }
    });

    Thread paralyze = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (time_paralyze < 1) {
                    paralyze1 = false;
                    time_paralyze = 5;
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    Thread t = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (timestart == false) {

                    times = (times - 1);

                    if (paralyze1) {
                        time_paralyze--;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    stage() {
        this.setFocusable(true);
        this.setLayout(null);
        btp.setBounds(125, 155, 75, 69);
        btp.setOpaque(false);
        btp.setContentAreaFilled(false);
        btp.setBorderPainted(false);

        btplay.setBounds(200, 155, 75, 69);
        btplay.setOpaque(false);
        btplay.setContentAreaFilled(false);
        btplay.setBorderPainted(false);

        btp.addActionListener(this);
        btplay.addActionListener(this);
        bth.addActionListener(this);

        this.add(btp);
        this.add(bth);
        this.add(btplay);

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int a = e.getKeyCode();
                if (!paralyze1) {
                    if (a == KeyEvent.VK_SPACE) {
                        if(b.y>100){
                            b.y -= 100;
                            b.count++;
                        }
                    }
                    if (b.count > 2) {
                        b.count = 0;
                    }
                }
            }

            public void keyReleased(KeyEvent e) {
                b.count = 0;
            }
        });

        b.y = -100;
        time.start();
        t.start();
        stnom.start();

        stg1.start();
        stg2.start();
        stbat.start();

        str1.start();
        str2.start();
        str3.start();

        paralyze.start();
        timebaby.start();
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//-------------------------------------- dan2 -----------------------------------------------------------------
        if (times <= 30) {
            if (hp == 0 || b.y == 800 || score < 0) {
                this.remove(btp);
                this.remove(btplay);
                this.setLayout(null);
                this.add(o);
                o.setBounds(0, 0, 1920, 1080);
            } else {
                if(hp!=0 && times==0){
                this.setLayout(null);
                this.remove(btp);
                this.remove(btplay);
                this.add(w);
                w.setBounds(0, 0, 1920, 1080);
                }
                else{
                g.drawImage(st2.getImage(), 0, 0, 1920, 1080, this);
                g.drawImage(b.im[b.count].getImage(), 1500, b.y, 128, 236, this);
//==================== nom ====================                
                for (int i = 0; i < nom.size(); i++) {
                    g.drawImage(nom.get(i).getImage(), nom.get(i).getX(), nom.get(i).getY(), 80, 73, this);
                }
                for (int i = 0; i < b.im.length; i++) {
                    for (int j = 0; j < nom.size(); j++) {
                        if (Intersect(b.getbound(), nom.get(j).getbound())) {
                            nom.remove(j);
                            score += 10;
                            if(hp==100){
                                hp = 100;
                            }
                            else{
                                hp += 5;
                            }
                        }
                    }
                }

//==================== r1 ====================
                for (int i = 0; i < r1.size(); i++) {
                    g.drawImage(r1.get(i).getImage(), r1.get(i).getX(), r1.get(i).getY(), 126, 117, this);
                }
                for (int i = 0; i < b.im.length; i++) {
                    for (int j = 0; j < r1.size(); j++) {
                        if (Intersect(b.getbound(), r1.get(j).getbound())) {
                            r1.remove(j);
                            score -= 10;
                           
                        }
                    }
                }
//===================== r2 ====================
                for (int i = 0; i < r2.size(); i++) {
                    g.drawImage(r2.get(i).getImage(), r2.get(i).getX(), r2.get(i).getY(), 144, 134, this);
                    
                }
                for(int i=0;i<b.im.length;i++){
                    for (int j = 0; j < r2.size(); j++) {
                        if (Intersect(b.getbound(), r2.get(j).getbound())) {
                            r2.remove(j);
                            hp -= 10;
                        }
                    }
                }
                
//================== r3 ======================
                for (int i = 0; i < r3.size(); i++) {
                    g.drawImage(r3.get(i).getImage(), r3.get(i).getX(), r3.get(i).getY(), 138, 149, this);
                }
                 for(int i=0;i<b.im.length;i++){
                    for (int j = 0; j < r3.size(); j++) {
                        if (Intersect(b.getbound(), r3.get(j).getbound())) {
                            r3.remove(j);
                            hp -= 5;
                        }
                    }
                }
            }

            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 40));
            g.setColor(Color.WHITE);
            g.drawString("" + score, 1745, 115);
            g.drawString("" + times, 1520, 210);
            g.drawString("" + hp, 1455, 85);
            }
        } 
//---------------------------------------- dan1 -----------------------------------------------------------------
        else if (times <= 60 && times > 30) {
            if (b.y >= 800 || hp == 0 || score <0) {
                this.remove(btp);
                this.remove(btplay);
                this.setLayout(null);
                this.add(o);
                o.setBounds(0, 0, 1920, 1080);
            } else {
                g.drawImage(st1.getImage(), 0, 0, 1920, 1080, this);
                g.drawImage(b.im[b.count].getImage(), 1500, b.y, 128, 236, this);

//==================== nom ====================                
                for (int i = 0; i < nom.size(); i++) {
                    g.drawImage(nom.get(i).getImage(), nom.get(i).getX(), nom.get(i).getY(), 80, 73, this);
                }
                for (int i = 0; i < b.im.length; i++) {
                    for (int j = 0; j < nom.size(); j++) {
                        if (Intersect(b.getbound(), nom.get(j).getbound())) {
                            nom.remove(j);
                            score += 10;
                            if(hp==100){
                                hp = 100;
                            }
                            else{
                                hp += 5;
                            }
                        }
                    }
                }

//======================== g1 ========================
                for (int i = 0; i < g1.size(); i++) {
                    g.drawImage(g1.get(i).getImage(), g1.get(i).getX(), g1.get(i).getY(), 174, 108, this);
                }
                for (int i = 0; i < b.im.length; i++) {
                    for (int j = 0; j < g1.size(); j++) {
                        if (Intersect(b.getbound(), g1.get(j).getbound())) {
                            g1.remove(j);
                            score -= 5;
                        }
                    }
                }
//======================== g2 ========================
                for (int i = 0; i < g2.size(); i++) {
                    g.drawImage(g2.get(i).getImage(), g2.get(i).getX(), g2.get(i).getY(), 195, 108, this);
                }
                for (int i = 0; i < b.im.length; i++) {
                    for (int j = 0; j < g2.size(); j++) {
                        if (Intersect(b.getbound(), g2.get(j).getbound())) {
                            g2.remove(j);
                            hp -= 10;
                            score -=10;
                        }
                    }
                }

//========================= bat =======================
                for (int i = 0; i < bat.size(); i++) {
                    g.drawImage(bat.get(i).getImage(i), bat.get(i).getX(), bat.get(i).getY(), 175, 83, this);
                }
                 for(int i=0;i<b.im.length;i++){
                    for (int j = 0; j < bat.size(); j++) {
                        if (Intersect(b.getbound(), bat.get(j).getbound())) {
                            bat.remove(j);
                            hp -= 5;
                        }
                    }
                }
            }

            g.setFont(new Font("Chiller", Font.BOLD, 45));
            g.setColor(Color.WHITE);
            g.drawString("" + score, 1660, 115);
            g.drawString("" + times, 180, 130);
            g.drawString("" + hp, 1320, 75);
        }
    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bth) {
            this.add(h);
            this.setLayout(null);
            h.setBounds(0, 0, 1920, 1080);
        } else if (e.getSource() == btp) {
            this.requestFocusInWindow();
            this.t.suspend();
            this.time.suspend();
            
            this.stnom.suspend();
            
            this.stg1.suspend();
            this.stg2.suspend();
            this.stbat.suspend();
            
            this.str1.suspend();
            this.str2.suspend();
            this.str3.suspend();
            
            this.timebaby.suspend();

        } else if (e.getSource() == btplay) {
            this.requestFocusInWindow();
            this.t.resume();
            this.time.resume();
            
            this.stnom.resume();
            
            this.stg1.resume();
            this.stg2.resume();
            this.stbat.resume();
            
            this.str1.resume();
            this.str2.resume();
            this.str3.resume();
            
            this.timebaby.resume();
        }
    }
}
