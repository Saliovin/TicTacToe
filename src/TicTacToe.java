import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
    private Logic gameLogic;
    private UI userInterface;
    private Scanner reader;


    public TicTacToe() {
        gameLogic = new Logic();
        userInterface = new UI();
        reader = new Scanner(System.in);
    }

    public void start() {
        int playerTurn = 1;

        while(true) {
            userInterface.printState(gameLogic);
            System.out.println("Player " + playerTurn +"'s turn");

            while(true) {
                System.out.print("Input X coordinate: ");
                int xPos = reader.nextInt();
                System.out.print("Input Y coordinate: ");
                int yPos = reader.nextInt();

                if(gameLogic.add(playerTurn, xPos, yPos)) {
                    break;
                }

                System.out.println("Wrong coordinate");
            }


            if(gameLogic.win(playerTurn)) {
                System.out.println("PLAYER " + playerTurn + " WINS!");
                break;
            }

            if(playerTurn == 1) {
                playerTurn = 2;
            }
            else {
                playerTurn = 1;
            }
        }
    }
}
