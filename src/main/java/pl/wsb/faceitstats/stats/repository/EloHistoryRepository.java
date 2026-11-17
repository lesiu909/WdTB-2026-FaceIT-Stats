package pl.wsb.faceitstats.stats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.faceitstats.stats.entity.EloHistory;

import java.util.List;

public interface EloHistoryRepository extends JpaRepository<EloHistory, Long> {

    List<EloHistory> findByPlayerProfileNicknameOrderByRecordedAtDesc(String nickname);
}