
CREATE TABLE `STUDENT` (
`ID` int(3) NOT NULL,
`NAME` varchar(10) NOT NULL,
`BIRTHDAY` date DEFAULT NULL,
PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `OPERLOG` (
`ID` int(3) NOT NULL AUTO_INCREMENT,
`OPERTYPE` varchar(10) NOT NULL,
`OPERDATE` date DEFAULT NULL,
PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `SCORE` (
`KEMU_NAME` varchar(10) NOT NULL,
`STUDENT_ID` int(3)  NOT NULL,
`SCORE` int(3) NOT NULL,
`ID` int(3) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (`ID`)
) 

select 
	SC.KEMU_NAME,
	SC.SCORE,
	ST.ID,
	ST.NAME
from 
	SCORE SC, STUDENT ST where SC.STUDENT_ID = ST.ID and ST.ID = 1 and SC.KEMU_NAME = '语文';

	update SCORE set KEMU_NAME = 'yuwen' where id = 1;


alter table STUDENT add column GENDER int(1);

alter table STUDENT drop column gender;

select * from STUDENT;

drop table SCORE;


