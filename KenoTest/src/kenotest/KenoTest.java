/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenotest;

import java.util.Scanner;
/**
 *
 * This program simulates the game Keno
 * @author Smit
 * Author: Smitkumar Patel
 * Student Id: 000737859
 * Authorship Statement: I, Smitkumar Patel, 000737859 certify that this 
 * material is my original work. No other person's work has been used without 
 * due acknowledgement.
 */
public class KenoTest {

      /**
     * This main method creates Keno machine and card objects, you can enter the
     * number of games, number of balls, and bet
     *
     * @param args unused
     */
    public static void main(String[] args) {

        // *** VARIABLES
        Scanner input = new Scanner(System.in); // Creates Scanner object
        KenoMachine machine;       // Creates Keno machine object
        KenoCard card;             // Creates Keno card object
        int numberOfGames;         // The number of games to be played
        int numberOfBalls;         // The number of balls to be selected on the Keno card
        int bet;                   // The bet for each game
        int totalMatches = 0;      // The total of ball matched of all the games
        double totalWinnings = 0;  // The total winnings of all the games
        double averageWinnings;    // The average winning or reward for all the game
        double averageReturn;      // The average return for every game

        // *** INPUT
        System.out.print("Number of Games? ");          // Prompt
        numberOfGames = input.nextInt();                // Inputs the number of games to be played
        System.out.print("Number of balls per game? "); // Prompt
        numberOfBalls = input.nextInt();                // Inputs the number of balls to be selected
        System.out.print("Bet per game in $? ");        // Prompt
        bet = input.nextInt();                          // Inputs the bet for every game

        // Loops the process for every game 
        for (int i = 1; i <= numberOfGames; i++) {
            card = new KenoCard(numberOfBalls, bet); // Creates another new Keno card
            machine = new KenoMachine();             // Creates another new Keno machine

            for (int x = 0; x < 20; x++) {
                card.ballSelected(machine.nextBall()); // Compares the selected ball in Keno machine on the balls selected in Keno card
            }
            totalWinnings += card.payout();            // Computes the winnings and add to the total winnings
            totalMatches += card.getNumMatches();      // Get the matches of ball on the game and add to the total match
            System.out.printf("%n%s%n%n", card);
        }

        // *** PROCESSING
        averageWinnings = totalWinnings / numberOfGames; // Computes the average winning for all the game
        averageReturn = (averageWinnings / bet) * 100;   // Computes the average return for all the game

        // *** OUTPUT
        //Displays the total winnings, average winnings, and average return
        System.out.printf("Total Winnings = $%.2f, Total Number of Matches = %d, Average Winnings = $%.2f, Average Return = %.1f%%", totalWinnings, totalMatches, averageWinnings, averageReturn);
    }
}

    

