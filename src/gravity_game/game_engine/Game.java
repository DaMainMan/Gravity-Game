package gravity_game.game_engine;

import gravity_game.gameState.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener {
    private static int WIDTH;
    private static int HEIGHT;
    public static final String TITLE = "Land Of Tales";
    //This is the main class. The entire game is ran through this single class.
    private static final long serialVersionUID = 1L;
    public static boolean DEBUG_MODE;
    public static Window window;
    private static Thread thread;
    private boolean running = false;
    private Scanner input;
    private GameStateManager gsm;
    private static long runningTime = 0;
    private static String directory;

    public Game() throws IOException {
        window = new Window(TITLE, 3, this);
        DisplayMode mode = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
        WIDTH = mode.getWidth();
        HEIGHT = mode.getHeight();
        thread = new Thread(this);
        addKeyListener(this);
        addMouseListener(this);
        requestFocus();
        running = true;
        initializeDirectory();
        gsm = new GameStateManager();
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        new Game();
    }

    private void initializeDirectory() {
        File file = new File("worlds");
        if (!file.exists()) {
            file.mkdir();
            try {
                FileWriter writer = new FileWriter(file);
            } catch (Exception e) {

            }
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int ticks = 60;
        double ns = 1000000000 / ticks;
        double delta = 0;

        int frames = 0;
        int updates = 0;
        //Allows for the logging of the ticks and frames each second
        //Game Loop\\
        while (running)
        //Boolean which controls the running of the game loop. Were it to equal false, the game would simply freeze.
        {
            /////////////////////////////
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta > 1) {
                tick();
                updates++;
                delta--;
            }
            /////////////////////////////
            //A tick is the game's equivalent of an instant. The code above allows time to be constant in a loop that varies
            //in the length of each iteration
            render();
            frames++;

            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + frames + ", Ticks: " + updates);
                updates = 0;
                frames = 0;
                timer += 1000;
                //Logs the Frames and the ticks that have passed since the last logging. The minimum time between each
                //logging is a second. (The max being however long the tick and drawTo take to process), so the actual
                //message being logged is a tad misleading
            }
        }
        //Game Loop\\
        stop();
    }

    public void stop() {
        //A method to stop the game loop and kill the game thread.
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        gsm.tick();
        runningTime++;
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        //Instead of drawing directly to the canvas, drawing to a buffer strategy allows for a concept called triple buffering
        if (bs == null) {
            createBufferStrategy(2);
            //triple buffering in the long term greatly increases performance. Instead of replacing every pixel, triple buffering
            //only changes the pixels that weren't present before. It also searches for and remembers patterns in a single runtime
            //iteration.
            return;
        }
        Graphics g = bs.getDrawGraphics();
        gsm.render(g);
        g.dispose();
        bs.show();
    }

    public void keyTyped(KeyEvent e) {
        //Irrelevant to program
    }

    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        gsm.keyPressed(k);
    }

    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();
        //k is an integer representing the key that was released
        gsm.keyReleased(k);
    }

    public void mouseClicked(MouseEvent e) {
        //Irrelevant to program
    }

    public void mousePressed(MouseEvent e) {
        //The mouse event itself is passed because it contains information of the mouse button pressed and the location of the mouse
        gsm.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
        //The mouse event itself is passed because it contains information of the mouse button released and the location of the mouse
        gsm.mouseReleased(e);
    }

    public void mouseEntered(MouseEvent e) {
        //Irrelevant to program
    }

    public void mouseExited(MouseEvent e) {
        //Irrelevant to program
    }

    public static long getRunningTime() {
        return runningTime;
    }

    public static String getDirectory() {
        return directory;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static Point mouseLocation(){
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(mouseLocation, window.getFrame());
        return mouseLocation;
    }
}