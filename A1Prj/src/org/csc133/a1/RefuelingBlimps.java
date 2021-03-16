package org.csc133.a1;

import com.codename1.charts.util.ColorUtil;

public class RefuelingBlimps extends Movable {
    int capacity = 10;
    int speed = 10;
    int size = 20;
    int color = ColorUtil.rgb(0, 100, 20);
    public RefuelingBlimps(double locationX, double locationY) {
        super(locationX, locationY);
        this.capacity = capacity;
        this.speed = speed;
        this.size = size;
        this.locationX = locationX;
        this.locationY = locationY;
        this.color = color;
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
}
