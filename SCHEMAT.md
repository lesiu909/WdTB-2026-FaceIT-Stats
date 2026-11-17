# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 6 (w tym tabele łączące @ManyToMany: match_participants) · kolumny: 52 · relacje: 4 × @ManyToOne, 3 × @OneToMany, 1 × @OneToOne, 2 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| elo_history | EloHistory | 8 | match_history_id, player_profile_id |
| match_history | MatchHistory | 9 | — |
| player_profile | PlayerProfile | 10 | user_account_id |
| player_stats | PlayerStats | 20 | match_history_id, player_profile_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    elo_history {
        Long id PK
        Integer elo_after
        Integer elo_before
        Integer elo_diff
        Integer level_after
        Long match_history_id FK
        Long player_profile_id FK
        LocalDateTime recorded_at
    }
    match_history {
        Long id PK
        Integer duration_minutes
        GameMap game_map
        String match_id
        LocalDateTime played_at
        Integer rounds
        String score
        String server_region
        Boolean won
    }
    player_profile {
        Long id PK
        GameMap best_map
        String country
        Integer elo
        Integer level
        Integer matches_played
        String nickname
        Long user_account_id FK
        Integer win_streak
        GameMap worst_map
    }
    player_stats {
        Long id PK
        BigDecimal adr
        Integer assists
        Integer clutch_wins
        BigDecimal crosshair_placement
        Integer deaths
        Integer entry_kills
        Integer flash_assists
        GameMap game_map
        BigDecimal headshot_percentage
        BigDecimal kast_percentage
        BigDecimal kd_ratio
        Integer kills
        Long match_history_id FK
        Integer mvps
        Long player_profile_id FK
        Integer time_to_damage_ms
        Integer time_to_kill_ms
        BigDecimal utility_damage_per_round
        BigDecimal win_rate
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    match_history ||--o{ elo_history : "match_history_id"
    match_history ||--o{ player_stats : "match_history_id"
    match_history }o--o{ player_profile : "match_participants"
    player_profile ||--o{ elo_history : "player_profile_id"
    player_profile ||--o{ player_stats : "player_profile_id"
    user_account |o--o| player_profile : "user_account_id"
```
