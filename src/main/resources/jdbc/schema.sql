CREATE TABLE EMPLOYEE
(
    ID int NOT NULL PRIMARY KEY,
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255)
);

CREATE TABLE voucher (
  id int NOT NULL  PRIMARY KEY,
  voucher_no varchar(45) ,
  creator varchar(45) ,
  created_date varchar(45)
);

CREATE TABLE voucher_detail (
  id int NOT NULL PRIMARY KEY,
  voucher_no varchar(45) ,
  seq varchar(45) ,
  comments varchar(45) ,
  account_no varchar(45) ,
  credit_amount int ,
  debt_amount int
) ;

CREATE TABLE project_account (
  id int NOT NULL PRIMARY KEY,
  voucher_no varchar(45) ,
  seq varchar(45) ,
  dimension_type varchar(45) ,
  dimension_code varchar(45) ,
  demension_name varchar(45)
) ;