import java.util.Scanner;

public class UI {
    private Logic gameLogic;
    private Scanner reader;


    public UI(Logic gameLogic) {
        this.gameLogic = gameLogic;
        reader = new Scanner(System.in);
    }

    public void printState() {
        StringBuilder toPrint = new StringBuilder("0 1 2\n3 4 5\n6 7 8");

        for(int i = 0; i < gameLogic.getPosArray1().size(); i++) {
            toPrint.setCharAt(2*gameLogic.getPosArray1().get(i), 'X');
        }
        for(int i = 0; i < gameLogic.getPosArray2().size(); i++) {
            toPrint.setCharAt(2*gameLogic.getPosArray2().get(i), '•');
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
                System.out.println("Wrong position");
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

    public int getPosition() {
        System.out.print("\tInput position(0-8): ");
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
