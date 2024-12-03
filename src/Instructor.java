import processing.core.PApplet;

public class Instructor {
    private PApplet canvas;
    private int x;
    private int y;
    private int[] range;

    public Instructor (PApplet c) {
        canvas = c;
        this.x = 100;
        this.y = 600;
        range = new int[4];
        range[0] = x - 30;
        range[1] = y - 80;
        range[2] = x + 95;
        range[3] = y + 190; 
    }

    public void draw() {
        canvas.pushMatrix();
        canvas.translate(this.x, this.y);
        canvas.stroke(0);
        canvas.strokeWeight(2);
        canvas.noFill();
        canvas.rect(-30, -80, 95, 190);
        canvas.fill(204, 132, 67);
        canvas.ellipse(20, -25 , 50, 50);
        canvas.fill(0, 0, 255);
        canvas.rect(0, 0, 40, 80);
        canvas.fill(0);
        canvas.ellipse(35, -30, 5, 5);
        canvas.popMatrix();
    }
}

