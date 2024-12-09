import processing.core.*;

public class App extends PApplet{
    Lvl0 test0;
    Lvl1 test;
    Lvl2 test2;
    int lvl = 0;
    boolean lvlUp;
    boolean status;
    public static void main(String[] args)  {
        PApplet.main("App");
       
    }

    public void setup(){ 
        lvlUp = false;
        status = false;
        
        test0 = new Lvl0(this, status);
        test = new Lvl1(this, status);
        test2 = new Lvl2(this, status);
        
        
        
    }

    public void settings(){
        size(800, 800);

    }

    public void draw(){
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
        

        if (keyPressed) {
           
            if (key == ENTER && !lvlUp) {
                if (lvl == 0 && test0.lvlOver()) {
                    lvlUp = true;
                    status = false;
                    test0.getStatus();
                    lvl++;
                    System.out.println(lvl);
                } else if (lvl == 1 && test.lvlOver()) {
                    lvlUp = true;
                    status = false;
                    test.getStatus();
                    lvl++;
                    System.out.println(lvl);
                }
            }
        }

        if (!keyPressed) {
            lvlUp = false;
        }
        
       

    }
}
