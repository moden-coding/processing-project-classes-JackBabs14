import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import processing.core.*;

public class App extends PApplet{
    //Initializing all the different levels, an int to track the level, a boolean to check the completed status of the levels, and a boolean to see if I should lvl up
    Lvl0 test0;
    Lvl1 test;
    Lvl2 test2;
    lvl3 test3;
    Conclustion gameFinished;
    int lvl = 0;
    boolean lvlUp;
    boolean status;
    double startTime;
    double time;
    public static void main(String[] args)  {
        PApplet.main("App");
       
    }

    public void setup(){ 
        lvlUp = false;
        status = false;
        
        test0 = new Lvl0(this, status);
        test = new Lvl1(this, status);
        test2 = new Lvl2(this, status);
        test3 = new lvl3(this, status);
        gameFinished = new Conclustion(this);
        
        
        
    }

    public void settings(){
        size(800, 800);

    }

    public void draw(){
        //Drawing each level based on the int lvl
        background(100);
        if (lvl == 0) {
            test0.draw();
        }
        if (lvl == 1) {
            test.draw();
        }
        if (lvl == 2) {
            test2.draw();
        }
        if (lvl == 3) {
            test3.draw();
        }
        if (lvl >= 4) {
            gameFinished.draw();
        }

        
// Level up mechanism
        if (keyPressed) {
           
            if (key == ENTER && !lvlUp) {
                // when the enter key is pressed and it is not already in the process of changing levels.
                if (lvl == 0 && test0.lvlOver()) {
                    // same for each other level: if the give lvl is being drawn and is over it starts the lvl up process
                    lvlUp = true;
                    status = false;
                    test0.getStatus();
                    lvl++;
                    String endDia = "endDia.txt";
                    try (FileWriter fw = new FileWriter(endDia, false);  
                    PrintWriter writer = new PrintWriter(fw)) {
                   writer.println("Bob, good job! You successfully beat the puzzle game!");  
                   writer.println("Now if you want you can explore the world and play around, but if you prefer to leave you can too.");  
                   writer.println("I hope you had fun completing these puzzles, I know I had fun helping you complete them.");  
                   writer.println("It reminds me of our old adventures together...");  
                   writer.println("...we really had fun when we were stealing the portal guns from those aliens, and their accents were so funny...");  
                   writer.println("Sorry I was getting side-tracked.");  
                   writer.println("I hope to see you again some day, good bye old friend!");  
                   writer.println("");  
                   System.out.println("Reset of Dialogue sucessful.");
               } catch (IOException e) {
                   System.out.println("An error occurred while writing to the file.");
                   e.printStackTrace();
               }
                    startTime = millis();
                } else if (lvl == 1 && test.lvlOver()) {
                    lvlUp = true;
                    status = false;
                    test.getStatus();
                    lvl++;
                } else if (lvl == 2 && test2.lvlOver()) {
                    lvlUp = true;
                    status = false;
                    test.getStatus();
                    lvl++;
                }  else if (lvl == 3 && test3.lvlOver()) {
                    lvlUp = true;
                    status = false;
                    test.getStatus();
                    lvl++;
                    time = millis();
                    finalTime();
                }
            }
        }

        if (!keyPressed) {
            lvlUp = false;
        }
        // only allows it to level up once per enter key
    }

    public void finalTime() {
    double minutes = 0;
    double seconds = 0;
    time = time - startTime;
    time = time / 1000;
    seconds = time % 60;
    minutes = ((time - seconds) / 60);

    String lastDia = "endDia.txt";
    String writeTime = "This game took you " + minutes + " minutes and " + seconds + " seconds to finish.";

    // Here chat gpt taught me how to add a line to a file without overriding it.
    try (FileWriter fw = new FileWriter(lastDia, true);  
         PrintWriter writer = new PrintWriter(fw)) {
        writer.println(writeTime);  
        System.out.println("Time saved to file successfully.");
    } catch (IOException e) {
        System.out.println("An error occurred while writing to the file.");
        e.printStackTrace();
    }
}
}
