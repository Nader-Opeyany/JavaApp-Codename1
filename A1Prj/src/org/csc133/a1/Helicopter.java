package org.csc133.a1;

import com.codename1.charts.util.ColorUtil;

public class Helicopter extends Movable implements ISteerable {


//size,maximumSpeed, color are permanent for Helicopter
final int size = 10;
final int color = ColorUtil.rgb(250, 0, 0);
final int maximumSpeed = 100;

    //stickAngle,heading,speed,maxSpeed
    int heading = 10;
    int stickAngle = 0;
    int speed = 50;
    int lastSkyScrapperReached = 1;
    int fuelLevel = 100;
    int fuelConsumptionRate = 2;
    int damageLevel = 0;//gets filled up until it hits 100
    int tick = 0;
    int lives = 3;

    public Helicopter(double locationX, double locationY,
                      int heading) {

        super( locationX, locationY);
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

}
