import java.util.ArrayList;

public class State {
    private ArrayList<String> moves;
    private String state;

    public State(String state) {
        this.state = state;
        moves = new ArrayList<>();
    }

    public void addMove(String move) {
        moves.add(move);
    }
}
