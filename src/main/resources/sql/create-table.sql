/*==============================================================*/
/* Table: user_t                                                */
/*==============================================================*/
CREATE TABLE user_t 
(
   id                   INTEGER                        NOT NULL,
   use_id               INTEGER                        NULL,
   NAME                 VARCHAR(2000)                     NULL,
   creater_by           VARCHAR(200)                      NULL,
   create_date          DATETIME                       NULL,
   last_update_by       VARCHAR(200)                      NULL,
   last_update_date     DATETIME                       NULL,
   CONSTRAINT PK_USER_T PRIMARY KEY clustered (id)
);

ALTER TABLE user_t MODIFY COLUMN id INT COMMENT '用户id';
ALTER TABLE user_t MODIFY COLUMN NAME INT COMMENT '用户名';
ALTER TABLE user_t MODIFY COLUMN creater_by INT COMMENT '创建人';
ALTER TABLE user_t MODIFY COLUMN create_date INT COMMENT '创建时间';
ALTER TABLE user_t MODIFY COLUMN last_update_by INT COMMENT '最后更新人';
ALTER TABLE user_t MODIFY COLUMN last_update_date INT COMMENT '最后更新时间';

/*==============================================================*/
/* Table: user_department_relation_t                            */
/*==============================================================*/
CREATE TABLE user_department_relation_t 
(
   id                   INTEGER                        NOT NULL,
   department_id        INTEGER                        NULL,
   department_code      INTEGER                        NULL,
   user_id              INTEGER                        NULL,
   creater_by           CHAR(200)                      NULL,
   create_date          DATETIME                       NULL,
   last_update_by       CHAR(200)                      NULL,
   last_update_date     DATETIME                       NULL,
   CONSTRAINT PK_USER_DEPARTMENT_RELATION_T PRIMARY KEY clustered (id)
);

ALTER TABLE user_department_relation_t MODIFY COLUMN id INT COMMENT '关系ID';
ALTER TABLE user_department_relation_t MODIFY COLUMN department_id INT COMMENT '部门id';
ALTER TABLE user_department_relation_t MODIFY COLUMN department_code INT COMMENT '部门编号';
ALTER TABLE user_department_relation_t MODIFY COLUMN user_id INT COMMENT '用户ID';
ALTER TABLE user_department_relation_t MODIFY COLUMN creater_by INT COMMENT '创建人';
ALTER TABLE user_department_relation_t MODIFY COLUMN create_date INT COMMENT '创建时间';
ALTER TABLE user_department_relation_t MODIFY COLUMN last_update_by INT COMMENT '最后更新人';
ALTER TABLE user_department_relation_t MODIFY COLUMN last_update_date INT COMMENT '最后更新时间';

CREATE TABLE department_t 
(
   id                   CHAR(10)                       NULL,
   department_code      INTEGER                        NOT NULL,
   department_name CHAR(200)                      NULL,
   parent_id            CHAR(10)                       NULL,
   department_level     CHAR(10)                       NULL,
   creater_by           CHAR(200)                      NULL,
   create_date          DATETIME                       NULL,
   last_update_by       CHAR(200)                      NULL,
   last_update_date     DATETIME                       NULL,
   CONSTRAINT PK_DEPARTMENT_T PRIMARY KEY clustered (department_code)
);

ALTER TABLE department_t MODIFY COLUMN id INT COMMENT '部门id';
ALTER TABLE department_t MODIFY COLUMN department_code INT COMMENT '部门编号';
ALTER TABLE department_t MODIFY COLUMN department_name INT COMMENT '部门名称';
ALTER TABLE department_t MODIFY COLUMN parent_id INT COMMENT '父节点id';
ALTER TABLE department_t MODIFY COLUMN department_level INT COMMENT '部门级别';
ALTER TABLE department_t MODIFY COLUMN creater_by INT COMMENT '创建人';
ALTER TABLE department_t MODIFY COLUMN create_date INT COMMENT '创建时间';
ALTER TABLE department_t MODIFY COLUMN last_update_by INT COMMENT '最后更新人';
ALTER TABLE department_t MODIFY COLUMN last_update_date INT COMMENT '最后更新时间';