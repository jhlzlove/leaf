/*
 Navicat Premium Data Transfer

 Source Server         : mysql-localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : market_vben

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 21/09/2022 16:02:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `parent_id` int NULL DEFAULT NULL COMMENT '父级id',
  `order_no` int NULL DEFAULT NULL COMMENT '排序',
  `status` bit(1) NULL DEFAULT b'1' COMMENT '状态（0启用 1禁用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_no` int NULL DEFAULT 0 COMMENT '显示顺序',
  `route_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由参数',
  `keepalive` int NULL DEFAULT 0 COMMENT '是否缓存（0不缓存 1缓存）',
  `is_ext` int NULL DEFAULT NULL COMMENT '是否外链（0否 1是）',
  `menu_type` int NULL DEFAULT NULL COMMENT '菜单类型（0目录 1菜单 2按钮）',
  `visible` int NULL DEFAULT 0 COMMENT '菜单状态（0显示 1隐藏）',
  `status` int NULL DEFAULT 0 COMMENT '菜单状态（0正常 1停用）',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2030 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, 'system', NULL, '', 0, NULL, 0, 0, 0, '', 'system', 'admin', '2022-03-31 15:49:57', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 2, 'monitor', NULL, '', 0, NULL, 0, 0, 0, '', 'monitor', 'admin', '2022-03-31 15:49:57', '', NULL, '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 3, 'tool', NULL, '', 0, NULL, 0, 0, 0, '', 'tool', 'admin', '2022-03-31 15:49:57', '', NULL, '系统工具目录');
INSERT INTO `sys_menu` VALUES (4, '功能管理', 0, 4, 'base', NULL, NULL, 0, NULL, 0, 0, 0, '', 'list', 'admin', '2022-07-06 15:51:45', 'admin', '2022-07-06 15:53:21', '功能管理目录');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', '', 0, NULL, 1, 0, 0, 'system:user:list', 'user', 'admin', '2022-03-31 15:49:57', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', '', 0, NULL, 1, 0, 0, 'system:role:list', 'peoples', 'admin', '2022-03-31 15:49:57', '', NULL, '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', '', 0, NULL, 1, 0, 0, 'system:menu:list', 'tree-table', 'admin', '2022-03-31 15:49:57', '', NULL, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', '', 0, NULL, 1, 0, 0, 'system:dept:list', 'tree', 'admin', '2022-03-31 15:49:57', '', NULL, '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', '', 0, NULL, 1, 0, 0, 'system:post:list', 'post', 'admin', '2022-03-31 15:49:57', '', NULL, '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', '', 0, NULL, 1, 0, 0, 'system:dict:list', 'dict', 'admin', '2022-03-31 15:49:57', '', NULL, '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', '', 0, NULL, 1, 0, 0, 'system:config:list', 'edit', 'admin', '2022-03-31 15:49:57', '', NULL, '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', '', 0, NULL, 1, 0, 0, 'system:notice:list', 'message', 'admin', '2022-03-31 15:49:57', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, 'log', '', '', 0, NULL, 0, 0, 0, '', 'log', 'admin', '2022-03-31 15:49:57', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', '', 0, NULL, 1, 0, 0, 'monitor:online:list', 'online', 'admin', '2022-03-31 15:49:57', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', '', 0, NULL, 1, 0, 0, 'monitor:job:list', 'job', 'admin', '2022-03-31 15:49:57', '', NULL, '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, '数据监控', 2, 3, 'druid', 'monitor/druid/index', '', 0, NULL, 1, 0, 0, 'monitor:druid:list', 'druid', 'admin', '2022-03-31 15:49:57', '', NULL, '数据监控菜单');
INSERT INTO `sys_menu` VALUES (112, '服务监控', 2, 4, 'server', 'monitor/server/index', '', 0, NULL, 1, 0, 0, 'monitor:server:list', 'server', 'admin', '2022-03-31 15:49:57', '', NULL, '服务监控菜单');
INSERT INTO `sys_menu` VALUES (113, '缓存监控', 2, 5, 'cache', 'monitor/cache/index', '', 0, NULL, 1, 0, 0, 'monitor:cache:list', 'redis', 'admin', '2022-03-31 15:49:57', '', NULL, '缓存监控菜单');
INSERT INTO `sys_menu` VALUES (114, '表单构建', 3, 1, 'build', 'tool/build/index', '', 0, NULL, 1, 0, 0, 'tool:build:list', 'build', 'admin', '2022-03-31 15:49:57', '', NULL, '表单构建菜单');
INSERT INTO `sys_menu` VALUES (115, '代码生成', 3, 2, 'gen', 'tool/gen/index', '', 0, NULL, 1, 0, 0, 'tool:gen:list', 'code', 'admin', '2022-03-31 15:49:57', '', NULL, '代码生成菜单');
INSERT INTO `sys_menu` VALUES (116, '系统接口', 3, 3, 'swagger', 'tool/swagger/index', '', 0, NULL, 1, 0, 0, 'tool:swagger:list', 'swagger', 'admin', '2022-03-31 15:49:57', '', NULL, '系统接口菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'monitor/operlog/index', '', 0, NULL, 1, 0, 0, 'monitor:operlog:list', 'form', 'admin', '2022-03-31 15:49:57', '', NULL, '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'monitor/logininfor/index', '', 0, NULL, 1, 0, 0, 'monitor:logininfor:list', 'logininfor', 'admin', '2022-03-31 15:49:57', '', NULL, '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, 1, '', '', '', 0, NULL, 2, 0, 0, 'system:user:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, 2, '', '', '', 0, NULL, 2, 0, 0, 'system:user:add', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, 3, '', '', '', 0, NULL, 2, 0, 0, 'system:user:edit', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, 4, '', '', '', 0, NULL, 2, 0, 0, 'system:user:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, 5, '', '', '', 0, NULL, 2, 0, 0, 'system:user:export', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, 6, '', '', '', 0, NULL, 2, 0, 0, 'system:user:import', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, 7, '', '', '', 0, NULL, 2, 0, 0, 'system:user:resetPwd', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, 1, '', '', '', 0, NULL, 2, 0, 0, 'system:role:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, 2, '', '', '', 0, NULL, 2, 0, 0, 'system:role:add', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, 3, '', '', '', 0, NULL, 2, 0, 0, 'system:role:edit', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, 4, '', '', '', 0, NULL, 2, 0, 0, 'system:role:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, 5, '', '', '', 0, NULL, 2, 0, 0, 'system:role:export', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, 1, '', '', '', 0, NULL, 2, 0, 0, 'system:menu:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, 2, '', '', '', 0, NULL, 2, 0, 0, 'system:menu:add', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, 3, '', '', '', 0, NULL, 2, 0, 0, 'system:menu:edit', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, 4, '', '', '', 0, NULL, 2, 0, 0, 'system:menu:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, 1, '', '', '', 0, NULL, 2, 0, 0, 'system:dept:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, 2, '', '', '', 0, NULL, 2, 0, 0, 'system:dept:add', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, 3, '', '', '', 0, NULL, 2, 0, 0, 'system:dept:edit', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, 4, '', '', '', 0, NULL, 2, 0, 0, 'system:dept:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, 1, '', '', '', 0, NULL, 2, 0, 0, 'system:post:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, 2, '', '', '', 0, NULL, 2, 0, 0, 'system:post:add', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, 3, '', '', '', 0, NULL, 2, 0, 0, 'system:post:edit', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, 4, '', '', '', 0, NULL, 2, 0, 0, 'system:post:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, 5, '', '', '', 0, NULL, 2, 0, 0, 'system:post:export', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, 1, '#', '', '', 0, NULL, 2, 0, 0, 'system:dict:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, 2, '#', '', '', 0, NULL, 2, 0, 0, 'system:dict:add', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, 3, '#', '', '', 0, NULL, 2, 0, 0, 'system:dict:edit', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, 4, '#', '', '', 0, NULL, 2, 0, 0, 'system:dict:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, 5, '#', '', '', 0, NULL, 2, 0, 0, 'system:dict:export', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1031, '参数查询', 106, 1, '#', '', '', 0, NULL, 2, 0, 0, 'system:config:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1032, '参数新增', 106, 2, '#', '', '', 0, NULL, 2, 0, 0, 'system:config:add', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1033, '参数修改', 106, 3, '#', '', '', 0, NULL, 2, 0, 0, 'system:config:edit', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1034, '参数删除', 106, 4, '#', '', '', 0, NULL, 2, 0, 0, 'system:config:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1035, '参数导出', 106, 5, '#', '', '', 0, NULL, 2, 0, 0, 'system:config:export', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1036, '公告查询', 107, 1, '#', '', '', 0, NULL, 2, 0, 0, 'system:notice:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1037, '公告新增', 107, 2, '#', '', '', 0, NULL, 2, 0, 0, 'system:notice:add', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1038, '公告修改', 107, 3, '#', '', '', 0, NULL, 2, 0, 0, 'system:notice:edit', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1039, '公告删除', 107, 4, '#', '', '', 0, NULL, 2, 0, 0, 'system:notice:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, 1, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:operlog:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1041, '操作删除', 500, 2, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:operlog:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:operlog:export', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:logininfor:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:logininfor:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:logininfor:export', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:online:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:online:batchLogout', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:online:forceLogout', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, 1, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:job:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, 2, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:job:add', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, 3, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:job:edit', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, 4, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:job:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, 5, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:job:changeStatus', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1054, '任务导出', 110, 7, '#', '', '', 0, NULL, 2, 0, 0, 'monitor:job:export', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1055, '生成查询', 115, 1, '#', '', '', 0, NULL, 2, 0, 0, 'tool:gen:query', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1056, '生成修改', 115, 2, '#', '', '', 0, NULL, 2, 0, 0, 'tool:gen:edit', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1057, '生成删除', 115, 3, '#', '', '', 0, NULL, 2, 0, 0, 'tool:gen:remove', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1058, '导入代码', 115, 2, '#', '', '', 0, NULL, 2, 0, 0, 'tool:gen:import', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1059, '预览代码', 115, 4, '#', '', '', 0, NULL, 2, 0, 0, 'tool:gen:preview', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1060, '生成代码', 115, 5, '#', '', '', 0, NULL, 2, 0, 0, 'tool:gen:code', '#', 'admin', '2022-03-31 15:49:57', '', NULL, '');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `module` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `req_method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '请求的方法名称',
  `req_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '请求方式',
  `req_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '请求参数',
  `req_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '请求URL',
  `client_type` int NULL DEFAULT 0 COMMENT '客户端类型（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '部门名称',
  `ip_adress` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT 'ip地址',
  `ip_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '操作地点',
  `json_result` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `oper_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 125 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限字符串',
  `order_no` int NULL DEFAULT NULL COMMENT '排序',
  `del_flag` bit(1) NULL DEFAULT b'0' COMMENT '删除标志(0未删除；1删除)',
  `status` bit(1) NULL DEFAULT b'1' COMMENT '状态（0停用；1启用）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'admin', 1, b'0', b'1', '2022-08-26 15:04:10', NULL, NULL, '2022-08-24 15:04:14', NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dept_id` bigint NULL DEFAULT NULL COMMENT '部门id',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'token',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标志(0：未删除；1：删除)',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否启用(0：未启用；1：启用)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, NULL, '风中捉刀', 'fzzd', '风中捉刀', NULL, NULL, b'0', NULL, NULL, b'1', '2022-08-10 00:00:00', NULL, '2022-08-14 14:55:57', NULL, NULL);
INSERT INTO `sys_user` VALUES (2, NULL, '无情葬月', 'wqzy', '无情葬月', NULL, NULL, b'0', NULL, NULL, b'1', '2022-08-10 00:00:00', NULL, '2022-08-14 14:55:59', NULL, NULL);
INSERT INTO `sys_user` VALUES (3, NULL, '玲珑雪霏', 'llxf', '{bcrypt}$2a$10$y4hL.UBBmVKBBhk1PGOLyOQnB3Xv7nivPEbzshB2Rv4UrXBjhCG.a', NULL, NULL, b'0', NULL, NULL, b'1', '2022-08-10 00:00:00', NULL, '2022-09-01 07:10:13', NULL, NULL);
INSERT INTO `sys_user` VALUES (4, NULL, '江湖浪子', 'jhlz', '{bcrypt}$2a$10$y4hL.UBBmVKBBhk1PGOLyOQnB3Xv7nivPEbzshB2Rv4UrXBjhCG.a', NULL, NULL, b'0', NULL, NULL, b'1', '2022-01-01 00:00:00', NULL, '2022-08-14 14:56:04', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
