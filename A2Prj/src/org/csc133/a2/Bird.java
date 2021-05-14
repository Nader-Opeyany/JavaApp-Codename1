package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;

import java.io.IOException;

//not steerable
public class Bird extends Movable {
    //color
     private int color = ColorUtil.rgb(0, 100, 0);//blue and red
     final int size = 5;
     int heading = 0;
     int speed = 10;
     Image bird;
    public Bird( double locationX, double locationY) {

        super( locationX, locationY);
        try {
            bird = Image.createImage("/bird.png");

        }catch(IOException e){e.printStackTrace(); System.out.println("bird");}
        this.heading = heading;
        this.locationX = locationX;
        this.locationY = locationY;
        this.speed = speed;
    }
    //small subtrations to heading within tick!

    @Override
    public void move() {
        locationX =                                 //270 makes them move west
                locationX + (Math.cos(Math.toRadians(270-heading)) * this.speed);
        locationY =
                locationY +( Math.sin(Math.toRadians(270-heading)) * this.speed);

    }
    public void heading(){
        this.heading += 1;

    }

    public String toString(){
        String str = "Bird on plane = (" +
                getLocationX() + "," + getLocationY()
                + " ) "+ "color = " +
                "[" +ColorUtil.red(color) + ","+ ColorUtil.green(color) +"," +
                ColorUtil.blue(color) +"]" + " heading= " + heading
                + " speed= "+ speed +" size="+size+" ";
        System.out.println(str);
        return str;
    }


    public void draw(Graphics g){
        try{
            g.drawImage(bird,(int)locationX,
                    (int)locationY,70,30);

        }catch(Exception a){System.out.println("bird catch");}
    }
}
