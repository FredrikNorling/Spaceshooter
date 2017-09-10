package Game.map;

import Game.drawAble.Ship;
import Game.drawAble.drawAble;

import java.util.ArrayList;

/**
 * Created by frallan on 10/09/2017.
 */
public class Adjuster {

    public int windowX=0; //1080
    public int windowY=0; //720
    Ship s;
    world wld;
    public Adjuster(Ship s) {
        this.s=s;
        wld = new world();
    }
    public void updateView(){
        if(s.x < 170){
            windowX -= s.speed;
            s.x=170;
        }
        if(s.x > 910){
            windowX += s.speed;
            s.x=910;
        }

        if(s.y < 170){
            windowY -= s.speed;
            s.y=170;
        }
        if(s.y > 550){
            windowY += s.speed;
            s.y=550;
        }
    }
    public ArrayList<drawAble> getMap (){
        return wld.getList();
    }
    public void addWorld(drawAble da){
        wld.add(da);
    }


        class world {
            ArrayList<drawAble> list = new ArrayList<drawAble>();
            public world(){
                int x, y;
                x=y=5000;
                System.out.println(x+" "+y);
            }

            public ArrayList<drawAble> getList() {
                return list;
            }

            public void add(drawAble da) {
                list.add(da);
            }
        }
}
