-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('s349690@student.wroclaw.merito.pl',   'Mateusz',   'USER',    current_timestamp),
    ('s011566@student.wroclaw.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('wrx85648@student.wroclaw.merito.pl',  'Batosz',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);
-- LAB 02: player_profile
-- 1. Profile graczy powiązane @OneToOne z istniejącymi kontami user_account (id 1, 2, 3)
INSERT INTO player_profile (nickname, elo, level, country, matches_played, win_streak, best_map, worst_map, user_account_id) VALUES
    ('test1', 1500, 7, 'PL', 120, 2, 'MIRAGE',
     'NUKE', 1),
    ('test2', 2100, 10, 'PL', 450, 5, 'INFERNO',
     'VERTIGO', 2),
    ('test3', 950, 4, 'DE', 45, 0, 'DUST2',
     'ANCIENT', 3);

-- 2. Historia meczów
INSERT INTO match_history (match_id, game_map, score, rounds, won, duration_minutes, server_region, played_at) VALUES
    ('test-match-001', 'MIRAGE', '13:9', 22, TRUE, 36, 'PL',
    '2026-11-10 18:00:00'),
    ('test-match-002', 'INFERNO', '16:14', 30, TRUE, 52, 'DE',
     '2026-11-11 20:30:00'),
    ('test-match-003', 'NUKE', '7:13', 20, FALSE, 31, 'EU_CENTRAL',
     '2026-11-12 22:00:00');

-- 3. Statystyki graczy powiązane @ManyToOne z player_profile oraz match_history
INSERT INTO player_stats (
    player_profile_id, match_history_id, game_map, kills, deaths, assists, mvps,
    entry_kills, clutch_wins, flash_assists,
    kd_ratio, win_rate, adr, crosshair_placement, time_to_kill_ms, time_to_damage_ms,
    headshot_percentage, kast_percentage, utility_damage_per_round
) VALUES
      (1, 1, 'MIRAGE', 21, 15, 4, 3, 4,
       1, 2, 1.40, 54.50, 84.20, 4.10, 310,
       215, 48.50, 73.00, 16.40),
      (2, 2, 'INFERNO', 27, 16, 6, 5, 6,
       2, 4, 1.69, 61.20, 96.80, 3.55, 275,
       190, 58.00, 79.50, 22.10),
      (3, 3, 'NUKE', 12, 18, 3, 1, 1,
       0, 1, 0.67, 46.00, 61.50, 5.40, 385,
       260, 35.00, 62.00, 11.20);

-- 4. Tabela łącząca dla relacji @ManyToMany (uczestnicy meczów)
INSERT INTO match_participants (match_history_id, player_profile_id) VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (2, 3),
    (3, 1),
    (3, 3);