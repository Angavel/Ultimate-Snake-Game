package SnakeGame;

public class Food {

    int x = 0;
    int y = 0;

    Food() {
//		x = 0;
//		y = 0;
        moveFood();
    }

    public void moveFood() {// currently may place food on or within snake, fix later :)
        x = ((int) (Math.random() * 41))*10; // set random value x & y within 10 by 10 area
        y = ((int) (Math.random() * 41))*10; //how to get x and y from playArea class?

//		placeFood(x,y); //make within playArea class to move image
    }

}// Food class