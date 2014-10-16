import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by konstantindovzikov on 16.10.14.
 */
public class PlanetaryModel {

    //private int x, y;
    private JFrame frame;
    private java.util.Timer timer;
    private double r = 225, a = 0, delta = 0.03;
    private double arrr[] = new double[10];
    private int arrx[] = new int[10];
    private int arry[] = new int[10];

    public static void main(String args[]) {
        new PlanetaryModel().start();
    }

    private void start() {
        DrawPanel draw = new DrawPanel();

        frame = new JFrame("Planetary System");
        frame.setSize(1000, 750);
        frame.setLocation(35, 55);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, draw);
        frame.setVisible(true);
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int step = 0;
                for (int i = 0; i < 10; i++) {
                    arrr[i] = 120 + step;
                    arrx[i] = (int) (arrr[i] * Math.sin(a)) + 560 - 25;
                    arry[i] = (int) (arrr[i] * Math.cos(a)) + 400 - 25;
                    step += 55;
                }
                a += delta;
                a = a > 2 * Math.PI ? 0 : a;
                //System.out.println(String.format("x = %d; y = %d", x, y));
                frame.repaint();
            }
        }, 14, 14);
    }

    class DrawPanel extends JPanel {
        PlanetaryModel planetaryModel = new PlanetaryModel();

        public void paintComponent(Graphics g) {
            g.drawString("This is my Planetary model", 70, 30);
//            g.drawOval(585, 425, 200, 200);
//            g.drawOval(522, 362, 325, 325);
//            g.drawOval(460, 300, 450, 450);
            int stepx = 0, stepy = 0, stepr = 125;
            for (int i = 0; i < 10; i++) {
                stepr += 110;
                stepx = 560 - stepr / 2;
                stepy = 400 - stepr / 2;
                g.drawOval(stepx, stepy, stepr, stepr);
            }

            for (int i = 0; i < 10; i++) {
                g.drawOval(arrx[i], arry[i], 50, 50);
            }
        }
    }
}
