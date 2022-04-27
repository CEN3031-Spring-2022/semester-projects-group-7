package javascryption;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BoardReader {
	private Board boardToReturn;
	
	public BoardReader() {
		boardToReturn = new Board();
	}
	
	public void readInputFile(String fileName) throws FileNotFoundException {
		try {
			BufferedReader inputFile = new BufferedReader(new FileReader(fileName));
			String currentLine = inputFile.readLine();
			String cardName;
			int laneNumber;
			int posY = 0;
			
			while(currentLine != null) {
				String[] text = currentLine.split(",");
				if(!text[0].equalsIgnoreCase("pass")) {
					for (int i = 0; i < text.length; i++) {
						cardName = text[i];
						Card newCard = makeCardFromLibrary(cardName);
						i++;
						laneNumber = Integer.parseInt(text[i]);
						addCardToBoard(newCard, laneNumber, posY);
					}
				} 
				posY++;
				boardToReturn.setBoardSizeY(posY+2);
				currentLine = inputFile.readLine();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Card makeCardFromLibrary(String name) throws IOException {
		BufferedReader cardLibrary = new BufferedReader(new FileReader("CardLibrary.txt"));
		String line = cardLibrary.readLine();
		int attack;
		int blood;
		int health;
		
		while(line != null) {
		
			String[] text = line.split(",");
			for(int i = 0; i<text.length; i++) {
				//System.out.println(text[i]);
				//System.out.println(name);
				if(text[i].equalsIgnoreCase(name)) {
					blood = Integer.parseInt(text[++i]);
					health = Integer.parseInt(text[++i]);
					attack = Integer.parseInt(text[++i]);
					return (new Card(name, blood, health, attack));
				}
			}
			
			line = cardLibrary.readLine();
		}
		
		return null;
	}
	
	
	
	public void addCardToBoard(Card cardToAdd, int posX, int posY) {
		boardToReturn.addOpponentCardtoSpecificLocation(cardToAdd, posX, posY);
	}
	
	public Board getBoard() {
		return boardToReturn;
	}
	
	
}
