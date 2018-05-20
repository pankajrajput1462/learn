drop table account if exists;
create table account(ID serial, amount FLOAT(5) NOT NULL, transactionDate timestamp) ;