/*
create table test_table (
idx int NOT NULL auto_increment,
name varchar(255),
... 블라 블라,
... 블라 블라,
... 블라 블라,  
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=euckr;
 */

drop table cFindwork;

-- 1) 커뮤니티게시판 -> 팀원 구하기
create table cFindwork (
	itemNum	int NOT NULL AUTO_INCREMENT,
	itemTitle		varchar(80),
	userId		varchar(12),
	itemDate	DATE,
	itemClick	int,
	itemPath	varchar(50),
	itemContent 	varchar(1000),
	primary key (itemNum)
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


-- 가끔은 이놈을 초기화 시켜야 할때가 있습니다. 초기화 시키기 위한 꼬라지는 아래와 같습니다.
-- 테이블을 지워야지면 관련 auto_increment가 지워지는 듯? 그냥은 초기화가 안됨.
-- # ALTER TABLE [테이블명] AUTO_INCREMENT=[시작할려는 순서]

ALTER TABLE cFindwork ADD COLUMN itemDataType varchar(50);

-- itemNum내림차순으로 select
select * from cFindwork order by itemNum desc;

-- limit을 이용한 출력
select * from cFindwork order by itemNum desc limit 0, 10;

SHOW TABLE STATUS FROM we2 LIKE 'cFindwork';

select 
itemNum, itemTitle, userId, 
date_format(itemDate,%Y-%m-%d), 
itemClick, itemPath, itemContent
from cFindwork limit 1, 10;

select 
date_format(itemDate,'%Y-%m-%d')  as idate,
itemClick, itemPath, itemContent
from cFindwork ;

select  * from cFindwork;




-- 2) 커뮤니티게시판 -> 자유게시판
create table cFreework (
	itemNum	int NOT NULL AUTO_INCREMENT,
	itemTitle		varchar(80),
	userId		varchar(12),
	itemDate	DATE,
	itemClick	int,
	itemPath	varchar(50),
	itemContent 	varchar(1000),
	primary key (itemNum)
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


-- 가끔은 이놈을 초기화 시켜야 할때가 있습니다. 초기화 시키기 위한 꼬라지는 아래와 같습니다.
-- 테이블을 지워야지면 관련 auto_increment가 지워지는 듯? 그냥은 초기화가 안됨.
-- # ALTER TABLE [테이블명] AUTO_INCREMENT=[시작할려는 순서]

ALTER TABLE cFreework ADD COLUMN itemDataType varchar(50);

-- itemNum내림차순으로 select
select * from cFreework order by itemNum desc;

-- limit을 이용한 출력
select * from cFreework order by itemNum desc limit 0, 10;

SHOW TABLE STATUS FROM we2 LIKE 'cFreework';

select 
itemNum, itemTitle, userId, 
date_format(itemDate,%Y-%m-%d), 
itemClick, itemPath, itemContent
from cFreework limit 1, 10;

select 
date_format(itemDate,'%Y-%m-%d')  as idate,
itemClick, itemPath, itemContent
from cFindwork ;

select  * from cFreework;



