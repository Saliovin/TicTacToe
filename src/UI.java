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

        for(int i = 0; i < gameLogic.getXPos1().size(); i++) {
            toPrint.setCharAt(2*gameLogic.getXPos1().get(i) + 6*gameLogic.getYPos1().get(i), 'X');
        }
        for(int i = 0; i < gameLogic.getXPos2().size(); i++) {
            toPrint.setCharAt(2*gameLogic.getXPos2().get(i) + 6*gameLogic.getYPos2().get(i), 'O');
        }

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
                System.out.println("Wrong coordinate");
                break;
        }
    }

    public void printMainMenu() {
        System.out.println("Welcome to TicTacToe!");
        System.out.println("Modes:");
        System.out.println("\t1 - Player vs player");
        System.out.println("\t2 - Player vs AI");
        System.out.println("\t2 - AI vs Player");
        System.out.println("\t4 - AI vs AI");
        System.out.println("\t5 - Exit");
        System.out.print("Input option: ");
    }

    public int getXCoordinate() {
        System.out.print("\tInput X coordinate: ");
        return reader.nextInt();
    }

    public int getYCoordinate() {
        System.out.print("\tInput X coordinate: ");
        return reader.nextInt();
    }

    public int getOption() {
        int mode = reader.nextInt();

        while(mode > 5) {
            printError(1);
            System.out.print("Input option: ");
        }

        return mode;
    }

    public int getNumberOfRounds() {
        System.out.print("Number of rounds: ");
        return reader.nextInt();
    }
}
