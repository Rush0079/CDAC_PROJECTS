create database cdacjuhu2;
use cdacjuhu2;
-- use Payment;
show tables;

create table tbl_admin(username varchar(20), password varchar(20));
insert into tbl_admin values("pritesh","pk@123"),("rushi","rushi@456"),("pankaj","pankaj@789");
select * from tbl_admin;
drop table tbl_admin;
-----------------------------------------------------
select * from tbl_user;
insert into tbl_user values('335538454798','World@gmail.com','8837432974','world','abc81011','Wordy');
delete from tbl_user where username='pk';
drop table tbl_user;
----------------------------------------------
delimiter //
create procedure recharge(mobno varchar(10), amount int)
begin
declare a varchar(10);
declare b int;
declare y int default 0;
 declare c1 cursor for select mobno from tbl_funds; 
 declare continue handler for not found set y = 1;
 open c1;
  curs_loop1:loop
            fetch c1 into a;
            if y = 1 then
			leave curs_loop1;
            end if;
            
		if( mobno = a )
			then
			update tbl_funds set balance=balance-amount where tbl_funds.mobno=a;
          leave curs_loop1;
			end if;
			end loop curs_loop1;
		close c1;
end//
delimiter ;

drop procedure recharge;

-- create table tbl_funds();
select * from tbl_funds;
desc tbl_funds;
drop table tbl_funds;
insert into tbl_funds(mobno,ban,balance) values('9876543210','27364747246',20000),
('9786534210','8374848890',15000),
('8765432109','83475834891',10500),
('9725659184','57348523841',125000),
('9235432046','17348523902',205000),
('8837432974','37548523801',105000),
('9933472947','57348523841',125000),
('9765341209','29837492890',40550),
('8823445345','98347528374',35000),
('9998213480','62834784987',775000);
-----------------------------------------------------------
delimiter //
create procedure addInWallet(mobno varchar(10), amount int)
begin
			update tbl_funds set balance=balance-amount where tbl_funds.mobno=mobno;
            update tbl_wallet set balance=balance+amount where tbl_wallet.mobno=mobno;
end//
delimiter ;

select * from tbl_wallet;
desc tbl_wallet;
insert into tbl_wallet values('8765432109',1000),('9765341209',3400),('8823445345',1500);
drop table tbl_wallet;
-----------------------------------------------------------
delimiter //
create procedure upiUpdate(mob1 varchar(10),mob2 varchar(10),amt float)
begin
		declare a varchar(10);
        declare b varchar(10);
        -- declare c float;
		declare y int default 0;
        declare c2 cursor for select mobno from tbl_funds; 
        declare c3 cursor for select mobno from tbl_funds; 
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
                update tbl_funds set balance=balance-amt where tbl_funds.mobno=a;
                update tbl_funds set balance=balance+amt where tbl_funds.mobno=b;
                -- insert into temp50 values('Valid');
                leave curs_loop2;
			end if;
			end loop curs_loop2;
            end if;
            end loop curs_loop1;
            close c2;
            close c3;
end; //
delimiter ;

call upiUpdate(9998213480,8765432109,15000);
drop procedure upiUpdate;