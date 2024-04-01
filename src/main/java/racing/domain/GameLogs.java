package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameLogs {
    private List<GameLog> gameLogs;

    public GameLogs() {
        this.gameLogs = new ArrayList<>();
    }

    public void addGameLog(Map<String, Integer> gameLog) {
        gameLogs.add(new GameLog(gameLog));
    }

    public List<GameLog> getGameLogs() {
        return this.gameLogs;
    }
}
