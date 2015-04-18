/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2010-6-19 0:42:48                            */
/*==============================================================*/


drop table T_TEST cascade constraints;

/*==============================================================*/
/* Table: T_TEST                                                */
/*==============================================================*/
create table T_TEST  (
   "startdate"          DATE,
   "enddate"            DATE
);

select * from t_test where "startdate" between to_date('08/22/2003','MM/DD/YYYY') and to_date('08/24/2003','MM/DD/YYYY');