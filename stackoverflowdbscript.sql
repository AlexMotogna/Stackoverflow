drop schema if exists stackoverflow;
create schema stackoverflow;
use stackoverflow;

create table user(
id int auto_increment not null,
username varchar(20) not null,
email varchar(30) not null,
password varchar(20) not null,
score int,
admin bool not null,
banned bool not null,
primary key(id)
);

create table question(
id int auto_increment not null,
title varchar(40) not null,
text varchar(100) not null,
creationtime datetime not null,
authorid int not null,
score int,
primary key(id),
foreign key(authorid) references user(id) ON DELETE CASCADE ON UPDATE RESTRICT
);

create table answer(
id int auto_increment not null,
text varchar(100) not null,
creationtime datetime not null,
qid int not null,
authorid int not null,
score int,
primary key(id),
foreign key(authorid) references user(id) ON DELETE CASCADE ON UPDATE RESTRICT,
foreign key(qid) references question(id) ON DELETE CASCADE ON UPDATE RESTRICT
);

create table tag(
id int auto_increment not null,
name varchar(20) not null,
primary key(id)
);

create table question_tag(
qid int not null,
tagid int not null,
primary key(qid, tagid),
foreign key(qid) references question(id) ON DELETE CASCADE ON UPDATE RESTRICT,
foreign key(tagid) references tag(id) ON DELETE CASCADE ON UPDATE RESTRICT
);

create table question_vote(
qid int not null,
userid int not null,
upvote bool not null,
primary key(qid, userid),
foreign key(qid) references question(id) ON DELETE CASCADE ON UPDATE RESTRICT,
foreign key(userid) references user(id) ON DELETE CASCADE ON UPDATE RESTRICT
);

create table answer_vote(
aid int not null,
userid int not null,
upvote bool not null,
primary key(aid, userid),
foreign key(aid) references answer(id) ON DELETE CASCADE ON UPDATE RESTRICT,
foreign key(userid) references user(id) ON DELETE CASCADE ON UPDATE RESTRICT
);

INSERT INTO user (username, email, password, score, admin, banned) 
VALUES ("Alexandru Motogna", "alexmotogna@gmail.com", "123", 22, 0, 0);

INSERT INTO user (username, email, password, score, admin, banned) 
VALUES ("Person", "person@gmail.com", "1234", 0, 0, 0);

INSERT INTO question (title, text, creationtime, authorid, score)
VALUES ("Java Question", "Why it don't work?", sysdate(), 1, 0);

INSERT INTO question (title, text, creationtime, authorid, score)
VALUES ("Python Question", "Why it don't work?", sysdate(), 2, 0);

INSERT INTO answer (text, creationtime, qid, authorid, score)
VALUES ("This is how", sysdate(), 1, 2, 0);

INSERT INTO answer (text, creationtime, qid, authorid, score)
VALUES ("This is how it's done", sysdate(), 2, 1, 0);

INSERT INTO answer (text, creationtime, qid, authorid, score)
VALUES ("Correction: This is how", sysdate(), 2, 1, 0);

INSERT INTO tag (name) 
VALUES ("Java");

INSERT INTO tag (name) 
VALUES ("Python");

INSERT INTO question_tag(qid, tagid) 
VALUES (1, 1);

INSERT INTO question_tag(qid, tagid) 
VALUES (2, 2);

