import java.util.ArrayList;

public class UI {
    public void printState(ArrayList<Integer> xPos1,ArrayList<Integer> yPos1,
                           ArrayList<Integer> xPos2,ArrayList<Integer> yPos2) {
        StringBuilder toPrint = new StringBuilder("_ _ _\n_ _ _\n_ _ _");

        for(int i = 0; i < xPos1.size(); i++) {
            toPrint.setCharAt(xPos1.get(i) + 6*yPos1.get(i), 'X');
        }
        for(int i = 0; i < xPos2.size(); i++) {
            toPrint.setCharAt(xPos2.get(i) + 6*yPos2.get(i), 'O');
        }

        System.out.println(toPrint);
    }
}
