/*
create table test_table (
idx int NOT NULL auto_increment,
name varchar(255),
... 블라 블라,
... 블라 블라,
... 블라 블라,  
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=euckr;
 */

-- 프로젝트게시판 - 조별과제
create table pGroup (
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
-- >> ALTER TABLE [테이블명] AUTO_INCREMENT=[시작할려는 순서]

-- itemNum내림차순으로 select
select * from pGroup order by itemNum desc;

-- limit을 이용한 출력
select * from pGroup order by itemNum desc limit 0, 10;

select 
itemNum, itemTitle, userId, 
date_format(itemDate,%Y-%m-%d), 
itemClick, itemPath, itemContent
from pGroup limit 1, 10;

select 
date_format(itemDate,'%Y-%m-%d')  as idate,
itemClick, itemPath, itemContent
from pGroup ;

select  * from pgroup;
