package org.csc133.a2.clocks;


import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.geom.Dimension;
import org.csc133.a2.GameWorld;
import org.csc133.a2.Helicopter;


import java.io.IOException;

public class LivesClock extends Component {

    GameWorld gw;
    Image[] digitImages = new Image[10];

    public int ledColor;
    private static final int numDigitsShowing = 2; // Lives only has 1 digits
    Image[] clockDigits = new Image[numDigitsShowing];

    public LivesClock(GameWorld gw) {
        this.gw = gw;
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



        }catch(IOException e){e.printStackTrace(); System.out.println("Here");}

        for(int i = 0; i < numDigitsShowing; i++){
            clockDigits[i]=digitImages[0];
        }
    }
    public void setLivesLabel(){
        Helicopter obj = (Helicopter)gw.holder.get(0);

        livesLabel(obj.lives);
    }
    public void livesLabel(int gas){

        int count =1;
        while (gas > 0 && count >= 0) {
            clockDigits[count] = digitImages[gas % 10];
            gas = gas / 10;

            count--;
        }

    }




    public void stop(){
        getComponentForm().deregisterAnimated(this);
    }

    public void laidout(){
        this.start();
    }

    public boolean animate(){
        setLivesLabel();
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
        g.fillRect(getX(),getY(),getWidth(),getHeight());
        g.setColor(ColorUtil.GRAY);
        g.fillRect(displayX + COLOR_PAD,displayY + COLOR_PAD,
                displayClockWidth - COLOR_PAD *2,displayDigitHeight-COLOR_PAD*2);

        for(int digitIndex = 0;digitIndex<numDigitsShowing;digitIndex++){
            g.drawImage(clockDigits[digitIndex],displayX + digitIndex * displayDigitWidth,
                    displayY,displayDigitWidth,displayDigitHeight);
        }laidout();

    }
    protected Dimension calcPreferredSize(){
        return new Dimension(digitImages[0].getWidth() * 4,digitImages[0].getHeight());//4 is numdigits showing
    }
    public void start(){
        getComponentForm().registerAnimated(this);
    }
}


