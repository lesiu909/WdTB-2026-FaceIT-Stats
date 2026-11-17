package pl.wsb.faceitstats.stats.entity;

import jakarta.persistence.*;
import  java.time.LocalDateTime;

@Entity
@Table(name = "elo_history")

public class EloHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_profile_id", nullable = false)
    private PlayerProfile playerProfile;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "match_history_id", nullable = false)
    private MatchHistory matchHistory;

    @Column(nullable = false)
    private Integer eloBefore;

    @Column(nullable = false)
    private Integer eloAfter;

    @Column(nullable = false)
    private Integer eloDiff;

    @Column(nullable = false)
    private Integer levelAfter;

    @Column(nullable = false)
    private LocalDateTime recordedAt;

    public EloHistory() {
    }

    public EloHistory(PlayerProfile playerProfile, MatchHistory matchHistory,
                      Integer eloBefore, Integer eloAfter, Integer eloDiff,
                      Integer levelAfter, LocalDateTime recordedAt) {
        this.playerProfile = playerProfile;
        this.matchHistory = matchHistory;
        this.eloBefore = eloBefore;
        this.eloAfter = eloAfter;
        this.eloDiff = eloDiff;
        this.levelAfter = levelAfter;
        this.recordedAt = recordedAt;
    }

    public Long getId() { return id; }

    public PlayerProfile getPlayerProfile() { return playerProfile; }
    public void setPlayerProfile(PlayerProfile playerProfile) { this.playerProfile = playerProfile; }

    public MatchHistory getMatchHistory() { return matchHistory; }
    public void setMatchHistory(MatchHistory matchHistory) { this.matchHistory = matchHistory; }

    public Integer getEloBefore() { return eloBefore; }
    public void setEloBefore(Integer eloBefore) { this.eloBefore = eloBefore; }

    public Integer getEloAfter() { return eloAfter; }
    public void setEloAfter(Integer eloAfter) { this.eloAfter = eloAfter; }

    public Integer getEloDiff() { return eloDiff; }
    public void setEloDiff(Integer eloDiff) { this.eloDiff = eloDiff; }

    public Integer getLevelAfter() { return levelAfter; }
    public void setLevelAfter(Integer levelAfter) { this.levelAfter = levelAfter; }

    public LocalDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }
}
