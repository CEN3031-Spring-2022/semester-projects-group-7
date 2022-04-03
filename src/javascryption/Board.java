package javascryption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Board
{
	private ArrayList<ArrayList<Card>> opponentBoard;
	private ArrayList<Card> playerBoard;
	private int boardSizeY = 10; //we'll set this dynamically in the future.
	private int boardSizeX = 4; //might be cool to change this as a feature.
	private int boardHealth = 5; //gonna assume the player wins if they get it up to 10.
	
	public Board()
	{
		opponentBoard = new ArrayList<ArrayList<Card>>();
		playerBoard = new ArrayList<Card>();
		initializeOpponentBoard();
		initializePlayerBoard();
	}
	
	private void initializeOpponentBoard() {
		for(int i=0; i<boardSizeX; i++)
			opponentBoard.add(new ArrayList<Card>());
		for(int i=0; i<boardSizeX; i++) {
			for(int j=0; j<boardSizeY; j++)
				opponentBoard.get(i).add(null);
		}
	}
	
	private void initializePlayerBoard() {
		for(int i=0; i< boardSizeX; i++)
			playerBoard.add(i, null);
	}
	
	public void addPlayerCardtoBoard(Card playerCard, int position) {
		playerBoard.set(position, playerCard);
	}
	
	public void removePlayerCardFromBoard(int position) {
		playerBoard.set(position, null);
	}
	
	public Card getPlayerCardByPos(int position) {
		return playerBoard.get(position);
	}
	
	
	/**
	 * This loops through the opponent's board until
	 * it finds somewhere empty. It then places the card 
	 * on the open slot in the given x position.
	 * 
	 * @param enemyCard Card you want to add
	 * @param positionX Position on the x-axis (lane) that you want to add it.
	 */
	public void addOpponentCardtoBoard(Card enemyCard, int positionX) {
		boolean locationContainsCard = true;
		int positionY = 0;
		while (locationContainsCard) {
			if(opponentBoard.get(positionX).get(positionY) == null)
				locationContainsCard = false;
			else
				positionY++;
		}
		opponentBoard.get(positionX).set(positionY, enemyCard);
	}
	
	//I'll break this up into a lot of helper functions later. This is a mess. 
	//Just trying to get it going and it ballooned up as I was working on it.
	public void attack(int attackerPos, boolean playerIsAttacking) {
		int overkillDamage;
		
		if (playerIsAttacking && this.getOpponentCardByPosition(attackerPos) == null) {
			dealBoardDamage(playerBoard.get(attackerPos).getAttack());
			return;
		}
		else if (!playerIsAttacking && this.getPlayerCardByPos(attackerPos) == null) {
			dealBoardDamage((getOpponentCardByPosition(attackerPos).getAttack())*-1);
			return;
		}
		
		if(playerIsAttacking) { //if overkill damage is dealt, it is dealt to the card in the second row.
			overkillDamage = playerBoard.get(attackerPos).cardAttacks(playerBoard, this.getFrontRow(), attackerPos);
			if(overkillDamage > 0 && this.getSecondRow().get(attackerPos) != null)
				getSecondRow().get(attackerPos).removeHealth(overkillDamage);
		}
		else { //player only has one row, so no overkill applies here
			getOpponentCardByPosition(attackerPos).cardAttacks(getFrontRow(), playerBoard, attackerPos);
		}

		deleteCardsWithoutHP();
	}
	
	public void deleteCardsWithoutHP() {
		//only looking throw the first two rows of opponentBoard.
		//They are the only sources in the opponent's board that can take damage.
		for (int i=0; i<boardSizeX; i++) {
			if (this.playerBoard.get(i) != null && this.playerBoard.get(i).getHealth() <= 0)
				this.removePlayerCardFromBoard(i);
			
			if (this.getFrontRow().get(i) != null && this.getOpponentCardByPosition(i).getHealth() <= 0)
				this.removeOpponentCardFromBoard(i);
			
			if (this.getSecondRow().get(i) != null && this.getSecondRow().get(i).getHealth() <= 0)
				this.removeOpponentCardFromBoard(i, 1);
		}
	}
	
	public void addOpponentCardtoSpecificLocation(Card enemyCard, int posX, int posY) {
		opponentBoard.get(posX).set(posY, enemyCard);
	}
	
	public void removeOpponentCardFromBoard(int positionX, int positionY) {
		opponentBoard.get(positionX).set(positionY, null);
	}
	
	public void removeOpponentCardFromBoard(int positionX) {
		opponentBoard.get(positionX).set(0, null);
	}
	
	//This is a mess, we should refactor this later.
	public void moveOpponentCardsForward() {
		for(int i=0; i<boardSizeX; i++) { 
			for(int j=1; j<boardSizeY; j++) { //loops through all locations in 2d arraylist
				if (opponentBoard.get(i).get(j) != null) { //if card exists
					if(opponentBoard.get(i).get(j-1) == null) { //if empty space is in front of card
						Card tempCard = opponentBoard.get(i).get(j).getCard(); //move card to temp variable
						opponentBoard.get(i).set(j, null); //remove card from board
						opponentBoard.get(i).set(j-1, tempCard); //place temp variable one up
					}
				}
			}
		}
	}
	
	public Card getOpponentCardByPosition(int positionX) {
		return opponentBoard.get(positionX).get(0);
	}
	
	public Card getOpponentCardByPosition(int posX, int posY) {
		return opponentBoard.get(posX).get(posY);
	}
	
	public ArrayList<Card> getPlayerBoard(){
		return playerBoard;
	}
	
	public ArrayList<Card> getFrontRow(){
		ArrayList<Card> frontRow = new ArrayList<Card>();
		for (int i=0; i<boardSizeX; i++)
			frontRow.add(opponentBoard.get(i).get(0));
		
		return frontRow;
	}
	
	public ArrayList<Card> getSecondRow(){
		ArrayList<Card> SecondRow = new ArrayList<Card>();
		for (int i=0; i<boardSizeX; i++)
			SecondRow.add(opponentBoard.get(i).get(1));
		
		return SecondRow;
	}
	
	public void dealBoardDamage(int damage) {
		boardHealth += damage;
	}
	
	public int getBoardHealth() {
		return boardHealth;
	}
}

