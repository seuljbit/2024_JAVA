-- 기록용, 나중에 유저와 비번, db를 확인할 목적

create user 'javaUser'@'localhost' IDENTIFIED by 'mysql';

create database javadb;

grant all privileges on javadb.* to 'javaUser'@'localhost' with grant option;
    flush privileges;
    
use javadb;

CREATE TABLE product (
  pno INT AUTO_INCREMENT PRIMARY KEY,
  pname VARCHAR(50) NOT NULL,
  price INT DEFAULT 0,
  regdate DATETIME DEFAULT NOW(),
  madeby TEXT
);

-- db는 수정되거나 추가되면 변경구문을 써놔야 함