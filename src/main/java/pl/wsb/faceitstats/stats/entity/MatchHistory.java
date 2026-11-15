package pl.wsb.faceitstats.stats.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(nullable = false)
    private Boolean won;

    @Column(nullable = false)
    private Integer durationMinutes;

    @Column(nullable = false)
    private String serverRegion;

    @Column(nullable = false)
    private LocalDateTime playedAt;

    @OneToMany(mappedBy = "matchHistory", fetch = FetchType.LAZY)
    private List<PlayerStats> playerStats = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "match_participants",
            joinColumns = @JoinColumn(name = "match_history_id"),
            inverseJoinColumns = @JoinColumn(name = "player_profile_id")
    )
    private Set<PlayerProfile> participants = new HashSet<>();

    public MatchHistory() {
    }

    public MatchHistory(String matchId, GameMap gameMap, String score, Integer rounds,
                        Boolean won, Integer durationMinutes, String serverRegion, LocalDateTime playedAt) {
        this.matchId = matchId;
        this.gameMap = gameMap;
        this.score = score;
        this.rounds = rounds;
        this.won = won;
        this.durationMinutes = durationMinutes;
        this.serverRegion = serverRegion;
        this.playedAt = playedAt;
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

    public Boolean getWon() { return won; }
    public void setWon(Boolean won) { this.won = won; }

    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }

    public String getServerRegion() { return serverRegion; }
    public void setServerRegion(String serverRegion) { this.serverRegion = serverRegion; }

    public LocalDateTime getPlayedAt() { return playedAt; }
    public void setPlayedAt(LocalDateTime playedAt) { this.playedAt = playedAt; }

    public List<PlayerStats> getPlayerStats() { return playerStats; }
    public void setPlayerStats(List<PlayerStats> playerStats) { this.playerStats = playerStats; }

    public Set<PlayerProfile> getParticipants() { return participants; }
    public void setParticipants(Set<PlayerProfile> participants) { this.participants = participants; }
}