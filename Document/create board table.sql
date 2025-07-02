#########################################################
# board table 만들기	#####################################
#########################################################

-- web_db 사용
use web_db;

-- 테이블 등록 조회
show tables;

-- 테이블 삭제
drop table board;


-- board(게시판) 테이블 생성
create table board(
	no			int				primary key		auto_increment,
    user_no		int				not null,
    title		varchar(100)	not null,
    content		text,
    hit			int,
    reg_date	datetime		not null,
    constraint board_fk foreign key(user_no)
    references userdata(no)
);

-- 게시물 등록
insert into board
values(null, '1', '방문했습니다', '첫 번째 방문입니다', 3, '2025-06-30')
;

insert into board
values(null, '2', '방문했습니다', '두 번째 방문입니다', 6, '2025-06-30')
;

-- 전체 조회
select	b.no,
        b.title,
        b.content,
        b.hit,
        date_format(b.reg_date, '%Y-%m-%d') regDate,
        u.no userNo,
        u.name userName
from board b, userdata u
where u.no = b.user_no
order by b.no asc
limit 0, 10
;

-- 특정 게시물 조회
select	b.no,
        b.title,
        b.content,
        b.hit,
        date_format(b.reg_date, '%Y-%m-%d') regDate,
        u.no userNo,
        u.name userName
from board b, userdata u
where u.no = b.user_no
and b.no = 2
;

-- 게시글 수정
update board
set title = '수정된 제목',
	content = '수정된 본문',
    reg_date = now()
where no = 1;

-- 게시글 검색
select	count(*)
from board
where title like '%12%'
;