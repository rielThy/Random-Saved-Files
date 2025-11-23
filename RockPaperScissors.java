package miniprojects;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissor"};

        boolean running = true;

        int playerScore = 0;
        int computerScore = 0;

        do {
            System.out.print("\n\nRock, Paper, or Scissor (Type \"quit\" to exit): ");
            String userInput = input.nextLine().toLowerCase();

            String computerInput = choices[random.nextInt(choices.length)];

//---------------------------------------------------------------------------------------------------------------------------------------
            //If user quits
            if (userInput.equalsIgnoreCase("quit")) {
                running = false;
            }

            //If user pick rock
            else if (userInput.equalsIgnoreCase("rock") && computerInput.equalsIgnoreCase("scissor")) {
                System.out.println("Your pick: " + userInput + " |Computer pick: " + computerInput);
                playerScore++;
                System.out.print("Your score: " + playerScore);
                System.out.print("\tComputer Score: " + computerScore);
            } else if (userInput.equalsIgnoreCase("rock") && computerInput.equalsIgnoreCase("paper")) {
                System.out.println("Your pick: " + userInput + " |Computer pick: " + computerInput);
                computerScore++;
                System.out.print("Your score: " + playerScore);
                System.out.print("\tComputer Score: " + computerScore);
            } else if (userInput.equalsIgnoreCase("rock") && computerInput.equalsIgnoreCase("rock")) {
                System.out.println("Your pick: " + userInput + " |Computer pick: " + computerInput);
                System.out.println("It's a Tie!");
                System.out.print("Your score: " + playerScore);
                System.out.print("\tComputer Score: " + computerScore);
            }

            //If user pick paper
            else if (userInput.equalsIgnoreCase("paper") && computerInput.equalsIgnoreCase("rock")) {
                System.out.println("Your pick: " + userInput + " |Computer pick: " + computerInput);
                playerScore++;
                System.out.print("Your score: " + playerScore);
                System.out.print("\tComputer Score: " + computerScore);
            } else if (userInput.equalsIgnoreCase("paper") && computerInput.equalsIgnoreCase("scissor")) {
                System.out.println("Your pick: " + userInput + " |Computer pick: " + computerInput);
                computerScore++;
                System.out.print("Your score: " + playerScore);
                System.out.print("\tComputer Score: " + computerScore);
            } else if (userInput.equalsIgnoreCase("paper") && computerInput.equalsIgnoreCase("paper")) {
                System.out.println("Your pick: " + userInput + " |Computer pick: " + computerInput);
                System.out.println("It's a Tie!");
                System.out.print("Your score: " + playerScore);
                System.out.print("\tComputer Score: " + computerScore);
            }

            //If user pick scissor
            else if (userInput.equalsIgnoreCase("scissor") && computerInput.equalsIgnoreCase("paper")) {
                System.out.println("Your pick: " + userInput + " |Computer pick: " + computerInput);
                playerScore++;
                System.out.print("Your score: " + playerScore);
                System.out.print("\tComputer Score: " + computerScore);
            } else if (userInput.equalsIgnoreCase("scissor") && computerInput.equalsIgnoreCase("rock")) {
                System.out.println("Your pick: " + userInput + " |Computer pick: " + computerInput);
                computerScore++;
                System.out.print("Your score: " + playerScore);
                System.out.print("\tComputer Score: " + computerScore);
            } else if (userInput.equalsIgnoreCase("scissor") && computerInput.equalsIgnoreCase("scissor")) {
                System.out.println("Your pick: " + userInput + " |Computer pick: " + computerInput);
                System.out.println("It's a Tie!");
                System.out.print("Your score: " + playerScore);
                System.out.print("\tComputer Score: " + computerScore);
            } else {
                System.out.print("Invalid input...");
            }
//---------------------------------------------------------------------------------------------------------------------------------------
            if (playerScore == 5) { //This runs if player wins
                System.out.println("\n\nYou WON!");
                System.out.printf("Final Score: [%d / %d]", playerScore, computerScore);

                System.out.print("\nPlay again? [Y/n]: ");
                String playAgain = input.nextLine();

                if (playAgain.equalsIgnoreCase("n")) {
                    running = false;
                } else if (playAgain.equalsIgnoreCase("Y")) {
                    //Game continues again...
                    playerScore = 0;
                    computerScore = 0;
                } else {
                    System.out.print("Invalid Input...");
                }
            }

            else if (computerScore == 5) { //This runs if computer wins
                System.out.println("\n\nYou LOST!");
                System.out.printf("Final Score: [Player: %d / Computer: %d]", playerScore, computerScore);
                
                System.out.print("\nPlay again? [Y/n]: ");
                String playAgain = input.nextLine();

                if (playAgain.equalsIgnoreCase("n")) {
                    running = false;
                } else if (playAgain.equalsIgnoreCase("Y")) {
                    //Game continues again...
                    playerScore = 0;
                    computerScore = 0;
                } else {
                    System.out.print("Invalid Input...");
                }
            }

        } while (running);

        System.out.println("\nExiting Program...");

        input.close();
    }
}
