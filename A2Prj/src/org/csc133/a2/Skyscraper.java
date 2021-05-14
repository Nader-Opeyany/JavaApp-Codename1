package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;

import java.io.IOException;

public class Skyscraper extends Fixed {
    //int waypoint = ;
    private int size ;
    private int color = ColorUtil.rgb(0, 0, 255);
    //skyscraper logic
    int sequenceNumber;//empty but populated through constructor
    Image skyScraper;
    public Skyscraper( double locationX, double locationY,
                      int sequenceNumber, int size) {
        super( locationX, locationY);

        try {
            skyScraper = Image.createImage("/skyScraper.png");

        }catch(IOException e){e.printStackTrace(); System.out.println("Skyscraper issue");}
        this.locationX = locationX;
        this.locationY = locationY;
        this.sequenceNumber = sequenceNumber;
        this.size =size;
    }
    //skyscrapers are blue

    public String toString(){
        String str = "SkyScraper= (" +
                getLocationX() + "," + getLocationY()
                + " ) "+ "color = " +
                "[" +ColorUtil.red(color) + ","+ ColorUtil.green(color) +"," +
                ColorUtil.blue(color) +"]" +
                " " +
                "size="+size+
                " SeqNum= " + sequenceNumber;
        System.out.println(str);
        return str;
    }

    public void draw(Graphics g){
        try{
            g.drawImage(skyScraper,(int)locationX,
                    (int)locationY,70,30);

        }catch(Exception a){System.out.println("SkyScraper");}
    }
}
