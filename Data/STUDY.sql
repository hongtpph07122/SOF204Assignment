CREATE DATABASE STUDY
USE STUDY
GO

--------
IF OBJECT_ID('CLASS') IS NOT NULL
DROP TABLE CLASS
GO
CREATE TABLE CLASS(
ID NVARCHAR(5) NOT NULL,
PRIMARY KEY (ID)
)
--------
INSERT INTO CLASS VALUES ('9A')
INSERT INTO CLASS VALUES ('9B')
INSERT INTO CLASS VALUES ('9C')
--------


IF OBJECT_ID('ACCOUNTS') IS NOT NULL
DROP TABLE ACCOUNTS
GO
CREATE TABLE ACCOUNTS(
USERNAME  NVARCHAR(12) NOT NULL,
PASSWORD NVARCHAR(16) NOT NULL,
TYPE BIT NOT NULL,
FULLNAME NVARCHAR(30) NOT NULL,
GENDER BIT NOT NULL,
BIRTHDAY DATE NOT NULL,
PHONE NVARCHAR(10) NOT NULL,
EMAIL NVARCHAR(30) NOT NULL,
CLASS NVARCHAR(5) NULL
PRIMARY KEY (USERNAME)

)
SELECT * FROM ACCOUNTS
SELECT * FROM CLASS
-------

INSERT INTO ACCOUNTS VALUES ('HS1','HS1',0,N'TRẦN VĂN NAM',1,'04-04-2000','091234122',N'E1@GMAIL.COM','9A')
INSERT INTO ACCOUNTS VALUES ('HS03','HS1',0,N'TRẦN VĂN NAM',1,'04-04-2000','091234122',N'E3@GMAIL.COM','9A')
INSERT INTO ACCOUNTS VALUES ('HS04','HS1',0,N'TRẦN VĂN NAM',1,'04-04-2000','091234122',N'E3@GMAIL.COM','')
INSERT INTO ACCOUNTS VALUES ('GV06','HS1',1,N'TRẦN VĂN NUA',0,'4-24-2000','091234123',N'G5@GMAIL.COM','')
IF OBJECT_ID('QUESTIONS') IS NOT NULL
DROP TABLE QUESTIONS
GO
CREATE TABLE QUESTIONS(
ID INT IDENTITY(1,1) NOT NULL,
Q NVARCHAR(MAX) NOT NULL,
AA NVARCHAR(MAX) NOT NULL,
AB NVARCHAR(MAX) NOT NULL,
AC NVARCHAR(MAX) NOT NULL,
AD NVARCHAR(MAX) NOT NULL,
ANSWER NVARCHAR(1) NOT NULL,
PRIMARY KEY (ID)
)
DELETE FROM QUESTIONS
--------]
INSERT INTO QUESTIONS VALUES (N'Nguyên nhân thúc đẩy cuộc khai thác thuộc địa lần thứ hai của Pháp là gì?',
N'Chuẩn bị cho chiến tranh thế giới.',
N'Bù đắp những thiệt hại do chiến tranh thế giới gây ra.',
N'Phát triển thuộc địa.',
N'Biến Việt Nam thành thị trường tiêu thụ của Pháp.',
N'B')
INSERT INTO QUESTIONS VALUES (N'Tư bản Pháp đầu tư vốn nhiều nhất vào lĩnh vực nào?',
N'Nông nghiệp.',
N'Công nghiệp.',
N'Giao thông vận tải.',
N'Khai mỏ',
N'A')
INSERT INTO QUESTIONS VALUES (N'Tại sao tư bản Pháp tập trung vốn vào việc lập đồn điền cao su và khai thác than?',
N'Cao su và than có giá trị cao.',
N'Việt Nam nhiều cao su và than.',
N'Cao su và than là hai mặt hàng thị trường Pháp và thế giới có nhu cầu lớn.',
N'Cao su và than dễ khai thác.',
N'C')
INSERT INTO QUESTIONS VALUES (N'Trong chính sách thương nghiệp, vì sao thực dân Pháp đánh thuế nặng các hàng hóa nước ngoài vào Việt Nam?',
N'Tạo sự canh tranh giữa hàng hóa các nước nhập vào Đông Dương.',
N'Không cho hàng hóa nước ngoài vào Việt Nam.',
N'Tạo điều kiện cho thương nghiệp Đông Dương phát triển.',
N'Muốn độc chiếm thị trường Việt Nam và Đông Dương.',
N'D')
INSERT INTO QUESTIONS VALUES (N'Chương trình khai thác thuộc địa lần thứ hai của thực dân Pháp tác động như thế nào đến nền kinh tế Việt Nam?',
N'Nền kinh tế Việt Nam Phát triển độc lập.',
N'Nền kinh tế Việt Nam vẫn lạc hậu, không phát triển.',
N'Nền kinh tế Việt Nam phát triển thêm một bước nhưng bị kìm hãm, lệ thuộc vào nền kinh tế Pháp.',
N'Nền kinh tế Việt Nam lệ thuộc hoàn toàn vào nền kinh tế Pháp.',
N'C')
INSERT INTO QUESTIONS VALUES (N'Ai là vị trạng nguyên trẻ tuổi nhất nước Nam?',
N'Lương Thế Vinh',
N'Mạc Đĩnh Chi',
N'Nguyễn Bỉnh Khiêm',
N'Nguyễn Hiền',
N'D')
INSERT INTO QUESTIONS VALUES (N'Chiến dịch Tây Nguyên diễn ra vào khoảng thời gian nào ?',
N'10/3 – 24/3/1975',
N'21/3 – 3/4/1975',
N'29/8 - 12/9/1975',
N'12/12 - 14/12/1975',
N'A')
INSERT INTO QUESTIONS VALUES (N'Quân đội Sài Gòn có những hành động nào nhằm phá hoại Hiệp định Pa-ri?',
N'Tiếp tục nhận viện trợ quân sự của Mĩ.',
N'Tiếp tục nhận viện trợ quân sự của Pháp.',
N'Lập Bộ chỉ huy quân sự.',
N'Tiến hành chiến dịch “tràn ngập lãnh thổ”, mở những cuộc hành quân bình định – lấn chiếm vùng giải phóng.',
N'D')
INSERT INTO QUESTIONS VALUES (N'Ta mở hoạt động quân sự đông xuân vào cuối 1974 đầu 1975, trọng tâm là:',
N'Đồng bằng Nam bộ và Nam Trung bộ.',
N'Đồng bằng sông Cửu Long và Đông Nam bộ.',
N'Trung bộ và khu V.',
N'Mặt trận Trị - Thiên.',
N'B')
INSERT INTO QUESTIONS VALUES (N'Thắng lợi tiêu biểu nhất trong các hoạt động quân sự Đông Xuân 1974 – 1975 là:',
N'Chiến thắng Đường 9 – Nam Lào.',
N'Đánh bại cuộc hành quân “Lam Sơn 719” của Mĩ – Ngụy.',
N'Chiến dịch Đường 14 – Phước Long.',
N'Chiến dịch Tây Nguyên.',
N'C')
INSERT INTO QUESTIONS VALUES (N'Kế hoạch giải phóng miền Nam được Bộ Chính trị Trung ương Đảng đề ra trong 2 năm, đó là 2 năm nào?',
N'1972 và 1973',
N'1973 và 1974',
N'1974 và 1975',
N'1975 và 1976',
N'D')
INSERT INTO QUESTIONS VALUES (N'',
N'',
N'',
N'',
N'',
N'')
INSERT INTO QUESTIONS VALUES (N'',
N'',
N'',
N'',
N'',
N'')
SELECT * FROM QUESTIONS

IF OBJECT_ID('EXAM') IS NOT NULL
DROP TABLE EXAM
GO
CREATE TABLE EXAM(
ID NVARCHAR(5) NOT NULL,
TEST_DAY DATE NOT NULL,
PRIMARY KEY (ID)
)
-----
INSERT INTO EXAM VALUES (N'EXAM1','03-21-2020')
INSERT INTO EXAM VALUES (N'EXAM2','03-21-2020')
INSERT INTO EXAM VALUES (N'EXAM3','03-21-2021')
SELECT * FROM EXAM
IF OBJECT_ID('EXAM_DETAIL') IS NOT NULL
DROP TABLE EXAM_DETAIL
GO
CREATE TABLE EXAM_DETAIL(
ID INT IDENTITY(1,1) NOT NULL,
EXAM_ID NVARCHAR(5) NOT NULL,
QUESTION_ID INT NOT NULL,
FOREIGN KEY (EXAM_ID) REFERENCES EXAM(ID) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (QUESTION_ID) REFERENCES QUESTIONS(ID) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (ID)
)

-----
INSERT INTO EXAM_DETAIL VALUES (N'EXAM1',4)
INSERT INTO EXAM_DETAIL VALUES (N'EXAM1',5)
INSERT INTO EXAM_DETAIL VALUES (N'EXAM1',6)
INSERT INTO EXAM_DETAIL VALUES (N'EXAM1',7)
INSERT INTO EXAM_DETAIL VALUES (N'EXAM1',8)


INSERT INTO EXAM_DETAIL VALUES (N'EXAM2',8)
INSERT INTO EXAM_DETAIL VALUES (N'EXAM2',7)
SELECT * FROM EXAM_DETAIL
IF OBJECT_ID('EXAM_RESULT') IS NOT NULL
DROP TABLE EXAM_RESULT
GO
CREATE TABLE EXAM_RESULT(
ID INT IDENTITY(1,1) NOT NULL,
EXAM_ID NVARCHAR(5) NOT NULL,
USERNAME NVARCHAR(12) NOT NULL,
SCORE INT NULL,
EXAMDAY DATE NOT NULL,
FOREIGN KEY (EXAM_ID) REFERENCES EXAM(ID) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (USERNAME) REFERENCES ACCOUNTS(USERNAME) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (ID)
)

INSERT INTO EXAM_RESULT VALUES (N'EXAM1',N'HS1',1000)
INSERT INTO EXAM_RESULT VALUES (N'EXAM2',N'HS1',1200)

SELECT * FROM EXAM_RESULT