import javax.swing.*;
import java.awt.*;

/**
 * Created by konstantindovzikov on 18.10.14.
 */
public class Planet {
    public int x = 0;
    public int y = 0;
    public int size;
    private double r;
    private double a;
    private double delta;

    public Planet(double r, double a, double delta, int size) {
        this.r = r;
        this.a = a;
        this.delta = delta;
        this.size = size;
    }

    public void movePlanet() {
        x = (int) (r * Math.sin(a) + 560 - 25); //!
        y = (int) (r * Math.cos(a) + 400 - 25);
        a += delta;
        a = a > 2 * Math.PI ? 0 : a;
    }
}
