import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private Logic gameLogic;
    private UI userInterface;
    private Scanner reader;
    private Random rng;


    public TicTacToe() {
        gameLogic = new Logic();
        userInterface = new UI(gameLogic);
        reader = new Scanner(System.in);
        rng = new Random();
    }

    public void start() {
        int playerTurn = 1;

        while(true) {
            userInterface.printState();
            System.out.println("Player " + playerTurn +"'s turn");

            while(true) {
                System.out.print("\tInput X coordinate: ");
                int xPos = reader.nextInt();
                System.out.print("\tInput Y coordinate: ");
                int yPos = reader.nextInt();

                if(gameLogic.add(playerTurn, xPos, yPos)) {
                    break;
                }

                System.out.println("Wrong coordinate");
            }


            if(gameLogic.win(playerTurn)) {
                userInterface.printState();
                System.out.println("PLAYER " + playerTurn + " WINS!");
                break;
            }
            else if(gameLogic.draw()) {
                userInterface.printState();
                System.out.println("DRAW!");
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
