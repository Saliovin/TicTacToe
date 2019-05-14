//This class handles all printing as well as user input.

import java.util.Scanner;

public class UI {
    private Logic gameLogic;
    private Scanner reader;


    public UI(Logic gameLogic) {
        this.gameLogic = gameLogic;
        reader = new Scanner(System.in);
    }

    public void printState() {
        StringBuilder toPrint = new StringBuilder("_ _ _\n_ _ _\n_ _ _");

        for(int i = 0; i < gameLogic.getPlayer1PositionsArray().size(); i++) {
            toPrint.setCharAt(2*gameLogic.getPlayer1PositionsArray().get(i), 'X');
        }
        for(int i = 0; i < gameLogic.getPlayer2PositionsArray().size(); i++) {
            toPrint.setCharAt(2*gameLogic.getPlayer2PositionsArray().get(i), 'O');
        }

        toPrint.insert(5, " 0 1 2"); //Adds position numbers to the side of the board
        toPrint.insert(17, " 3 4 5");
        toPrint.insert(29, " 6 7 8");

        System.out.println(toPrint);
    }

    public void printTurn(int player) {
        System.out.println("Player " + player +"'s turn");
    }

    public void printWinner(int player) {
        printState();
        System.out.println("PLAYER " + player + " WINS!");
    }

    public void printDraw() {
        printState();
        System.out.println("DRAW!");
    }

    public void printError(int error) {
        switch(error) {
            case 1:
                System.out.println("Wrong input");
                break;
            case 2:
                System.out.println("Wrong position");
                break;
        }
    }

    public void printMainMenu() {
        System.out.println("Welcome to TicTacToe!");
        System.out.println("Menu:");
        System.out.println("\t1 - Player vs player");
        System.out.println("\t2 - Player vs AI");
        System.out.println("\t3 - AI vs Player");
        System.out.println("\t4 - Train AI with rng");
        System.out.println("\t5 - AI statistics");
        System.out.println("\t6 - Exit");
        System.out.print("Input option: ");
    }

    public void printAIStatistics(AI computer) {
        System.out.println("AI statistics:");
        System.out.println("  Games recorded: " + (computer.getSavedGamesCount(1) + computer.getSavedGamesCount(2)));
        System.out.println("    As player 1: " + computer.getSavedGamesCount(1));
        System.out.println("    As player 2: " + computer.getSavedGamesCount(2));
        System.out.println("  States saved: " + (computer.getStatesCount(1) + computer.getStatesCount(2)));
        System.out.println("    As player 1: " + computer.getStatesCount(1));
        System.out.println("    As player 2: " + computer.getStatesCount(2));
        System.out.println("  Moves saved: " + (computer.getMovesCount(1) + computer.getMovesCount(2)));
        System.out.println("    As player 1: " + computer.getMovesCount(1));
        System.out.println("    As player 2: " + computer.getMovesCount(2));
    }

    public int getPosition() {
        System.out.print("\tInput position(0-8): ");
        return reader.nextInt();
    }

    public int getOption() {
        int mode = reader.nextInt();

        while(mode > 6) {
            printError(1);
            System.out.print("Input option: ");
            mode = reader.nextInt();
        }

        return mode;
    }

    public int getNumberOfRounds() {
        System.out.print("Number of rounds: ");
        return reader.nextInt();
    }
}
