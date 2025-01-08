
-- Insert 20 questions
INSERT INTO question (question_text)
VALUES ('Is Java compiled or interpreted?'),                               -- Q1
       ('Java was originally created by which company?'),                  -- Q2
       ('Are Java and JavaScript closely related?'),                       -- Q3
       ('Which version of Java is currently an LTS release?'),             -- Q4
       ('Which HTML tag is used to include JavaScript code?'),             -- Q5
       ('In which year was Java first released?'),                         -- Q6
       ('What is the standard signature for the main method in Java?'),    -- Q7
       ('Which keyword is used for inheritance in Java?'),                 -- Q8
       ('What does JVM stand for?'),                                       -- Q9
       ('Which command is used to compile Java source files?'),            -- Q10
       ('Which file extension holds the compiled bytecode for Java?'),     -- Q11
       ('What is the name of the main method in Java?'),                   -- Q12
       ('What does the static keyword in Java indicate?'),                 -- Q13
       ('A Java interface is...'),                                         -- Q14
       ('Which primitive type stores a single character in Java?'),        -- Q15
       ('Which API introduced in Java 8 is used for date/time handling?'), -- Q16
       ('Which of these is NOT a Java primitive type?'),                   -- Q17
       ('Which keyword is used to import a package in Java?'),             -- Q18
       ('Which framework is commonly used for unit testing in Java?'),     -- Q19
       ('Which tool was historically used for building Java projects?');
-- Q20

-- Insert possible answers for each question (3 per question)
--    Q1: Is Java compiled or interpreted?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (1, 'Only compiled', false),
       (1, 'Only interpreted', false),
       (1, 'Both compiled and interpreted', true);

-- Q2: Java was originally created by which company?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (2, 'Sun Microsystems', true),
       (2, 'Apache Software Foundation', false),
       (2, 'Oracle Corporation', false);

-- Q3: Are Java and JavaScript closely related?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (3, 'Yes, JavaScript is an extension of Java', false),
       (3, 'Not really, they only share part of the name', true),
       (3, 'They use the exact same syntax', false);

-- Q4: Which version of Java is currently an LTS release?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (4, 'Java 8', false),
       (4, 'Java 11', true),
       (4, 'Java 15', false);

-- Q5: Which HTML tag is used to include JavaScript code?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (5, '<script>', true),
       (5, '<javascript>', false),
       (5, '<js>', false);

-- Q6: In which year was Java first released?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (6, '1991', false),
       (6, '1995', true),
       (6, '2000', false);

-- Q7: What is the standard signature for the main method in Java?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (7, 'public Program()', false),
       (7, 'public void main(String args)', false),
       (7, 'public static void main(String[] args)', true);

-- Q8: Which keyword is used for inheritance in Java?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (8, 'extends', true),
       (8, 'inherits', false),
       (8, 'implement', false);

-- Q9: What does JVM stand for?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (9, 'Java Virtual Machine', true),
       (9, 'Java Version Manager', false),
       (9, 'Java Value Model', false);

-- Q10: Which command is used to compile Java source files?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (10, 'javac', true),
       (10, 'java', false),
       (10, 'jar', false);

-- Q11: Which file extension holds the compiled bytecode for Java?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (11, '.class', true),
       (11, '.java', false),
       (11, '.jar', false);

-- Q12: What is the name of the main method in Java?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (12, 'start()', false),
       (12, 'main()', true),
       (12, 'run()', false);

-- Q13: What does the static keyword in Java indicate?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (13, 'The field/method belongs to the class rather than instances', true),
       (13, 'It can only be accessed from within the same package', false),
       (13, 'It is a keyword for inheritance', false);

-- Q14: A Java interface is...
INSERT INTO answer (question_id, answer_text, correct)
VALUES (14, 'A type of abstract class', false),
       (14, 'A contract that classes can implement', true),
       (14, 'An external library import', false);

-- Q15: Which primitive type stores a single character in Java?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (15, 'char', true),
       (15, 'String', false),
       (15, 'Character', false);

-- Q16: Which API introduced in Java 8 is used for date/time handling?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (16, 'java.util.Date', false),
       (16, 'java.time (LocalDate, LocalDateTime, etc.)', true),
       (16, 'java.sql.Timestamp', false);

-- Q17: Which of these is NOT a Java primitive type?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (17, 'float', false),
       (17, 'boolean', false),
       (17, 'String', true);

-- Q18: Which keyword is used to import a package in Java?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (18, 'package', false),
       (18, 'import', true),
       (18, 'using', false);

-- Q19: Which framework is commonly used for unit testing in Java?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (19, 'JUnit', true),
       (19, 'JDBC', false),
       (19, 'JAX-RS', false);

-- Q20: Which tool was historically used for building Java projects?
INSERT INTO answer (question_id, answer_text, correct)
VALUES (20, 'Apache Ant', true),
       (20, 'npm', false),
       (20, 'Composer', false);
