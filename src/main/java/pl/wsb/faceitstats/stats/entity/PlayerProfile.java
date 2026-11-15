package pl.wsb.faceitstats.stats.entity;

import jakarta.persistence.*;
import pl.wsb.faceitstats.account.domain.UserAccount;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "player_profile")
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private Integer elo;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Integer matchesPlayed;

    @Column(nullable = false)
    private Integer winStreak;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameMap bestMap;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameMap worstMap;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id", unique = true)
    private UserAccount userAccount;

    @OneToMany(mappedBy = "playerProfile", fetch = FetchType.LAZY)
    private List<PlayerStats> stats = new ArrayList<>();

    @ManyToMany(mappedBy = "participants", fetch = FetchType.LAZY)
    private Set<MatchHistory> matches = new HashSet<>();

    public PlayerProfile() {
    }

    public PlayerProfile(String nickname, Integer elo, Integer level, String country,
                         Integer matchesPlayed, Integer winStreak, GameMap bestMap, GameMap worstMap, UserAccount userAccount) {
        this.nickname = nickname;
        this.elo = elo;
        this.level = level;
        this.country = country;
        this.matchesPlayed = matchesPlayed;
        this.winStreak = winStreak;
        this.bestMap = bestMap;
        this.worstMap = worstMap;
        this.userAccount = userAccount;
    }

    public Long getId() { return id; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public Integer getElo() { return elo; }
    public void setElo(Integer elo) { this.elo = elo; }

    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Integer getMatchesPlayed() { return matchesPlayed; }
    public void setMatchesPlayed(Integer matchesPlayed) { this.matchesPlayed = matchesPlayed; }

    public Integer getWinStreak() { return winStreak; }
    public void setWinStreak(Integer winStreak) { this.winStreak = winStreak; }

    public GameMap getBestMap() { return bestMap; }
    public void setBestMap(GameMap bestMap) { this.bestMap = bestMap; }

    public GameMap getWorstMap() { return worstMap; }
    public void setWorstMap(GameMap worstMap) { this.worstMap = worstMap; }

    public UserAccount getUserAccount() {return userAccount; }
    public void setUserAccount(UserAccount userAccount) { this.userAccount = userAccount; }

    public List<PlayerStats> getStats() { return stats; }
    public void setStats(List<PlayerStats> stats) { this.stats = stats; }

    public Set<MatchHistory> getMatches() { return matches; }
    public void setMatches(Set<MatchHistory> matches) { this.matches = matches; }
}