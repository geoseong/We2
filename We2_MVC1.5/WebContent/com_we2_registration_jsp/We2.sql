create table member(
name varchar2(10),
userid varchar2(12), 
pwd varchar2(12) not null,
email varchar2(30),
sub_email varchar2(30),
phone char(13),
gender number(1) default(0), --1:³²ÀÚ,0:¿©ÀÚ
primary key(userid)
);

insert into member values('½ÖÄ®','ssang2nife'
,'1234', 'ssang2nife@naver.com','ssang2nife@gmail.com',
'010-1245-8954','1');

select * from member;