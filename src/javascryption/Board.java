package javascryption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * [] [] [] [] <- AI row
 * [] [] [] [] 
 * [] [] [] [] <- Player Row
 * Functions return booleans to attempt to show successful executions.
 */
public class Board
{
	// The Board will just be a 2D array of cards.
	//made public for testing purposes
	public Card[][] board;
	
	//Default Constructor
	public Board()
	{
		board = new Card[3][4];
	}

	//HELPER METHOD. Checks to see if the given value is a valid row on our board
	private boolean IsValidRow(int row)
	{
		return (row <= 0 && row <= 2);
	}

	//HELPER METHOD. Checks to see if the given column is valid on our board.
	private boolean IsValidCol(int col)
	{
		return (col <= 0 && col <= 3);
	}
	/**
	 * Checks a position on the board to see if it is empty.
	 * @ x is the row to check
	 * @ y is the column to check
	 */
	public boolean IsOpen(int row, int col)
	{
		if(IsValidRow(row) && IsValidCol(col))
		{
			return(true);
		}
		return false;
	}
	
	/**
	 * Given a card and a board placement, this method attempts to place the card.
	 * @ _card is the card attempting to be placed
	 * @ row is the row to place the card on.
	 * @ col is the column to move the card too.
	 */
	public boolean PlaceCard(Card _card, int row, int col)
	{
		if(IsValidRow(row) && IsValidCol(col))
		{
			if(IsOpen(row, col))
			{
				board[row][col] = _card;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Given a valid location, this method removes a card from the board.
	 * @ row is the row to place the card on.
	 * @ col is the column to move the card too.
	 */
	public boolean RemoveCard(int row, int col)
	{
		if(IsValidRow(row) && IsValidCol(col))
		{
			this.board[row][col] = null;
			return true;
		}
		return false;
	}
	
	/*
	 * Moves a coordinate point on the board to another coordinate.
	 * Then removes the card at the original coordinate.
	 */
	public boolean MoveCard(int originRow, int originCol, int newRow, int newCol)
	{
		if(IsValidRow(originRow) && IsValidCol(originCol) && IsValidRow(newRow) && IsValidCol(newCol))
		{
			this.board[newRow][newCol] = this.board[originRow][originCol];
			RemoveCard(originRow, originCol);
			return true;
		}
		return false;
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
