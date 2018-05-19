drop table account if exists;
create table account(ID serial, amount varchar(5) NOT NULL, transactionDate varchar(200) );