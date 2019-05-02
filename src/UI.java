import java.util.ArrayList;

public class UI {
    private Logic gameLogic;

    public UI(Logic gameLogic) {
        this.gameLogic = gameLogic;
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
}
