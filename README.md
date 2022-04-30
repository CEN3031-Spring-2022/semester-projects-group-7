![image](https://user-images.githubusercontent.com/56174126/166113156-4cca028e-a9e9-4308-bd18-79a33e0d33dc.png)

Group Contract: https://docs.google.com/document/d/1mxnc9-wFADE_DrKvBGJeeW6bBEolSrwWFI9HRKmoWT8/edit?usp=sharing

Trello: https://trello.com/b/tgY8jsoV/cen3031-group-7-javascryption

## JavaScryption - A quick introduction
Javascryption is a very barebones JavaFX card game utilizing heavy inspiration from the card game “Inscryption”. The scope of this project was to build a functioning game where you could play against an enemy opponent and win the game. The functionality of the card battling mechanics should behave similiar to the of Inscryption, however, there is no rogue-like mechanics or behavior besides the simple deck-building functionality of the program.
The goal of the game is to win against your opponent. This is achieved by dealing more damage than you receive. Damage is dealt by a card being in a “lane” with no card in the opposing “lane”, if this is not  the case, the cards will deal damage to each other. If the player deals damage to the opponent, the health "scale" tips in the players favor, however, if dealt damage by the opponent, the scale will begin tipping back in the oppopnents favor. If equivelent damage is dealt, the scale will tip back to its starting location. The player receives a normal deck along with a squirrel deck. Squirrels are useful for “sacrificing”, as most cards will need a blood sacrifice to be played.

## Major Features
- Card Battling and winning/losing game states
- Dynamic Card Graphics
- Custom Deck Creation and reading from a file
- Enemy Behavior read from a file

## Program Demonstration
  ### Custom Deck and Enemy Deck Behavior
  ![Custom Deck Behavior](https://i.gyazo.com/409050e16565e849b2ed2aa6d815d09d.gif)
  ### Example of Overkill Damage
    - Here we can see "Overkill damage" being applied, in which a card in the enemies back row is damaged for the remainder of the
      attackers attack power subtracted from the front row enemies health pool. As we can see, the Snapper here takes 1 damage
      even though it is in the back row because the squirrel in the front row only has 1 health point.
  ![Overkill Damage](https://i.gyazo.com/50d7a45586b563e98c5f4df5304622f9.gif)
  ### Example of Sigils, Sacrifice, and Health Scale
    - The Adder card here has a "touch of death" sigil, meaning no matter the health of the enemy, the Adder will instantly
      destroy the other card.
  ![Sigils,Battle,Health](https://gyazo.com/971e49cf8c4dc385d5029e6e9f617b8c.gif)
  
  ### Winning and losing the game
    - Winning functions the exact same so I left out the demonstration, however, it is fully working as intended. As we can see,
      the scale tips further and further in the enemies favor as it deals damage to us. Eventually when the scale tips, the game
      is lost.
  ![Win/Lose Conditions](https://i.gyazo.com/42a5f24db7d7974a2c1c5bf4478b3d29.gif)

## External Libraries Utilized
  - JavaFX

## Assumptions and Dependencies
Ideally, any computer that has the Java Runtime Environment and a desktop environment installed should be able to use the GUI of this program. The specification on how to achieve this state is solely up to the user of the computer and the only foreseeable issues are an outdated version of the JRE or an operating system that specifically blocks the dependencies listed.


## UML Diagram
<img width="1743" alt="Sprint3UML" src="https://user-images.githubusercontent.com/56174126/166112254-9d492d13-3e3e-4c56-a598-ce9162258288.png">
