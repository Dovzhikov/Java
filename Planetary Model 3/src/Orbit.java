/**
 * Created by konstantindovzikov on 19.10.14.
 */
public class Orbit {
    private int stepx = 0;
    private int stepy = 0;


    public Orbit(int stepr) {
//            stepr += 110;
            stepx = 560 - stepr / 2;
            stepy = 400 - stepr / 2;
    }

    public int getstepx() {
        return stepx;
    }

    public int getstepy() {
        return stepy;
    }

}
