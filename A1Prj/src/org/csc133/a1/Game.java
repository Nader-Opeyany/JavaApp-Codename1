package org.csc133.a1;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class Game extends Form {
    private GameWorld gw;
    public Game() {
        gw = new GameWorld();
        gw.init();

        play();
    }
    public void play() {
        Label myLabel=new Label("Enter a Command:");
        this.addComponent(myLabel);
        final TextField myTextField=new TextField();
        this.addComponent(myTextField);
        this.show();
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
        });
    }
}