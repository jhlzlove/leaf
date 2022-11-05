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

 Date: 05/11/2022 16:12:05
*/


-- ----------------------------
-- Table structure for vben_account
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_account";
CREATE TABLE "public"."vben_account" (
  "id" int4 NOT NULL,
  "account_name" varchar(255) COLLATE "pg_catalog"."default",
  "nick_name" varchar(255) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default",
  "sex" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" date,
  "update_time" date,
  "create_by" varchar(255) COLLATE "pg_catalog"."default",
  "update_by" date
)
;
COMMENT ON COLUMN "public"."vben_account"."account_name" IS '用户名';
COMMENT ON COLUMN "public"."vben_account"."nick_name" IS '昵称';
COMMENT ON COLUMN "public"."vben_account"."password" IS '密码';
COMMENT ON COLUMN "public"."vben_account"."sex" IS '性别';
COMMENT ON COLUMN "public"."vben_account"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."vben_account"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."vben_account"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."vben_account"."update_by" IS '更新者';
COMMENT ON TABLE "public"."vben_account" IS '帐户表';

-- ----------------------------
-- Records of vben_account
-- ----------------------------

-- ----------------------------
-- Table structure for vben_dept
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_dept";
CREATE TABLE "public"."vben_dept" (
  "id" int4 NOT NULL,
  "dept_name" varchar(255) COLLATE "pg_catalog"."default",
  "dept_code" varchar(255) COLLATE "pg_catalog"."default",
  "dept_pcode" varchar(255) COLLATE "pg_catalog"."default",
  "leader" varchar(255) COLLATE "pg_catalog"."default",
  "phone" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" date,
  "update_time" date,
  "create_by" varchar(255) COLLATE "pg_catalog"."default",
  "update_by" date,
  "remark" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."vben_dept"."dept_name" IS '部门名称';
COMMENT ON COLUMN "public"."vben_dept"."dept_code" IS '部门编码';
COMMENT ON COLUMN "public"."vben_dept"."dept_pcode" IS '部门父级编码';
COMMENT ON COLUMN "public"."vben_dept"."leader" IS '负责人';
COMMENT ON COLUMN "public"."vben_dept"."phone" IS '负责人电话';
COMMENT ON COLUMN "public"."vben_dept"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."vben_dept"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."vben_dept"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."vben_dept"."update_by" IS '负责人电话';
COMMENT ON COLUMN "public"."vben_dept"."remark" IS '备注';
COMMENT ON TABLE "public"."vben_dept" IS '部门表';

-- ----------------------------
-- Records of vben_dept
-- ----------------------------

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
-- Records of vben_menu
-- ----------------------------

-- ----------------------------
-- Table structure for vben_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_role";
CREATE TABLE "public"."vben_role" (
  "id" int4 NOT NULL,
  "role_name" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" date,
  "update_time" date,
  "create_by" varchar(255) COLLATE "pg_catalog"."default",
  "update_by" date
)
;
COMMENT ON COLUMN "public"."vben_role"."role_name" IS '角色名称';
COMMENT ON COLUMN "public"."vben_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."vben_role"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."vben_role"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."vben_role"."update_by" IS '更新人';
COMMENT ON TABLE "public"."vben_role" IS '角色表';

-- ----------------------------
-- Records of vben_role
-- ----------------------------

-- ----------------------------
-- Table structure for vben_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_user";
CREATE TABLE "public"."vben_user" (
  "id" int4 NOT NULL,
  "user_name" varchar(255) COLLATE "pg_catalog"."default",
  "sex" varchar(255) COLLATE "pg_catalog"."default",
  "birthday" varchar(255) COLLATE "pg_catalog"."default",
  "card_code" varchar(255) COLLATE "pg_catalog"."default",
  "age" int4,
  "address" varchar(255) COLLATE "pg_catalog"."default",
  "phone" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" date,
  "update_time" date,
  "create_by" varchar(255) COLLATE "pg_catalog"."default",
  "update_by" date,
  "remark" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."vben_user"."user_name" IS '用户名';
COMMENT ON COLUMN "public"."vben_user"."sex" IS '性别';
COMMENT ON COLUMN "public"."vben_user"."birthday" IS '出生日期';
COMMENT ON COLUMN "public"."vben_user"."card_code" IS '身份证号';
COMMENT ON COLUMN "public"."vben_user"."age" IS '年龄';
COMMENT ON COLUMN "public"."vben_user"."address" IS '居住地址';
COMMENT ON COLUMN "public"."vben_user"."phone" IS '联系电话';
COMMENT ON COLUMN "public"."vben_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."vben_user"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."vben_user"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."vben_user"."update_by" IS '更新人';
COMMENT ON COLUMN "public"."vben_user"."remark" IS '备注';
COMMENT ON TABLE "public"."vben_user" IS '用户信息表';

-- ----------------------------
-- Records of vben_user
-- ----------------------------

-- ----------------------------
-- Table structure for vben_user_dept
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_user_dept";
CREATE TABLE "public"."vben_user_dept" (
  "id" int4 NOT NULL,
  "dept_id" int4,
  "user_id" int4
)
;
COMMENT ON COLUMN "public"."vben_user_dept"."dept_id" IS '部门id';
COMMENT ON COLUMN "public"."vben_user_dept"."user_id" IS '用户id';
COMMENT ON TABLE "public"."vben_user_dept" IS '用户部门关联表';

-- ----------------------------
-- Records of vben_user_dept
-- ----------------------------

-- ----------------------------
-- Table structure for vebn_account_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."vebn_account_role";
CREATE TABLE "public"."vebn_account_role" (
  "id" int4 NOT NULL,
  "account_id" int4,
  "role_id" int4
)
;
COMMENT ON COLUMN "public"."vebn_account_role"."account_id" IS '用户id';
COMMENT ON COLUMN "public"."vebn_account_role"."role_id" IS '角色id';
COMMENT ON TABLE "public"."vebn_account_role" IS '账户角色关联表';

-- ----------------------------
-- Records of vebn_account_role
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table vben_account
-- ----------------------------
ALTER TABLE "public"."vben_account" ADD CONSTRAINT "vben_account_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table vben_dept
-- ----------------------------
ALTER TABLE "public"."vben_dept" ADD CONSTRAINT "vben_dept_pkey" PRIMARY KEY ("id");

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
-- Primary Key structure for table vebn_account_role
-- ----------------------------
ALTER TABLE "public"."vebn_account_role" ADD CONSTRAINT "vebn_account_role_pkey" PRIMARY KEY ("id");
