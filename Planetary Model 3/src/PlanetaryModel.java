import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by konstantindovzikov on 16.10.14.
 */
public class PlanetaryModel {

    private JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
    private JPanel panel = new JPanel(true);
    private final int num = 9;
    public int delta;
    private JFrame frame;
    private Timer timer;
    private int radiusofplanet[] = {70, 10, 30, 32, 15, 50, 45, 38, 37};
    Planet planet[] = new Planet[num];




    public static void main(String[] args) {
        new PlanetaryModel().start();
    }

    private void start() {
        DrawPanel draw = new DrawPanel();
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(10));
        slider.setSnapToTicks(true);

        panel.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        panel.add(slider, BorderLayout.CENTER);

        frame = new JFrame("Planetary System");
        frame.setSize(1000, 750);
        frame.setLocation(35, 55);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, draw);
        frame.setVisible(true);

        Random random = new Random();
        int n = 10; // distance between planets

        planet[0] = new Planet(0, 1, 0.003 * random.nextDouble(), radiusofplanet[0], new Color(255, 255, 0));       //Солнце
        planet[1] = new Planet(radiusofplanet[0] / 2 + radiusofplanet[1] / 2 + n, 1, 0.003 * random.nextDouble(), radiusofplanet[1], new Color(153, 0, 0));   //Меркурий
        planet[2] = new Planet(planet[1].r + radiusofplanet[2] / 2 + radiusofplanet[1] / 2 + n, 1, 0.003 * random.nextDouble(), radiusofplanet[2], new Color(204, 153, 102));    //Венера
        planet[3] = new Planet(planet[2].r + radiusofplanet[3] / 2 + radiusofplanet[2] / 2 + n, 4, 0.003 * random.nextDouble(), radiusofplanet[3], new Color(204, 51, 255));    //Земля
        planet[4] = new Planet(planet[3].r + radiusofplanet[4] / 2 + radiusofplanet[3] / 2 + n, 5, 0.003 * random.nextDouble(), radiusofplanet[4], new Color(51, 153, 0));    //Марс
        planet[5] = new Planet(planet[4].r + radiusofplanet[5] / 2 + radiusofplanet[4] / 2 + n, 6, 0.003 * random.nextDouble(), radiusofplanet[5], new Color(0, 204, 51));    //Юпитер
        planet[6] = new Planet(planet[5].r + radiusofplanet[6] / 2 + radiusofplanet[5] / 2 + n, 7, 0.003 * random.nextDouble(), radiusofplanet[6], new Color(102, 102, 153));    //Сатурн
        planet[7] = new Planet(planet[6].r + radiusofplanet[7] / 2 + radiusofplanet[6] / 2 + n, 8, 0.003 * random.nextDouble(), radiusofplanet[7], new Color(153, 102, 102));    //Уран
        planet[8] = new Planet(planet[7].r + radiusofplanet[8] / 2 + radiusofplanet[7] / 2 + n, 9, 0.003 * random.nextDouble(), radiusofplanet[8], new Color(255, 102, 153));   //Нептун

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < planet.length; i++) {
                    planet[i].movePlanet(delta);
                    frame.repaint();
                    delta = slider.getValue();
                }
            }

        }, 4, 4); // !!!
    }


    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.drawString("This is my Planetary model", 70, 30);
            for (int i = 0; i < planet.length; i++) {
                g.setColor(planet[i].color);
                g.fillOval(planet[i].x, planet[i].y, planet[i].size, planet[i].size);
            }
        }
    }

}