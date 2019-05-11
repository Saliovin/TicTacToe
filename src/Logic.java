import java.util.ArrayList;

public class Logic {
    private ArrayList<Integer> posArray1;
    private ArrayList<Integer> posArray2;

    public Logic() {
        posArray1 = new ArrayList<>();
        posArray2 = new ArrayList<>();
    }

    public boolean win(int player) {
        if (player == 1) {
            return checkHorizontal(posArray1) || checkVertical(posArray1) || checkDiagonal(posArray1);
        } else {
            return checkHorizontal(posArray2) || checkVertical(posArray2) || checkDiagonal(posArray2);
        }
    }

    public boolean draw() {
        if ((posArray1.size() + posArray2.size()) == 9) {
            return true;
        }

        return false;
    }

    public boolean add(int player, Integer pos) {
        if ((pos > 8) || (pos < 0)) {
            return false;
        }

        if (!isConflict(pos)) {
            if (player == 1) {
                posArray1.add(pos);
            } else {
                posArray2.add(pos);
            }
            return true;
        }

        return false;
    }

    public void reset() {
        posArray1.clear();
        posArray2.clear();
    }

    public ArrayList<Integer> getPosArray1() {
        return posArray1;
    }

    public ArrayList<Integer> getPosArray2() {
        return posArray2;
    }

    private boolean checkHorizontal(ArrayList<Integer> posArray) {
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;

        for (Integer i : posArray) {
            if (i < 3) {
                counter0++;
            } else if (i < 6) {
                counter1++;
            } else {
                counter2++;
            }
        }

        return counter0 == 3 || counter1 == 3 || counter2 == 3;
    }

    private boolean checkVertical(ArrayList<Integer> posArray) {
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;

        for (Integer i : posArray) {
            if ((i % 3) == 0) {
                counter0++;
            } else if ((i == 1) || (i == 4) || (i == 7)) {
                counter1++;
            } else {
                counter2++;
            }
        }

        return counter0 == 3 || counter1 == 3 || counter2 == 3;
    }

    private boolean checkDiagonal(ArrayList<Integer> posArray) {
        int counter0 = 0;
        int counter1 = 0;

        for (Integer i : posArray) {
            if ((i % 4) == 0) {
                counter0++;

                if (i == 4) {
                    counter1++;
                }
            } else if ((i % 2) == 0) {
                counter1++;
            }
        }

        return counter0 == 3 || counter1 == 3;
    }

    private boolean isConflict(Integer pos) {
        return posArray1.contains(pos) || posArray2.contains(pos);
    }
}
