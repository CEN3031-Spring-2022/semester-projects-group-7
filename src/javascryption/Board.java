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
	
	public Board()
	{
		opponentBoard = new ArrayList<ArrayList<Card>>();
		playerBoard = new ArrayList<Card>();
		initializeOpponentBoard();
		
	}
	
	private void initializeOpponentBoard() {
		for(int i=0; i<4; i++)
			opponentBoard.add(new ArrayList<Card>());
		for(int i=0; i<4; i++) {
			for(int j=0; j<boardSizeY; j++)
				opponentBoard.get(i).add(null);
		}
	}
	
	public void addPlayerCardtoBoard(Card playerCard, int position) {
		playerBoard.add(position, playerCard);
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
		for(int i=0; i<4; i++) { 
			for(int j=1; j<boardSizeY; j++) { //loops through all locations in 2d arraylist
				if (opponentBoard.get(i).get(j) != null) { //if card exists
					if(opponentBoard.get(i).get(j-1) == null) { //if empty space is in front of card
						Card tempCard = opponentBoard.get(i).get(j).getCard();
						opponentBoard.get(i).set(j, null);
						opponentBoard.get(i).set(j-1, tempCard);
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
	
}