package Game;

/**
 * Created by Home on 2017-04-05.
 */
public class Bullets{
    int x,y;
    int vx,vy;

    public Bullets(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void update(){
        y+=vy;
        x+=vx;
    }
}
