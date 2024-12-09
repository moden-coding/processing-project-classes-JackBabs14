import java.util.ArrayList;

import processing.core.PApplet;

public class Character {
    private PApplet canvas;
    private int x;
    private int y;
    private int speed;
    private int screen;
    private int width;
    private int length;
    private int[] hitbox;
    private boolean talking;
    private int inv;
    

    public Character(PApplet c, boolean dialogue, int inventory) {
        canvas = c;
        x = 385; 
        y = 335; 
        speed = 7;
        screen = 4;
        length = 130;
        width = 60; 
        hitbox = new int[4];
        talking = dialogue;
        inv = inventory;
        
    }

    public void draw() {
        canvas.pushMatrix();
        canvas.translate(x,y);

        canvas.stroke(0);
        canvas.strokeWeight(2);       
        canvas.fill(139,69,19); 
        canvas.rect(0, 0, 30, 60);
        canvas.line(0, 5, 30, 5);
        canvas.line(0, 12, 30, 12);
        canvas.line(0, 19, 30, 19);
        canvas.line(0, 25, 30, 25);
        canvas.line(0, 31, 30, 31);
        canvas.line(0, 39, 30, 39);
        canvas.line(0, 47, 30,47);
        canvas.fill(139,69,19); 
        canvas.rect(5, 60, 20, 40);
        canvas.line(5, 70, 25, 70);
        canvas.line(5, 75, 25, 75);
        canvas.line(5, 85, 25, 85);
        canvas.line(5, 93, 25, 93);
        canvas.triangle(0, 0, 30, 0, 15, -30);
        canvas.rect(-15, 20, 15, 5);
        canvas.rect(-15, 40, 15, 5);
        canvas.rect(30, 20, 15, 5);
        canvas.rect(30, 40, 15, 5);
        canvas.fill(0);
        canvas.ellipse(15, -30, 5, 5);
        canvas.ellipse(7, -10, 3, 3);
        canvas.ellipse(23, -10, 3, 3);
        canvas.popMatrix();
    }

    public void handleMovements() {
        if (!talking) {
            if (canvas.keyPressed) {
            if (canvas.key == 'a' || canvas.key == 'A' || canvas.keyCode == canvas.LEFT) {
                this.x -= speed;
                
            }
            if (canvas.key == 'd' || canvas.key == 'D' || canvas.keyCode == canvas.RIGHT) {
                this.x += speed;
            }
            if (canvas.key == 'w' || canvas.key == 'W' || canvas.keyCode == canvas.UP) {
                this.y -= speed;
            }
            if (canvas.key == 's' || canvas.key == 'S' || canvas.keyCode == canvas.DOWN) {
                this.y += speed;
            }
        }
        else if (screen == 0) {
            if (x < 15) {
                x = 15;
            }
            if (x > 755) {
                x = 15;
                screen += 1;
            }
            if (y < 30) {
                y = 30;
            }
            if (y > 700) {
                y = 30;
                screen += 3;
            }
        }
        else if (screen == 1) {
            if (x < 15) {
                x = 755;
                screen -= 1;
            }
            if (x > 755) {
                x = 15;
                screen += 1;
            }
            if (y < 30) {
                y = 30;
            }
            if (y > 700) {
                y = 30;
                screen += 3;
            }
        }
        else if (screen == 2) {
            if (x < 15) {
                x = 755;
                screen -= 1;
            }
            if (x > 755) {
                x = 755;
            }
            if (y < 30) {
                y = 30;
            }
            if (y > 700) {
                y = 30;
                screen += 3;
            }
        }
        else if (screen == 3) {
            if (x < 15) {
                x = 15;
            }
            if (x > 755) {
                x = 15;
                screen += 1;
            }
            if (y < 30) {
                y = 700;
                screen -=3;
            }
            if (y > 700) {
                y = 30;
                screen += 3;
            }
        }
        else if (screen == 4) {
            if (x < 15) {
                x = 755;
                screen -= 1;
            }
            if (x > 755) {
                x = 15;
                screen += 1;
            }
            if (y < 30) {
                y = 700;
                screen -=3;
            }
            if (y > 700) {
                y = 30;
                screen += 3;
            }
        }
        else if (screen == 5) {
            if (x < 15) {
                x = 755;
                screen -= 1;
            }
            if (x > 755) {
                x = 755;
            }
            if (y < 30) {
                y = 700;
                screen -=3;
            }
            if (y > 700) {
                y = 30;
                screen += 3;
            }
        }
        else if (screen == 6) {
            if (x < 15) {
                x = 15;
            }
            if (x > 755) {
                x = 15;
                screen += 1;
            }
            if (y < 30) {
                y = 700;
                screen -=3;
            }
            if (y > 700) {
                y = 700;
            }
        }
        else if (screen == 7) {
            if (x < 15) {
                x = 755;
                screen -= 1;
            }
            if (x > 755) {
                x = 15;
                screen += 1;
            }
            if (y < 30) {
                y = 700;
                screen -=3;
            }
            if (y > 700) {
                y = 700;
            }
        }
        else if (screen == 8) {
            if (x < 15) {
                x = 755;
                screen -= 1;
            }
            if (x > 755) {
                x = 755;
            }
            if (y < 30) {
                y = 700;
                screen -=3;
            }
            if (y > 700) {
                y = 700;
            }
        }
        else {
        if (x < 15) {
            x = 15;
        }
        if (x > 755) {
            x = 755;
        }
        if (y < 30) {
            y = 30;
        }
        if (y > 700) {
            y = 700;
        }
    } 
}
    updateHitbox();
    }

    public int thisScreen() {
        return screen;
    }

    public void getScreen(int screens) {
        this.screen = screens;
    }

    public void updateHitbox(){
        hitbox[0] = x - 15;  
        hitbox[1] = y - 30;  
        hitbox[2] = hitbox[0] + width; 
        hitbox[3] = hitbox[1] + length;
    }

    public int[] hitbox() {
        return hitbox;
    }

    public void getTalking(boolean ddialogue) {
        this.talking = ddialogue;
    }

    public void getCoords(int xcoord, int ycoord){
        this.x = xcoord;
        this.y = ycoord;
    }

    public int getInv () {
        return inv;
    }


}
