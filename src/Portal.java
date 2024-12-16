import java.util.ArrayList;
// This is the circle in the middle of the starting screen. This probably didn't need a seperate class but origionally I was planning to maybe do a bit more with it that I decided against and/or found other ways to do it.
// Once I had created the class already, I didnt see a need to delete it so I kept it as a seperate class.

import processing.core.PApplet;

public class Portal {
    private PApplet canvas;
    private int x;
    private int y;
    private int size;
    
   
// sets it to the middle of whatever screen it is called to and sets the size and color of the circle so it cant be changed later
    public Portal(PApplet c) {
        canvas = c;
        x = 400;
        y = 400;
        size = 200;
       
        
    }

    public void draw() {
        canvas.stroke(0);
        canvas.strokeWeight(2);
        canvas.fill(250, 0, 200);
        canvas.ellipse(x, y, size, size);
    }

    
    }


