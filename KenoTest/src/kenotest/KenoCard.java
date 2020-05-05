/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenotest;

/**
 *This class used to create Keno card object
 * @author Smit
 * Author: Smitkumar Patel
 * Student Id: 000737859
 * Authorship Statement: I, Smitkumar Patel, 000737859 certify that this 
 * material is my original work. No other person's work has been used without 
 * due acknowledgement.
 */
public class KenoCard {
    
     //** The bet of the player **//
    private int bet;
    //** The number of balls matched in the Keno Machine selected ball **//
    private int matches;
    //** The winnings or reward for the player on single game**//
    private int winnings;
    //** Creates Keno ball object **//
    private KenoBall[] ball;

    /**
     * This method or constructor is used to initialize the bet and number of
     * Keno ball objects selected
     *
     * @param n used to get the number of Keno ball objects selected
     * @param bet used to get or initialize the bet
     */
    public KenoCard(int n, int bet) {
        this.bet = bet;
        ball = new KenoBall[n];
        boolean[][] ballRepetition = new boolean[4][20]; // Creates an array to be used on checking repetitions

        int counter = 0;
        while (counter < ball.length) {
            int color = (int) (Math.random() * 4);       // Selects random row or color for the ball
            int number = (int) (Math.random() * 20);     // Selects random number for the ball

            // Checks if the selected ball is repeated
            if (!ballRepetition[color][number]) {
                ball[counter] = new KenoBall(number + 1, color);
                ballRepetition[color][number] = true;
                counter++;
            }
        }
    }

    /**
     * This method is used to match the selected Keno ball objects on card to
     * the selected Keno ball objects from the Keno machine object
     *
     * @param ball Keno ball object that is used to compare.
     */
    public void ballSelected(KenoBall ball) {
        String output = ""; // Used to display the Keno ball from Keno machine
        for (int i = 0; i < this.ball.length; i++) {
            if (this.ball[i].matches(ball)) {
                matches++;  // Increments the instance variable matches if the two balls matched
                output = ball + "* "; // Adds asterisk to the Keno ball from the machine if it is macthed to the card Keno balls
                break;
            } else {
                output = ball + " ";
            }
        }
        System.out.print(output); // Displays the Keno ball from Keno machine
    }

    /**
     * This method is used to determine and return the winnings or reward
     *
     * @return the winnings or reward for the player
     */
    public int payout() {
        //Computes the winnings of less than 10 balls selected
        if (ball.length < 10) {
            double winCounter = matches - Math.round((ball.length * 0.5) + 0.4); 
            if (winCounter >= 0) {
                winnings += bet;

                while (winCounter > 0) {
                    winCounter--;
                    winnings += winnings;
                }
            }
        } // Computes the winnings of more than or equals 10 ten balls selected
        else if (ball.length >= 10) {
            double winCounter = Math.round((ball.length * 0.15) - 0.5) - matches;
            if (winCounter >= 0) {
                winnings += bet * 2;
                while (winCounter > 0) {
                    winCounter--;
                    winnings += winnings;
                }
            }
        }
        return winnings;
    }

    /**
     * These method returns the number of matches per game
     *
     * @return the number of matches per game
     */
    public int getNumMatches() {
        return matches;
    }

    /**
     * This method is used to return a String representation for the Keno card
     * object
     *
     * @return the chosen Keno ball objects, the number of matched balls, and
     * the winnings or the reward
     */
    @Override
    public String toString() {
        String cardReport = "Card: ";
        for (int i = 0; i < ball.length; i++) {
            cardReport += ball[i] + " ";
        }
        cardReport += "Matches: " + matches + ", Bet: " + bet + ", Winnings: " + winnings;
        return cardReport;
    }
    
}
