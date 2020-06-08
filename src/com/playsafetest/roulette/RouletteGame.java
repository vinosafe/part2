package com.playsafetest.roulette;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RouletteGame {
//
//  private static List<Player> configurePlayers() {
//    List<Player> players = new ArrayList();
//    Player player1 = new Player("Vincent");
//    Player player2 = new Player("James");
//    players.add(player1);
//    players.add(player2);
//    getPlayersFromFile();
//    return players;
//  }

  private static List<Player> getPlayersFromFile (){
    List<Player> players = new ArrayList();
    try {
      File myObj = new File("players.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        Player player = new Player(data);
        players.add(player);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return players;
  }

  public static void main(String[] args) {

    // 1. Players
    List<Player> players = getPlayersFromFile();
    //2. Bet
    Scanner keyboard = new Scanner(System.in);
    Random generator = new Random();
    int rouletteNum = 0;
    char response = 'y';
    int spin = 0;
    while (response == 'y' || response == 'Y') {
      //2. Run Roulette
      rouletteNum = generator.nextInt(37);
      spin++;
      for (Player player : players) {
        System.out.println(player.getName());
        int choice;
        int number;
        double amount;

        int resultMultiple = 0;


        System.out.print("0 - Even\n1 - Odd\n2 - Number\n");
        choice = -1;
        while (choice < 0 || choice > 2) {
          System.out.print("Place your bet on: ");
          choice = keyboard.nextInt();
        }
        number = 0;
        if (choice == 2) {
          while (number < 1 || number > 36) {
            System.out.print("Place your bet on number(1-36): ");
            number = keyboard.nextInt();
          }
        }
        System.out.print("Enter your bet amount: ");
        amount = keyboard.nextDouble();


        //3. Determine win or lose
        if (choice == 2) {
          if (rouletteNum == number)
            resultMultiple = 36;
          else
            resultMultiple = 0;
        } else {
          if ((choice == 0) && ((rouletteNum % 2) == 0))
           {
            resultMultiple = 2;
          }
          if ((choice == 1) && ((rouletteNum % 2) != 0)){
            resultMultiple = 2;
          }
        }

        //4. Print out game result, win/lose amount
        BettingActivity bettingActivity = new BettingActivity();
        if (resultMultiple > 0)// Won
        {
          bettingActivity.setBetOutcome("WON");
        } else// Lost
        {
          bettingActivity.setBetOutcome("LOST");
        }
        if (choice == 0) {
          bettingActivity.setBetType("EVEN");
        }
        if (choice == 1) {
          bettingActivity.setBetType("ODD");
        }
        if (choice == 2) {
          bettingActivity.setBetType("" + choice);
        }
        double winnings = (resultMultiple) * amount;
        bettingActivity.setWinnings(winnings);
        player.getBettingActivities().add(bettingActivity);
        System.out.println("-------------------------------------------");
        System.out.println("------------ next player betting ----------");
        System.out.println("-------------------------------------------");

      }// end of betting FOR PLAYERS

      // 5. Print results
      System.out.println("Number: " + rouletteNum);
      System.out.println("Player       Bet       Outcome       Winnings");
      System.out.println("---");
      for (Player player : players){
        //go through the activities
        for(BettingActivity bettingActivity : player.getBettingActivities()){
          System.out.println("" + player.getName() + "       " +
            bettingActivity.getBetType() + "      " +
            bettingActivity.getBetOutcome() + "       " +
            bettingActivity.getWinnings());
        }
      }

      //5. Ask for another game
      System.out.print("\nWould you like to play another game? (y/n) ");
      response = keyboard.next().charAt(0);
    }// END OF PLAY



  }

//  public static void main(String[] args) {
//
//    // 1. Players
//    List<String> players.txt = new ArrayList();
//    String player1 = "Vincent";
//    String player2 = "James";
//    players.txt.add(player1);
//    players.txt.add(player2);
//
//    String resultStatus = "";
//    String even = "EVEN";
//    String odd = "ODD";
//
//    Scanner keyboard = new Scanner(System.in);
//    Random generator = new Random();
//    double total = 0;
//    double winnings = 0;
//    double amount;
//    int choice, win = 0, lose = 0, spin = 0;
//    int number;
//    int rouletteNum;
//    int resultMultiple = 0;
//    char response = 'y';
//    int resultArr[] = new int[36];
//
//    //1.  input from console
////    System.out.println("Enter player name: ");
////    player1 = keyboard.next();
//
//    while (response == 'y' || response == 'Y' && total <= 0) {
//      System.out.print("0 - Even\n1 - Odd\n2 - Number\n");
//      choice = -1;
//      while (choice < 0 || choice > 2) {
//        System.out.print("Place your bet on: ");
//        choice = keyboard.nextInt();
//      }
//      number = 0;
//      if (choice == 2) {
//        while (number < 1 || number > 36) {
//          System.out.print("Place your bet on number(1-36): ");
//          number = keyboard.nextInt();
//        }
//      }
//      System.out.print("Enter your bet amount: ");
//      amount = keyboard.nextDouble();
//      // End input from console
//
//      //2. Run Roulette
//      rouletteNum = generator.nextInt(37);
//      spin++;
////      System.out.println("Roulette number: " + rouletteNum);
//      //3. Determine win or lose
//      if (choice == 2) {
//        if (rouletteNum == number)
//          resultMultiple = 36;
//        else
//          resultMultiple = 0;
//      } else {
//        if (((choice == 0) && (rouletteNum % 2 == 0))
//          || ((choice == 1) && (rouletteNum % 2 != 0))) {
//          resultMultiple = 2;
//        }
//      }
//
//      //4. Print out game result, win/lose amount
//      if (resultMultiple > 0)// Won
//      {
//        resultStatus = "WON";
//        winnings = (resultMultiple) * amount;
////        System.out.println("Congratulations!!! You win!");
////        System.out.printf("You have won %.2f \n", winnings);
////        System.out.printf("Here's your money back: $%.2f \n",
////          (resultMultiple + 1) * amount);
////        total = winnings + total;
////        win ++;
//        resultArr[rouletteNum]++;
//
//      } else// Lost
//      {
//        resultStatus = "LOST";
//        winnings = (resultMultiple) * amount;
////        System.out.println("You lose. Better luck next time!");
////        System.out.printf("You have lost %.2f \n",
////          (resultMultiple + 1) * amount);
////        total = total - (resultMultiple + 1) * (amount);
////        lose ++;
//        resultArr[rouletteNum]++;
////
////        if (total <= 0) {
////          break;
////        }
//
//      }
//
//      String betDisplay = "";
//      if (choice == 0) {
//        betDisplay = even;
//      } else if (choice == 1) {
//        betDisplay = odd;
//      } else if (choice == 2) {
//        betDisplay = "" + number;
//      }
//      System.out.println("Number: " + rouletteNum);
//      System.out.println("Player       Bet       Outcome       Winnings");
//      System.out.println("---");
//      System.out.println("" + player1 + "        " + betDisplay + "       " + resultStatus + "        " + winnings);
//      //5. Ask for another game
//      System.out.print("\nWould you like to play another game? (y/n) ");
//      response = keyboard.next().charAt(0);
//
//
//    }
//
//  }
}

