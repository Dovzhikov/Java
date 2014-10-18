import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by konstantindovzikov on 16.10.14.
 */
public class PlanetaryModel {

    private JFrame frame;
    private java.util.Timer timer;
    Planet planet[] = new Planet[9];

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
        Random random = new Random();
        int step = 0;
        for (int i = 0; i < planet.length; i++) {
            planet[i] = new Planet(120 + step, 1 + (i - 3), 0.003 * random.nextDouble());
            step += 55;
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < planet.length; i++) {
                    planet[i].movePlanet();
                    frame.repaint();
                }
            }
        }, 14, 14);
    }

    class DrawPanel extends JPanel {
        PlanetaryModel planetaryModel = new PlanetaryModel();

        public void paintComponent(Graphics g) {
            g.drawString("This is my Planetary model", 70, 30);
            int stepx = 0, stepy = 0, stepr = 125;
            for (int i = 0; i < 9; i++) {
                stepr += 110;
                stepx = 560 - stepr / 2;
                stepy = 400 - stepr / 2;
                g.drawOval(stepx, stepy, stepr, stepr);
            }
            for (int i = 0; i < planet.length; i++) {
                g.drawOval(planet[i].x, planet[i].y, 50, 50);
            }
        }
    }
}