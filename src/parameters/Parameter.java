package parameters;

import java.util.HashMap;
import java.util.Map;

public class Parameter {
     private final Map<String, Integer> score = new HashMap<>();
    public Roll add(int pins) {
        return player -> {
            if(!score.containsKey(player)) score.put(player, 0);
            score.put(player, score.get(player)+pins);
        };
    }

    public int get(String player) {
        return score.get(player);
    }

    public void add(int pins, String player) {
        if(!score.containsKey(player)) score.put(player, 0);
        score.put(player, score.get(player)+pins);
    }

    public interface Roll {
        void to(String player);
    }
}
