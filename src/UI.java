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
        System.out.println("  Games recorded: " + (computer.getSavedGames1() + computer.getSavedGames2()));
        System.out.println("    As player 1: " + computer.getSavedGames1());
        System.out.println("    As player 2: " + computer.getSavedGames2());
        System.out.println("  States saved: " + (computer.getStates(1) + computer.getStates(2)));
        System.out.println("    As player 1: " + computer.getStates(1));
        System.out.println("    As player 2: " + computer.getStates(2));
        System.out.println("  Moves saved: " + (computer.getMoves(1) + computer.getMoves(2)));
        System.out.println("    As player 1: " + computer.getMoves(1));
        System.out.println("    As player 2: " + computer.getMoves(2));
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
