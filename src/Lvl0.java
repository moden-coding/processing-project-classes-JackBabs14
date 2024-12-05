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
    private int[] character;
    private boolean inRange;
    private int[] instructor;
    private boolean dialogue;
    private boolean diaOver;
    private boolean missionComplete;
    private String dia1;
    private boolean dia1lines;

    public Lvl0(PApplet c) {
        gameOver = false;
        inRange = false;
        canvas = c;
        bob = new Character(c, inRange);
        guy = new Instructor(c);
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
            canvas.background(0, 255, 0);
        }
        if (bob.thisScreen() == 4) {
            canvas.background(0, 255, 0);
            guy.draw();
            first.draw(); 
        }
        if (bob.thisScreen() == 5) {
            canvas.background(0, 255, 0);
        }
        if (bob.thisScreen() == 6) {
            canvas.background(0, 255, 0);
        }
        if (bob.thisScreen() == 7) {
            canvas.background(0, 255, 0);
        }
        if (bob.thisScreen() == 8) {
            canvas.background(0, 255, 0);
    }
    bob.draw();
    bob.handleMovements();
    
    checkDia();
    dialogue();

    
    }

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
            bob.getCoords(385, 335);
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
    

    public boolean lvlOver() {
        boolean cTouchP = (character[0] > 300 && character[1] > 300 && character[2] < 500 && character[3] < 500);
         
        if(cTouchP && missionComplete) {
            gameOver = true;
        }
        else {gameOver = false;}
        return gameOver;
    }
}