drop table if exists member;

create table if not exists member(
	loginId varchar(10) primary key,
	password varchar(20) not null,
	name varchar(16) not null,
	phone varchar(12),
	email varchar(30)
);