/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenotest;

/**
 *
 * This class used to create Keno ball object
 * @author Smit
 * Author: Smitkumar Patel
 * Student Id: 000737859
 * Authorship Statement: I, Smitkumar Patel, 000737859 certify that this 
 * material is my original work. No other person's work has been used without 
 * due acknowledgement.
 */
public class KenoBall {
    
    //** The number of the Keno Ball **//
    private int number;
    //** The color of the Keno ball **//
    private String color;

    /**
     * This method or constructor is used to initialize the color and number of the ball
     * @param number used to initialize the number of the ball
     * @param color used to initialize the color of the ball
     */
    public KenoBall(int number, int color) {
        this.number = number;
        switch (color) {
            case 0:
                this.color = "W"; // Assigns color white
                break;
            case 1:
                this.color = "B"; // Assigns color blue
                break;
            case 2:
                this.color = "R"; // Assigns color red
                break;
            case 3:
                this.color = "G"; // Assigns color green
                break;
        }
    }

    /**
     * This method is used to compare other Keno ball the instance Keno ball
     * @param other used to compare to the instance Keno ball
     * @return Return true if the ball match, otherwise false
     */
    public boolean matches(KenoBall other) {
        if (this.toString().equals(other.toString())) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * This method is used to return a String representation of the object
     * @return the color and the number of the ball as a String
     */
    @Override
    public String toString() {
        return number + color;
    }
    
}
