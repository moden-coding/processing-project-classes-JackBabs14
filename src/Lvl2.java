import java.nio.file.Paths;
import java.util.Scanner;

import processing.core.PApplet;

public class Lvl2 {
    private PApplet canvas;
    private Character bob;
    private Instructor guy;
    private Portal first;
    private Mission2 mission;
    private Hammer hammer;
    private int inv;
    private double[] mission2;
    private int[] character;
    private int[] instructor;
    private int[] hammerHB;
    private boolean hammerPickUp;
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
    private String dia1;
    private String dia2;

    public Lvl2 (PApplet c, boolean status) {
        canvas = c;
        inv = 0;
        bob = new Character(c, inRange, inv);
        guy = new Instructor(c, 100, 600);
        first = new Portal(c);
        mission = new Mission2(c, 450, 300);
        hammerPickUp = false;
        hammer = new Hammer(c, 600, 300, hammerPickUp);
        character = bob.hitbox();
        instructor = guy.getRange();
        mission2 = mission.getRange();
        hammerHB = hammer.getHitbox();
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
        dia2 = "lvl2dia1.txt";
        dia1 = "lvl2dia2.txt";


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
            hammer.draw();
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
            canvas.fill(0, 175, 0);
            canvas.ellipse(650, 150, 50, 50);
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
            mission.draw();
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
        bob.draw();
        bob.handleMovements();
        checkDia();
        dialogue();
        hammerPickUp();
        checkDia2();
        dialogue2();
        
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

    public boolean checkDia2(){
        if (inv == 2 && bob.thisScreen() == 5) {
          
              inRange2 = (character[2] > mission2[0] && character[0] < mission2[2] && character[3] > mission2[1] && character[1] < mission2[3]); 
              
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
                bob.getCoords(385, 555);
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
                missionComplete = true;
                }
            }
        }

        public void  hammerPickUp(){
            if (bob.thisScreen() == 0) {
                if (bob.getInv() == 0) {
                if(hammerHB[0] > character[0] && hammerHB[1] > character[1] && hammerHB[2] < character[2] && hammerHB[3] < character[3]) {
                    hammerPickUp = true;
                    inv = 2;
                    bob.setInv(inv);
                    hammer.getPick(hammerPickUp);
                }
                }
            }
        }
        
       
        
    
        public boolean lvlOver() {
            boolean cTouchP = (character[0] - 5 > 300 && character[1] - 5 > 300 && character[2] - 10 < 500 && character[3] - 10 < 500);
             
            if(cTouchP && missionComplete && bob.thisScreen() == 4) {
                gameOver = true;
            }
            else {gameOver = false;}
            return gameOver;
        }
    
        public boolean getStatus () {
            return this.gameOver;
        }
    }

