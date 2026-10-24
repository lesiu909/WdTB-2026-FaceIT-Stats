package pl.wsb.faceitstats.stats.entity;

import jakarta.persistence.*;
import pl.wsb.faceitstats.stats.entity.GameMap;

@Entity
@Table(name = "match_history")
public class MatchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String matchId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameMap gameMap;

    @Column(nullable = false)
    private String score;

    @Column(nullable = false)
    private Integer rounds;

    public MatchHistory() {
    }

    public MatchHistory(String matchId, GameMap gameMap, String score, Integer rounds) {
        this.matchId = matchId;
        this.gameMap = gameMap;
        this.score = score;
        this.rounds = rounds;
    }

    public Long getId() { return id; }
    public String getMatchId() { return matchId; }
    public void setMatchId(String matchId) { this.matchId = matchId; }
    public GameMap getGameMap() { return gameMap; }
    public void setGameMap(GameMap gameMap) { this.gameMap = gameMap; }
    public String getScore() { return score; }
    public void setScore(String score) { this.score = score; }
    public Integer getRounds() { return rounds; }
    public void setRounds(Integer rounds) { this.rounds = rounds; }
}