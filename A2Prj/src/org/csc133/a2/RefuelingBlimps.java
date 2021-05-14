package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;

import java.io.IOException;

public class RefuelingBlimps extends Movable {
    private int capacity = 10;
    private int speed = 10;
    private int size = 20;
    private int color = ColorUtil.rgb(0, 100, 20);
    private int heading = 0;
    Image blimp;

    public RefuelingBlimps(double locationX, double locationY) {
        super(locationX, locationY);
        try {
            blimp =  Image.createImage("/blimp.png");

        }catch(IOException e){e.printStackTrace(); System.out.println("Blimp");}
        this.capacity = capacity;
        this.speed = speed;
        this.size = size;
        this.locationX = locationX;
        this.locationY = locationY;
        this.color = color;
        this.heading = heading;


    }

    @Override
    public void move() {
        locationX =                                 //270 makes them move west
                locationX + (Math.cos(Math.toRadians(270-heading)) * this.speed);
        locationY =
                locationY +( Math.sin(Math.toRadians(270-heading)) * this.speed);
    }
    public String toString(){
        String str = "Refueling Blimp on plane = (" +
                getLocationX() + "," + getLocationY()
                + " ) "+ "color = " +
                "[" + ColorUtil.red(color) + ","+ ColorUtil.green(color) +"," +
                ColorUtil.blue(color) +"]"
                + " speed= "+ speed +" size="+size+" ";
        System.out.println(str);
        return str;
    }

    public void draw(Graphics g){
        try{
            g.drawImage(blimp,(int)locationX,
                    (int)locationY,70,30);

        }catch(Exception a){System.out.println("Blimp catch");}
    }
}
