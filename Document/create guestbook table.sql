#########################################################
# guestbook table 만들기	#################################
#########################################################

-- web_db 사용
use web_db;

-- 테이블 등록 조회
show tables;

-- guestbook(게시판) 테이블 생성
create table guestbook(
	no			int				primary key		auto_increment,
    user_name	varchar(20)		not null,
    password	varchar(20)		not null,
    reg_date	datetime,
    content		text
);

-- 테이블 삭제
drop table guestbook;

-- 방명록 등록
insert into guestbook
values(null, '이정재', '123', now(), '방명록 글입니다. 방명록 글입니	다.')
;

-- 전체 조회
select	no,
		user_name userName,
        password,
        reg_date regDate,
        content
from guestbook
order by no asc
;