package org.csc133.a2;

import com.codename1.ui.Command;

public class CommandClass extends Command {
    GameWorld gw;
    public String key;

    public CommandClass(String key, GameWorld gw){
        super(key);//The single string key binding
        this.gw = gw;

    }



}
