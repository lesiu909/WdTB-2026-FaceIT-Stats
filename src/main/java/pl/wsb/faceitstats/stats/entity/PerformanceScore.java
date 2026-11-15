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

    @Column(nullable = false)
    private BigDecimal adr;

    @Column(nullable = false)
    private BigDecimal crosshairPlacement;

    @Column(nullable = false)
    private Integer timeToKillMs;

    @Column(nullable = false)
    private Integer timeToDamageMs;

    @Column(nullable = false)
    private BigDecimal headshotPercentage;

    @Column(nullable = false)
    private BigDecimal kastPercentage;

    @Column(nullable = false)
    private BigDecimal utilityDamagePerRound;

    public PerformanceScore() {
    }

    public PerformanceScore(BigDecimal kdRatio, BigDecimal winRate, BigDecimal adr,
                            BigDecimal crosshairPlacement, Integer timeToKillMs,
                            Integer timeToDamageMs, BigDecimal headshotPercentage,
                            BigDecimal kastPercentage, BigDecimal utilityDamagePerRound) {
        this.kdRatio = kdRatio;
        this.winRate = winRate;
        this.adr = adr;
        this.crosshairPlacement = crosshairPlacement;
        this.timeToKillMs = timeToKillMs;
        this.timeToDamageMs = timeToDamageMs;
        this.headshotPercentage = headshotPercentage;
        this.kastPercentage = kastPercentage;
        this.utilityDamagePerRound = utilityDamagePerRound;
    }

    public BigDecimal getKdRatio() { return kdRatio; }
    public void setKdRatio(BigDecimal kdRatio) { this.kdRatio = kdRatio; }

    public BigDecimal getWinRate() { return winRate; }
    public void setWinRate(BigDecimal winRate) { this.winRate = winRate; }

    public BigDecimal getAdr() { return adr; }
    public void setAdr(BigDecimal adr) { this.adr = adr; }

    public BigDecimal getCrosshairPlacement() { return crosshairPlacement; }
    public void setCrosshairPlacement(BigDecimal crosshairPlacement) { this.crosshairPlacement = crosshairPlacement; }

    public Integer getTimeToKillMs() { return timeToKillMs; }
    public void setTimeToKillMs(Integer timeToKillMs) { this.timeToKillMs = timeToKillMs; }

    public Integer getTimeToDamageMs() { return timeToDamageMs; }
    public void setTimeToDamageMs(Integer timeToDamageMs) { this.timeToDamageMs = timeToDamageMs; }

    public BigDecimal getHeadshotPercentage() { return headshotPercentage; }
    public void setHeadshotPercentage(BigDecimal headshotPercentage) { this.headshotPercentage = headshotPercentage; }

    public BigDecimal getKastPercentage() { return kastPercentage; }
    public void setKastPercentage(BigDecimal kastPercentage) { this.kastPercentage = kastPercentage; }

    public BigDecimal getUtilityDamagePerRound() { return utilityDamagePerRound; }
    public void setUtilityDamagePerRound(BigDecimal utilityDamagePerRound) { this.utilityDamagePerRound = utilityDamagePerRound; }
}