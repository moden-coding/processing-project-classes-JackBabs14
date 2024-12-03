import processing.core.PApplet;

public class Lvl0 {
    private PApplet canvas;
    private Character bob;
    private Instructor guy;

    public Lvl0(PApplet c) {
        canvas = c;
        bob = new Character(c);
        guy = new Instructor(c);
    }

    public void draw() {
        canvas.background(200);
        bob.draw();
        bob.handleMovements();
        if (bob.thisScreen() == 4) {
            guy.draw(); 
        }
    }
}
