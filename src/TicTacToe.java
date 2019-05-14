//The main class of the program. Handles the other classes to output the game.

public class TicTacToe {
    private Logic gameLogic;
    private UI userInterface;
    private boolean player1AI;
    private boolean player2AI;
    private boolean trainingMode;
    private AI computer;

    public TicTacToe() {
        gameLogic = new Logic();
        userInterface = new UI(gameLogic);
        computer = new AI();
    }

    public void start() {
        while(true) {
            player1AI = false;
            player2AI = false;
            trainingMode = false;

            userInterface.printMainMenu();
            int option = userInterface.getOption();
            int rounds = 1;

            if(option == 2) {
                player2AI = true;
            }
            else if(option == 3) {
                player1AI = true;
            }
            else if(option == 4) {
                rounds = userInterface.getNumberOfRounds();
                trainingMode = true;
                player1AI = true;
                player2AI = true;
            }
            else if(option == 5) {
                rounds = 0;
                userInterface.printAIStatistics(computer);
            }
            else if(option == 6){
                break;
            }

            while(rounds > 0) {
                startGame();
                rounds--;
            }
        }
    }

    public String getCurrentState() {
        StringBuilder state = new StringBuilder("         ");

        for(int i = 0; i < gameLogic.getPlayer1PositionsArray().size(); i++) {
            state.setCharAt(gameLogic.getPlayer1PositionsArray().get(i), 'X');
        }
        for(int i = 0; i < gameLogic.getPlayer2PositionsArray().size(); i++) {
            state.setCharAt(gameLogic.getPlayer2PositionsArray().get(i), 'O');
        }

        return state.toString();
    }

    private void startGame() {
        int playerTurn = 1;
        gameLogic.resetArrays();

        while(true) {
            userInterface.printState();
            userInterface.printTurn(playerTurn);
            String state = this.getCurrentState();
            Integer move;

            if(((playerTurn == 1) && player1AI) || ((playerTurn == 2) && player2AI)) { //If AI is on for the current player, make the AI object move.
                move = computer.move(playerTurn, state, trainingMode);
                gameLogic.addPosition(playerTurn, move);
            }
            else {
                while(true) {
                    move = userInterface.getPosition();

                    if(gameLogic.addPosition(playerTurn, move)) {
                        break;
                    }

                    userInterface.printError(2);
                }
            }

            computer.addTempData(state, move, playerTurn);

            if(gameLogic.win(playerTurn)) {
                computer.addData(playerTurn);
                userInterface.printWinner(playerTurn);
                break;
            }
            else if(gameLogic.draw()) {
                userInterface.printDraw();
                break;
            }

            if(playerTurn == 1) {
                playerTurn = 2;
            }
            else {
                playerTurn = 1;
            }

            System.out.println();
        }
    }
}
