
CREATE TABLE `STUDENT` (
`ID` int(3) NOT NULL,
`NAME` varchar(10) NOT NULL,
`BIRTHDAY` date DEFAULT NULL,
PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
select * from STUDENT;

CREATE TABLE `OPERLOG` (
`ID` int(3) NOT NULL AUTO_INCREMENT,
`OPERTYPE` varchar(10) NOT NULL,
`OPERDATE` date DEFAULT NULL,
PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table STUDENT add column GENDER int(1);

alter table STUDENT drop column gender;