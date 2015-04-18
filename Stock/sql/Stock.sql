/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2010-6-19 19:24:58                           */
/*==============================================================*/


drop table T_Stock cascade constraints;

/*==============================================================*/
/* Table: T_Stock                                             */
/*==============================================================*/
create table T_Stock  (
   TICKER               VARCHAR2(10)                    not null,
   STOCKDATE            DATE                            not null,
   STOCKTIME            VARCHAR2(4)                     not null,
   OPENPRICE            NUMBER(8,2)                     not null,
   CLOSEPRICE           NUMBER(8,2)                     not null,
   HIGHPRICE            NUMBER(8,2)                     not null,
   LOWPRICE             NUMBER(8,2)                     not null,
   VOLUME               INTEGER                         not null
);

comment on table T_Stock is
'存储一只股票在一分钟的交易情况';

