-- 테이블 생성
create table spring_board (
	id number(10, 0) not null,
	subject varchar2(50),
	name varchar2(50),
	created_date date,
	mail varchar2(50),
	memo varchar2(200),
	hits number(10, 0),
	primary key(id) enable
);
-- 시퀀스 생성
create sequence seq_id minvalue 1 maxvalue 99999999999
increment by 1 start with 1;

drop sequence "seq_id";

drop table spring_board;

select * from spring_board;

commit