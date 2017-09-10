package Game;
import Game.drawAble.Asteroid;
import Game.drawAble.Bullets;
import Game.drawAble.Ship;
import Game.drawAble.drawAble;
import Game.map.Adjuster;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;


public class Window extends JPanel implements KeyListener, ActionListener{
    int x =0;
    boolean[] key = new boolean[4];
    Ship ship = new Ship(260,260);
    ArrayList<rect> al = new ArrayList<rect>();
    ArrayList<Asteroid> ast = new ArrayList<Asteroid>();
    Adjuster adjuster;
    public Window(){
        repaint();
        Timer t = new Timer(5,this);
        t.start();
        adjuster = new Adjuster(ship);
        adjuster.addWorld(ship);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("x:"+(int)ship.x+"     y:"+(int)ship.y,0,29);
        g.drawString("WindowX:"+adjuster.windowX+"     WindowY:"+adjuster.windowY,0,50);

        for(drawAble b : adjuster.getMap()){
            b.draw(g);
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()=='a'){
            ship.angleIncrement(Math.toRadians(-1));
        }
        if(e.getKeyChar()=='d'){
            ship.angleIncrement(Math.toRadians(1));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==32){
            ship.shoot();
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
        adjuster.updateView();
    }

    private void update() {
        if(key[3]){
            ship.angleIncrement(Math.toRadians(-5));
        }
        if(key[0]) {
            ship.forward();
        }
        if(key[1]){
            ship.backward();
        }
        if(key[2]){
            ship.angleIncrement(Math.toRadians(+5));
        }
        Iterator<Bullets> iter = ship.getList().iterator();
        while (iter.hasNext()) {
            Bullets p = iter.next();
            p.update();
            if (p.getX()>1200 || p.getX()<0 ||p.getY()<0 || p.getY()>720) iter.remove();
        }

    }
}
