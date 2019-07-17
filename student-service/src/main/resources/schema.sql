  drop table if exists book_seq;
  drop table if exists student;

  create table book_seq(
    next_val bigint
  );

  create table student (
    id VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    schoolname VARCHAR(255),
    grade INTEGER,
    PRIMARY KEY(id)
  );


