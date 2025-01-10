CREATE DATABASE IF NOT EXISTS quizdb;
USE quizdb;

DROP TABLE IF EXISTS score;
DROP TABLE IF EXISTS players;
DROP TABLE IF EXISTS reponse;
DROP TABLE IF EXISTS question;

CREATE TABLE question
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    question_text VARCHAR(255) NOT NULL
);

CREATE TABLE answer
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    question_id INT          NOT NULL,
    answer_text VARCHAR(255) NOT NULL,
    correct     BOOLEAN      NOT NULL,
    CONSTRAINT fk_question
        FOREIGN KEY (question_id)
            REFERENCES question (id)
            ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS players
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS score
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    user_id     INT      NOT NULL,
    score_value INT      NOT NULL,
    play_date   DATETIME NOT NULL,
    CONSTRAINT fk_user_score
        FOREIGN KEY (user_id) REFERENCES players (id)
            ON DELETE CASCADE
);