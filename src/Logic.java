import java.util.ArrayList;

public class Logic {
    public boolean win(ArrayList<Integer> xPos, ArrayList<Integer> yPos) {
        return checkHorizontal(xPos) || checkVertical(yPos) || checkDiagonal(xPos, yPos);
    }

    private boolean checkHorizontal(ArrayList<Integer> xPos) {
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;

        for(int i = 0; i < xPos.size(); i++) {
            if(xPos.get(i) == 0) {
                counter0++;
            }
            else if(xPos.get(i) == 1) {
                counter1++;
            }
            else {
                counter2++;
            }
        }

        return counter0 == 3 || counter1 == 3 || counter2 == 3;
    }

    private boolean checkVertical(ArrayList<Integer> yPos) {
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;

        for(int i = 0; i < yPos.size(); i++) {
            if(yPos.get(i) == 0) {
                counter0++;
            }
            else if(yPos.get(i) == 1) {
                counter1++;
            }
            else {
                counter2++;
            }
        }

        return counter0 == 3 || counter1 == 3 || counter2 == 3;
    }

    private boolean checkDiagonal(ArrayList<Integer> xPos, ArrayList<Integer> yPos) {
        int counter0 = 0;
        int counter1 = 0;

        for(int i = 0; i < xPos.size(); i++) {
            if(xPos.get(i).equals(yPos.get(i))) {
                counter0++;
            }
            else if(yPos.get(i) == (xPos.size() - xPos.get(i))) {
                counter1++;
            }
        }

        return counter0 == 3 || counter1 == 3;
    }
}
