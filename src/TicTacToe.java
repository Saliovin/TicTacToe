import java.util.Random;

public class TicTacToe {
    private Logic gameLogic;
    private UI userInterface;
    private Random rng;
    private int option;

    public TicTacToe() {
        gameLogic = new Logic();
        userInterface = new UI(gameLogic);
        rng = new Random();
    }

    public void start() {
        while(true) {
            userInterface.printMainMenu();
            option = userInterface.getOption();
            int rounds = 1;

            if(option == 4) {
                rounds = userInterface.getNumberOfRounds();
            }
            else if(option == 5) {
                break;
            }

            while(rounds > 0) {
                startGame();
                rounds--;
            }
        }
    }

    private void startGame() {

        int playerTurn = 1;

        while(true) {
            userInterface.printState();
            userInterface.printTurn(playerTurn);

            while(true) {
                int xPos = userInterface.getXCoordinate();
                int yPos = userInterface.getYCoordinate();

                if(gameLogic.add(playerTurn, xPos, yPos)) {
                    break;
                }

                userInterface.printError(2);
            }


            if(gameLogic.win(playerTurn)) {
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
