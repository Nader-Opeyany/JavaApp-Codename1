package org.csc133.a1;

//This will go into movable and fixed
public abstract class GameObject {
      public double  locationX, locationY;
    public static int color;

    public GameObject(double locationX,double locationY){};

    public double getLocationX() {
        return locationX;
    }

    public double getLocationY() {
        return locationY;
    }

   // public String toString(){ return ""; }
}
//for color int color = ColorUtil.rgb(0, 0, 0);
