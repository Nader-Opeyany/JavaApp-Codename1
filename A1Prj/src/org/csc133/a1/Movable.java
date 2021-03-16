package org.csc133.a1;

public abstract class Movable extends GameObject{
    //all subclasses have heading/speed
    int heading,speed;

    public Movable( double locationX, double locationY
                   ) {
        super( locationX, locationY);

    }

    public void move(){
        locationX = (locationX + Math.cos(Math.toRadians(90-heading)) * speed);
        locationY = (locationY + Math.sin(Math.toRadians(90-heading))* speed);
    }


}
