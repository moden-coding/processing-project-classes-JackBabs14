import java.util.ArrayList;

import processing.core.PApplet;

public class Lvl0 {
    private PApplet canvas;
    private Character bob;
    private Instructor guy;
    private boolean gameOver;
    private Portal first;
    private int[] character;

    public Lvl0(PApplet c) {
        gameOver = false;
        canvas = c;
        bob = new Character(c);
        guy = new Instructor(c);
        first = new Portal(c);
        character = bob.hitbox();
    }

    public void draw() {
        canvas.background(0);
        if (bob.thisScreen() == 0) {
            canvas.background(0, 255, 0);
        }
        if (bob.thisScreen() == 1) {
            canvas.background(0, 255, 0);
        }
        if (bob.thisScreen() == 2) {
            canvas.background(0, 255, 0);
        }
        if (bob.thisScreen() == 3) {
            canvas.background(0, 255, 0);
        }
        if (bob.thisScreen() == 4) {
            canvas.background(0, 255, 0);
            guy.draw();
            first.draw(); 
        }
        if (bob.thisScreen() == 5) {
            canvas.background(0, 255, 0);
        }
        if (bob.thisScreen() == 6) {
            canvas.background(0, 255, 0);
        }
        if (bob.thisScreen() == 7) {
            canvas.background(0, 255, 0);
        }
        if (bob.thisScreen() == 8) {
            canvas.background(0, 255, 0);
    }
    bob.draw();
    bob.handleMovements();
    }

    public boolean lvlOver() {
        boolean cTouchP = (character[0] > 300 && character[1] > 300 && character[2] < 500 && character[3] < 500);
         
        if(cTouchP) {
            gameOver = true;
        }
        else {gameOver = false;}
        return gameOver;
    }
}
