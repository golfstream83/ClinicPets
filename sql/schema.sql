-- create table
create table client (
	uid serial primary key,
	name varchar(200)
);

create table pet (
	uid serial primary key,
	client_id int not null references client(uid),
	nick varchar(200)
);