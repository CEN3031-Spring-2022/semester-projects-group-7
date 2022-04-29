package javascryption;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Deck {
	private ArrayList<Card> deck; //Array List of card objects is stored here.
	
	/**
	 * Default constructor, not sure which one we'll end up using so I did both.
	 */
	public Deck() {
		this.deck = new ArrayList<Card>();
	}
	
	/**
	 * Parameterized constructor. Takes in a pre existing deck of cards.
	 * @param newDeck Deck of cards to import.
	 */
	public Deck(ArrayList<Card> newDeck) {
		this.deck = new ArrayList<Card>();
		addMultipleCards(newDeck);
	}
	
	/**
	 * Adds cards to the deck individually
	 * @param newCard any given card that you want to add.
	 */
	public void addCard(Card newCard) {
		this.deck.add(newCard);
	}
	
	/**
	 * Adds any number of cards to the deck.
	 * @param newDeck an array list of cards.
	 */
	public void addMultipleCards(ArrayList<Card> newDeck) {
		for (Card newCard: newDeck)
			addCard(newCard);
	}
	
	/**
	 * Deletes a card.
	 * @param cardPos Position of card you wish to delete in Array List.
	 */
	public void deleteCardByPosition(int cardPos) {
		deck.remove(cardPos);
	}
	
	public void shuffleCards() {
		Random rand = new Random();
		int randNum;
		
		if (this.getSize() <= 1)
			return;
		
		ArrayList<Card> tempDeck = new ArrayList<Card>();
		for (Card copy: deck)
			tempDeck.add(copy);
		
		while (getSize() > 0)
			deleteCardByPosition(0);
		
		while (tempDeck.size() > 0) {
			randNum = rand.nextInt(tempDeck.size());
			addCard(tempDeck.get(randNum));
			tempDeck.remove(randNum);
		}
	}
	
	public ArrayList<Card> getDeck(){
		return this.deck;
	}
	
	/**
	 * input a position in the deck to get that card
	 * @param cardPos integer representing the position of the card. Starts at 0.
	 * @return Card object from given position.
	 */
	public Card getCardByPosition(int cardPos) {
		return deck.get(cardPos);
	}
	
	/**
	 * Adds a new card at the front of the deck.
	 * @param newCard new card to add.
	 */
	public void addCardToFront(Card newCard) {
		deck.add(0, newCard);
	}
	
	/**
	 * returns the current size of the arraylist
	 * @return integer showing the size.
	 */
	public int getSize() {
		return deck.size();
	}
	

	
	public void readDeckFromFile(String path){
		try{
			BufferedReader in = new BufferedReader(new FileReader(path));
			String line = null;
			String name;
			int blood;
			int health;
			int attack;
			Card currCard = null;
			
			while((line = in.readLine()) != null ){
				
				String[] textArr = line.split(",");
				for(int i = 0; i < textArr.length; ++i)
				{
					name = textArr[i];
					blood = Integer.parseInt(textArr[++i]);
					health = Integer.parseInt(textArr[++i]);
					attack = Integer.parseInt(textArr[++i]);
					if(textArr.length >= 5)
					{
						switch(textArr[++i].toLowerCase())
						{
						case "touchofdeath":
							currCard = new TouchOfDeathCard(name,blood,health,attack);
							break;
						case "bifurcatedstrike":
							currCard = new BifurcatedStrikeCard(name,blood,health,attack);
							break;
						}
					}
					else {
						currCard = new NormalCard(name,blood,health,attack);
					}

					addCard(currCard);
				}
			}
	
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public String toString() {
		if (this.getSize()<= 0)
			return ("Error: You have "+this.getSize()+" cards in your deck.");
		String output = "";
		output += "Number of cards: "+this.getSize()+"\n";
		
		for (Card newCard : this.deck)
			output+= newCard.toString()+"\n";
		
		return output;
	}
	
}
