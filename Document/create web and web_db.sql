#####################################
##	web 계정 만들기					#
#####################################

-- 계정생성
create user 'web'@'localhost' identified by 'web';

create user 'web'@'%' identified by 'web';

-- 계정삭제
drop user 'web'@'localhost';

-- 권한 부여
grant all privileges on web_db.* to 'web'@'%' ;

-- 데이터베이스 생성
create database web_db
    default character set utf8mb4
    collate utf8mb4_general_ci
    default encryption='n'
;

-- 데이터베이스 조회
show databases;