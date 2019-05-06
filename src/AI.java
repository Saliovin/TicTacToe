import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AI {
    private HashMap<String, ArrayList<Integer>> data1;
    private HashMap<String, ArrayList<Integer>> data2;
    private HashMap<String, Integer> tempData1;
    private HashMap<String, Integer> tempData2;
    private Logic gameLogic;
    private Random rng;

    public AI(Logic gameLogic, Random rng) {
        data1 = new HashMap<>();
        data2 = new HashMap<>();
        tempData1 = new HashMap<>();
        tempData2 = new HashMap<>();
        this.gameLogic = gameLogic;
        this.rng = rng;
    }

    public int move(int player) {
        String state = getCurrentState();
        if(player == 1) {
            if(data1.containsKey(state)) {
                return data1.get(state).get(rng.nextInt(state.length()));
            }
        }
        else {
            if(data2.containsKey(state)) {
                return data2.get(state).get(rng.nextInt(state.length()));
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
        if(player == 1) {
            for(String state: tempData1.keySet()) {
                if(data1.containsKey(state)) {
                    data1.get(state).add(tempData1.get(state));
                }
                else {
                    ArrayList<Integer> moves = new ArrayList<>();
                    moves.add(tempData1.get(state));
                    data1.put(state, moves);
                }
            }
        }
        else {
            for(String state: tempData2.keySet()) {
                if(data2.containsKey(state)) {
                    data2.get(state).add(tempData2.get(state));
                }
                else {
                    ArrayList<Integer> moves = new ArrayList<>();
                    moves.add(tempData2.get(state));
                    data2.put(state, moves);
                }
            }
        }
    }

    private String getCurrentState() {
        StringBuilder state = new StringBuilder("         ");

        for(int i = 0; i < gameLogic.getPosArray1().size(); i++) {
            state.setCharAt(gameLogic.getPosArray1().get(i), 'X');
        }
        for(int i = 0; i < gameLogic.getPosArray2().size(); i++) {
            state.setCharAt(gameLogic.getPosArray2().get(i), '•');
        }

        return state.toString();
    }
}
