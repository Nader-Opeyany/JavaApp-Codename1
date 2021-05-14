package org.csc133.a2;

import com.codename1.ui.Graphics;

public abstract class Movable extends GameObject{
    //all subclasses have heading/speed
    int heading,speed;

    public int getHeading() {
        return heading;
    }

    public int getSpeed() {
        return speed;
    }

    public Movable(double locationX, double locationY) {
        super( locationX, locationY);

    }

    public void move(){
        locationX = (locationX + Math.cos(Math.toRadians(90-heading)) * speed);
        locationY = (locationY + Math.sin(Math.toRadians(90-heading))* speed);
    }
    abstract public void draw(Graphics g);
}
