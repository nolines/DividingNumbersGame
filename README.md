### Problem

When a player starts, it incepts a random (whole) number and sends it to the second
player as an approach of starting the game. The receiving player can now always choose between adding one of {​1, 0, 1} to get to a number that is divisible by 3. Divide it by three. The resulting whole number is then sent back to the original sender.


### Approach

First of all, i wanted to implement the calls by over websocket but I started
to make the game logic first by runing on game class with holding states of Players and Game
Objects.

It includes some parts;

1) The main logic : 
    Includes round based implementation. There is an round input - game logic -round result
    It checks the players for whose turn its and make the move for the round. If the player is computer then
    it plays by itself by using a basic algorithm. If the player is human it asks for human input.
    (unfortunately, I did not have so much time implement this over websocket.)

2) User interactions, which created players (computer, human) and allows user to select operation.
And it sets the main logic.

3) Setup websocket: it created a basic websocket handler and server. TODO: it is not used for round based
game implementation.

### Supported Operations

PLAY_AGAINST_COMPUTER
PLAY_COMPUTERS

... and follow instructions on the command cline

### Acceptance

Game could be played by user-computer or computer-computer. 
Creates a new round for each turn
Assigns players
Switches players based on rounds
Game has status, so It could be traced by using this

### NOTE

Used DDD approach and used a lot of immutable objects.

This was done in 10 hours.

