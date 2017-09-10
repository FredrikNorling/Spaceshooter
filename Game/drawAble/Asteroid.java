package Game.drawAble;

import java.awt.*;

/**
 * Created by Home on 2017-04-05.
 */
public class Asteroid implements drawAble {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getT() {
        return t;
    }

    @Override
    public void draw(Graphics g) {

    }

    int x,y,t;

    public Asteroid(int x, int y,int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}
