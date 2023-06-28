CREATE database testdb;

USE testdb;


CREATE TABLE IF NOT EXISTS `STUDENT` (
  `sid` int primary key auto_increment NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `num` int DEFAULT NULL,
  `major` varchar(10) DEFAULT NULL
   
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `STUDENT` (`sid`, `name`, `age`, `num`, `major`) VALUES
(1, 'ȫ�浿', 20, 202301, '�����'),
(2, '�Ӳ���', 21, 202201, '�����'),
(3, '�ֹ��', 22, 202101, '����'),
(4, '�ڸ��', 23, 202001, '����'),
(5, '����', 22, 202102, '��ǻ��'),
(6, '�迵��', 22, 202103, '�����'),
(7, '������', 24, 201901, '����'),
(8, 'ĳ����', 21, 202202, '������'),
(9, '�̳���', 20, 202303, '�����');

