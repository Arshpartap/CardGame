
package cardgame;

import java.util.Random;
import java.util.Scanner;

/**
 * This class models a simple card guessing game
 * 
 * @author Arshpartap Singh 
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Scanner input = new Scanner(System.in);

        // Create an array to hold 7 cards
        Card[] hand = new Card[7];

        // We'll use Random to generate random numbers
        Random random = new Random();

        for (int i = 0; i < hand.length; i++) {
            int value = random.nextInt(13) + 1;
            String suit = Card.SUITS[random.nextInt(4)];

            Card card = new Card(suit, value);
            hand[i] = card;
        }

        // print them out for debugging purposes
        System.out.println("Here are the cards in the hand");
        for (Card card : hand) {
            System.out.printf("%d of %s\n", card.getValue(), card.getSuit());
        }

        // Now ask the user for a card
        System.out.println("Pick a suit for your card");
        for (int i = 0; i < Card.SUITS.length; i++) {
            System.out.println((i + 1) + ": " + Card.SUITS[i]);
        }
        int suit = input.nextInt();

        System.out.println("Enter a value (1 to 13)");
        int value = input.nextInt();

        Card userGuess = new Card(Card.SUITS[suit - 1], value);

        boolean match = false;
        for (Card card : hand) {
            if (card.getValue() == userGuess.getValue()
                    && card.getSuit().equals(userGuess.getSuit())) {
                match = true;
                break;
            }
        }
        
        printInfo(match);
    }

        //modified the printInfo()
        public static void printInfo(boolean match) {
            
            if(match == true){
                System.out.println("Right guess");
            }
            
            else {
                System.out.println("No match");
            }
            
            System.out.println("My name is Arshpartap Singh. I am currently enrolled in Computer Programming diploma at Sheridan College.");
        }

    }
    





class Card {

    public Card() {
    }

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    
    
   private String suit; //clubs, spades, diamonds, hearts
   private int value;//1-13

   public static final String [] SUITS = {"Hearts", "Diamonds", "Spades", "Clubs"};
    /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
   
   
    
}
