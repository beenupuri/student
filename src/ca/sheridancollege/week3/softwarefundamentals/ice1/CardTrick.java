/*          Class: SYST 17796 - Fundamentals of Software Design and Development
 *     Assignment: ICE 1
 *    Author Name: Beenu Puri
 *    Sheridan ID: puribee
 * Student Number: 991713401
 *           Date: 24 May 2023
 * 
 * @author beenupuri
 */

 package ca.sheridancollege.week3.softwarefundamentals.ice1;

 /**
  * A class that fills a magic hand of 7 cards with random Card Objects
  * and then asks the user to pick a card and searches the array of cards
  * for the match to the user's card. To be used as starting code in ICE 1
  * @author beenu <- Co-Author; provided base framework
  */
 
 import java.util.Scanner;
 
 public class CardTrick {    
     public static void main(String[] args)
     {
         //#region Object / Variable Creation
         Card[] magicHand = new Card[7]; //stores the hand
         Scanner get = new Scanner(System.in);   //creates a Scanner object for user input
//         String sCertain = "";    //Allows user to change their mind <- Removed; made redundant
         String[] userInput = {"suit", "value"}; //user's input, default values will be overwritten and are for descriptive purposes only
         String sResult = "I'm sorry, your chosen card does not match one in my hand.";  //losing output
         //#endregion Object / Variable Creation
 
         //#region Draw Hand
         for (int iHand=0; iHand < magicHand.length; iHand++)    //cycles through the 7 cards; creates a new one each cycle
         {
             Card newDraw = new Card();  //draws a card
             newDraw.setSuit();  //sets card's suit
             newDraw.setValue(); //sets card's value
             magicHand[iHand] = newDraw; //stores card in hand
 
             //#region displays cards in hand; testing purposes only
 //            System.out.printf("%s of %s%n",
 //                magicHand[iHand].getValueString(),
 //                magicHand[iHand].getSuit());  //#endregion display hand
         }   //#endregion draw the hand
 
         /* Removed: Switched for new Lucky Card
         //#region User Pick a Card 
         while(!sCertain.equals("Yes")) {    //loops back here if user changes mind
             System.out.printf("%n%s%n%s",   //asks for / stores user's guess (suit)
                 "('Clubs') ('Spades') ('Diamonds') ('Hearts')",
                 "Input your card's suit from the above options: ");
             userInput[0] = get.nextLine();
 
             System.out.printf("%n%s%n%s",   //asks for / stores user's guess (value)
                 "('Ace') ('2') ('3') ('4') ('5') ('6') ('7') ('8') ('9') ('10') ('Jack') ('Queen') ('King')",
                 "Input your card's value from the above options: ");
             userInput[1] = get.nextLine();
 
             System.out.printf("%nYou have entered the %s of %s. Are you sure? ('Yes') ('No') ",
                 userInput[1], userInput[0]);    //displays users guess, allows for a re-guess before checking hand
             sCertain = get.nextLine();  //note: no error checking. "ace" will always return a wrong answer (lack of capitalization)
         } //#endregion User Pick a Card
         */
         
         //#region ADDED: Lucky Card Generation
         Card LuckyCard = new Card();  //original program didn't rely on user's input being committed to an object
         LuckyCard.setSuit(2);   //sets the suit of the lucky card manually
         LuckyCard.setValue(6);     //sets the value of the card manually
         userInput[0] = LuckyCard.getSuit();  //translates the suit into userinput to prevent further code needing to change
         userInput[1] = LuckyCard.getValueString();//as above for value; this is not up to normal par but instead a 2-minute fix that satisfies the purpose of the exercise
         //#endregion Lucky Card Generation
 
         //#region check guess
         for(int iHand = 0; iHand < magicHand.length; iHand++) { //cycles through hand to see if guess matches a card
             if(magicHand[iHand].getSuit().equals(userInput[0]) && magicHand[iHand].getValueString().equals(userInput[1]))
                 sResult = "You are magical! Your chosen card is in my hand!";   //if guess is correct, change output statement
         }   //continue cycling til done //#endregion check guess
 
         System.out.printf("%n%s",sResult);  //display win/lose
         get.close();    //closes scanner to prevent memory leaks
     }
 }
