

#########################################################
# mysite-user 만들기
#########################################################

-- db 선택
use web_db;

-- table 조회
show tables;

-- drop table
drop table userdata;

-- 테이블 생성
create table userdata(
	no				int				primary key		auto_increment,
	id				varchar(30)		unique			not null,
    password		varchar(20)		not null,
    name			varchar(20),
    gender			varchar(10)		-- male female
);

-- 등록
insert into userdata
values(3, 'jjj', '123', '김태희', 'female')
;

insert into userdata
values(1, 'aaa', '123', '정우성', 'female')
;
insert into userdata
values(2, 'bbb', '123', '유재석', 'female')
;

-- 조회
select	no,
		id,
		password,
        name,
        gender
from userdata
order by no desc
;

-- 수정
update guestbook
set name = '서장훈'
where person_id = 1;

-- 삭제
delete from guestbook
where no = 6;
