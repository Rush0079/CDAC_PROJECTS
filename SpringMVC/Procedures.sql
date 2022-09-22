create database payment;
use payment;

create table Login(U_id int primary key,UserName varchar(20) not null unique,passwordd varchar(20) not null);
insert into Login values
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

drop table Login;
select * from Login;

select UserName,MobNo from Login,Funds where Login.U_id=Funds.Uid having MobNo=9786534210;

create table Funds(Uid int not null unique,MobNo Bigint not null unique,BAN Bigint not null,
Balance Bigint, foreign key (Uid) references Login(U_id) ON DELETE CASCADE on update cascade);

insert into Funds values(1,9876543210,27364747246,2000000),
(2,9786534210,8374848890,1500000),
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

create table CARDS
(
SR_No int not null unique,
Card_number varchar(20) unique,
CARD_TYPE varchar(10) not null check(CARD_TYPE in('CREDIT', 'DEBIT')),
CARD_HOLDER_NAME varchar(20) not null,
CVV int(3),
EXPRIY_DATE date not null,
NETWORK char(10) not null,
foreign key(SR_No) references Login(U_id) ON DELETE CASCADE on update cascade
);

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

drop table CARDS;
select * from CARDS;

create table InternetBanking
(username varchar(20) not null,
pass_word varchar(20) not null,
foreign key (username) references Login(Username) ON DELETE CASCADE on update cascade
);

insert into InternetBanking values
('Mohit Chouhan','Mohit@121'),
('Prathmesh Shinde','Pratham@212'),
('Pritesh Kolhe','Pritesh@313'),
('Jack Reacher','Jack#424'),
('Paul Walker','Paul@321'),
('Dwayne Johnson','Dwayne%515'),
('Tony Stark','Stark@555'),
('Tom Hanks','Hanks&818'),
('Gal Gadot','Gadot@717'),
('Lionel Messi','Lionel$454');

drop table InternetBanking;
select * from InternetBanking;

Alter table InternetBanking add column extra tinyint;
Alter table InternetBanking drop column extra;

create table UPI(MobNo Bigint not null unique,pin int,foreign key (MobNo) references Funds(MobNo) ON DELETE CASCADE on update cascade);
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

select Balance,BAN from Funds,UPI where Funds.MobNo=UPI.MobNo having BAN=62834784987;

create table ELECTRICITY
(
uno int not null unique,
CONSUMER_NO varchar(20),
CONSUMER_NAME varchar(20),
BILL_AMT float,
foreign key (uno) references Login(U_id) ON DELETE CASCADE on update cascade
);

insert into ELECTRICITY values
(1,'IVSR1234','Mohit chouhan',1200),
(2,'IVSR7893','Prathmesh Shinde',2000),
(3,'IVSR2345','Pritesh Kolhe',3200),
(4,'IVSR6789','Jack Reacher',10500),
(5,'IVSR2301','Paul Walker',16050),
(6,'IVSR1908','Tony Stark',18090),
(7,'IVSR2208','Tom Hanks',14360),
(8,'IVSR0979','Lionel Messi',12925),
(9,'IVSR0932','Dwayne Johnson',12045),
(10,'IVSR0842','Gal Gadot',22950);

drop table ELECTRICITY;
select * from ELECTRICITY;

create table insurance
(
sr_no int not null unique,
insurance_type varchar(30) not null,
plan_no int not null,
duration varchar(30) not null,
amount float
);

insert into insurance values
(1,'health insurance',678,'1 year',25000),
(2,'car insurance',954,'1 year',30000),
(3,'travel insurance',631,'1 year',20000),
(4,'home insurance',320,'1 year',35000),
(5,'bike insurance',492,'1 year',10000);

drop table insurance;
select * from insurance;

create table MobRechg(srno int not null unique, operator varchar(10) not null, amount float not null, days int not null);
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

create table HistoryCheck(d date);
drop table HistoryCheck;

create table temp50(just char(10));
delimiter //
create procedure abc(
Cn varchar(20),
Ct varchar(10),
Chn varchar(20),
Cv int(3),
Ed date,
Nt char(10)
)
begin
		declare a varchar(20);
        declare b varchar(20);
        declare c varchar(20);
        declare d int;
        declare e date;
        declare f char(10);
        declare y int default 0;
        declare c1 cursor for select Card_number,CARD_TYPE,CARD_HOLDER_NAME,CVV,EXPRIY_DATE,NETWORK from CARDS; 
        declare continue handler for not found set y = 1;
        open c1;
        curs_loop:loop
			fetch c1 into a,b,c,d,e,f;
            if y = 1 then
			leave curs_loop;
            end if;
            
			if( (Cn=a) and (Ct=b) and (Chn=c)
				and (Cv=d) and (Ed=e) and (Nt=f))
			then
                insert into temp50 values('Valid');
                leave curs_loop;
			end if;
            end loop curs_loop;
            close c1;
end; //
delimiter ;

call abc('3312 5424 2900 8901','CREDIT','DWAYNE Jhnson',373,'2024-10-19','RUPY');
drop procedure abc;
select * from temp50;
truncate table temp50;
   
   
delimiter //
create trigger hist
after insert
on temp50 for each row
begin
insert into HistoryCheck values(sysdate());
end; //
delimiter ;
drop trigger hist;
select * from HistoryCheck;
truncate table HistoryCheck;

-- Money transfer
delimiter //
create procedure balupdate(mob1 bigint,mob2 bigint,amt float)
begin
		declare a bigint;
        declare b bigint;
        -- declare c float;
		declare y int default 0;
        declare c2 cursor for select MobNo from Funds; 
        declare c3 cursor for select MobNo from Funds; 
        declare continue handler for not found set y = 1;
        open c2;
        open c3;
        curs_loop1:loop
            fetch c2 into a;
            if y = 1 then
			leave curs_loop1;
            end if;
            
		if( mob1 = a )
			then
		curs_loop2:loop
			fetch c3 into b;
            
             if y = 1 then
			leave curs_loop2;
            end if;
		if( mob2 = b )
			then
                update Funds set balance=balance-amt where Funds.MobNo=a;
                update Funds set balance=balance+amt where Funds.MobNo=b;
                insert into temp50 values('Valid');
                leave curs_loop2;
			end if;
			end loop curs_loop2;
            end if;
            end loop curs_loop1;
            close c2;
            close c3;
end; //
delimiter ;

call balupdate(9998213480,8765432109,15000);
drop procedure balupdate;
