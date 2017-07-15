INSERT INTO user VALUES
  (1, NOW(), NULL, ''Jon'', ''Doe'', ''jon - doe@mail.com'', ''MALE''),
  (2, NOW(), NULL, ''Jane'', ''Doe'', ''jane - doe@mail.com'', ''FEMALE'');
INSERT INTO message VALUES
  (1, NOW(), NULL, ''Message TO Jane Doe'', ''I write this message TO Jane Doe'', 1),
  (2, NOW(), NULL, ''Message TO Jon Doe'', ''I write this message TO Jon Doe'', 2);
INSERT INTO comment VALUES
  (1, NOW(), NULL, ''Hello Jane'', 1, 2),
  (2, NOW(), NULL, ''Hello Jon'', 2, 1);
INSERT INTO like_table VALUES
  (1, NOW(), NULL, 1, 2),
  (2, NOW(), NULL, 2, 1),
  (3, NOW(), NULL, 2, 2);
INSERT INTO share VALUES
  (1, NOW(), NULL, ''https://twitter.com'', 1),
  (2, NOW(), NULL, ''https://instagram.com'', 2);