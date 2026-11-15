# Schemat bazy danych — FaceIT Stats

## Diagram ERD

```mermaid
erDiagram
    USER_ACCOUNT ||--o| PLAYER_PROFILE : "posiada profil (@OneToOne)"
    PLAYER_PROFILE ||--o{ PLAYER_STATS : "generuje statystyki (@OneToMany)"
    MATCH_HISTORY ||--o{ PLAYER_STATS : "zawiera wyniki graczy (@OneToMany)"
    MATCH_HISTORY }o--o{ PLAYER_PROFILE : "uczestnicy meczu (@ManyToMany)"

    USER_ACCOUNT {
        bigint id PK
        varchar email UK
        varchar display_name
        varchar role
        timestamp created_at
    }

    PLAYER_PROFILE {
        bigint id PK
        bigint user_account_id FK "UNIQUE"
        varchar nickname
        int elo
        int level
        varchar country
        int matches_played
        int win_streak
        varchar best_map
        varchar worst_map
    }

    MATCH_HISTORY {
        bigint id PK
        varchar match_id
        varchar game_map
        varchar score
        int rounds
        boolean won
        int duration_minutes
        varchar server_region
        timestamp played_at
    }

    PLAYER_STATS {
        bigint id PK
        bigint player_profile_id FK
        bigint match_history_id FK
        varchar game_map
        int kills
        int deaths
        int assists
        int mvps
        int entry_kills
        int clutch_wins
        int flash_assists
        decimal kd_ratio "Embedded PerformanceScore"
        decimal win_rate "Embedded PerformanceScore"
        decimal adr "Embedded PerformanceScore"
        decimal crosshair_placement "Embedded PerformanceScore"
        int time_to_kill_ms "Embedded PerformanceScore"
        int time_to_damage_ms "Embedded PerformanceScore"
        decimal headshot_percentage "Embedded PerformanceScore"
        decimal kast_percentage "Embedded PerformanceScore"
        decimal utility_damage_per_round "Embedded PerformanceScore"
    }

    MATCH_PARTICIPANTS {
        bigint match_history_id PK, FK
        bigint player_profile_id PK, FK
    }