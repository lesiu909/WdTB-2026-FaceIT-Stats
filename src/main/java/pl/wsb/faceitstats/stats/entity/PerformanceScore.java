package pl.wsb.faceitstats.stats.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class PerformanceScore {

    @Column(nullable = false)
    private BigDecimal kdRatio;

    @Column(nullable = false)
    private BigDecimal winRate;

    public PerformanceScore() {
    }

    public PerformanceScore(BigDecimal kdRatio, BigDecimal winRate) {
        this.kdRatio = kdRatio;
        this.winRate = winRate;
    }

    public BigDecimal getKdRatio() { return kdRatio; }
    public void setKdRatio(BigDecimal kdRatio) { this.kdRatio = kdRatio; }
    public BigDecimal getWinRate() { return winRate; }
    public void setWinRate(BigDecimal winRate) { this.winRate = winRate; }
}