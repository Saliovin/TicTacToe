import java.util.Random;

public class TicTacToe {
    private Logic gameLogic;
    private UI userInterface;
    private Random rng;
    private int option;
    private boolean player1AI;
    private boolean player2AI;

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

            if(option == 1) {
                player1AI = false;
                player2AI = false;
            }
            else if(option == 2) {
                player1AI = false;
                player2AI = true;
            }
            else if(option == 3) {
                player1AI = true;
                player2AI = false;
            }
            else if(option == 4) {
                rounds = userInterface.getNumberOfRounds();
                player1AI = true;
                player2AI = true;
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
        gameLogic.reset();

        while(true) {
            userInterface.printState();
            userInterface.printTurn(playerTurn);

            //if(playerTurn == 1 && player1AI ==true) {
                //gameLogic.add(playerTurn, )
            //}
            while(true) {
                int pos = userInterface.getPosition();

                if(gameLogic.add(playerTurn, pos)) {
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
