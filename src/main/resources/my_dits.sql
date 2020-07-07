-- create schema

CREATE schema IF NOT EXISTS my_dits;

use my_dits;

-- delete tables if exists
SET FOREIGN_KEY_CHECKS = 0;	

DROP TABLE IF EXISTS topic;
DROP TABLE IF EXISTS test;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS userRole;
DROP TABLE IF EXISTS statistic;
DROP TABLE IF EXISTS literature;
DROP TABLE IF EXISTS link;

SET FOREIGN_KEY_CHECKS = 1;	


-- create tables

-- topic
create table if not exists topic(
	id bigint not null auto_increment primary key,
    description varchar(150) not null,
    name varchar(100) not null
) engine = InnoDB;

-- test 
create table if not exists test(
	id bigint not null auto_increment primary key,
    name varchar(100) not null,
    description varchar(150) not null,
    topicId bigint not null,
    
    foreign key(topicId) references topic(id) on delete cascade
) engine = InnoDB;

-- question
create table if not exists question(
	id bigint not null auto_increment primary key,
	description varchar(150) not null,
    testId bigint not null,
    
    foreign key(testID) references test(id) on delete cascade
) engine = InnoDB;

-- answer
create table if not exists answer(
	id bigint not null auto_increment primary key,
    description varchar(150) not null,
    correct boolean not null,
    questionId bigint not null,
    
    foreign key (questionId) references question (id) on delete cascade
) engine = InnoDB;

-- roles
create table if not exists roles(
	id bigint not null auto_increment primary key,
    name varchar(50) not null
) engine = InnoDB;

-- users
create table if not exists users(
	id bigint not null auto_increment primary key,
	firstName varchar(50) not null,
    lastName varchar(50) not null,
    login varchar(50) not null unique,
    password varchar(255) not null
) engine = InnoDB;

-- userRole
create table if not exists userRole(
	userId bigint not null ,
    roleId bigint not null ,
    
    primary key(userId, roleId),
    
    foreign key(userId) references users(id) on delete cascade,
    foreign key(roleId) references roles(id) on delete cascade
)  engine = InnoDB;

-- statistic
create table if not exists statistic(
	id bigint not null auto_increment primary key,
    date datetime not null,
    correct boolean not null,
    questionId bigint not null,
    userId bigint not null,
    
    foreign key(questionId) references question(id) on delete cascade,
    foreign key(userId) references users(id) on delete cascade
) engine = InnoDB;

-- literature
create table if not exists literature(
	id bigint not null auto_increment primary key,
    description varchar(150) not null,
    questionId bigint not null,
    
     foreign key(questionId) references question(id) on delete cascade
) engine = InnoDB;

-- link
create table if not exists link(
	id bigint not null auto_increment primary key,
    link varchar(250) not null,
    literatureId bigint not null,
    
    foreign key(literatureId) references literature(id) on delete cascade
) engine = InnoDB;
