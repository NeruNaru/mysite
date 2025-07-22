#########################################################
# guestbook table 만들기	#################################
#########################################################

-- web_db 사용
use web_db;

-- 테이블 등록 조회
show tables;

-- fileattach(파일업로드) 테이블 생성
create table fileattach(
	no			int				primary key		auto_increment,
	name		varchar(20)		not null,
    org_name	varchar(50),
    ex_name		varchar(10),
    save_name	varchar(100),
    file_path	varchar(100),
    file_size	int
);

-- 테이블 삭제
drop table fileattach;

-- 전체 조회
select	no,
		name,
        org_name	orgName,
        ex_name		exName,
        save_name	saveName,
        file_path	filePath,
        file_size	fileSize
from fileattach
;

