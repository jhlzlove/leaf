-- public.leaf_dept definition

-- Drop table

-- DROP TABLE public.leaf_dept;

CREATE TABLE public.leaf_dept (
	dept_id int8 NOT NULL,
	dept_code varchar NOT NULL, -- 部门编码
	dept_name varchar NOT NULL, -- 部门名称
	parent_id int8 NULL, -- 父级部门id
	leader_id int8 NULL, -- 部门负责人id
	description varchar NULL, -- 部门描述
	status int2 NULL, -- 状态：1正常，0禁用
	del_flag bit(1) NULL, -- 是否删除：true(b'1')已删除，false(b'0')正常
	create_by varchar NULL, -- 创建人
	create_time timestamptz NULL, -- 创建时间
	update_by varchar NULL, -- 更新者
	update_time timestamptz NULL, -- 更新时间
	remark varchar NULL, -- 备注
	CONSTRAINT leaf_dept_pk PRIMARY KEY (dept_id)
);
COMMENT ON TABLE public.leaf_dept IS '部门表';

-- Column comments

COMMENT ON COLUMN public.leaf_dept.dept_code IS '部门编码';
COMMENT ON COLUMN public.leaf_dept.dept_name IS '部门名称';
COMMENT ON COLUMN public.leaf_dept.parent_id IS '父级部门id';
COMMENT ON COLUMN public.leaf_dept.leader_id IS '部门负责人id';
COMMENT ON COLUMN public.leaf_dept.description IS '部门描述';
COMMENT ON COLUMN public.leaf_dept.status IS '状态：1正常，0禁用';
COMMENT ON COLUMN public.leaf_dept.del_flag IS '是否删除：true(b''1'')已删除，false(b''0'')正常';
COMMENT ON COLUMN public.leaf_dept.create_by IS '创建人';
COMMENT ON COLUMN public.leaf_dept.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_dept.update_by IS '更新者';
COMMENT ON COLUMN public.leaf_dept.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_dept.remark IS '备注';


-- public.leaf_dict definition

-- Drop table

-- DROP TABLE public.leaf_dict;

CREATE TABLE public.leaf_dict (
	dict_id int8 NOT NULL,
	dict_key varchar NULL, -- 字典键
	dict_value varchar NULL, -- 字典值
	dict_type varchar NULL, -- 字典类型
	status int2 NULL, -- 状态：1正常，0禁用
	create_by varchar NULL, -- 创建人
	create_time timestamptz NULL, -- 创建时间
	update_by varchar NULL, -- 更新者
	update_time timestamptz NULL, -- 更新时间
	remark varchar NULL, -- 备注
	CONSTRAINT leaf_dict_pk PRIMARY KEY (dict_id)
);
COMMENT ON TABLE public.leaf_dict IS '字典表';

-- Column comments

COMMENT ON COLUMN public.leaf_dict.dict_key IS '字典键';
COMMENT ON COLUMN public.leaf_dict.dict_value IS '字典值';
COMMENT ON COLUMN public.leaf_dict.dict_type IS '字典类型';
COMMENT ON COLUMN public.leaf_dict.status IS '状态：1正常，0禁用';
COMMENT ON COLUMN public.leaf_dict.create_by IS '创建人';
COMMENT ON COLUMN public.leaf_dict.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_dict.update_by IS '更新者';
COMMENT ON COLUMN public.leaf_dict.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_dict.remark IS '备注';


-- public.leaf_menu definition

-- Drop table

-- DROP TABLE public.leaf_menu;

CREATE TABLE public.leaf_menu (
	menu_id int8 NOT NULL,
	menu_name varchar NULL, -- 菜单名称
	menu_url varchar NULL, -- 菜单地址
	parent_id int8 NULL, -- 父菜单id
	menu_icon varchar NULL, -- 菜单图标
	menu_type bpchar(1) NULL, -- 菜单类型：D目录，M菜单，B按钮
	order_num int8 NULL, -- 菜单显示顺序
	status int2 NULL, -- 状态：1正常，0禁用
	"permission" varchar NULL, -- 权限字符
	CONSTRAINT leaf_permission_pk PRIMARY KEY (menu_id)
);
COMMENT ON TABLE public.leaf_menu IS '菜单表';

-- Column comments

COMMENT ON COLUMN public.leaf_menu.menu_name IS '菜单名称';
COMMENT ON COLUMN public.leaf_menu.menu_url IS '菜单地址';
COMMENT ON COLUMN public.leaf_menu.parent_id IS '父菜单id';
COMMENT ON COLUMN public.leaf_menu.menu_icon IS '菜单图标';
COMMENT ON COLUMN public.leaf_menu.menu_type IS '菜单类型：D目录，M菜单，B按钮';
COMMENT ON COLUMN public.leaf_menu.order_num IS '菜单显示顺序';
COMMENT ON COLUMN public.leaf_menu.status IS '状态：1正常，0禁用';
COMMENT ON COLUMN public.leaf_menu."permission" IS '权限字符';


-- public.leaf_menu_role definition

-- Drop table

-- DROP TABLE public.leaf_menu_role;

CREATE TABLE public.leaf_menu_role (
	id int8 NOT NULL,
	menu_id int8 NULL, -- 菜单id
	role_id int8 NULL, -- 角色id
	CONSTRAINT leaf_menu_role_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.leaf_menu_role IS '菜单-角色关联表';

-- Column comments

COMMENT ON COLUMN public.leaf_menu_role.menu_id IS '菜单id';
COMMENT ON COLUMN public.leaf_menu_role.role_id IS '角色id';


-- public.leaf_role definition

-- Drop table

-- DROP TABLE public.leaf_role;

CREATE TABLE public.leaf_role (
	role_id int8 NOT NULL,
	role_name varchar NOT NULL, -- 角色名称
	role_code varchar NOT NULL, -- 角色编码
	status int2 NULL, -- 状态：1正常，0禁用
	del_flag bit(1) NULL, -- 是否删除：true(b'1')已删除，false(b'0')正常
	create_by varchar NULL, -- 创建人
	create_time timestamptz NULL, -- 创建时间
	update_by varchar NULL, -- 更新者
	update_time timestamptz NULL, -- 更新时间
	remark varchar NULL, -- 备注
	CONSTRAINT leaf_role_pk PRIMARY KEY (role_id)
);
COMMENT ON TABLE public.leaf_role IS '角色表';

-- Column comments

COMMENT ON COLUMN public.leaf_role.role_name IS '角色名称';
COMMENT ON COLUMN public.leaf_role.role_code IS '角色编码';
COMMENT ON COLUMN public.leaf_role.status IS '状态：1正常，0禁用';
COMMENT ON COLUMN public.leaf_role.del_flag IS '是否删除：true(b''1'')已删除，false(b''0'')正常';
COMMENT ON COLUMN public.leaf_role.create_by IS '创建人';
COMMENT ON COLUMN public.leaf_role.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_role.update_by IS '更新者';
COMMENT ON COLUMN public.leaf_role.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_role.remark IS '备注';


-- public.leaf_user definition

-- Drop table

-- DROP TABLE public.leaf_user;

CREATE TABLE public.leaf_user (
	user_id int8 NOT NULL,
	username varchar NOT NULL, -- 用户名
	"password" varchar NOT NULL, -- 密码
	phone varchar NULL, -- 登录绑定手机号
	email varchar NULL, -- 登录绑定邮箱
	nick_name varchar NOT NULL, -- 昵称
	avatar varchar NULL, -- 头像地址
	user_detail_id int8 NULL, -- 用户详情id
	status int2 NULL, -- 状态：1正常，0禁用
	del_flag bit(1) NULL, -- 是否删除：true(b'1')已删除，false(b'0')正常
	create_by varchar NULL, -- 创建人
	create_time timestamptz NULL, -- 创建时间
	update_by varchar NULL, -- 更新者
	update_time timestamptz NULL, -- 更新时间
	remark varchar NULL, -- 备注
	CONSTRAINT leaf_user_pk PRIMARY KEY (user_id)
);
COMMENT ON TABLE public.leaf_user IS '用户登录信息表';

-- Column comments

COMMENT ON COLUMN public.leaf_user.username IS '用户名';
COMMENT ON COLUMN public.leaf_user."password" IS '密码';
COMMENT ON COLUMN public.leaf_user.phone IS '登录绑定手机号';
COMMENT ON COLUMN public.leaf_user.email IS '登录绑定邮箱';
COMMENT ON COLUMN public.leaf_user.nick_name IS '昵称';
COMMENT ON COLUMN public.leaf_user.avatar IS '头像地址';
COMMENT ON COLUMN public.leaf_user.user_detail_id IS '用户详情id';
COMMENT ON COLUMN public.leaf_user.status IS '状态：1正常，0禁用';
COMMENT ON COLUMN public.leaf_user.del_flag IS '是否删除：true(b''1'')已删除，false(b''0'')正常';
COMMENT ON COLUMN public.leaf_user.create_by IS '创建人';
COMMENT ON COLUMN public.leaf_user.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_user.update_by IS '更新者';
COMMENT ON COLUMN public.leaf_user.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_user.remark IS '备注';


-- public.leaf_user_detail definition

-- Drop table

-- DROP TABLE public.leaf_user_detail;

CREATE TABLE public.leaf_user_detail (
	user_detail_id int8 NOT NULL,
	user_code varchar NULL, -- 用户编码
	first_name varchar NULL, -- 姓氏
	last_name varchar NULL, -- 名称
	real_name varchar NULL, -- 姓名
	ethnic varchar NULL, -- 民族
	mobile varchar NULL, -- 联系电话
	gender int2 NULL, -- 性别 0 保密，1 女，2 男
	age int2 NULL, -- 年龄
	address varchar NULL, -- 住址
	hometown varchar NULL, -- 故里
	id_card varchar NULL, -- 身份证号
	tab1 varchar NULL, -- 备用字段1
	tab2 varchar NULL, -- 备用字段2
	tab3 varchar NULL, -- 备用字段3
	tab4 varchar NULL, -- 备用字段4
	tab5 varchar NULL, -- 备用字段5
	tab6 varchar NULL, -- 备用字段6
	dept_id int8 NULL, -- 所属部门id
	CONSTRAINT leaf_user_detail_pk PRIMARY KEY (user_detail_id)
);
COMMENT ON TABLE public.leaf_user_detail IS '用户信息表';

-- Column comments

COMMENT ON COLUMN public.leaf_user_detail.user_code IS '用户编码';
COMMENT ON COLUMN public.leaf_user_detail.first_name IS '姓氏';
COMMENT ON COLUMN public.leaf_user_detail.last_name IS '名称';
COMMENT ON COLUMN public.leaf_user_detail.real_name IS '姓名';
COMMENT ON COLUMN public.leaf_user_detail.ethnic IS '民族';
COMMENT ON COLUMN public.leaf_user_detail.mobile IS '联系电话';
COMMENT ON COLUMN public.leaf_user_detail.gender IS '性别 0 保密，1 女，2 男';
COMMENT ON COLUMN public.leaf_user_detail.age IS '年龄';
COMMENT ON COLUMN public.leaf_user_detail.address IS '住址';
COMMENT ON COLUMN public.leaf_user_detail.hometown IS '故里';
COMMENT ON COLUMN public.leaf_user_detail.id_card IS '身份证号';
COMMENT ON COLUMN public.leaf_user_detail.tab1 IS '备用字段1';
COMMENT ON COLUMN public.leaf_user_detail.tab2 IS '备用字段2';
COMMENT ON COLUMN public.leaf_user_detail.tab3 IS '备用字段3';
COMMENT ON COLUMN public.leaf_user_detail.tab4 IS '备用字段4';
COMMENT ON COLUMN public.leaf_user_detail.tab5 IS '备用字段5';
COMMENT ON COLUMN public.leaf_user_detail.tab6 IS '备用字段6';
COMMENT ON COLUMN public.leaf_user_detail.dept_id IS '所属部门id';


-- public.leaf_user_role definition

-- Drop table

-- DROP TABLE public.leaf_user_role;

CREATE TABLE public.leaf_user_role (
	id int8 NOT NULL,
	user_id int8 NOT NULL, -- 用户id
	role_id int8 NOT NULL, -- 角色id
	CONSTRAINT leaf_user_role_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.leaf_user_role IS '用户-角色关联表';

-- Column comments

COMMENT ON COLUMN public.leaf_user_role.user_id IS '用户id';
COMMENT ON COLUMN public.leaf_user_role.role_id IS '角色id';