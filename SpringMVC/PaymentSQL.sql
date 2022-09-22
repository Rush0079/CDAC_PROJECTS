create database payment;
use payment;

create table User(U_id int,UserName varchar(20),Password varchar(20));
insert into User values
(1,'Mohit Chouhan','Mohit@123'),
(2,'Prathmesh Shinde','Prataham@456'),
(3,'Pritesh Kolhe','Pritesh@789'),
(4,'Jack Reacher','Jack/\012'),
(5,'Paul Walker','Paul@walker3'),
(6,'Dwayne Johnson','Dwayne*246'),
(7,'Tony Stark','Stark;Industry5'),
(8,'Tom Hanks','Hank()power15'),
(9,'Gal Gadot','Gadot&&531'),
(10,'Lionel Messi','Leo#Messi010');

drop table User;
select * from User;

create table CARDS
(
SR_No int,
Card_number varchar(20) unique,
CARD_TYPE varchar(10) check(CARD_TYPE in('CREDIT', 'DEBIT')),
CARD_HOLDER_NAME varchar(20),
CVV int(3),
EXPRIY_DATE date,
NETWORK char(10)
);
drop table CARDS;
insert into CARDS values
(1,'4312 5121 9870 2010','DEBIT','Mohit Chouhan',371,'2025-05-20','VISA'),
(2,'3642 2341 3490 9067','CREDIT','Tony Stark',512,'2032-08-15','RUPYEE'),
(3,'5312 1423 1237 1289','DEBIT','Pritesh Kolhe',198,'2027-05-20',' MASTER'),
(4,'5312 4521 1270 2415','DEBIT','Prathmesh shinde',143,'2026-05-20',' MASTER'),
(5,'3312 2321 8980 1209','CREDIT','Paul waker',189,'2030-05-20','RUPYEE'),
(6,'4312 5420 2450 8976','CREDIT','Gal GADOT',760,'2027-05-20','VISA'),
(7,'5312 3221 1810 1230','DEBIT','Lionel Messi',199,'2030-05-20','MASTER'),
(8,'3312 5424 2900 8901','CREDIT','DWAYNE Jhnson',373,'2024-10-19','RUPYEE'),
(9,'1302 8421 3450 2301','CREDIT','Jack Reacher',565,'2026-05-20','VISA'),
(10,'4312 5426 4250 9801','DEBIT','Tom Hanks',766,'2028-12-10','VISA');

select * from CARDS;

create table InternetBanking
(
username varchar(20),
password varchar(20)
);

insert into InternetBanking values
('Mohit Chouhan','Mohit@121'),
('Prathmesh Shinde','Pratham@212'),
('Pritesh Kolhe','Pritesh@313'),
('Jack Reacher','Jack@424'),
('Paul Walker','Paul@321'),
('Dwayne Johnson','Dwayne@515'),
('Tony Stark','Stark@555'),
('Tom Hanks','Hanks@818'),
('Gal Gadot','Gadot@717'),
('Lionel Messi','Lionel@454');

drop table InternetBanking;
select * from InternetBanking;

create table Funds(Uid int,MobNo Bigint,BAN Bigint,Balance Bigint);
insert into Funds values(1,9876543210,27364747246,2000000),
(2,9786534210,28374848890,1500000),
(3,8765432109,83475834891,1050000),
(4,9237432947,57348523841,125000000),
(5,9235432046,17348523902,205000500),
(6,8837432974,37548523801,105000000),
(7,9933472947,57348523841,125000000),
(8,9765341209,29837492890,405500000),
(9,8823445345,98347528374,350000500),
(10,9998213480,62834784987,775000500);

drop table Funds;
select * from Funds;

create table UPI(MobNo Bigint,pin int);
insert into UPI values(9876543210,4302),
(9786534210,9834),
(8765432109,3230),
(9237432947,3948),
(9235432046,2039),
(8837432974,7485),
(9933472947,3940),
(9765341209,1239),
(8823445345,4913),
(9998213480,5324);

drop table UPI;
select * from UPI;

create table ELECTRICITY
(
CONSUMER_NO varchar(20),
CONUMER_NAME varchar(20),
BILL_AMT float
);

insert into ELECTRICITY values
('IVSR1234','Mohit chouhan',1200),
('IVSR7893','Prathmesh Shinde',2000),
('IVSR2345','Pritesh Kolhe',3200),
('IVSR6789','Jack Reacher',10500),
('IVSR2301','Paul Walker',16050),
('IVSR1908','Tony Stark',18090),
('IVSR2208','Tom Hanks',14360),
('IVSR0979','Lionel Messi',12925),
('IVSR0932','Dwayne Johnson',12045),
('IVSR0842','Gal Gadot',22950);

drop table ELECTRICITY;
select * from ELECTRICITY;

create table insurance
(
sr_no int,
insurance_type varchar(30),
plan_no int,
duration varchar(30),
ammount int
);

insert into insurance values
(1,'health insurance',678,'1 year',25000),
(2,'car insurance',954,'1 year',30000),
(3,'travel insurance',631,'1 year',20000),
(4,'home insurance',320,'1 year',35000),
(5,'bike insurance',492,'1 year',10000);

drop table insurance;
select * from insurance;

create table MobRechg(srno int, operator varchar(10), amount float, days int);
insert into MobRechg values(1,'VI',179,28),
(2,'VI',399,56),
(3,'VI',599,84),
(4,'AIRTEL',199,28),
(5,'AIRTEL',349,56),
(6,'AIRTEL',555,84),
(7,'JIO',189,28),
(8,'JIO',379,56),
(9,'JIO',549,84);

DROP TABLE MobRechg;
select * from MobRechg;


