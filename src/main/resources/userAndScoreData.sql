INSERT INTO players (username) VALUES
                                ('Alice'),
                                ('Bob'),
                                ('Charlie'),
                                ('Dave'),
                                ('Eve');

-- Suppose player IDs got assigned as 1..5, then insert some scores
INSERT INTO score (player_id, score_value, play_date) VALUES
                                                        (1, 80, NOW()),
                                                        (1, 90, NOW()),
                                                        (2, 70, NOW()),
                                                        (2, 60, NOW()),
                                                        (3, 100, NOW()),
                                                        (4, 50, NOW()),
                                                        (5, 75, NOW()),
                                                        (5, 80, NOW());
