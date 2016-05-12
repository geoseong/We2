


-- 테이블 생성
CREATE TABLE cFindWork(
	cFindNum INT,   -- 게시번호
	cFindTitle VARCHAR(80),  -- 제목
	userId VARCHAR(12),      -- 작성자
	cFindDate date,          -- 작성일
	cFindClick INT,          -- 조회수
	cFindPath VARCHAR(50),   -- 자료경로
	cFindContent VARCHAR(1000)  -- 내용
)engine=InnoDB character set=utf8; 
desc cFindWork;
	
-- alter table 테이블명 add primary key(컬럼명, 컬럼명, 컬럼명 ... );
alter table cFindWork add primary key(cFindNum);


