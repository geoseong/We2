create table notice(
	num number(5) primary key,
	title varchar2(50),
	pass varchar2(30),
	writer varchar2(30),
	content varchar2(1000),
	writedate date default sysdate
);

create sequence notice_seq start with 1 increment by 1;