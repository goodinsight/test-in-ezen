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
('�峭��', '��ǰ����', 10, '�߰�����'),
('�峭��2', '��ǰ����2', 5, '�߰�����2'),
('�峭��3', '��ǰ����3', 6, '�߰�����3');

