package org.csc133.a1;

public abstract class Fixed extends GameObject{
    public Fixed( double locationX, double locationY) {
        super( locationX, locationY);
    }
    //All fixed game objects are not allowed to change location once they are
    // created.


}
