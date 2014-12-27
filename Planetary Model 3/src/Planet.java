import javax.swing.*;
import java.awt.*;

/**
 * Created by konstantindovzikov on 18.10.14.
 */
public class Planet {
    public int x = 0;
    public int y = 0;
    public int size;
    public double r;
    private double a;
    private double delta;
    Color color;

    public Planet(double r, double a, double delta, int size, Color color) {
        this.r = r;
        this.a = a;
        this.delta = delta;
        this.size = size;
        this.color = color;
    }

    public void movePlanet(int speed) {
        x = (int) (r * Math.sin(a) + 560 - this.size/2); //!
        y = (int) (r * Math.cos(a) + 400 - this.size/2);
        a += delta * speed;
        a = a > 2 * Math.PI ? 0 : a;
    }
}
