package game;

import input.KeyManager;
import input.MenuKeyManager;
import input.PlayKeyManager;
import models.Entity.Avatar;
import models.Factories.EntityFactory;
import models.Inventory.Inventory;
import models.States.*;

import views.Assets;
import views.Display;

import java.awt.*;
import java.awt.font.GraphicAttribute;
import java.awt.image.BufferStrategy;

/**
 *
 */
public class Game implements Runnable{
    /* Attributes */
    private Display display;
    private static int width, height;
    public String title;

    private Thread thread;
    private boolean running;

    private BufferStrategy bufferStrategy;
    private Graphics g;

    //States
    private State mainMenuState;


    //Input
    private KeyManager keyManager;

    //Test
    int x = 0;


    /* Constructor */
    public Game(String title , int width, int height){
        this.width =    width;
        this.height =   height;
        this.title = title;
        running = false;
        keyManager = new PlayKeyManager();
    }

    public void init(){
        GameStateManager.setGame(this);
        display = new Display(title, width, height);
        display.addKeyListener(keyManager);
        Assets.init();


        mainMenuState = new MainMenuState(new MenuKeyManager());
        GameStateManager.setState(mainMenuState);


    }

    private void tick(){
        if(GameStateManager.getState() != null){
            GameStateManager.tickCurrentState();
        }
    }

    private void render(){
        bufferStrategy = display.getCanvasBufferStrategy();
        if(bufferStrategy == null){
            display.createCanvasBufferStrategy(3);
            return;
        }

        g = bufferStrategy.getDrawGraphics();
        g.clearRect(0 , 0 , width , height);

        if(GameStateManager.getState() != null){
            GameStateManager.renderCurrentState(g);
        }

        bufferStrategy.show();
        g.dispose();



    }

    public void run(){
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps ; // 1sec / fps
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/ timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                //System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    };
    public synchronized void start(){
        if(running){
            return; //do nothing
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running){
            return; //do nothing
        }
        running = false;
        try{
            thread.join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setKeyListener(KeyManager keyManager){
        this.keyManager = keyManager;
        display.addKeyListener(keyManager);
    }




    public KeyManager getKeyManager(){
        return this.keyManager;
    }

    public boolean hasKeyManager(){
        if(keyManager == null){
            return false;
        }

        return true;
    }

    public static int getWidth(){ return width;};
    public static int getHeight(){return height;}
}
