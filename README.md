# Kalah Computer Game


## References
* [Wikipedia link](https://en.wikipedia.org/wiki/Kalah)

## Github 
https://github.com/SteveH1UK/kalah 

## Heroku (free) deployment

http://gentle-brook-23279.herokuapp.com/kalah/


## Game Description
### Overview
The game provides a Kalah board and a number of seeds (also called counters). The board has 12 small pits, called houses, on each side; and a big pit, called an end zone (this acts as a Store), at each end. The object of the game is to capture more seeds than one's opponent.

Each player controls the six houses and their seeds on the player's side of the board. The player's score is the number of seeds in the store to their right.
### Setup
At the beginning of the game, four seeds are placed in each house. This is the traditional method
### Playing
1. Players take turns sowing their seeds. On a turn, the player removes all seeds from one of the houses under their control. Moving counter-clockwise, the player drops one seed in each house in turn, including the player's own store but not their opponent's.
2. If the last sown seed lands in an empty house owned by the player, and the opposite house contains seeds, both the last seed and the opposite seeds are captured and placed into the player's store.
3. If the last sown seed lands in the player's store, the player gets an additional move. There is no limit on the number of moves a player can make in their turn.
4. When one player no longer has any seeds in any of their houses, the game ends. The other player moves all remaining seeds to their store, and the player with the most seeds in their store wins.

Implicit in these rules is that a player can only select a house with seeds in

## Number of users
Multiuser by using session state


## Model

       <--- Player 2 (North)
    --------------------------    
    13  12  11  10   9   8     
                              
    14                   7    
                             
    1    2   3   4   5   6      
    --------------------------     
      Player 1 (South) --->
         
    Pits 1 to 6 are player's 1 houses   
    Pit 7 is player's 1 store
    Pits 8 to 13 are player's 2 houses
    Pit 14 is player's 2 store  
    
## Building the application
1. Make sure you have Java 8 and Maven 3 downloaded and on the user's PATH
2. in the root directory run
```
   mvn package
```

## Running the application
Just execute the newly build application (within the target directory). Then in a browser window go to
[http://localhost:8080/kalah](localhost:8080/kalah)



## Use of Spring
1. Spring is used to allow the application to run within Tomcat via Spring Boot
2. Spring is used for the web tier (Spring MVC and Thymeleaf integration)


## Application package
### Game
This controls the playing of the game itself and implements the game's rules (as listed above)
### Board
This represents the Kalah board and therefore contains most of the state of the game
### Pit
A general pit (seed container)
### House (extends Pit)
### Store (extends Pit)
### Player
One of the two players in the game
### GameDto and PlayerDto
Two classes used to give a simple model for the view layer


## Web Package
### GameWebController
Handles web requests, delegating to the Game object (Stored in session state) and returning the GameDto after a move to the view (game.html Thymeleaf template). For session timeouts the game is restarted
### home.html
View to start the game
### game.html
View for the game itself. This uses Bootstrap grids to format the game with two flavours:
1. Laptop / Landscape Tablet - As per model above
2. Phone / Portrait Tablet - Players objects in two columns



