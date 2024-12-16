import processing.core.PApplet;
// First NPC created, used as the basis for the rest
public class Instructor {
    private PApplet canvas;
    private int x;
    private int y;
    private int[] range;
// sets the range of the instructor (for dialogue) and makes the x and y coordinates initializable by other classes.
    public Instructor (PApplet c, int xcoord, int ycoord) {
        canvas = c;
        this.x = xcoord; 
        this.y = ycoord;
        range = new int[4];
    }
// draws character
    public void draw() {
        canvas.strokeWeight(2);
        canvas.fill(204, 132, 67);
        canvas.ellipse(x + 20, y - 25, 50, 50); 
        canvas.fill(0, 0, 255);
        canvas.rect(x, y, 40, 80); 
        canvas.fill(0);
        canvas.ellipse(x + 35, y - 30, 5, 5);
    }
// sets range, sets 4 points on a rectangle, top left and bottom right corner
    public int[] getRange() {
        return new int[] {x - 35, y - 80, x + 75, y + 110};
    }
    }


