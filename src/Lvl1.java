import java.nio.file.Paths;
import java.util.Scanner;

import processing.core.PApplet;

public class Lvl1 {
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
    private Ball ball;
    private boolean ballPickup;
    private int inv;
    private double[] hball;

    public Lvl1 (PApplet c) {
        gameOver = false;
        inRange = false;
        canvas = c;
        inv = 0;
        bob = new Character(c, inRange, inv);
        guy = new Instructor(c);
        first = new Portal(c);
        character = bob.hitbox();
        instructor = guy.getRange();
        dialogue = false;
        diaOver = false;
        missionComplete = false;
        dia1 = "lvl0instructor.txt";
        dia1lines = false;
        ballPickup = false;
        ball = new Ball(c, 600, 600, false);
        hball = ball.getHitbox();
    }

    public void draw() {
        canvas.background(0);
        if (bob.thisScreen() == 0) {
            canvas.background(255);
        }
        if (bob.thisScreen() == 1) {
            canvas.background(150);
        }
        if (bob.thisScreen() == 2) {
            canvas.background(50);
        }
        if (bob.thisScreen() == 3) {
            canvas.background(255, 0, 0);
        }
        if (bob.thisScreen() == 4) {
            canvas.background(0, 255, 0);
            guy.draw();
            first.draw();
            ball.draw();
        }
        if (bob.thisScreen() == 5) {
            canvas.background(255, 255, 0);
        }
        if (bob.thisScreen() == 6) {
            canvas.background(0, 0, 255);
        }
        if (bob.thisScreen() == 7) {
            canvas.background(255, 0, 255);
        }
        if (bob.thisScreen() == 8) {
            canvas.background(0, 255, 255);
        }
        bob.draw();
        bob.handleMovements();
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
            
        }
        if (dialogue) {
            canvas.fill(0);
            canvas.rect(0, 0, 800, 800);
            int y = 50;
            canvas.textSize(15);
            canvas.fill(255);
            if (!dia1lines) {
                try (Scanner scanner1 = new Scanner(Paths.get(dia1))) { // change lines
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


        
    

 