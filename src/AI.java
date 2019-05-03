import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AI {
    private HashMap<String, ArrayList<String>> data1;
    private HashMap<String, ArrayList<String>> data2;
    private HashMap<String, String> tempData1;
    private HashMap<String, String> tempData2;
    private Logic gameLogic;
    private Random rng;

    public AI(Logic gameLogic, Random rng) {
        data1 = new HashMap<>();
        data2 = new HashMap<>();
        tempData1 = new HashMap<>();
        this.gameLogic = gameLogic;
        this.rng = rng;
    }

    public String move(int player) {
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

        return spaces.get(rng.nextInt(spaces.size())).toString();
    }

    public void addTempData(String state, String move, int player) {
        if(player == 1) {
            tempData1.put(state, move);
        }
        else {
            tempData2.put(state, move);
        }
    }

    private String getCurrentState() {
        StringBuilder state = new StringBuilder("         ");

        for(int i = 0; i < gameLogic.getXPos1().size(); i++) {
            state.setCharAt(gameLogic.getXPos1().get(i) + 3*gameLogic.getYPos1().get(i), 'X');
        }
        for(int i = 0; i < gameLogic.getXPos2().size(); i++) {
            state.setCharAt(gameLogic.getXPos2().get(i) + 3*gameLogic.getYPos2().get(i), 'O');
        }

        return state.toString();
    }
}
