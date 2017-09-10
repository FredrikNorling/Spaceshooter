package Game;
public class test {
    public double x,y;
    public double x2,y2;
    public double angle=3.14/4;
    public double vx,vy=0;
    //(x2-x)^2+(y2-y)^2 = 100^2

    public test(int x, int y, double x2, double y2) {
        this.x=x;
        this.y=y;
        this.x2 = x2;
        this.y2 = y2;
    }
    public void flip(){
        x2=Math.cos(angle)*8+x;
        y2=Math.sin(angle)*8+y;
        vx=x2-x;
        vy=y2-y;
        x+=vx;
        y+=vy;
    }
    public void angleIncrement(double i){
        angle+=i;
    }
}
