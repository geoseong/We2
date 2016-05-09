

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

/* SQL�� : alter table test rename column osy to osy79;*/
alter table cTeamWork rename column cTeamNum to itemNum	;
alter table cTeamWork rename column cTeamTitle to itemTitle	;
alter table cTeamWork rename column cTeamDate to itemDate	;
alter table cTeamWork rename column cTeamClick to itemClick	;
alter table cTeamWork rename column cTeamPath to itemPath	;
alter table cTeamWork rename column cTeamContent to itemContent;

/** �̹� ����.*/

/* Ŀ�´�Ƽ - ��������*/
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

/* Ŀ�´�Ƽ - ����*/
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

/* Ŀ�´�Ƽ - �ɰ���*/
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




/* ������Ʈ - ��������*/
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

/* ������Ʈ - ����*/
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

/* ������Ʈ - �ɰ���*/
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

/* cTeamWork�� ���� ������ */
create sequence board_no start with 1 increment by 1;
insert into cTest values(cTest_no.nextval, 'cTeamWork test', 'ssang2nife', sysdate, 0, null, '�Խù� ���� �߰�');


/* cTeamWork �� ���� ������ */
create sequence cTeamWork_no start with 1 increment by 1;
/* cWithWork �� ���� ������ */
create sequence cWithWork_no start with 1 increment by 1;
/* cTest �� ���� ������ */
create sequence cTest_no start with 1 increment by 1;

/* pTeamWork �� ���� ������ */
create sequence pTeamWork_no start with 1 increment by 1;
/* pWithWork �� ���� ������ */
create sequence pWithWork_no start with 1 increment by 1;
/* pTest  �� ���� ������ */
create sequence pTest_no start with 1 increment by 1;

		/* �������� Ȯ�� ( ���������� �߸� �������� ������.. ) */
		SELECT OWNER, CONSTRAINT_NAME, TABLE_NAME,COLUMN_NAME, POSITION
		  FROM USER_CONS_COLUMNS;
		/* �������� ���� */
		ALTER TABLE board_smpl DROP CONSTRAINT sys_c0011176;
		/* �������� �߰� */
		ALTER TABLE board_smpl ADD CONSTRAINT cTeamNum_PK PRIMARY KEY (cTeamNum);

/* �÷��� �������� ���� */
		ALTER TABLE board_smpl MODIFY(cTeamTitle VARCHAR2(80));
		
insert into board_smpl values(board_no.nextval, null, null, TO_CHAR(SYSDATE,'YYYY/MM/DD HH:MI:SS'), null, null, null);
/* �� ORA-01861: ���ͷ��� ���� ���ڿ��� ��ġ���� ���� - to_char(sysdate) ���� String���̱� ����.*/

select count(*) from board_smpl;

/* Ư�� row���� Ư�� row������ ���̰� �ϴ� sql��.*/
select rownum, cteamnum  from
(SELECT ROWNUM AS RNUM, b.* 
FROM board_smpl b) A 
where a.rnum>=1 and rnum<=5;

/* Ŀ�� */
commit
