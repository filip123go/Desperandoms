# Desperandoms
Contains the Marketplace project for Coding Hive 2018

CREATE TABLE `student` (
  `STUDENTID` int(11) NOT NULL,
  `FIRSTNAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LASTNAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `USERNAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PASSWORD` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `YEARLEVEL` int(11) DEFAULT NULL,
  PRIMARY KEY (`STUDENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci