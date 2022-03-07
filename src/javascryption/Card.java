package javascryption;

public class Card {
	private String name; //name of the card
	private int health; //amount of health. TODO: Delete card when it reaches 0.
	private int attack; //amount of attack power.
	private int blood; //amount of blood required to put into play.
	
	/**
	 * Default constructor. This is for testing, not intended for actual use.
	 */
	public Card() {
		setName("Not Assigned");
		setHealth(1);
		setAttack(1);
		setBlood(1);
	}
	
	/**
	 * Constructs new card using the assigned values from the start. These can be read from a file.
	 * I called the setters here in case we desire to regulate these values more heavily later on.
	 * @param newName Name of the card.
	 * @param newHealth Amount of health.
	 * @param newAttack Amount of Attack.
	 * @param newBlood Amount of blood which it costs to put card into play.
	 */
	public Card(String newName, int newHealth, int newAttack, int newBlood) {
		setName(newName);
		setHealth(newHealth);
		setAttack(newAttack);
		setBlood(newBlood);
	}
	
	public void recieveAttack(int damageDealt) {
		setHealth(getHealth()-damageDealt);
		
		/*
		 * later on we need to put something here stating to delete
		 * the card if it no longer has enough health, we need to
		 * build up more of a framework for it first though.
		 */
	}
	
	/* From here on out it's just the usual setters and getters.
	 * The setters will be useful once we start being able to modify cards,
	 * but that won't be for a while.
	*/
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setHealth(int newHealth) {
		this.health = newHealth;
	}
	
	public void setAttack(int newAttack) {
		this.attack = newAttack;
	}
	
	public void setBlood(int newBlood) {
		this.blood = newBlood;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getAttack() {
		return this.attack;
	}
	
	public int getBlood() {
		return this.blood;
	}
}
