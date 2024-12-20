import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PConstants;

public class Lvl0 {
    private PApplet canvas;
    private Character bob;
    private Instructor guy;
    private boolean gameOver;
    private Portal first;
    // initializes the canvas and the objects that will be used in this level
    private int[] character;
    private boolean inRange;
    private int[] instructor;
    // hitbox of character and of the instructor, and the boolean seeing if they are in the range
    private boolean dialogue;
    private boolean diaOver;
    private boolean missionComplete; // checks to see if the mission per leel is complete
    private String dia1;
    private boolean dia1lines;
    private int inv; // sets the character inv
// the rest are all related to dialogue
    public Lvl0(PApplet c, boolean status) {
        gameOver = status; // this is so the status of whether the game is completed can be seen by other classes
        inv = 0;
        inRange = false;
        canvas = c;
        bob = new Character(c, inRange, inv, 385, 355);
        guy = new Instructor(c, 100, 600);
        first = new Portal(c);
        character = bob.hitbox();
        instructor = guy.getRange();
        dialogue = false;
        diaOver = false;
        missionComplete = false;
        dia1 = "lvl0instructor.txt";
        dia1lines = false;
    }

    public void draw() {
        canvas.background(0);
        character = bob.hitbox();
        instructor = guy.getRange();
        canvas.strokeWeight(2);
        if (bob.thisScreen() == 0) {
            int y = 25;
            canvas.background(0, 255, 0);
            canvas.fill(150);
            canvas.rect(0, 0, 800, 400);
            canvas.stroke(255, 255, 0);
            canvas.strokeWeight(5);
            canvas.line(y, 50, 5*y, 50);
            canvas.line(y, 50, y, 250);
            canvas.line(5*y, 50, 5*y, 250);
            canvas.line(7*y, 50, 11*y, 50);
            canvas.line(7*y, 50, 7*y, 250);
            canvas.line(11*y, 50, 11*y, 250);
            canvas.line(13*y, 50, 17*y, 50);
            canvas.line(13*y, 50, 13*y, 250);
            canvas.line(17*y, 50, 17*y, 250);
            canvas.line(19*y, 50, 23*y, 50);
            canvas.line(19*y, 50, 19*y, 250);
            canvas.line(23*y, 50, 23*y, 250);
            canvas.line(25*y, 50, 29*y, 50);
            canvas.line(25*y, 50, 25*y, 250);
            canvas.line(29*y, 50, 29*y, 250);

        }
        if (bob.thisScreen() == 1) {
            canvas.background(0, 255, 0);
            canvas.fill(150);
            canvas.beginShape();
            canvas.vertex(0, 450);
            canvas.vertex(0, 350);
            canvas.vertex(800, 350);
            canvas.vertex(800, 450);
            canvas.vertex(450, 450);
            canvas.vertex(450, 800);
            canvas.vertex(350, 800);
            canvas.vertex(350, 450);
            canvas.vertex(0, 450);
            canvas.endShape();
        }
        if (bob.thisScreen() == 2) {
            canvas.background(0, 255, 0);
            canvas.fill(150);
            canvas.beginShape();
            canvas.vertex(0,350);
            canvas.vertex(450, 350);
            canvas.vertex(450, 800);
            canvas.vertex(350, 800);
            canvas.vertex(350, 450);
            canvas.vertex(0, 450);
            canvas.endShape();
        }
        if (bob.thisScreen() == 3) {
            canvas.background(196, 164, 132);
            for (int x = 5; x < 800; x += 10){
                for(int y = 5; y < 790; y += 15) {
                    canvas.stroke(250, 250, 110);
                    canvas.strokeWeight(5);
                    canvas.line(x, y, x, y-10);
                }
            }
        }
        if (bob.thisScreen() == 4) {
            canvas.background(0, 255, 0);
            guy.draw();
            first.draw(); 
        }
        if (bob.thisScreen() == 5) {
            canvas.background(0, 255, 0);
            canvas.background(0, 255, 0);
            canvas.fill(150);
            canvas.beginShape();
            canvas.vertex(500,450);
            canvas.vertex(450, 450);
            canvas.vertex(450, 800);
            canvas.vertex(350, 800);
            canvas.vertex(350, 0);
            canvas.vertex(450, 0);
            canvas.vertex(450, 350);
            canvas.vertex(500, 350);
            canvas.endShape();
            canvas.fill(0,0,255);
            canvas.ellipse(650, 400, 200, 200);
        }
        if (bob.thisScreen() == 6) {
            canvas.background(0, 255, 0);
            for (int i = 25; i < 800; i += 50) {
                for (int j = 25; j < 800; j += 50) {
                canvas.fill(255, 0, 0);
                canvas.ellipse(i, j, 20, 20);
                canvas.stroke(1, 50, 32);
                canvas.line(i, j+10, i, j+20);
                }
            }
        }
        if (bob.thisScreen() == 7) {
            canvas.background(0, 255, 0);
            canvas.fill(0,0,255);
            canvas.ellipse(400, 400, 550, 550);
        }
        if (bob.thisScreen() == 8) {
            canvas.background(0, 255, 0);
            canvas.fill(150);
            canvas.beginShape();
            canvas.vertex(350,0);
            canvas.vertex(350, 350);
            canvas.vertex(0, 350);
            canvas.vertex(0, 450);
            canvas.vertex(450, 450);
            canvas.vertex(450, 0);
            canvas.endShape();
    }
    // draws the background for the levels as well as the objects that will be in each screen
    bob.draw();
    bob.handleMovements();
    // draws the character and allow him to be moved
    checkDia();
    dialogue();
// allows dialogue workds
    
    }
// Checks to see if the character is within range of the instructor and then sets boolean in range to true
    public boolean checkDia(){
      if (bob.thisScreen() == 4) {
        
            inRange = (character[2] > instructor[0] && character[0] < instructor[2] && character[3] > instructor[1] && character[1] < instructor[3]); 
        }else {
            inRange = false;
            dia1lines = false;
        }      
     
        bob.getTalking(inRange);
        return inRange;
        } 
       // has the boolean in range to see if it should start the dialogue
       // boolean dialogue is to see if the process is still ongoing
       // diaover is to see if the dialogue is over
       // dia1lines is to see if the lines are are the screen or not
       // creates a rectangle while dialogue is true and displayes the text, then ending it by pressing space moves the character out of range and resets all the booleans so dialogue can be accessed again. 
    public void dialogue() {
        if (!inRange && diaOver) {
            diaOver = false;
        }
        if (inRange && !diaOver) {
            dialogue = true;
        }else {
            dialogue = false;
        }
        if (diaOver) {
            dialogue = false;
            bob.getCoords(385, 355);
            bob.updateHitbox();
            missionComplete = true;
        }
        if (dialogue) {
            canvas.fill(0);
            canvas.rect(0, 0, 800, 800);
            int y = 50;
            canvas.textSize(15);
            canvas.fill(255);
            if (!dia1lines) {
                try (Scanner scanner1 = new Scanner(Paths.get(dia1))) {
                    while (scanner1.hasNextLine()) {
                        String line = scanner1.nextLine();
                        canvas.text(line, 20, y);
                        y += 20;
                    }
                } catch (Exception e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
                
            }
            if (canvas.keyPressed && canvas.key == ' ') {
            diaOver = true;
            }
        }
    }
    // The mission in this level is just to talk to the guy and figure out what the game is about, once that is done the boolean missionOver is set to true

    // If the character is on the portal and mission complete is true, this allows the character to move on to the next level
    public boolean lvlOver() {
        boolean cTouchP = (character[0] - 5 > 300 && character[1] - 5 > 300 && character[2] - 10 < 500 && character[3] - 10 < 500);
         
        if(cTouchP && missionComplete && bob.thisScreen() == 4) {
            gameOver = true;
        }
        else {gameOver = false;}
        return gameOver;
    }
// allows the status to be seen by other classes
    public boolean getStatus () {
        return this.gameOver;
    }
}
