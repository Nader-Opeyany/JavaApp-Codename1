package org.csc133.a2.clocks;


import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.geom.Dimension;
import org.csc133.a2.GameWorld;


import java.io.IOException;

public class GameTimeClock extends Component {

    GameWorld gw;
    Image[] digitImages = new Image[10];
    Image colonImage;

    public static int COLON = 2; // needed for this clock
    public static int COLON_TWO = 5;
    public int ledColor;
    private static final int numDigitsShowing = 7; // 7 for clock
    Image[] clockDigits = new Image[numDigitsShowing];

    //FOR CLOCK LOGIC, VARIABLES
    private long stopWatch;
    //private long stopWatchEnd;

    public GameTimeClock () {
        this.gw =gw;
        try {
            digitImages[0] = Image.createImage("/LED_digit_0.png");
            digitImages[1] = Image.createImage("/LED_digit_1.png");
            digitImages[2] = Image.createImage("/LED_digit_2.png");
            digitImages[3] = Image.createImage("/LED_digit_3.png");
            digitImages[4] = Image.createImage("/LED_digit_4.png");
            digitImages[5] = Image.createImage("/LED_digit_5.png");
            digitImages[6] = Image.createImage("/LED_digit_6.png");
            digitImages[7] = Image.createImage("/LED_digit_7.png");
            digitImages[8] = Image.createImage("/LED_digit_8.png");
            digitImages[9] = Image.createImage("/LED_digit_9.png");

            colonImage = Image.createImage("/LED_colon.png");
        }catch(IOException e){e.printStackTrace(); System.out.println("Here");}

        for(int i = 0; i < numDigitsShowing; i++){
            clockDigits[i]=digitImages[0];
            clockDigits[COLON] = colonImage;//Used for the clocks image
            clockDigits[COLON_TWO] = colonImage;
        }
        //stop watch notification
        stopWatch = System.currentTimeMillis();

    }

    public void setGameClockTime(int minutes,int seconds,int milliSeconds){

        clockDigits[0] = digitImages[minutes/10];
        clockDigits[1] = digitImages[minutes%10];
        //colon image goes here
        clockDigits[3] = digitImages[seconds/10];
        clockDigits[4] = digitImages[seconds%10];
        //another colon image here
        clockDigits[6] = digitImages[milliSeconds%10];


    }

    public void setCurrentGameClockTime(){


        long stopWatchEnd = System.currentTimeMillis();
        int stopWatchOne = ((int)stopWatchEnd - (int)stopWatch);
        //MUST CONVERT TO INT
        int minutes = (int)(stopWatchOne / (1000 *60));
        int seconds = (int)((stopWatchOne )/1000) ;
        int milliSeconds = (int)((stopWatchOne )/ 100);

        if(minutes >=10){
            setLedColor(255);
        }
        setGameClockTime(minutes,seconds,milliSeconds);
    }



    public void stop(){
        getComponentForm().deregisterAnimated(this);
    }

    public void laidout(){
        this.start();
    }

    public boolean animate(){
        setCurrentGameClockTime();
        return true;
    }
    public void setLedColor(int ledColor){
        this.ledColor = ledColor;
    }

    public void paint(Graphics g){
        super.paint(g);
        final int COLOR_PAD = 1;

        int digitWidth = clockDigits[0].getWidth();
        int digitHeight = clockDigits[0].getHeight();
        int clockWidth = numDigitsShowing * digitWidth;

        float scaleFactor = Math.min(
                getInnerHeight()/(float)digitHeight,
                getInnerWidth()/(float)clockWidth);

        int displayDigitWidth = (int)(scaleFactor*digitWidth);
        int displayDigitHeight = (int)(scaleFactor*digitHeight);
        int displayClockWidth = displayDigitWidth*numDigitsShowing;

        int displayX = getX() + (getWidth() - displayClockWidth)/2;
        int displayY = getY() + (getHeight() - displayDigitHeight)/2;


        g.setColor(ColorUtil.BLACK);
        g.fillRect(getX(),getY(),getWidth(),getHeight()-30);
        g.setColor(ColorUtil.YELLOW);
        g.fillRect(displayX + COLOR_PAD,displayY + COLOR_PAD,
                (displayClockWidth - COLOR_PAD *2),(displayDigitHeight-COLOR_PAD*2)-30);

        for(int digitIndex = 0;digitIndex<numDigitsShowing;digitIndex++){
            g.drawImage(clockDigits[digitIndex],displayX + digitIndex * displayDigitWidth,
                    displayY,displayDigitWidth,displayDigitHeight-30);
        }laidout();

    }
    protected Dimension calcPreferredSize(){
        return new Dimension(digitImages[0].getWidth() * 4,digitImages[0].getHeight());//4 is numdigits showing
    }
    public void start(){
        getComponentForm().registerAnimated(this);
    }
}

