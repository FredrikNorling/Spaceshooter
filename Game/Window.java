package Game;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.*;


public class Window extends JPanel implements KeyListesner, ActionListener{
    int x =0;
    boolean[] key = new boolean[4];
    Ship s = new Ship(260,260);
    ArrayList<rect> al = new ArrayList<rect>();
    ArrayList<Asteroid> ast = new ArrayList<Asteroid>();
    public Window(){
        repaint();
        Timer t = new Timer(5,this);
        t.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawPolygon(s.getShip());
        for(Bullets b : s.getList()){
            g.fillOval(b.getX(),b.getY(),10,10);
        }
        for(Asteroid at : ast){

        }

    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()=='a'){
            s.angleIncrement(Math.toRadians(-1));
        }
        if(e.getKeyChar()=='d'){
            s.angleIncrement(Math.toRadians(1));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==32){
            s.shoot();
            System.out.println(s.getList().size());
        }
        if(e.getKeyChar()=='w'){
            key[0]=true;
        }
        if(e.getKeyChar()=='s'){
            key[1]=true;
        }
        if(e.getKeyChar()=='a'){
            key[2]=true;
        }
        if(e.getKeyChar()=='d'){
            key[3]=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()=='w'){
            key[0]=false;
        }
        if(e.getKeyChar()=='q'){

        }
        if(e.getKeyChar()=='s'){
            key[1]=false;
        }
        if(e.getKeyChar()=='a'){
            key[2]=false;
        }
        if(e.getKeyChar()=='d'){
            key[3]=false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        update();
    }

    private void update() {
        if(key[3]){
            s.angleIncrement(Math.toRadians(-5));
        }
        if(key[0]) {
            s.forward();
        }
        if(key[1]){
            s.backward();
        }
        if(key[2]){
            s.angleIncrement(Math.toRadians(+5));
        }
        Iterator<Bullets> iter = s.getList().iterator();
        while (iter.hasNext()) {
            Bullets p = iter.next();
            p.update();
            if (p.getX()>1200 || p.getX()<0 ||p.getY()<0 || p.getY()>720) iter.remove();
        }

    }
}
