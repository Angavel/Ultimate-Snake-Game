package SnakeGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake {

    int x, y, direction;
    static int tailLength = 0;

    Boolean playerMoved = false;

    Snake() {   //Set snake to starting position & size
        x = 200;
        y = 200;
        tailLength = 0;
        direction = 1;
    }

    public void foodGet() {
        tailLength++;
    }

    public void setPlayerMoved(Boolean x){
        playerMoved = x;
    }

    public Boolean getPlayerMoved(){
        return playerMoved;
    }

    public void setDirection(int x){
        direction = x;
    }
    public int getDirection(){
        return direction;
    }

//    public void moveUp() {
//        y += 10;
//    }
//
//    public void moveDown() {
//        y -= 10;
//    }
//
//    public void moveLeft() {
//        x -= 10;
//    }
//
//    public void moveRight() {
//        x += 10;
//    }
//
//    public void moveSnake(String x) {
//        switch (x) { // Check for all movement options of snake
//            case "w" -> moveUp();
//            case "s" -> moveDown();
//            case "a" -> moveLeft();
//            case "d" -> moveRight();
//            default -> System.out.println("INVALID MOVE");
//        }
//    }

}//Snake class
