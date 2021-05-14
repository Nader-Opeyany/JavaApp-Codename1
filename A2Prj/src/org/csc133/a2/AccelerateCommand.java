package org.csc133.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


//get gameworld into this
public class AccelerateCommand extends Command{
    GameWorld gw;
    public  AccelerateCommand(String key,GameWorld gw){
        super(key);
        this.gw = gw;

    }

    @Override
    public void actionPerformed(ActionEvent a) {

        Helicopter obj = (Helicopter)gw.holder.get(0);
        obj.speed =obj.speed + 5;
        System.out.println("Speed Increased");
        //This is used to get the first obj and display the outputed speed, works
        System.out.println(((Helicopter) gw.holder.get(0)).speed);
    }


}
