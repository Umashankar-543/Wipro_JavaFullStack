-- DDl comands

create database if not exists Wipro;

use Wipro;

select * from day;

create table student(
id int primary key,
sname varchar(30),
gpa decimal(3,2));
drop table student;

truncate table student;

describe student;

alter table student add department varchar(5);

alter table student drop column department;

alter table student rename column gpa to cgpa;

