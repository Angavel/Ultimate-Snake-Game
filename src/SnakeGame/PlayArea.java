package SnakeGame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;
import javax.swing.JFrame;

class PlayArea extends JFrame implements KeyListener {
    int x, y; // size of window in pixels

    Snake s = new Snake(); //has to be here for KeyEvent to work?
    Food f = new Food();

    public PlayArea(int x, int y) {
        this.x = x;
        this.y = y;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ULTIMATE SNAKE GAME");
        this.setSize(this.x, this.y); //stackoverflow says delete this?
        this.addKeyListener(this);
        this.setVisible(true);

//        ImageIcon grid = new ImageIcon("Grid.png"); //how to make visible?
//        JLabel label = new JLabel(grid); //wrong but dunno how
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> moveUp();//redo this to only change cardinal direction. only 1 action should be executable per 'frame'
            case KeyEvent.VK_S -> moveDown();
            case KeyEvent.VK_A -> moveLeft();
            case KeyEvent.VK_D -> moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    public void moveUp() {
        s.setPlayerMoved(true); //instruct idleMove not to advance snake automatically
        s.y += 10;
        s.setDirection(1);
        checkMove();
    }
    public void moveDown() {
        s.setPlayerMoved(true); //instruct idleMove not to advance snake automatically
        s.y -= 10;
        s.setDirection(2);
        checkMove();
    }
    public void moveLeft() {
        s.setPlayerMoved(true); //instruct idleMove not to advance snake automatically
        s.x -= 10;
        s.setDirection(3);
        checkMove();
    }
    public void moveRight() {
        s.setPlayerMoved(true); //instruct idleMove not to advance snake automatically
        s.x += 10;
        s.setDirection(4);
        checkMove();
    }

    public void idleMoveUp() { //does not change idle token.  does not change direction.
        s.y += 10;
        checkMove();
    }
    public void idleMoveDown() {
        s.y -= 10;
        checkMove();
    }
    public void idleMoveLeft() {
        s.x -= 10;
        checkMove();
    }
    public void idleMoveRight() {
        s.x += 10;
        checkMove();
    }


    public void checkMove(){

        if ((s.x == f.x) && (s.y == f.y)) { // eat the food?
            f.moveFood();// move food to new spot
            s.foodGet();// increase tail length

        } else if (((s.x > x) | s.x < 0) || ((s.y > y) | (s.y < 0))) { // Loss for going out of bounds
            System.out.println("OUT OF BOUNDS");
        } // add loss conditions for hitting boundary or tail here later :)
        System.out.printf("Snake x & y are: %d %d \n", s.x, s.y);
        System.out.printf("Food x & y are: %d %d \n", f.x, f.y);

    }

}//PlayArea class


//	public void createFrame(int width, int height) {

//	setDefaultCloseOperation(EXIT_ON_CLOSE);

//	setSize(5, 5);

// playArea Class

///////////////////////////////////////////////////////////////////////

//package P1;
//
//
//@SuppressWarnings("serial")
//public class GameFrame extends JFrame{
//	private Game game;
//	public GameFrame(Game game, String title, int width, int height) {
//		this.game = game;
//		//attributes
//		setSize(width, height);
//		setTitle(title);
//		setUndecorated(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		//create and add objects
//		add(new GamePanel());
//	}
//
//	private class GamePanel extends JPanel{
//		BufferedImage myImage;
//		public GamePanel() {
//			//setBackground(Color.BLACK);
//			try {
//				myImage = ImageIO.read(new File("background.jpg"));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		public void paint(Graphics g) {
//			super.paint(g);
//			g.drawImage(myImage, 0, 0, this);
//			game.paint((Graphics2D)g);
//		}
//
//	}
//
//}