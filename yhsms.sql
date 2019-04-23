/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/4/20 18:04:23                           */
/*==============================================================*/


alter table menum
   drop constraint FK_MENUM_REFERENCE_MENUTYPE;

alter table oitem
   drop constraint FK_OITEM_REFERENCE_CARD;

alter table oitem
   drop constraint FK_OITEM_REFERENCE_MENUM;

alter table orders
   drop constraint FK_ORDERS_REFERENCE_EMPLOYEE;

alter table orders
   drop constraint FK_ORDERS_REFERENCE_OITEM;

drop table card cascade constraints;

drop table employee cascade constraints;

drop table menum cascade constraints;

drop table menutype cascade constraints;

drop table oitem cascade constraints;

drop table orders cascade constraints;

/*==============================================================*/
/* Table: card                                                  */
/*==============================================================*/
create table card 
(
   caid                 NUMBER(4)            not null,
   uname                VARCHAR2(20)         not null,
   capass               VARCHAR2(20)         not null,
   catype               VARCHAR2(20)         not null,
   discount             NUMBER(2,1)          not null,
   money                NUMBER(6,2)          not null,
   canote               VARCHAR2(20),
   constraint PK_CARD primary key (caid)
);

/*==============================================================*/
/* Table: employee                                              */
/*==============================================================*/
create table employee 
(
   eid                  NUMBER(4)            not null,
   ename                VARCHAR2(20)         not null,
   eaccount             VARCHAR2(20)         not null,
   epass                VARCHAR2(20)         not null,
   ejob                 VARCHAR2(20)         not null,
   eloc                 VARCHAR2(20)         not null,
   enote                VARCHAR2(20),
   constraint PK_EMPLOYEE primary key (eid)
);

/*==============================================================*/
/* Table: menum                                                 */
/*==============================================================*/
create table menum 
(
   mid                  NUMBER(4)            not null,
   mname                VARCHAR2(20)         not null,
   mprice               NUMBER(4,1)          not null,
   mtid                 NUMBER(4)            not null,
   mnote                VARCHAR2(20),
   constraint PK_MENUM primary key (mid)
);

/*==============================================================*/
/* Table: menutype                                              */
/*==============================================================*/
create table menutype 
(
   mtid                 NUMBER(4)            not null,
   mtname               VARCHAR2(20)         not null,
   mtnote               VARCHAR2(20),
   constraint PK_MENUTYPE primary key (mtid)
);

/*==============================================================*/
/* Table: oitem                                                 */
/*==============================================================*/
create table oitem 
(
   oid                  NUMBER(4)            not null,
   caid                 NUMBER(4),
   mid                  NUMBER(4)            not null,
   num                  NUMBER(4)            not null,
   oprice               NUMBER(4,1)          not null,
   onote                VARCHAR2(20),
   otime                DATE,
   constraint PK_OITEM primary key (oid)
);

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders 
(
   oid                  NUMBER(4)            not null,
   eid                  NUMBER(4),
   time                 DATE,
   constraint PK_ORDERS primary key (oid)
);

alter table menum
   add constraint FK_MENUM_REFERENCE_MENUTYPE foreign key (mtid)
      references menutype (mtid);

alter table oitem
   add constraint FK_OITEM_REFERENCE_CARD foreign key (caid)
      references card (caid);

alter table oitem
   add constraint FK_OITEM_REFERENCE_MENUM foreign key (mid)
      references menum (mid);

alter table orders
   add constraint FK_ORDERS_REFERENCE_EMPLOYEE foreign key (eid)
      references employee (eid);

alter table orders
   add constraint FK_ORDERS_REFERENCE_OITEM foreign key (oid)
      references oitem (oid);

