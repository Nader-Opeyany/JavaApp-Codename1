package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;

import java.io.IOException;

public class Helicopter extends Movable implements ISteerable {

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
    public int lastSkyScrapperReached = 1;
    public int fuelLevel = 100;
    int fuelConsumptionRate = 2;
    public int damageLevel = 0;//gets filled up until it hits 100
    int tick = 0;
    public int lives = 3;

    public Helicopter(double locationX, double locationY,
                      int heading) {

        super( locationX, locationY);
        try {
            heli = Image.createImage("/heli.png");

        }catch(IOException e){e.printStackTrace(); System.out.println("Helicopter");}

        this.heading = heading;
        this.speed = speed;
        this.stickAngle = stickAngle;
        this.fuelLevel=fuelLevel;
        this.locationX = locationX;
        this.locationY = locationY;
        this.heading = heading;
        this.tick =tick;
        this.lives =lives;

    }

    public String toString(){
        String str = "Helicopter on plane = (" +
                getLocationX() + "," + getLocationY()
                + " ) "+ "color = " +
                "[" +ColorUtil.red(color) + ","+ ColorUtil.green(color) +"," +
                ColorUtil.blue(color) +"]" + " heading= " + heading
                + " speed= "+ speed +" size="+size+" maxspeed=" + maximumSpeed+
                " Stickangle= " + stickAngle+ " fuellevel= " + fuelLevel + " " +
                " damagelevel= " + damageLevel;
        System.out.println(str);
        return str;
    }
    @Override
    public void move() {

        locationX =
                Math.round( locationX + (Math.cos(Math.toRadians(90-heading)) * this.speed));
        locationY =
                Math.round(locationY +( Math.sin(Math.toRadians(90-heading)) * this.speed));

        this.fuelLevel = fuelLevel - fuelConsumptionRate;
        if(fuelLevel <=0){
            GameWorld gw = new GameWorld();
            System.out.println("\nRan out of fuel!");
            this.lives = lives--;
            System.out.println("Lives left: " +this.lives);
            this.fuelLevel = 100;
        }

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
    public void lastSkyScrapperReached(){
        this.lastSkyScrapperReached +=1;
        GameWorld gw = new GameWorld();

        if(lastSkyScrapperReached >4){
            System.out.println("\nYou've won the game! Time taken " + this.tick);
            gw.exit();
        }

    }
    public void checkLife() {
        GameWorld gw = new GameWorld();//for exit condition
        if (damageLevel >= 100) {
            lives--;
            System.out.println("You've lost a life from collision damage");
            damageLevel = 0;//resets damage level
        }

        if(lives<=0){
            System.out.println("\nYou have run out of lives!");
            gw.exit();
        }
    }


    public void draw(Graphics g){
        try{
        g.drawImage(heli,(int)locationX,
                (int)locationY,70,30);

        }catch(Exception a){System.out.println("Heli catch");}
    }

}
