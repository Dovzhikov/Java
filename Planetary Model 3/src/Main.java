import javax.swing.*;
import java.awt.*;

/**
 * Created by konstantindovzikov on 15.10.14.
 */
final public class Main {

    JFrame frame;
    DrawPanel drawPanel;

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
        move();
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


    private void move() {
        double r = 395;
        double a = 0, delta = 0.001;
        while (true) {
            x = (int) (r * Math.sin(a)) + 520;
            y = (int) (r * Math.cos(a)) + 520;
            a += delta;
            //a = a > 2 * Math.PI ? 0 : a;
            try {
                Thread.sleep(1);
            } catch (Exception exception) {
            }
            frame.repaint();
        }
    }
}
