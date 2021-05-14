package org.csc133.a2;

import java.util.ArrayList;

public class GameWorld {
    //used to store all game objects
   public ArrayList<GameObject> holder = new ArrayList<GameObject>();


    public void bounds() {
        //Entirety of game with the quadrant formed by these two variables
        double locationX = 1024.0;
        double locationY = 768.0;
    }

    public void init() {
        //code here to create the
        //initial game objects/setup
        //single Helicopter object
        Helicopter player = new Helicopter(200, 400, 10);
        holder.add( player);
        //Skyscrapers
        Skyscraper buildingOne = new Skyscraper(300, 300, 1, 20);
        Skyscraper buildingTwo = new Skyscraper(300, 450, 2, 20);
        Skyscraper buildingThree = new Skyscraper(400, 360, 3, 20);
        Skyscraper buildingFour = new Skyscraper(500, 500, 4, 20);

        //make an arraylist for all objects made in game

        holder.add((GameObject) buildingOne);
        holder.add((GameObject) buildingTwo);
        holder.add((GameObject) buildingThree);
        holder.add((Skyscraper) buildingFour);

        Bird birdOne = new Bird(800,500);
        Bird birdTwo = new Bird(700,600);
        holder.add((GameObject) birdOne);
        holder.add((GameObject) birdTwo);

        RefuelingBlimps blimpOne = new RefuelingBlimps(300,400);
        RefuelingBlimps blimpTwo = new RefuelingBlimps(400,300);
        RefuelingBlimps blimpThree = new RefuelingBlimps(600,300);
        holder.add((GameObject) blimpOne);
        holder.add((GameObject) blimpTwo);
        holder.add(blimpThree);
      /*  for(GameObject a: holder){
            System.out.println("Pop");
        }*/
    }

        //new method for exit
        public void exit () {
            System.exit(1); //code to exit
        }

        //map displays text based representation
        public void map () {
            //foreach loop
            for (GameObject print : holder) {
                print.toString();
            }
        }

        public void tick () {
            Helicopter obj = (Helicopter)holder.get(0);
            obj.tick++;
            obj.checkLife();

        }
        // moves using native move class
        public void move(){

            for (int i=0; i<holder.size(); i++) {
                if (holder.get(i) instanceof Movable) { Movable mObj =
                        (Movable)holder.get(i); mObj.move();
                }
                //this checks x and y bounds and changes
                if (holder.get(i) instanceof Movable) {
                    Movable mobj = (Movable)holder.get(i);

                        if(mobj.locationX >= 1024.0){
                            System.out.println("Reached the end of the line " +
                                    "and won. ");
                                exit();
                            }
                                if(mobj.locationY >= 720.0){
                                   mobj.locationY =- 100;
                                    mobj.heading =0;}

                            }
            }
            Helicopter obj = (Helicopter)holder.get(0);
            Skyscraper intial = (Skyscraper)holder.get(1);
          if( obj.locationX >=300 && intial.sequenceNumber < 3 && obj.lastSkyScrapperReached<3){
              obj.lastSkyScrapperReached();
              System.out.println("reached 2nd");
          }
            Skyscraper intial2 = (Skyscraper)holder.get(2);
            if(intial2.sequenceNumber < 4 && obj.locationX >= 400 && obj.lastSkyScrapperReached<4){
                System.out.println("Reached Skyscraper " + obj.lastSkyScrapperReached);
                obj.lastSkyScrapperReached();
                System.out.println("reached 3rd");
            }
            Skyscraper intial3 = (Skyscraper)holder.get(3);
            if(intial3.sequenceNumber < 5 && obj.locationX >= 500 && obj.lastSkyScrapperReached<5){
                System.out.println("Reached Skyscraper " + obj.lastSkyScrapperReached);
                obj.lastSkyScrapperReached();
                System.out.println("reached 4th");
            }

            }

        //change heading of helicopter
    public void stickAngleRight (){
        Helicopter obj = (Helicopter)holder.get(0);
        obj.stickAngleRight();
        obj.heading();

    }
    public void stickAngleLeft(){
        Helicopter obj = (Helicopter)holder.get(0);
        obj.stickAngleLeft();
        obj.heading();
    }
    public void lastSkyScrapperReached(){
        Helicopter obj = (Helicopter)holder.get(0);
        obj.lastSkyScrapperReached();//increments by one

        if(obj.lastSkyScrapperReached >=5){
            System.out.println("\nYou've won the game! Time taken " + obj.tick);
            exit();
        }
    }
        //DELETEEEEEEEEEEEEEEEEEEEEEEEEEE
    public void accelerate(){
        Helicopter obj = (Helicopter)holder.get(0);
        obj.speed =+ 5;

    }
    public void breakN(){

        Helicopter obj = (Helicopter)holder.get(0);
        if(!(obj.speed <= 0)){
        obj.speed =- 5;
        }
    }
    public void collide(){
        Helicopter obj = (Helicopter)holder.get(0);
        obj.damageLevel += 50;
        obj.checkLife();
    }
    public void refuel(){
        Helicopter obj = (Helicopter)holder.get(0);
        obj.fuelLevel = obj.fuelLevel+20;//possible error
        System.out.println("You have refueled!");
    }
    public void gummedUp(){
        Helicopter obj = (Helicopter)holder.get(0);
        obj.damageLevel = obj.damageLevel + 20;
        System.out.println("You have hit a bird and received 20 damage!");
        obj.checkLife();
    }
    public void display() {
        Helicopter obj = (Helicopter) holder.get(0);
        System.out.println("You have this many lives left: " + obj.lives);
        System.out.println("\nYou have elapsed this much time: " + obj.tick);
        System.out.println("\n You have passed this many skyscrapers: " + obj.lastSkyScrapperReached);
        System.out.println("\n You have this much fuel: " + obj.fuelLevel);
        System.out.println("\n You have this much damage out of 100: " + obj.damageLevel);

    }

}
