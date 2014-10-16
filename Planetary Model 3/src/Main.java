import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

/**
 * Created by konstantindovzikov on 15.10.14.
 */
final public class Main {

    private JFrame frame;
    private DrawPanel drawPanel;
    private java.util.Timer timer;


    private int x = 125; // 125
    private int y = 330; // 330

    public static void main(String args[]) {
        new Main().go();
    }

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawPanel = new DrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(700, 700);
        frame.setLocation(375, 55);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int x = (int) (r * Math.sin(a)) + 100;
                y = (int) (r * Math.cos(a)) + 100;
                a += delta;
                System.out.println(String.format("x = %d; y = %d", x, y));
                frame.repaint();
                //a = a > 2 * Math.PI ? 0 : a;
            }
        }, 14, 14);
    }

    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.drawString("This is my Planetary Model!", 70, 30);
            g.drawOval(140, 140, 850, 850); // орбита
            g.setColor(Color.BLUE);
            g.fillOval(x, y, 50, 50); // planet
            g.setColor(Color.YELLOW);
            g.fillOval(500, 500, 400, 400); // son
        }
    }

    double r = 395;
    double a = 0, delta = 0.005;
}
