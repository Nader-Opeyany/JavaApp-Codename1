package org.csc133.a2;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;

public class Game extends Form {
    private GameWorld gw;
    public Game() {

        gw = new GameWorld();
        gw.init();

        play();
    }
    public void play() {
        //Add new glass cockpit component here
        //change from box layout, gridlayout or flowout (borderlayout.north or .south)

        this.setLayout(new BorderLayout());

        GlassCockpit glass = new GlassCockpit(gw);
        this.add(BorderLayout.NORTH,glass);



       MapView map = new MapView(gw);
        add(BorderLayout.CENTER,map);

        //TO DO LIKE GLASS THIS WILL BE A "mini form"
        //

        AccelerateCommand a = new AccelerateCommand("accelerate",gw);
        DeccelerateCommand b = new DeccelerateCommand("break",gw);
        LeftTurn l = new LeftTurn("left",gw);
        RightTurn r = new RightTurn("right",gw);

        addKeyListener('r',r);
        addKeyListener('l',l);
        addKeyListener('b',b);
        addKeyListener('a',a);



        ActionButtons buttons = new ActionButtons(a,b,r,l);
        this.add(BorderLayout.SOUTH,buttons);

        this.show();


        /*
        myTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                String sCommand=myTextField.getText().toString();
                if (sCommand == null || sCommand.equals(""))
                    return;
                myTextField.clear();
                switch (sCommand.charAt(0)){
                    case 'x':
                        System.out.println("\nAre you sure you want to exit? " +
                                "\n"+ "\ny or n\n");
                        break;
                    case 'a':
                        gw.accelerate();
                        break;
                    case 'b':
                        gw.breakN();
                        break;
                    case 'l':
                        gw.stickAngleLeft();
                        break;
                    case 'r':
                        gw.stickAngleRight();
                        break;
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    gw.lastSkyScrapperReached();
                        break;
                    case 'c':
                        gw.collide();
                        break;

                    case 'e' :
                        gw.refuel();
                        break;
                    case 'g':
                        gw.gummedUp();
                        break;
                    case 't':
                        gw.tick();
                        gw.move();
                        System.out.println("tick used");

                        break;
                    case 'd':
                        gw.display();
                        System.out.println("Dispaly used\n");
                        break;
                    case 'm':
                        gw.map();
                        System.out.println("map displayed");
                        break;
                    case 'y':
                        gw.exit();
                        break;
                    case 'n':
                        System.out.println("\nYou have decided not to exit\n");
                        break;

                }
            }
        });*/
    }
}