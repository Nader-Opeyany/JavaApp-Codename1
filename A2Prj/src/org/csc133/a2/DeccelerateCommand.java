package org.csc133.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class DeccelerateCommand extends Command{
    GameWorld gw;
    public  DeccelerateCommand(String key,GameWorld gw){
        super(key);
        this.gw = gw;

    }

    @Override
    public void actionPerformed(ActionEvent a) {

        Helicopter obj = (Helicopter)gw.holder.get(0);
        obj.speed =obj.speed - 5;
        System.out.println("Speed Decreased");
        //This is used to get the first obj and display the outputted speed, works
        System.out.println(((Helicopter) gw.holder.get(0)).speed);
    }
}
