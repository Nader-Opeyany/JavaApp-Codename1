package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;

import java.io.IOException;

public class NonPlayerHelicopter extends Movable implements ISteerable {

    //size,maximumSpeed, color are permanent for Helicopter
    final int size = 10;
    final int color = ColorUtil.rgb(250, 0, 0);
    final int maximumSpeed = 100;
    Image heli ;


    //META:
    //NEED TO BE PUBLIC SO NO PACKAGE CONFLICTS
    public int heading = 10;
    public int stickAngle = 0;
    public int speed = 50;


    int tick = 0;


    public NonPlayerHelicopter(double locationX, double locationY,
                      int heading) {

        super( locationX, locationY);
        this.heading = heading;
        this.speed = speed;
        this.stickAngle = stickAngle;

        this.locationX = locationX;
        this.locationY = locationY;
        this.heading = heading;
        this.tick =tick;

        try {
            Image heli =  Image.createImage("/heli.png");

        }catch(IOException e){e.printStackTrace(); System.out.println("Helicopter");}
    }

    public String toString(){
        String str = "NONPLAYER Helicopter on plane = (" +
                getLocationX() + "," + getLocationY()
                + " ) ";
        System.out.println(str);
        return str;
    }
    @Override
    public void move() {

        locationX =
                Math.round( locationX + (Math.cos(Math.toRadians(90-heading)) * this.speed));
        locationY =
                Math.round(locationY +( Math.sin(Math.toRadians(90-heading)) * this.speed));


        }


    //takes angle to change heading
    public void heading(){
        this.heading += stickAngle;
        stickAngle = 0;//resets stickAngle after being implemented
    }

    public void stickAngleRight
            (){
        this.stickAngle =+ 5;

    }
    public void stickAngleLeft(){
        this.stickAngle =- 5;
    }





    public void draw(Graphics g){

        try {
            Image heli =  Image.createImage("/heli.png");

        }catch(IOException e){e.printStackTrace(); System.out.println("Helicopter");}

        g.drawImage(heli,(int) locationX,
                (int) locationY,10,10);System.out.println("In Heli");
    }


}

