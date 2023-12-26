package SnakeGame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;
import java.util.concurrent.Delayed;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner in = new Scanner(System.in);
//        JFrame ww = new JFrame();
        PlayArea p = new PlayArea(500, 500);  // create window of x by y pixels
//        JPanel p = new JPanel(new BorderLayout());
        Snake s = new Snake(); // create default snake at start position
        Food f = new Food(); // creates an initial food at random place
        String move, lastMove;  // stores wasd inputs from user
        int moveDir = 0;
        int time = 3000;
        Timer timer = new Timer();

//        p.keyPressed(KeyEvent());
//        KeyEvent e = new KeyEvent()

//        try {// Dunno what all this is, eclipse added it
//            Object snek = ImageIO.read(new File("Snek.png"));
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }// how to attach this to xy coords of object Snake?
//
//        try {
//            Object food = ImageIO.read(new File("Food.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        p.getClientProperty("Snek.png").add(ww);

        timer.scheduleAtFixedRate(new TimerTask() { // creates a persistent timer instance
            public void run() {
                System.out.println("TIMER LOOP");
                if(p.s.playerMoved) { //check if user input detected this cycle
                    p.s.setPlayerMoved(false); //reset token for timer session if player input detected
                    System.out.println("token reset");//think i can remove this if input commands only change direction of next travel
                    } else{
                    switch (p.s.getDirection()) { // keep snake moving in cardinal direction when idle
                        case 1 -> p.idleMoveUp();
                        case 2 -> p.idleMoveDown();
                        case 3 -> p.idleMoveLeft();
                        case 4 -> p.idleMoveRight();
                }
            }
        }},time, time);// what time unit does this use, milliseconds?
        //HOW TO LOOP EVERY X SECONDS WITHOUT WAITING FOR INPUT?
        // FOLKS WE DID IT.

        do { // User inputs for movement, main play loop

            System.out.println("Enter wasd input: ");
            move = in.nextLine();
            lastMove = move;// this will keep snake moving forward once framerate implemented :)

            System.out.println("Is this loop working?"+move);

//            s.moveSnake(move); // moves snake up, down, left, or right from w a s d input

//            w.keyPressed();

//            if ((s.x == f.x) && (s.y == f.y)) { // eat the food?
//                f.moveFood();// move food to new spot
//                s.foodGet();// increase tail length
//
//            } else if (((s.x > p.getX()) | (s.x < 0)) || ((s.y > p.getY()) | (s.y < 0))) { // Loss for going out of bounds
//                System.out.println("OUT OF BOUNDS");
//            } // add loss conditions for hitting boundary or tail here later :)
//
//            System.out.printf("Snake x & y are: %d %d \n", s.x, s.y);
//            System.out.printf("Food x & y are: %d %d \n", f.x, f.y);

        } while (true); // end of gameplay loop

    }// main Method

}// Game class