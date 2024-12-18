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
    
    time = time - startTime;
    time = time / 60000;

    String lastDia = "endDia.txt";
    String writeTime = "This game took you " + time + " minutes to complete.";

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
