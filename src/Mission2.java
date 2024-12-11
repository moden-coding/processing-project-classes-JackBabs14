
import processing.core.PApplet;

public class Mission2 {
    private PApplet canvas;
    private int x;
    private int y;
    private double[] hitbox;
    private boolean hasBall;

    public Mission2(PApplet c, int xcoord, int ycoord) {
        canvas = c;
        x = xcoord;
        y = ycoord;
        hitbox = new double[4];
        hitbox[0] = x - 35;
        hitbox[1] = y - 80;
        hitbox[2] = x + 75;
        hitbox[3] = y + 110;
        hasBall = false;
    }

    public void draw(){
        canvas.strokeWeight(2);
        canvas.fill(204, 150, 87);
        canvas.ellipse(x + 20, y - 25, 50, 50); 
        canvas.fill(50, 253, 92);
        canvas.rect(x, y, 40, 80); 
        canvas.fill(0);
        canvas.ellipse(x + 35, y - 30, 5, 5);

    }

    public double[] getRange() {
        return hitbox;
    }
    
}
