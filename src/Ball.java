import processing.core.PApplet;

public class Ball {
    private PApplet canvas;
    private int x;
    private int y;
    private double[] hitbox;
    private boolean pickUp;
    private int size;

    public Ball (PApplet c, int xcoord, int ycoord, boolean pickedUp) {
        // ball can be drawn at a given x and y with a give size, and the hitbox is created. a boolean tracks if it is picked up
        canvas = c;
        x = xcoord;
        y = ycoord;
        hitbox = new double[4];
        this.pickUp = pickedUp;
        size = 30;
    }

    public void draw () {
       if (!pickUp) {
        // if the ball is not picked up, it is drawn. once it gets picked up it is no longer drawn.
        canvas.stroke(0);
        canvas.strokeWeight(2);
        canvas.fill(222, 103, 21);
        canvas.ellipse(x, y, size, size);
       }
    }
// gets hitbox that can be called in other classes
    public double[] getHitbox(){
        hitbox[0] = (x - (size/2));
        hitbox[1] = (y - (size/2));
        hitbox[2] = (x + (size/2));
        hitbox[3] = (y + (size/2));
        return hitbox;
    }
// allows to check if the ball is picked up in other classes
    public void getPick(boolean getpick) {
        this.pickUp = getpick;
    }
}

