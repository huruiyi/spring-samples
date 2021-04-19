--PL/SQL 工具->导入表
prompt PL/SQL Developer Export User Objects for user C##HURUIYI@ORCL
prompt Created by hurui on 2021年4月19日
set define off
spool sql.log

prompt
prompt Creating table MAIN
prompt ===================
prompt
create table C##HURUIYI.MAIN
(
  id       NUMBER default "C##HURUIYI"."IDAUTO"."NEXTVAL",
  mainname NVARCHAR2(200)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SUB
prompt ==================
prompt
create table C##HURUIYI.SUB
(
  id      NUMBER default "C##HURUIYI"."IDAUTO"."NEXTVAL",
  subname NVARCHAR2(200),
  mainid  NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence IDAUTO
prompt ========================
prompt
create sequence C##HURUIYI.IDAUTO
minvalue 1
maxvalue 999999999999
start with 10120
increment by 2
cache 20;


prompt Done
spool off
set define on
