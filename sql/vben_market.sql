/*
 Navicat Premium Data Transfer

 Source Server         : pg-localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 150000 (150000)
 Source Host           : localhost:5432
 Source Catalog        : vben_market
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 150000 (150000)
 File Encoding         : 65001

 Date: 13/12/2022 21:48:05
*/


-- ----------------------------
-- Sequence structure for vben_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."vben_user_id_seq";
CREATE SEQUENCE "public"."vben_user_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for vben_dept
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_dept";
CREATE TABLE "public"."vben_dept" (
  "id" int8 NOT NULL,
  "dept_name" varchar(50) COLLATE "pg_catalog"."default",
  "code" varchar(50) COLLATE "pg_catalog"."default",
  "pcode" varchar(50) COLLATE "pg_catalog"."default",
  "leader" varchar(50) COLLATE "pg_catalog"."default",
  "phone" varchar(11) COLLATE "pg_catalog"."default",
  "create_time" date,
  "update_time" date,
  "create_by" varchar(50) COLLATE "pg_catalog"."default",
  "update_by" varchar(50) COLLATE "pg_catalog"."default",
  "remark" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."vben_dept"."dept_name" IS '部门名称';
COMMENT ON COLUMN "public"."vben_dept"."code" IS '部门编码';
COMMENT ON COLUMN "public"."vben_dept"."pcode" IS '部门父级编码';
COMMENT ON COLUMN "public"."vben_dept"."leader" IS '负责人';
COMMENT ON COLUMN "public"."vben_dept"."phone" IS '负责人电话';
COMMENT ON COLUMN "public"."vben_dept"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."vben_dept"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."vben_dept"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."vben_dept"."update_by" IS '更新人';
COMMENT ON COLUMN "public"."vben_dept"."remark" IS '备注';
COMMENT ON TABLE "public"."vben_dept" IS '部门表';

-- ----------------------------
-- Table structure for vben_dict
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_dict";
CREATE TABLE "public"."vben_dict" (
  "id" int4 NOT NULL,
  "dict_type" varchar(255) COLLATE "pg_catalog"."default",
  "dict_name" varchar(255) COLLATE "pg_catalog"."default",
  "dict_code" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" date,
  "update_time" date,
  "create_by" varchar(50) COLLATE "pg_catalog"."default",
  "update_by" varchar(50) COLLATE "pg_catalog"."default",
  "remark" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."vben_dict"."dict_type" IS '类型';
COMMENT ON COLUMN "public"."vben_dict"."dict_name" IS '名称';
COMMENT ON COLUMN "public"."vben_dict"."dict_code" IS '编码';
COMMENT ON COLUMN "public"."vben_dict"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."vben_dict"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."vben_dict"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."vben_dict"."update_by" IS '更新人';
COMMENT ON COLUMN "public"."vben_dict"."remark" IS '备注';
COMMENT ON TABLE "public"."vben_dict" IS '数据字典';

-- ----------------------------
-- Table structure for vben_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_menu";
CREATE TABLE "public"."vben_menu" (
  "id" int8 NOT NULL,
  "menu_name" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" date,
  "update_time" date,
  "create_by" varchar(255) COLLATE "pg_catalog"."default",
  "update_by" date,
  "remark" varchar(255) COLLATE "pg_catalog"."default",
  "code" varchar(255) COLLATE "pg_catalog"."default",
  "parent_code" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."vben_menu"."menu_name" IS '菜单名称';
COMMENT ON COLUMN "public"."vben_menu"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."vben_menu"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."vben_menu"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."vben_menu"."update_by" IS '更新人';
COMMENT ON COLUMN "public"."vben_menu"."remark" IS '备注说明';
COMMENT ON COLUMN "public"."vben_menu"."code" IS '菜单编号';
COMMENT ON COLUMN "public"."vben_menu"."parent_code" IS '菜单父编号';
COMMENT ON TABLE "public"."vben_menu" IS '菜单表';

-- ----------------------------
-- Table structure for vben_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_role";
CREATE TABLE "public"."vben_role" (
  "id" int8 NOT NULL,
  "role_name" varchar(255) COLLATE "pg_catalog"."default",
  "role_code" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" date,
  "update_time" date,
  "create_by" varchar(50) COLLATE "pg_catalog"."default",
  "update_by" varchar(50) COLLATE "pg_catalog"."default",
  "remark" varchar(255) COLLATE "pg_catalog"."default",
  "status" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."vben_role"."role_name" IS '角色名称';
COMMENT ON COLUMN "public"."vben_role"."role_code" IS '角色';
COMMENT ON COLUMN "public"."vben_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."vben_role"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."vben_role"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."vben_role"."update_by" IS '更新人';
COMMENT ON COLUMN "public"."vben_role"."remark" IS '备注';
COMMENT ON COLUMN "public"."vben_role"."status" IS '状态 == 1 ? 启用 : 禁用';
COMMENT ON TABLE "public"."vben_role" IS '角色表';

-- ----------------------------
-- Table structure for vben_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_user";
CREATE TABLE "public"."vben_user" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "name" varchar(20) COLLATE "pg_catalog"."default",
  "birthday" timestamp(0),
  "identity_card" varchar(20) COLLATE "pg_catalog"."default",
  "age" int2,
  "address" varchar(255) COLLATE "pg_catalog"."default",
  "phone" char(11) COLLATE "pg_catalog"."default",
  "create_time" timestamp(0) DEFAULT CURRENT_TIMESTAMP,
  "update_time" timestamp(0) DEFAULT CURRENT_TIMESTAMP,
  "create_by" varchar(50) COLLATE "pg_catalog"."default",
  "update_by" varchar(50) COLLATE "pg_catalog"."default",
  "remark" varchar(255) COLLATE "pg_catalog"."default",
  "user_name" varchar(64) COLLATE "pg_catalog"."default",
  "password" varchar(64) COLLATE "pg_catalog"."default",
  "last_login" timestamp(0),
  "login_device" varchar(255) COLLATE "pg_catalog"."default",
  "nick_name" varchar(54) COLLATE "pg_catalog"."default",
  "avatar" varchar(255) COLLATE "pg_catalog"."default",
  "status" int2 DEFAULT 1,
  "gender" int2 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."vben_user"."name" IS '姓名';
COMMENT ON COLUMN "public"."vben_user"."birthday" IS '出生日期';
COMMENT ON COLUMN "public"."vben_user"."identity_card" IS '身份证号';
COMMENT ON COLUMN "public"."vben_user"."age" IS '年龄';
COMMENT ON COLUMN "public"."vben_user"."address" IS '居住地址';
COMMENT ON COLUMN "public"."vben_user"."phone" IS '联系电话';
COMMENT ON COLUMN "public"."vben_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."vben_user"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."vben_user"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."vben_user"."update_by" IS '更新人';
COMMENT ON COLUMN "public"."vben_user"."remark" IS '备注';
COMMENT ON COLUMN "public"."vben_user"."user_name" IS '登录账户';
COMMENT ON COLUMN "public"."vben_user"."password" IS '密码';
COMMENT ON COLUMN "public"."vben_user"."last_login" IS '最后登录时间';
COMMENT ON COLUMN "public"."vben_user"."login_device" IS '登录设备';
COMMENT ON COLUMN "public"."vben_user"."nick_name" IS '昵称';
COMMENT ON COLUMN "public"."vben_user"."avatar" IS '头像';
COMMENT ON COLUMN "public"."vben_user"."status" IS '1？启用 : 禁用';
COMMENT ON COLUMN "public"."vben_user"."gender" IS '性别(0：保密，1：女，2：男)';
COMMENT ON TABLE "public"."vben_user" IS '用户信息表';

-- ----------------------------
-- Table structure for vben_user_dept
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_user_dept";
CREATE TABLE "public"."vben_user_dept" (
  "id" int8 NOT NULL,
  "dept_id" int8,
  "user_id" int8
)
;
COMMENT ON COLUMN "public"."vben_user_dept"."dept_id" IS '部门id';
COMMENT ON COLUMN "public"."vben_user_dept"."user_id" IS '用户id';
COMMENT ON TABLE "public"."vben_user_dept" IS '用户部门关联表';

-- ----------------------------
-- Table structure for vebn_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."vebn_user_role";
CREATE TABLE "public"."vebn_user_role" (
  "id" int8 NOT NULL,
  "account_id" int8,
  "role_id" int8
)
;
COMMENT ON COLUMN "public"."vebn_user_role"."account_id" IS '用户id';
COMMENT ON COLUMN "public"."vebn_user_role"."role_id" IS '角色id';
COMMENT ON TABLE "public"."vebn_user_role" IS '账户角色关联表';

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."vben_user_id_seq"
OWNED BY "public"."vben_user"."id";
SELECT setval('"public"."vben_user_id_seq"', 5, true);

-- ----------------------------
-- Primary Key structure for table vben_dept
-- ----------------------------
ALTER TABLE "public"."vben_dept" ADD CONSTRAINT "vben_dept_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table vben_dict
-- ----------------------------
ALTER TABLE "public"."vben_dict" ADD CONSTRAINT "vben_dict_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table vben_menu
-- ----------------------------
ALTER TABLE "public"."vben_menu" ADD CONSTRAINT "vben_menu_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table vben_role
-- ----------------------------
ALTER TABLE "public"."vben_role" ADD CONSTRAINT "vben_role_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table vben_user
-- ----------------------------
ALTER TABLE "public"."vben_user" ADD CONSTRAINT "vben_user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table vben_user_dept
-- ----------------------------
ALTER TABLE "public"."vben_user_dept" ADD CONSTRAINT "vben_user_dept_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table vebn_user_role
-- ----------------------------
ALTER TABLE "public"."vebn_user_role" ADD CONSTRAINT "vebn_account_role_pkey" PRIMARY KEY ("id");
