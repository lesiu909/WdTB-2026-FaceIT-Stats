package pl.wsb.faceitstats.stats.entity;

import jakarta.persistence.*;

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

    public PlayerProfile() {
    }

    public PlayerProfile(String nickname, Integer elo, Integer level, String country) {
        this.nickname = nickname;
        this.elo = elo;
        this.level = level;
        this.country = country;
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
}