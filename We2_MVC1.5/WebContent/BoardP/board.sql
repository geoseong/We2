

select * from tabs;
select * from cTeamWork;

rename board_smpl to cTeamWork;
select * from cTeamWork;

drop table cTeamWork;
drop table cWithWork;
drop table cTest;
drop table pTeamWork;
drop table pWithWork;
drop table pTest;

/* SQL문 : alter table test rename column osy to osy79;*/
alter table cTeamWork rename column cTeamNum to itemNum	;
alter table cTeamWork rename column cTeamTitle to itemTitle	;
alter table cTeamWork rename column cTeamDate to itemDate	;
alter table cTeamWork rename column cTeamClick to itemClick	;
alter table cTeamWork rename column cTeamPath to itemPath	;
alter table cTeamWork rename column cTeamContent to itemContent;

/** 이미 만듦.*/

/* 커뮤니티 - 조별과제*/
create table cTeamWork(
	itemNum	number(4),
	itemTitle		varchar2(80),
	userId		varchar2(12),
	itemDate	DATE,
	itemClick	number(4),
	itemPath	varchar2(50),
	itemContent 	varchar2(1000),
	primary key (itemNum)
);

/* 커뮤니티 - 협업*/
create table cWithWork(
	itemNum	number(4),
	itemTitle		varchar2(80),
	userId		varchar2(12),
	itemDate	DATE,
	itemClick	number(4),
	itemPath	varchar2(50),
	itemContent 	varchar2(1000),
	primary key (itemNum)
);

/* 커뮤니티 - 셤공부*/
create table cTest(
	itemNum	number(4),
	itemTitle		varchar2(80),
	userId		varchar2(12),
	itemDate	DATE,
	itemClick	number(4),
	itemPath	varchar2(50),
	itemContent 	varchar2(1000),
	primary key (itemNum)
);




/* 프로젝트 - 조별과제*/
create table pTeamWork(
	itemNum	number(4),
	itemTitle		varchar2(80),
	userId		varchar2(12),
	itemDate	DATE,
	itemClick	number(4),
	itemPath	varchar2(50),
	itemContent 	varchar2(1000),
	primary key (itemNum)
);

/* 프로젝트 - 협업*/
create table pWithWork(
	itemNum	number(4),
	itemTitle		varchar2(80),
	userId		varchar2(12),
	itemDate	DATE,
	itemClick	number(4),
	itemPath	varchar2(50),
	itemContent 	varchar2(1000),
	primary key (itemNum)
);

/* 프로젝트 - 셤공부*/
create table pTest(
	itemNum	number(4),
	itemTitle		varchar2(80),
	userId		varchar2(12),
	itemDate	DATE,
	itemClick	number(4),
	itemPath	varchar2(50),
	itemContent 	varchar2(1000),
	primary key (itemNum)
);



select * from board_smpl;

/* cTeamWork에 대한 시퀀스 */
create sequence board_no start with 1 increment by 1;
insert into cTest values(cTest_no.nextval, 'cTeamWork test', 'ssang2nife', sysdate, 0, null, '게시물 내용 추가');


/* cTeamWork 에 대한 시퀀스 */
create sequence cTeamWork_no start with 1 increment by 1;
/* cWithWork 에 대한 시퀀스 */
create sequence cWithWork_no start with 1 increment by 1;
/* cTest 에 대한 시퀀스 */
create sequence cTest_no start with 1 increment by 1;

/* pTeamWork 에 대한 시퀀스 */
create sequence pTeamWork_no start with 1 increment by 1;
/* pWithWork 에 대한 시퀀스 */
create sequence pWithWork_no start with 1 increment by 1;
/* pTest  에 대한 시퀀스 */
create sequence pTest_no start with 1 increment by 1;

		/* 제약조건 확인 ( 제약조건을 잘못 지정했을 때에만.. ) */
		SELECT OWNER, CONSTRAINT_NAME, TABLE_NAME,COLUMN_NAME, POSITION
		  FROM USER_CONS_COLUMNS;
		/* 제약조건 제거 */
		ALTER TABLE board_smpl DROP CONSTRAINT sys_c0011176;
		/* 제약조건 추가 */
		ALTER TABLE board_smpl ADD CONSTRAINT cTeamNum_PK PRIMARY KEY (cTeamNum);

/* 컬럼의 데이터형 수정 */
		ALTER TABLE board_smpl MODIFY(cTeamTitle VARCHAR2(80));
		
insert into board_smpl values(board_no.nextval, null, null, TO_CHAR(SYSDATE,'YYYY/MM/DD HH:MI:SS'), null, null, null);
/* └ ORA-01861: 리터럴이 형식 문자열과 일치하지 않음 - to_char(sysdate) 형이 String형이기 때문.*/

select count(*) from board_smpl;

/* 특정 row부터 특정 row까지만 보이게 하는 sql문.*/
select rownum, cteamnum  from
(SELECT ROWNUM AS RNUM, b.* 
FROM board_smpl b) A 
where a.rnum>=1 and rnum<=5;

/* 커밋 */
commit
