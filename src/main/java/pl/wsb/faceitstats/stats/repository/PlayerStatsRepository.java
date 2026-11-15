package pl.wsb.faceitstats.stats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.faceitstats.stats.entity.GameMap;
import pl.wsb.faceitstats.stats.entity.PlayerStats;

import java.util.List;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {

    // Zapytanie przechodzące przez relację @ManyToOne do PlayerProfile
    List<PlayerStats> findByPlayerProfileNickname(String nickname);

    // Zapytanie przechodzące przez relację do PlayerProfile + filtrowanie po mapie
    List<PlayerStats> findByPlayerProfileNicknameAndGameMap(String nickname, GameMap gameMap);

    // Zapytanie przechodzące przez relację @ManyToOne do MatchHistory
    List<PlayerStats> findByMatchHistoryMatchId(String matchId);
}