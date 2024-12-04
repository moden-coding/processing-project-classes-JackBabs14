import processing.core.*;

public class App extends PApplet{
    Lvl0 test0;
    Lvl1 test;
    int lvl = 0;
    public static void main(String[] args)  {
        PApplet.main("App");
       
    }

    public void setup(){ 
        
        test0 = new Lvl0(this);
        test = new Lvl1(this);
        
        
        
    }

    public void settings(){
        size(800, 800);

    }

    public void draw(){
        background(100);
        if (lvl == 0) {
            test0.draw();
        }
        else {test.draw();}

        if (keyPressed) {
            if (key == ENTER && test0.lvlOver() == true) {
                lvl++;
            }
            
        }
        
       

    }
}
