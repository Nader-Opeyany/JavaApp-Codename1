package org.csc133.a2;

import com.codename1.ui.Component;
import com.codename1.ui.Graphics;

public class MapView extends Component {
    GameWorld gw;

    public MapView(GameWorld gw) {
        this.gw = gw;

    }


    @Override
   public void paint(Graphics g){

         for (GameObject a : gw.holder) {
            a.draw(g);
        }
    }

    public void move(){
        for (GameObject a : gw.holder) {
            gw.tick();
            gw.move();
            repaint();
        }
    }


    public void start(){
        getComponentForm().registerAnimated(this);
    }

}
