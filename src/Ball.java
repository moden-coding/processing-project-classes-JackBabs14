import processing.core.PApplet;

public class Ball {
    private PApplet canvas;
    private int x;
    private int y;
    private double[] hitbox;
    private boolean pickUp;
    private int size;

    public Ball (PApplet c, int xcoord, int ycoord, boolean pickedUp) {
        canvas = c;
        x = xcoord;
        y = ycoord;
        hitbox = new double[4];
        this.pickUp = pickedUp;
        size = 30;
    }

    public void draw () {
       if (!pickUp) {
        canvas.fill(222, 103, 21);
        canvas.ellipse(x, y, size, size);

        canvas.noFill();
        canvas.stroke(0);
        canvas.strokeWeight(2);
        canvas.rect(x - (size/2), y - (size/2), size, size);
       }
    }

    public double[] getHitbox(){
        hitbox[0] = (x - (size/2));
        hitbox[1] = (y - (size/2));
        hitbox[2] = (x + (size/2));
        hitbox[3] = (y + (size/2));
        return hitbox;
    }
}

