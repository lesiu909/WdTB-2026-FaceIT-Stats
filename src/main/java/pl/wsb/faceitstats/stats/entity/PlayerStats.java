package pl.wsb.faceitstats.stats.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "player_stats")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String player;

    @Column(nullable = false)
    private Integer kills;

    @Embedded
    private PerformanceScore score;

    public PlayerStats() {
    }

    public PlayerStats(String player, Integer kills, PerformanceScore score) {
        this.player = player;
        this.kills = kills;
        this.score = score;
    }

    public Long getId() { return id; }
    public String getPlayer() { return player; }
    public void setPlayer(String player) { this.player = player; }
    public Integer getKills() { return kills; }
    public void setKills(Integer kills) { this.kills = kills; }
    public PerformanceScore getScore() { return score; }
    public void setScore(PerformanceScore score) { this.score = score; }
}