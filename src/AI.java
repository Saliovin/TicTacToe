import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AI {
    private HashMap<String, ArrayList<Integer>> data1;
    private HashMap<String, ArrayList<Integer>> data2;
    private HashMap<String, Integer> tempData1;
    private HashMap<String, Integer> tempData2;
    private Random rng;
    private int savedGames1;
    private int savedGames2;

    public AI() {
        data1 = new HashMap<>();
        data2 = new HashMap<>();
        tempData1 = new HashMap<>();
        tempData2 = new HashMap<>();
        rng = new Random();
        savedGames1 = 0;
        savedGames2 = 0;
    }

    public int move(int player, String state, boolean trainingMode) {
        if(!trainingMode) {
            if(player == 1) {
                if(data1.containsKey(state)) {
                    return data1.get(state).get(rng.nextInt(data1.get(state).size()));
                }
            }
            else {
                if(data2.containsKey(state)) {
                    return data2.get(state).get(rng.nextInt(data2.get(state).size()));
                }
            }
        }

        ArrayList<Integer> spaces = new ArrayList<>();
        for(int i = 0; i < state.length(); i++) {
            if(state.charAt(i) == ' ') {
                spaces.add(i);
            }
        }

        return spaces.get(rng.nextInt(spaces.size()));
    }

    public void addTempData(String state, Integer move, int player) {
        if(player == 1) {
            tempData1.put(state, move);
        }
        else {
            tempData2.put(state, move);
        }
    }

    public void addData(int player) {
        boolean addedNew = false;

        if(player == 1) {
            for(String state: tempData1.keySet()) {
                if(data1.containsKey(state)) {
                    if(!data1.get(state).contains(tempData1.get(state))) {
                        data1.get(state).add(tempData1.get(state));
                        if(!addedNew) {
                            addedNew = true;
                        }
                    }
                }
                else {
                    ArrayList<Integer> moves = new ArrayList<>();
                    moves.add(tempData1.get(state));
                    data1.put(state, moves);
                    if(!addedNew) {
                        addedNew = true;
                    }
                }
            }

            if(addedNew) {
                savedGames1++;
            }
        }
        else {
            for(String state: tempData2.keySet()) {
                if(data2.containsKey(state)) {
                    if(!data2.get(state).contains(tempData2.get(state))) {
                        data2.get(state).add(tempData2.get(state));
                        if(!addedNew) {
                            addedNew = true;
                        }
                    }
                }
                else {
                    ArrayList<Integer> moves = new ArrayList<>();
                    moves.add(tempData2.get(state));
                    data2.put(state, moves);
                    if(!addedNew) {
                        addedNew = true;
                    }
                }
            }

            if(addedNew) {
                savedGames2++;
            }
        }

        tempData1.clear();
        tempData2.clear();
    }

    public int getSavedGames1() {
        return savedGames1;
    }

    public int getSavedGames2() {
        return savedGames2;
    }

    public int getStates(int player) {
        if(player == 1) {
            return data1.keySet().size();
        }
        else {
            return data2.keySet().size();
        }
    }

    public int getMoves(int player) {
        int counter = 0;

        if(player == 1) {
            for(ArrayList i : data1.values()) {
                counter += i.size();
            }
        }
        else {
            for(ArrayList i : data2.values()) {
                counter += i.size();
            }
        }

        return counter;
    }
}
