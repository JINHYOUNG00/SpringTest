-- DDL.sql
CREATE TABLE book_tbl_06
(
            book_no number primary key,
            book_name varchar2(50) not null,
            book_coverimg varchar2(20),
            book_date date,
            book_price number,
            book_publisher varchar2(50),
            book_info varchar2(2000)
);

INSERT INTO book_tbl_06
VALUES (100, '������' , '100.jpg', '2015/09/02', 24000, '���轺', '�ü��, DB����, ��Ʈ��ũ����, ����ȯ�汸��');

INSERT INTO book_tbl_06
VALUES (101, '�ڹ�' , '101.jpg', '2016/01/10', 20000, '���ڹ�', '���α׷��� ���');
INSERT INTO book_tbl_06
VALUES (102, '�ڹ������α׷���' , '102.jpg', '2016/10/30', 25000,'������', '����ȯ��/�������α׷�/��ġ���α׷�');
INSERT INTO book_tbl_06
VALUES (103, '���¼ҽ�Ȱ���ϱ�' , '103.jpg', '2017/09/01', 30000,'�ڿ���', '�������, ����, ����');
INSERT INTO book_tbl_06
VALUES (104, 'HTML' , '104.jpg', '2018/04/04', 10000, 'ȫ�浿', 'HTML/CSS/JAVASCRIPT/JQUERY');

COMMIT;

SELECT * FROM BOOK_TBL_06;

CREATE TABLE rent_tbl_06
(
            rent_no NUMBER PRIMARY KEY,
            book_no NUMBER NOT NULL,
            rent_price NUMBER NOT NULL,
            rent_date DATE NOT NULL,
            rent_status CHAR(1) DEFAULT 0 NOT NULL
);

INSERT INTO rent_tbl_06
VALUES(10001, 100, 2400, '2018/07/02', '1');

INSERT INTO rent_tbl_06
VALUES(10002, 101, 2000, '2018/07/04', '1');

INSERT INTO rent_tbl_06
VALUES(10003, 100, 2400, '2018/08/02', '1');

INSERT INTO rent_tbl_06
VALUES(10004, 100, 2400, '2018/08/12', '1');

INSERT INTO rent_tbl_06
VALUES(10005, 102, 2500, '2018/08/13', '1');

INSERT INTO rent_tbl_06
VALUES(10006, 103, 3000, '2018/08/13', '1');

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date)
VALUES(10007, 103, 3000, '2018/08/20');

INSERT INTO rent_tbl_06
VALUES(10008, 100, 2400, '2018/09/03', '1');

INSERT INTO rent_tbl_06
VALUES(10009, 100, 2400, '2018/09/08', '1');

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date)
VALUES(10010, 100, 2400, '2018/09/14');

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date)
VALUES(10011, 102, 2500, '2018/09/14');

COMMIT;
SELECT * 
FROM rent_tbl_06
JOIN book_tbl_06
ON ;

select * from book_tbl_06;

select * from rent_tbl_06;

select sq.book_no, b.book_name, sq.rent_sum, sq.rent_cnt
from book_tbl_06 b
right join (
            select book_no, sum(rent_price) as rent_sum , count(book_no) as rent_cnt
            from rent_tbl_06
            group by book_no
            ) sq
on b.book_no = sq.book_no
order by sq.book_no;

select book_no, sum(rent_price) as rent_sum , count(book_no) as rent_cnt
from rent_tbl_06
group by book_no;
