import processing.core.PApplet;

public class Hammer {
    private PApplet canvas;
    private int x;
    private int y;
    private int[] hitbox;
    private boolean pickUp;

    public Hammer (PApplet c, int xcoord, int ycoord, boolean pickedUp) {
        canvas = c;
        x = xcoord;
        y = ycoord;
        hitbox = new int[4];
        this.pickUp = pickedUp;
    }

    public void draw () {
       if (!this.pickUp) {
        canvas.stroke(110, 38, 14);
        canvas.strokeWeight(5);
        canvas.line(x + 15, y + 15, x + 15, y + 45);
        canvas.stroke(0);
        canvas.strokeWeight(2);
        canvas.fill(0);
        canvas.rect(x, y, 30, 15);
       }
    }

    public int[] getHitbox(){
        hitbox[0] = x;
        hitbox[1] = y;
        hitbox[2] = x + 30;
        hitbox[3] = (y + 45);
        return hitbox;
    }

    public void getPick(boolean getpick) {
        this.pickUp = getpick;
    }
    
}

