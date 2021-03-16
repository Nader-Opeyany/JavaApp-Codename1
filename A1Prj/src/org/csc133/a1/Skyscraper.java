package org.csc133.a1;

import com.codename1.charts.util.ColorUtil;

public class Skyscraper extends Fixed {
    //int waypoint = ;
    int size ;
    int color = ColorUtil.rgb(0, 0, 255);
    //skyscraper logic
    int sequenceNumber;//empty but populated through constructor
    public Skyscraper( double locationX, double locationY,
                      int sequenceNumber, int size) {
        super( locationX, locationY);
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
}
