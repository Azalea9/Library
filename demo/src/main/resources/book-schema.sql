drop table if exists books CASCADE;
create table books
 (
 	bookid bigint primary key auto_increment,
 	authors varchar(255),
 	isbn bigint,
 	title varchar(255)
 );