package pl.wsb.faceitstats.stats.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "player_stats")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_profile_id", nullable = false)
    private PlayerProfile playerProfile;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "match_history_id", nullable = false)
    private MatchHistory matchHistory;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameMap gameMap;

    @Column(nullable = false)
    private Integer kills;

    @Column(nullable = false)
    private Integer deaths;

    @Column(nullable = false)
    private Integer assists;

    @Column(nullable = false)
    private Integer mvps;

    @Column(nullable = false)
    private Integer entryKills;

    @Column(nullable = false)
    private Integer clutchWins;

    @Column(nullable = false)
    private Integer flashAssists;

    @Embedded
    private PerformanceScore score;

    public PlayerStats() {
    }

    public PlayerStats(PlayerProfile playerProfile, MatchHistory matchHistory, GameMap gameMap,
                       Integer kills, Integer deaths, Integer assists, Integer mvps,
                       Integer entryKills, Integer clutchWins, Integer flashAssists,
                       PerformanceScore score) {
        this.playerProfile = playerProfile;
        this.matchHistory = matchHistory;
        this.gameMap = gameMap;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.mvps = mvps;
        this.entryKills = entryKills;
        this.clutchWins = clutchWins;
        this.flashAssists = flashAssists;
        this.score = score;
    }

    public Long getId() { return id; }

    public PlayerProfile getPlayerProfile() { return playerProfile; }
    public void setPlayerProfile(PlayerProfile playerProfile) { this.playerProfile = playerProfile; }

    public MatchHistory getMatchHistory() { return matchHistory; }
    public void setMatchHistory(MatchHistory matchHistory) { this.matchHistory = matchHistory; }

    public GameMap getGameMap() { return gameMap; }
    public void setGameMap(GameMap gameMap) { this.gameMap = gameMap; }

    public Integer getKills() { return kills; }
    public void setKills(Integer kills) { this.kills = kills; }

    public Integer getDeaths() { return deaths; }
    public void setDeaths(Integer deaths) { this.deaths = deaths; }

    public Integer getAssists() { return assists; }
    public void setAssists(Integer assists) { this.assists = assists; }

    public Integer getMvps() { return mvps; }
    public void setMvps(Integer mvps) { this.mvps = mvps; }

    public Integer getEntryKills() { return entryKills; }
    public void setEntryKills(Integer entryKills) { this.entryKills = entryKills; }

    public Integer getClutchWins() { return clutchWins; }
    public void setClutchWins(Integer clutchWins) { this.clutchWins = clutchWins; }

    public Integer getFlashAssists() { return flashAssists; }
    public void setFlashAssists(Integer flashAssists) { this.flashAssists = flashAssists; }

    public PerformanceScore getScore() { return score; }
    public void setScore(PerformanceScore score) { this.score = score; }
}