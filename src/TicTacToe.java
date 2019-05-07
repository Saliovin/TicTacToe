import java.util.Random;

public class TicTacToe {
    private Logic gameLogic;
    private UI userInterface;
    private Random rng;
    private int option;
    private boolean player1AI;
    private boolean player2AI;
    private AI computer;

    public TicTacToe() {
        gameLogic = new Logic();
        userInterface = new UI(gameLogic);
        rng = new Random();
        computer = new AI(this, rng);
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
            String state = this.getCurrentState();
            Integer move;

            if(((playerTurn == 1) && player1AI) || ((playerTurn == 2) && player2AI)) {
                move = computer.move(playerTurn, state);
                gameLogic.add(playerTurn, move);
            }
            else {
                while(true) {
                    move = userInterface.getPosition();

                    if(gameLogic.add(playerTurn, move)) {
                        break;
                    }

                    userInterface.printError(2);
                }
            }

            computer.addTempData(state, move, playerTurn);

            if(gameLogic.win(playerTurn)) {
                if(player1AI || player2AI) {
                    computer.addData(playerTurn);
                }

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

    public String getCurrentState() {
        StringBuilder state = new StringBuilder("         ");

        for(int i = 0; i < gameLogic.getPosArray1().size(); i++) {
            state.setCharAt(gameLogic.getPosArray1().get(i), 'X');
        }
        for(int i = 0; i < gameLogic.getPosArray2().size(); i++) {
            state.setCharAt(gameLogic.getPosArray2().get(i), '•');
        }

        return state.toString();
    }
}
