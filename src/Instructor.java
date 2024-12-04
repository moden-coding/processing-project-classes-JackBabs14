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
    }

    public void draw() {
        canvas.strokeWeight(2);
        canvas.fill(204, 132, 67);
        canvas.ellipse(x + 20, y - 25, 50, 50); 
        canvas.fill(0, 0, 255);
        canvas.rect(x, y, 40, 80); 
        canvas.fill(0);
        canvas.ellipse(x + 35, y - 30, 5, 5);
    }

    public int[] getRange() {
        return new int[] {x - 35, y - 80, x + 75, y + 110};
    }
    }


