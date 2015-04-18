create table DHCX_RYXX
(
   ID                   varchar(32) not null,
   NAME                 varchar(40),
   TITLE                varchar(40),
   ADDRESS              varchar(60),
   COMPANY              varchar(60),
   DEPARTMENT           varchar(60),
   OFFICENUMBER         varchar(30),
   HOMENUMBER           varchar(30),
   PHONENUMBER          varchar(13),
   USERNAME             varchar(40),
   primary key (ID)
);

alter table DHCX_RYXX comment '职工的信息表';

/*==============================================================*/
/* Table: DHCX_XTYH                                             */
/*==============================================================*/
create table DHCX_XTYH
(
   UID                  varchar(32) not null,
   USERNAME             varchar(40),
   PASSWORD             varchar(32),
   primary key (UID)
);

alter table DHCX_XTYH comment '系统用户表';

