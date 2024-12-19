import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.PApplet;

public class lvl3 {
    private PApplet canvas;
    private Character bob;
    private Instructor guy;
    private Portal first;
    private Ball ball;
    private Mission1 mission1;
    private Mission2 mission2;
    private Hammer hammer;
    private int inv;
    private double[] ballhb;
    private double[] mission1HB;
    private double[] mission2HB;
    private int[] character;
    private int[] instructor;
    private int[] hammerHB;
    private boolean ballPickedup;
    private boolean hammerPickUp;
    private boolean missionFirst;
    private boolean missionComplete;
    private boolean gameOver;
    private boolean inRange;
    private boolean dialogue;
    private boolean diaOver;
    private boolean dia1lines;
    private boolean inRange2;
    private boolean dialogue2;
    private boolean diaOver2;
    private boolean dia2lines;
    private boolean inRange3;
    private boolean dialogue3;
    private boolean diaOver3;
    private boolean dia3lines;
    private String dia1;
    private String dia2;
    private String dia3;
     private ArrayList<Integer> visited;
// This combines the last two levels, now there is botha ball and a hamemer and there are two mission guys
    public lvl3 (PApplet c, boolean status) {
        canvas = c;
        inv = 0;
        bob = new Character(c, inRange, inv, 385, 355);
        guy = new Instructor(c, 100, 600);
        first = new Portal(c);
        ballPickedup = false;
        ball = new Ball(c, 200, 400, ballPickedup);
        mission1 = new Mission1(c, 550, 550);
        mission2 = new Mission2(c, 125, 100);
        hammerPickUp = false;
        hammer = new Hammer(c, 50, 700, hammerPickUp);
        character = bob.hitbox();
        instructor = guy.getRange();
        ballhb = ball.getHitbox();
        mission1HB = mission1.getRange();
        mission2HB = mission2.getRange();
        hammerHB = hammer.getHitbox();
        missionFirst = false;
        missionComplete = false;
        gameOver = status;
        inRange = false;
        dialogue = false;
        diaOver = false;
        dia1lines = false;
        inRange2 = false;
        dialogue2 = false;
        diaOver2 = false;
        dia2lines = false;
        dia1 = "lvl3dia1.txt";
        dia2 = "lvl3dia2.txt";
        dia3 = "lvl3dia3.txt";
        visited = bob.getVisited();

    }

    public void draw() {
        canvas.background(0);
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
            canvas.stroke(0);
            canvas.strokeWeight(2);
            canvas.fill(255, 0, 0);
            canvas.rect(y + 10, 60, 80, 240);
            canvas.fill(0);
            canvas.rect(y+5, 100, 5, 15);
            canvas.rect(y+5, 235, 5, 15);
            canvas.rect(115, 100, 5, 15);
            canvas.rect(115, 235, 5, 15);
            mission2.draw();
            
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
                ball.draw();
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
                if (missionFirst) {
                    hammer.draw();
                }
                // only draws the hammer once the first missin is done
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
            mission1.draw();
        }
        bob.draw();
        bob.handleMovements();
        checkDia();
        dialogue();
        ballPickUp();
        checkDia2();
        dialogue2();
        hammerPickUp();
        checkDia3();
        dialogue3();
        // same as before except with 2 objects and 3 dialogues
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
// second dialogue checks if the character has the ball first, then resets inv to 0 after and it end the first mission in this level.
    public boolean checkDia2(){
        if (inv == 1 && bob.thisScreen() == 8) {
          
              inRange2 = (character[2] > mission1HB[0] && character[0] < mission1HB[2] && character[3] > mission1HB[1] && character[1] < mission1HB[3]); 
              
          }else {
              inRange2 = false;
              dia2lines = false;
          }      
       
          bob.getTalking(inRange2);
          return inRange2;
          } 

    public void dialogue2() {
            if (!inRange2 && diaOver2) {
                diaOver2 = false;
            }
            if (inRange2 && !diaOver2) {
                dialogue2 = true;
            }else {
                dialogue2 = false;
            }
            if (diaOver2) {
                dialogue2 = false;
                bob.getCoords(385, 355);
                bob.updateHitbox();
                
            }
            if (dialogue2) {
                canvas.fill(0);
                canvas.rect(0, 0, 800, 800);
                int y = 50;
                canvas.textSize(15);
                canvas.fill(255);
                if (!dia2lines) {
                    try (Scanner scanner1 = new Scanner(Paths.get(dia2))) { 
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
                diaOver2 = true;
                missionFirst = true;
                inv = 0;
                bob.setInv(inv);
                }
            }
        }
// checks if character has the hammer and if the first mission is done, ends by making the entire game mission complete.
        public boolean checkDia3(){
            if (inv == 2 && bob.thisScreen() == 0 && missionFirst) {
              
                  inRange3 = (character[2] > mission2HB[0] && character[0] < mission2HB[2] && character[3] > mission2HB[1] && character[1] < mission2HB[3]); 
                  
              }else {
                  inRange3 = false;
                  dia3lines = false;
              }      
           
              bob.getTalking(inRange3);
              return inRange3;
              } 
    
        public void dialogue3() {
                if (!inRange3 && diaOver3) {
                    diaOver3 = false;
                }
                if (inRange3 && !diaOver3) {
                    dialogue3 = true;
                }else {
                    dialogue3 = false;
                }
                if (diaOver3) {
                    dialogue3 = false;
                    bob.getCoords(385, 555);
                    bob.updateHitbox();
                    
                }
                if (dialogue3) {
                    canvas.fill(0);
                    canvas.rect(0, 0, 800, 800);
                    int y = 50;
                    canvas.textSize(15);
                    canvas.fill(255);
                    if (!dia3lines) {
                        try (Scanner scanner1 = new Scanner(Paths.get(dia3))) { 
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
                    diaOver3 = true;
                    missionComplete = true;
                    inv = 0;
                    bob.getInv();
                    }
                }
            }
    

    public void  ballPickUp(){
        if (bob.thisScreen() == 3) {
            if (bob.getInv() == 0) {
                if(ballhb[0] > character[0] && ballhb[1] > character[1] && ballhb[2] < character[2] && ballhb[3] < character[3]) {
                    ballPickedup = true;
                    inv = 1;
                    bob.setInv(inv);
                    ball.getPick(ballPickedup);
                }
            }
        }
    }
// Here there are both ball and hammer so both methods are needed, ball makes inventory '1' while hammer makes it '2'.
        public void  hammerPickUp(){
            if (bob.thisScreen() == 6 && missionFirst && bob.getInv() == 0 && bob.getInv() == 0) {
                if(hammerHB[0] > character[0] && hammerHB[1] > character[1] && hammerHB[2] < character[2] && hammerHB[3] < character[3]) {
                    hammerPickUp = true;
                    inv = 2;
                    bob.setInv(inv);
                    hammer.getPick(hammerPickUp);
                    
                }
                }
            }
        

            public boolean lvlOver() {
                boolean cTouchP = (character[0] - 5 > 300 && character[1] - 5 > 300 && character[2] - 10 < 500 && character[3] - 10 < 500);
                 
                if(cTouchP && missionComplete && bob.thisScreen() == 4) {
                    updateVisited();
                    System.out.println(this.visited);
                    gameOver = true;
                }
                else {gameOver = false;}
                return gameOver;
            }
        
            public void updateVisited() {
                this.visited = bob.getVisited();
            }
    
        public boolean getStatus () {
            return this.gameOver;
        }
        // gameover and status are the same as always.
    }

