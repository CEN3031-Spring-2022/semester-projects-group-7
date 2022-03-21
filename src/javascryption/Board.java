package javascryption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Board
{
	private ArrayList<ArrayList<Card>> opponentBoard;
	private ArrayList<Card> playerBoard;
	
	public Board()
	{
		opponentBoard = new ArrayList<ArrayList<Card>>();
		playerBoard = new ArrayList<Card>();
		
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
	public void addEnemyCardtoBoard(Card enemyCard, int positionX) {
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
	
	public void removeEnemyCardFromBoard(int positionX, int positionY) {
		opponentBoard.get(positionX).set(positionY, null);
	}
	
	public void removeEnemyCardFromBoard(int positionX) {
		opponentBoard.get(positionX).set(0, null);
	}
	
	public void moveOpponentCardsForward() {
		for(int i=0; i<4; i++) {
			for(int j=1; j<opponentBoard.get(j).size(); j++) {
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


	//TODO probably with graphics.
	/*@Override
	public String toString() {
		return (this.getName() 
				+ "\tBlood:" +this.getBlood() 
				+ " Health:" +this.getHealth() 
				+ " Attack:"+this.getAttack());
	}*/
	
}