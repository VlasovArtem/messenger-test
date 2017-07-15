INSERT INTO user VALUES
(1, NOW(), null, 'Jon', 'Doe', 'jon-doe@mail.com', 'MALE'),
(2, NOW(), null, 'Jane', 'Doe', 'jane-doe@mail.com', 'FEMALE');
INSERT INTO message VALUES
(1, NOW(), null, 'Message to Jane Doe', 'I write this message to Jane Doe', 1),
(2, NOW(), null, 'Message to Jon Doe', 'I write this message to Jon Doe', 2);
INSERT INTO comment VALUES
(1, NOW(), null, 'Hello Jane', 1, 2),
(2, NOW(), null, 'Hello Jon', 2, 1);
INSERT INTO like_table VALUES
(1, NOW(), null, 1, 2),
(2, NOW(), null, 2, 1),
(3, NOW(), null, 2, 2);
INSERT INTO share VALUES
(1, NOW(), null, 'https://twitter.com', 1),
(2, NOW(), null, 'https://instagram.com', 2);