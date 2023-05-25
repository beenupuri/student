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
 * A class that models playing card Objects. Cards have 
 * a value (note that Ace = 1, Jack -11, Queen =12, King = 13)
 * A suit (clubs, hearts, spades, diamonds).
 * There are 52 cards in a deck, no jokers.
 * This code is to be used in ICE1. When you create your own branch,
 * add your name as a modifier.
 * @author beenu <- Co-Author; provided base framework
 */

import java.lang.Math;

public class Card {
    private String suit; //clubs, spades, diamonds, hearts
    private int value;//1-13
    private double dTemp;   //stores a temporary random number in a double
    private int iTemp;  //converts temp double to an integer
    private String sValue;  //holds card value in a more readable (user-friendly) string variable
 
    //readable labels for suits and values rather than integers
    public static final String [] SUITS = {"Clubs", "Spades", "Diamonds", "Hearts"};
    public static final String [] VALUES = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
 
    public String getSuit() {  //gets the suit
        return suit;
    }
    public void setSuit() {    //randomizes the suit and stores it
        dTemp = Math.random() * 4; //these three lines could be changed to a single one without the need of iTemp and dTemp
        iTemp = (int) dTemp;   //no points for efficiency given and this is easier to read / understand
        this.suit = SUITS[iTemp];  //as well as test for errors
    }
    public void setSuit(int i) {
        this.suit = SUITS[i];
    }

    public int getValue() {    //gets the value of the card
        return value;
    }
    public void setValue() {   //randomizes the value and stores it
        dTemp = Math.random() * 13;    //see above for comments
        iTemp = (int) dTemp;
        this.value = iTemp;
    }
    public void setValue(int i) {
        this.suit = SUITS[i];
    }

    public String getValueString() {    //gets the value of the string
        setValueString();               // (in a readable format)
        return this.sValue;
    }
    public void setValueString() {  //converts the integer value of card to string
        this.sValue = VALUES[value];
    }
}
