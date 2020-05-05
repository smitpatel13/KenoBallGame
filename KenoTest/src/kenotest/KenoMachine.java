/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenotest;

/**
 *This method is used to select random different Keno balls from the Keno
 *Machine object
 * @author Smit
 * Author: Smitkumar Patel
 * Student Id: 000737859
 * Authorship Statement: I, Smitkumar Patel, 000737859 certify that this 
 * material is my original work. No other person's work has been used without 
 * due acknowledgement.
 */
public class KenoMachine {
     //** Creates 80 Keno balls object **//
    private KenoBall[][] ball = new KenoBall[4][20];
    //** Creates 80 boolean arrays **//
    private boolean[][] ballRepetition = new boolean[4][20];

    /**
     * This method or constructor is used to initialize the number and color of
     * the object
     */
    public KenoMachine() {
        for (int row = 0; row < ball.length; row++) {
            for (int col = 0; col < ball[row].length; col++) {
                int num = col + 1;
                switch (row) {
                    case 0:
                        ball[row][col] = new KenoBall(num, 0); // Creates white Keno ball
                        break;
                    case 1:
                        ball[row][col] = new KenoBall(num, 1); // Creates blue Keno ball
                        break;
                    case 2:
                        ball[row][col] = new KenoBall(num, 2); // Creates red Keno ball
                        break;
                    case 3:
                        ball[row][col] = new KenoBall(num, 3); // Creates green Keno ball
                        break;
                }
            }
        }
    }

    /**
     * This method is used to select random different Keno balls from the Keno
     * Machine object
     *
     * @return returns the selected Keno ball
     */
    public KenoBall nextBall() {
        while (true) {
            int row = (int) (Math.random() * 4);  // Selects random color or row for the ball
            int col = (int) (Math.random() * 20); // Selects random number of the ball

            // Checks if the randomly selected ball is repeated
            if (!(ballRepetition[row][col])) {
                ballRepetition[row][col] = true;
                return ball[row][col];
            }
        }
    }
}
