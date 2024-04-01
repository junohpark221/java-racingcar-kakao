package racing.domain;

import java.util.Map;

public class GameLog {
    private Map<String, Integer> gameLog;

    public GameLog(Map<String, Integer> gameLog) {
        this.gameLog = gameLog;
    }

    public Map<String, Integer> getGameLog() {
        return this.gameLog;
    }
}
