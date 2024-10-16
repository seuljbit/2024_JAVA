-- 기록용, 나중에 유저와 비번, db를 확인할 목적

create user 'javaUser'@'localhost' IDENTIFIED by 'mysql';

create database javadb;

grant all privileges on javadb.* to 'javaUser'@'localhost' with grant option;
    flush privileges;
    
use javadb;

CREATE TABLE student (
    student_id VARCHAR(10) PRIMARY KEY,  		 -- 학번
    student_name VARCHAR(50) NOT NULL,           -- 이름
    student_birth_date DATE,                     -- 생년월일
    student_phone_number VARCHAR(15),            -- 전화번호
    student_address VARCHAR(255),                -- 주소
    student_admission_date DATE,                 -- 입학일
    student_department VARCHAR(100),             -- 학부
    student_major VARCHAR(100)               	 -- 학과
);