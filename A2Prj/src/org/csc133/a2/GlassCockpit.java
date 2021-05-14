package org.csc133.a2;

import com.codename1.ui.*;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a2.clocks.*;


public class GlassCockpit extends Container {// container not componenet
    // Functions that will display needed info i.e. GameTime or lives



    GameWorld gw;

    public GlassCockpit(GameWorld gw) {


        super(new GridLayout(2,6));//Add labels on top row
        this.gw = gw;
        calcPreferredSize();
        Label clockLabel = new Label("Fuel");
        this.addComponent(clockLabel);
        clockLabel = new Label("Damage");
        this.addComponent(clockLabel);
        clockLabel =new Label("Lives");
        this.addComponent(clockLabel);
        clockLabel =new Label("Heading");
        this.addComponent(clockLabel);
        clockLabel =new Label("Skyscraper");
        this.addComponent(clockLabel);
        clockLabel =new Label("GameClock");
        this.addComponent(clockLabel);

        FuelClock fuel = new FuelClock(gw);
        DamageClock damage = new DamageClock(gw);
        LivesClock lives = new LivesClock(gw);
        HeadingClock heading = new HeadingClock(gw);
        LastSkyScrapperClock sky = new LastSkyScrapperClock(gw);
        GameTimeClock time = new GameTimeClock();

        add(fuel);
        add(damage);
        add(lives);
        add(heading);
        add(sky);
        add(time);

    }


    public boolean animate(){

        return true;
    }
    public void start(){
        getComponentForm().registerAnimated(this);
    }
    public void stop(){
        getComponentForm().deregisterAnimated(this);
    }
    public void laidout(){
        this.start();
    }



}
