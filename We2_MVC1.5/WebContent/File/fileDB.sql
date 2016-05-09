create table fileshare(
	fcode number(5),
	fname varchar(50),
	fileurl varchar(50),
	fdate varchar(50)
);


create sequence file_seq start with 1 increment by 1;


update fileshare set  fdate=to_char(sysdate,'mm-dd/HH:MM:SS') where fcode=24
select  * from fileshare;

