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
INSERT INTO player_profile (nickname, elo, level, country) VALUES ('s1mple', 3400, 10, 'UA');
INSERT INTO player_profile (nickname, elo, level, country) VALUES ('zywoo', 3500, 10, 'FR');
INSERT INTO player_profile (nickname, elo, level, country) VALUES ('m0nesy', 3300, 10, 'PL');

-- LAB 02: match_history
INSERT INTO match_history (match_id, game_map, score, rounds) VALUES ('m-01', 'MIRAGE', '13:9', 22);
INSERT INTO match_history (match_id, game_map, score, rounds) VALUES ('m-02', 'INFERNO', '16:14', 30);
INSERT INTO match_history (match_id, game_map, score, rounds) VALUES ('m-03', 'NUKE', '13:5', 18);

-- LAB 02: player_stats
INSERT INTO player_stats (player, kills, kd_ratio, win_rate) VALUES ('s1mple', 24, 1.85, 65.50);
INSERT INTO player_stats (player, kills, kd_ratio, win_rate) VALUES ('zywoo', 28, 1.90, 68.00);
INSERT INTO player_stats (player, kills, kd_ratio, win_rate) VALUES ('m0nesy', 20, 1.70, 60.00);
