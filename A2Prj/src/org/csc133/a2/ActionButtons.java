package org.csc133.a2;


import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.GridLayout;

public class ActionButtons extends Container {
    AccelerateCommand a ;
    DeccelerateCommand b ;
    LeftTurn l ;
    RightTurn r ;
    public ActionButtons( AccelerateCommand a, DeccelerateCommand b, RightTurn r, LeftTurn l) {

        super(new GridLayout(1,4));
        this.a =a;
        this.b = b;
        this.l = l;
        this.r =r;
        //Key listener was taken out this is for buttons

        Button left = new Button("left");
        left.addActionListener(l);
        Button right = new Button("right");
        right.addActionListener(r);
        Button breakOut = new Button("break");
        breakOut.addActionListener(b);
        Button accelerate = new Button("accelerate");
        accelerate.addActionListener(a);
        add(left);
        add(right);
        add(breakOut);
        add(accelerate);
    }



}
