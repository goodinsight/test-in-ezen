CREATE database testdb;

USE testdb;

CREATE TABLE IF NOT EXISTS `goods` (
  `gid` int primary key auto_increment NOT NULL,
  `gname` varchar(45) NOT NULL,
  `gcontent` varchar(45) NOT NULL,
  `gcnt` int DEFAULT NULL,
  `getc` varchar(45) DEFAULT NULL
   
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `goods`.`goods` (`gname`, `gcontent`, `gcnt`, `getc`) VALUES
('장난감', '제품설명', 10, '추가설명'),
('장난감2', '제품설명2', 5, '추가설명2'),
('장난감3', '제품설명3', 6, '추가설명3');

