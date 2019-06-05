# TicTacToe
A simple TicTacToe game that you play on the console but with a learning AI.

How it works is actually pretty simple. What it does is that it records game states like this "..XOX.O.." which equates to:

_ _ X

O X _

O _ _

as a HashMap key and then links it to next move. It does this for both players and stores them temporarily. When a win condition is detected the recorded states and their corresponding moves are added permanently to another HashMap. Now when it's the AI's turn, it will look at the HashMap that contains previous won games' data if there is an exact match of the current game state. If there is, it will simply do the move linked in the HashMap, else, it randomly chooses an empty spot on the board. Basically it records winning games and when presented with an exact situation, it will simply make the same move as before.
