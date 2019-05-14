// The class that handles the AI.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AI {
    private HashMap<String, ArrayList<Integer>> player1Data;
    private HashMap<String, ArrayList<Integer>> player2Data;
    private HashMap<String, Integer> player1TempData;
    private HashMap<String, Integer> player2TempData;
    private Random rng;
    private int player1SavedGamesCounter;
    private int player2SavedGamesCounter;

    public AI() {
        player1Data = new HashMap<>();
        player2Data = new HashMap<>();
        player1TempData = new HashMap<>();
        player2TempData = new HashMap<>();
        rng = new Random();
        player1SavedGamesCounter = 0;
        player2SavedGamesCounter = 0;
    }

    public int move(int player, String state, boolean trainingMode) {
        if(!trainingMode) { //If training mode is on, the method skips checks and returns a random unused space on the board..
            if(player == 1) {
                if(player1Data.containsKey(state)) { //If data contains an exact match of the current state, the method returns a random move from the linked array.
                    return player1Data.get(state).get(rng.nextInt(player1Data.get(state).size()));
                }
            }
            else {
                if(player2Data.containsKey(state)) {
                    return player2Data.get(state).get(rng.nextInt(player2Data.get(state).size()));
                }
            }
        }

        ArrayList<Integer> spaces = new ArrayList<>();
        for(int i = 0; i < state.length(); i++) { //Creates an array of unused spaces on the board.
            if(state.charAt(i) == ' ') {
                spaces.add(i);
            }
        }

        return spaces.get(rng.nextInt(spaces.size())); //Returns a random unused space from the created array.
    }

    public void addTempData(String state, Integer move, int player) {
        if(player == 1) {
            player1TempData.put(state, move);
        }
        else {
            player2TempData.put(state, move);
        }
    }

    public void addData(int player) {
        boolean addedNew = false;
        HashMap<String, ArrayList<Integer>> playerData;
        HashMap<String, Integer> playerTempData;

        if(player == 1) {
            playerData = player1Data;
            playerTempData = player1TempData;
        }
        else {
            playerData = player2Data;
            playerTempData = player2TempData;
        }

        for(String state: playerTempData.keySet()) { //Migrates the temp data saved to the true data hashmap.
            if(playerData.containsKey(state)) {
                if(!playerData.get(state).contains(playerTempData.get(state))) {
                    playerData.get(state).add(playerTempData.get(state));
                    if(!addedNew) { //If addedNew is false, turns true to indicate a new game is saved
                        addedNew = true;
                    }
                }
            }
            else {
                ArrayList<Integer> moves = new ArrayList<>();
                moves.add(playerTempData.get(state));
                playerData.put(state, moves);
                if(!addedNew) {
                    addedNew = true;
                }
            }
        }

        if(addedNew) {
            if(player == 1) {
                player1SavedGamesCounter++;
            }
            else {
                player2SavedGamesCounter++;
            }
        }

        player1TempData.clear();
        player2TempData.clear();
    }

    public int getSavedGamesCount(int player) {
        if(player == 1) {
            return player1SavedGamesCounter;
        }
        else {
            return player2SavedGamesCounter;
        }
    }

    public int getStatesCount(int player) {
        if(player == 1) {
            return player1Data.keySet().size();
        }
        else {
            return player2Data.keySet().size();
        }
    }

    public int getMovesCount(int player) {
        int counter = 0;

        if(player == 1) {
            for(ArrayList i : player1Data.values()) {
                counter += i.size();
            }
        }
        else {
            for(ArrayList i : player2Data.values()) {
                counter += i.size();
            }
        }

        return counter;
    }
}
