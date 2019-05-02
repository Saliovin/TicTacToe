import java.util.ArrayList;

public class Logic {
    private ArrayList<Integer> xPos1;
    private ArrayList<Integer> yPos1;
    private ArrayList<Integer> xPos2;
    private ArrayList<Integer> yPos2;

    public Logic() {
        xPos1 = new ArrayList<>();
        yPos1 = new ArrayList<>();
        xPos2 = new ArrayList<>();
        yPos2 = new ArrayList<>();
    }

    public boolean win(int player) {
        if (player == 1) {
            return checkHorizontal(xPos1) || checkVertical(yPos1) || checkDiagonal(xPos1, yPos1);
        } else {
            return checkHorizontal(xPos2) || checkVertical(yPos2) || checkDiagonal(xPos2, yPos2);
        }
    }

    public boolean draw() {
        if (xPos1.size() + xPos2.size() == 9) {
            return true;
        }

        return false;
    }

    private boolean checkHorizontal(ArrayList<Integer> xPos) {
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;

        for (Integer xPo : xPos) {
            if (xPo == 0) {
                counter0++;
            } else if (xPo == 1) {
                counter1++;
            } else {
                counter2++;
            }
        }

        return counter0 == 3 || counter1 == 3 || counter2 == 3;
    }

    private boolean checkVertical(ArrayList<Integer> yPos) {
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;

        for (Integer yPo : yPos) {
            if (yPo == 0) {
                counter0++;
            } else if (yPo == 1) {
                counter1++;
            } else {
                counter2++;
            }
        }

        return counter0 == 3 || counter1 == 3 || counter2 == 3;
    }

    private boolean checkDiagonal(ArrayList<Integer> xPos, ArrayList<Integer> yPos) {
        int counter0 = 0;
        int counter1 = 0;

        for (int i = 0; i < xPos.size(); i++) {
            if (xPos.get(i).equals(yPos.get(i))) {
                counter0++;
            }
            if (xPos.get(i) == (2 - yPos.get(i))) {
                counter1++;
            }
        }

        return counter0 == 3 || counter1 == 3;
    }

    public boolean add(int player, int xPos, int yPos) {
        if (xPos > 2 || yPos > 2) {
            return false;
        }

        if (!isConflict(xPos, yPos)) {
            if (player == 1) {
                xPos1.add(xPos);
                yPos1.add(yPos);
            } else {
                xPos2.add(xPos);
                yPos2.add(yPos);
            }
            return true;
        }

        return false;
    }

    private boolean isConflict(int xPos, int yPos) {
        for (int i = 0; i < xPos1.size(); i++) {
            if ((xPos1.get(i) == xPos && yPos1.get(i) == yPos)) {
                return true;
            } else if (!(i == xPos2.size())) {
                if (xPos2.get(i) == xPos && yPos2.get(i) == yPos) {
                    return true;
                }
            }
        }

        return false;
    }

    public ArrayList<Integer> getXPos1() {
        return xPos1;
    }

    public ArrayList<Integer> getYPos1() {
        return yPos1;
    }

    public ArrayList<Integer> getXPos2() {
        return xPos2;
    }

    public ArrayList<Integer> getYPos2() {
        return yPos2;
    }
}
