import processing.core.PApplet;

public class Lvl1 {
    private PApplet canvas;
    private Character bob;
    private Instructor guy;
    private Portal portal;

    public Lvl1 (PApplet c) {
        canvas = c;
        bob = new Character(c);
        guy = new Instructor(c);
        portal = new Portal(c);
    }

    public void draw() {
        canvas.background(0);
        if (bob.thisScreen() == 0) {
            canvas.background(255);
        }
        if (bob.thisScreen() == 1) {
            canvas.background(150);
        }
        if (bob.thisScreen() == 2) {
            canvas.background(50);
        }
        if (bob.thisScreen() == 3) {
            canvas.background(255, 0, 0);
        }
        if (bob.thisScreen() == 4) {
            canvas.background(0, 255, 0);
            guy.draw();
            portal.draw();
        }
        if (bob.thisScreen() == 5) {
            canvas.background(255, 255, 0);
        }
        if (bob.thisScreen() == 6) {
            canvas.background(0, 0, 255);
        }
        if (bob.thisScreen() == 7) {
            canvas.background(255, 0, 255);
        }
        if (bob.thisScreen() == 8) {
            canvas.background(0, 255, 255);
        }
        bob.draw();
        bob.handleMovements();
        }

        
    }

 