
select DATE_FORMAT('05-01-2016', %m-%d-%Y);
select to_days('05-01-2016') - to_days('05-15-2016');

DATE_FORMAT(05/01/2016,'%m/%d/%Y');
DATE_FORMAT(05/12/2016,'%m-%d-%Y');

DATE_FORMAT(NOW(),'%m-%d-%Y')

SELECT TO_DAYS(ENDDATE)-TO_DAYS(STARTDATE) FROM PJTMAKE WHERE PJTCODE=10;