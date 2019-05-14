//This class handles the logic of the game like for example checking for win conditions.

import java.util.ArrayList;

public class Logic {
    private ArrayList<Integer> player1PositionsArray;
    private ArrayList<Integer> player2PositionsArray;

    public Logic() {
        player1PositionsArray = new ArrayList<>();
        player2PositionsArray = new ArrayList<>();
    }

    public boolean win(int player) {
        if (player == 1) {
            return checkHorizontal(player1PositionsArray) || checkVertical(player1PositionsArray) || checkDiagonal(player1PositionsArray);
        } else {
            return checkHorizontal(player2PositionsArray) || checkVertical(player2PositionsArray) || checkDiagonal(player2PositionsArray);
        }
    }

    public boolean draw() {
        if ((player1PositionsArray.size() + player2PositionsArray.size()) == 9) {
            return true;
        }

        return false;
    }

    public boolean addPosition(int player, Integer pos) {
        if ((pos > 8) || (pos < 0)) {
            return false;
        }

        if (!checkConflict(pos)) {
            if (player == 1) {
                player1PositionsArray.add(pos);
            } else {
                player2PositionsArray.add(pos);
            }
            return true;
        }

        return false;
    }

    public void resetArrays() {
        player1PositionsArray.clear();
        player2PositionsArray.clear();
    }

    public ArrayList<Integer> getPlayer1PositionsArray() {
        return player1PositionsArray;
    }

    public ArrayList<Integer> getPlayer2PositionsArray() {
        return player2PositionsArray;
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

    private boolean checkConflict(Integer pos) {
        return player1PositionsArray.contains(pos) || player2PositionsArray.contains(pos);
    }
}
