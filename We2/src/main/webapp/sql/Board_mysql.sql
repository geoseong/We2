


-- ���̺� ����
CREATE TABLE cFindWork(
	cFindNum INT,   -- �Խù�ȣ
	cFindTitle VARCHAR(80),  -- ����
	userId VARCHAR(12),      -- �ۼ���
	cFindDate date,          -- �ۼ���
	cFindClick INT,          -- ��ȸ��
	cFindPath VARCHAR(50),   -- �ڷ���
	cFindContent VARCHAR(1000)  -- ����
)engine=InnoDB character set=utf8; 
desc cFindWork;
	
-- alter table ���̺�� add primary key(�÷���, �÷���, �÷��� ... );
alter table cFindWork add primary key(cFindNum);


