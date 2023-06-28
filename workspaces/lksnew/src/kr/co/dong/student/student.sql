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
(1, '홍길동', 20, 202301, '국어국문'),
(2, '임꺽정', 21, 202201, '영어국문'),
(3, '최배달', 22, 202101, '수학'),
(4, '박명수', 23, 202001, '물리'),
(5, '장길산', 22, 202102, '컴퓨터'),
(6, '김영희', 22, 202103, '영어영문'),
(7, '윤도현', 24, 201901, '음악'),
(8, '캐리어', 21, 202202, '에어컨'),
(9, '이나라', 20, 202303, '국어국문');

