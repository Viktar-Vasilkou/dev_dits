use my_dits;

SET FOREIGN_KEY_CHECKS = 0;	

TRUNCATE topic;
TRUNCATE test;
TRUNCATE question;
TRUNCATE answer;
TRUNCATE roles;
TRUNCATE users;
TRUNCATE userRole;
TRUNCATE statistic;
TRUNCATE literature;
TRUNCATE link;

SET FOREIGN_KEY_CHECKS = 1;

-- topic
LOCK TABLES topic WRITE;
INSERT INTO topic (description, name)
VALUES
('First Topic description','First Topic'),
('Second Topic description','Second Topic'),
('Third Topic description','Third Topic');
UNLOCK TABLES;

-- test
LOCK TABLES test WRITE;
insert into test (name, description, topicId)
values
('First test name', 'First test descrioption', 1),
('Second test name', 'Second test descrioption', 2);
UNLOCK TABLES;

-- question
LOCK TABLES question WRITE;
insert into question (description, testId)
values
('1 quest for 1 test', 1),
('2 quest for 1 test', 1),

('1 quest for 2 test', 2),
('2 quest for 2 test', 2);
UNLOCK TABLES;

-- answer
LOCK TABLES answer WRITE;
insert into answer (description, correct, questionId)
values
('1 ans for 1 quest', 0, 1),
('2 ans for 1 quest', 1, 1),

('1 ans for 2 quest', 1, 2),
('2 ans for 2 quest', 0, 2);
UNLOCK TABLES;

-- roles
LOCK TABLES roles WRITE;
insert into roles (name)
values
('ROLE_ADMIN'),
('ROLE_USER'),
('ROLE_TUTOR');
UNLOCK TABLES;

-- users
LOCK TABLES users WRITE;
insert into users (firstName, lastName, login, password)
values
('Kostya', 'Astashonok', 'root1', '$2y$12$SvW0hVMZUhLxQBQQVjX5DuQIDQzJn.aNJAEnh5cGdsD9Civcv48qa'), /* root */
('Dima', 'Korotin', 'root2', '$2y$12$SvW0hVMZUhLxQBQQVjX5DuQIDQzJn.aNJAEnh5cGdsD9Civcv48qa'), /* root */
('Vitya', 'Vasilkov', 'root3', '$2y$12$SvW0hVMZUhLxQBQQVjX5DuQIDQzJn.aNJAEnh5cGdsD9Civcv48qa'); /* root */
UNLOCK TABLES;

-- userRole
LOCK TABLES userRole WRITE;
insert into userRole (userId, roleId)
values
(1, 2),
(2, 1),
(3, 3);
UNLOCK TABLES;

-- statistic
LOCK TABLES statistic WRITE;
insert into statistic (date, correct, questionId, userId)
values
('2020-07-04 10:08:32', 1, 1, 2), -- first question first test
('2020-07-04 10:09:05', 0, 2, 2), -- second question first test

('2020-07-04 10:10:22', 0, 3, 2), -- first question second test
('2020-07-04 10:11:46', 1, 4, 2); -- second question second test
UNLOCK TABLES;

-- literature
LOCK TABLES  literature WRITE;
insert into  literature (description, questionId)
values
('Literature for quest 1.1', 1),
('Literature for quest 1.2', 2),
('Literature for quest 2.1', 3),
('Literature for quest 2.2', 4);
UNLOCK TABLES;

-- link
LOCK TABLES link WRITE;
insert into  link (link, literatureId)
values
('Link 1 for Lit 1', 1),
('Link 2 for Lit 1', 1),
('Link 1 for Lit 2', 2),
('Link 1 for Lit 3', 3),
('Link 1 for Lit 4', 4);
UNLOCK TABLES;
