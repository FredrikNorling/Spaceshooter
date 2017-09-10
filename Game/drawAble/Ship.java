package Game.drawAble;
import Game.drawAble.Bullets;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Home on 2017-03-27.
 */
public class Ship implements drawAble {
    public double x,y;
    public double x2,y2;
    public double angle=0;
    public double vx,vy=0;
    public int speed =3;
    ArrayList<Bullets> b = new ArrayList<Bullets>();
    public Ship(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public void angleIncrement(double i){
        angle+=-i;
    }

    public Polygon getShip(){
        int A = 8;
        int xPoly[] = {(int)(x-(A*2*Math.cos(-angle))),(int)(x+(-(A*Math.cos(-angle+2*Math.PI/3)))),(int)(x-(A*Math.cos(-angle-2*Math.PI/3)))};
        int yPoly[] = {(int)(y+A*2*Math.sin(-angle)),(int)(y+A*Math.sin(-angle+2*Math.PI/3)),(int)(y+(A*Math.sin(-angle-2*Math.PI/3)))};


        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);

        return poly;



    }
    public ArrayList<Bullets> getList(){
        return b;
    }
    public void shoot(){
        double bvx=-Math.cos(angle)*5;
        double bvy=-Math.sin(angle)*5;
        b.add(new Bullets((int)x,(int)y,(int)bvx,(int)bvy));
    }

    public void forward() {
        vx=Math.cos(angle)*speed;
        vy=Math.sin(angle)*speed;
        x+=-vx;
        y+=-vy;
    }
    public void backward(){
        vx=Math.cos(angle)*speed;
        vy=Math.sin(angle)*speed;
        x+=vx;
        y+=vy;
    }
    public void removeshoot(Bullets bull){
        b.remove(bull);
    }

    @Override
    public int getX() {
        return (int)x;
    }

    @Override
    public int getY() {
        return (int)y;
    }

    @Override
    public int getT() {
        return 30;
    }

    public void draw(Graphics g) {
        g.drawPolygon(getShip());
    }
}
