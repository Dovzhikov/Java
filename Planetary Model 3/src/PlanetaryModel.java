import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by konstantindovzikov on 16.10.14.
 */
public class PlanetaryModel {

    private final int num = 9;

    private JFrame frame;
    private java.util.Timer timer;
    Planet planet[] = new Planet[num];
    Orbit orbit[] = new Orbit[num];

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
            planet[i] = new Planet(120 + step, 1 + (i - 3), 0.003 * random.nextDouble(), 50);
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
            int stepr = 250;
            for (int i = 0; i < orbit.length; i++) {
                orbit[i] = new Orbit(stepr);
                g.drawOval(orbit[i].getstepx(), orbit[i].getstepy(), stepr, stepr);
                stepr += 110;
            }

            for (int i = 0; i < planet.length; i++) {
                g.drawOval(planet[i].x, planet[i].y, planet[i].size, planet[i].size);
            }
        }
    }
}