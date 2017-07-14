CREATE TABLE IF NOT EXISTS user (
  ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  CREATED_DATE DATE NOT NULL,
  MODIFIED_DATE DATE,
  FIRST_NAME VARCHAR(30),
  LAST_NAME VARCHAR(40),
  EMAIL VARCHAR(50) NOT NULL UNIQUE,
  SEX VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS message (
  ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  CREATED_DATE DATE NOT NULL,
  MODIFIED_DATE DATE,
  TITLE VARCHAR(255) NOT NULL,
  BODY VARCHAR(5000) NOT NULL,
  USER_ID INTEGER REFERENCES user(ID)
);

CREATE TABLE IF NOT EXISTS comment (
  ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  CREATED_DATE DATE NOT NULL,
  MODIFIED_DATE DATE,
  COMMENT_TEXT VARCHAR(4000) NOT NULL,
  USER_ID INTEGER REFERENCES user(ID),
  MESSAGE_ID INTEGER REFERENCES message(ID)
);

CREATE TABLE IF NOT EXISTS like_table (
  ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  CREATED_DATE DATE NOT NULL,
  MODIFIED_DATE DATE,
  USER_ID INTEGER REFERENCES user(ID),
  MESSAGE_ID INTEGER REFERENCES message(ID)
);

CREATE TABLE IF NOT EXISTS share (
  ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  CREATED_DATE DATE NOT NULL,
  MODIFIED_DATE DATE,
  SHARE_TO VARCHAR(100) NOT NULL,
  MESSAGE_ID INTEGER REFERENCES message(ID)
);





