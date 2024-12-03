import java.util.ArrayList;

import processing.core.PApplet;

public class Portal {
    private PApplet canvas;
    private int x;
    private int y;
    private int size;
    
   

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


