-- public.leaf_user definition

CREATE TABLE public.leaf_user (
                                  id bigserial NOT NULL,
                                  username varchar NOT NULL, -- 用户名
                                  "password" varchar NOT NULL, -- 密码
                                  nickname varchar NOT NULL, -- 昵称
                                  phone varchar NULL, -- 手机号
                                  email varchar NULL, -- 邮箱
                                  avatar varchar NULL, -- 头像
                                  dept_id varchar NOT NULL, -- 部门id
                                  status int2 NOT NULL, -- 状态：0正常，1禁用
                                  user_detail_id varchar NULL, -- 外键，leaf_user_detail 表主键
                                  create_id int8 NOT NULL, -- 创建人
                                  create_time timestamptz NOT NULL, -- 创建时间
                                  update_id int8 NULL, -- 更新人
                                  update_time timestamptz NULL, -- 更新时间
                                  remark varchar NULL, -- 备注
                                  CONSTRAINT leaf_user_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.leaf_user IS '用户信息表';

-- Column comments

COMMENT ON COLUMN public.leaf_user.username IS '用户名';
COMMENT ON COLUMN public.leaf_user."password" IS '密码';
COMMENT ON COLUMN public.leaf_user.nickname IS '昵称';
COMMENT ON COLUMN public.leaf_user.phone IS '手机号';
COMMENT ON COLUMN public.leaf_user.email IS '邮箱';
COMMENT ON COLUMN public.leaf_user.avatar IS '头像';
COMMENT ON COLUMN public.leaf_user.dept_id IS '部门id';
COMMENT ON COLUMN public.leaf_user.status IS '状态：0正常，1禁用';
COMMENT ON COLUMN public.leaf_user.user_detail_id IS '外键，leaf_user_detail 表主键';
COMMENT ON COLUMN public.leaf_user.create_id IS '创建人';
COMMENT ON COLUMN public.leaf_user.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_user.update_id IS '更新人';
COMMENT ON COLUMN public.leaf_user.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_user.remark IS '备注';

CREATE TABLE public.leaf_role (
                                  id bigserial NOT NULL,
                                  role_name varchar NOT NULL,
                                  role_code varchar NOT NULL,
                                  status int2 DEFAULT 0 NOT NULL,
                                  sortable int2 DEFAULT 0 NOT NULL,
                                  create_id int8 NOT NULL,
                                  create_time timestamptz NOT NULL,
                                  update_id int8 NULL,
                                  update_time timestamptz NULL,
                                  remark varchar NULL,
                                  CONSTRAINT leaf_role_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.leaf_role IS '角色信息表';

-- Column comments

COMMENT ON COLUMN public.leaf_role.role_name IS '角色名称';
COMMENT ON COLUMN public.leaf_role.role_code IS '角色编码';
COMMENT ON COLUMN public.leaf_role.status IS '状态：0正常，1禁用';
COMMENT ON COLUMN public.leaf_role.sortable IS '排序';
COMMENT ON COLUMN public.leaf_role.create_id IS '创建人';
COMMENT ON COLUMN public.leaf_role.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_role.update_id IS '更新人';
COMMENT ON COLUMN public.leaf_role.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_role.remark IS '备注';

CREATE TABLE public.leaf_user_role (
       user_id int8 NOT NULL,
       role_id int8 NOT NULL,
       CONSTRAINT leaf_user_role_unique UNIQUE (user_id,role_id)
);
COMMENT ON TABLE public.leaf_user_role IS '用户角色关联表';

-- Column comments

COMMENT ON COLUMN public.leaf_user_role.user_id IS '用户id';
COMMENT ON COLUMN public.leaf_user_role.role_id IS '角色id';


CREATE TABLE public.leaf_dict (
                                  id bigserial NOT NULL,
                                  dict_type varchar NOT NULL, -- 字典类型标识
                                  dict_name varchar NOT NULL, -- 字典类型名称
                                  status int2 NOT NULL, -- 状态：0正常，1禁用
                                  sortable int2 DEFAULT 1 NOT NULL, -- 排序
                                  create_id int8 NOT NULL, -- 创建人
                                  create_time timestamptz NOT NULL, -- 创建时间
                                  update_id int8 NULL, -- 更新人
                                  update_time timestamptz NULL, -- 更新时间
                                  remark varchar NULL, -- 备注
                                  CONSTRAINT leaf_dict_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.leaf_dict IS '字典表';

-- Column comments

COMMENT ON COLUMN public.leaf_dict.dict_type IS '字典类型标识';
COMMENT ON COLUMN public.leaf_dict.dict_name IS '字典类型名称';
COMMENT ON COLUMN public.leaf_dict.status IS '状态：0正常，1禁用';
COMMENT ON COLUMN public.leaf_dict.sortable IS '排序';
COMMENT ON COLUMN public.leaf_dict.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_dict.update_id IS '更新人';
COMMENT ON COLUMN public.leaf_dict.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_dict.remark IS '备注';
COMMENT ON COLUMN public.leaf_dict.create_id IS '创建人';


CREATE TABLE public.leaf_dict_item (
                                       id bigserial NOT NULL,
                                       item_key varchar NOT NULL,
                                       item_value varchar NOT NULL,
                                       dict_id int8 NOT NULL,
                                       sortable int2 DEFAULT 1 NOT NULL,
                                       status int2 DEFAULT 0 NOT NULL,
                                       create_id int8 NOT NULL,
                                       create_time timestamptz NOT NULL,
                                       update_id int8 NULL,
                                       update_time timestamptz NULL,
                                       remark varchar NULL,
                                       CONSTRAINT leaf_dict_item_pk PRIMARY KEY (id),
                                       CONSTRAINT leaf_dict_item_leaf_dict_fk FOREIGN KEY (dict_id) REFERENCES public.leaf_dict(id)
);
COMMENT ON TABLE public.leaf_dict_item IS '字典属性表';

-- Column comments

COMMENT ON COLUMN public.leaf_dict_item.item_key IS '字典键';
COMMENT ON COLUMN public.leaf_dict_item.item_value IS '字典值';
COMMENT ON COLUMN public.leaf_dict_item.dict_id IS '字典表id';
COMMENT ON COLUMN public.leaf_dict_item.sortable IS '排序';
COMMENT ON COLUMN public.leaf_dict_item.status IS '状态：0正常，1禁用';
COMMENT ON COLUMN public.leaf_dict_item.create_id IS '创建人';
COMMENT ON COLUMN public.leaf_dict_item.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_dict_item.update_id IS '更新人';
COMMENT ON COLUMN public.leaf_dict_item.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_dict_item.remark IS '备注';


CREATE TABLE public.leaf_dept (
                                  id bigserial NOT NULL,
                                  dept_name varchar NOT NULL,
                                  parent_id int8 NULL,
                                  ancestors json NULL,
                                  leader_id int8 NOT NULL,
                                  status int2 DEFAULT 0 NOT NULL,
                                  sortable int2 DEFAULT 1 NOT NULL,
                                  create_id int8 NOT NULL,
                                  create_time timestamptz NOT NULL,
                                  update_id int8 NULL,
                                  update_time timestamptz NULL,
                                  remark varchar NULL,
                                  CONSTRAINT leaf_dept_pk PRIMARY KEY (id)
);

-- Column comments

COMMENT ON COLUMN public.leaf_dept.dept_name IS '部门名称';
COMMENT ON COLUMN public.leaf_dept.parent_id IS '父部门id';
COMMENT ON COLUMN public.leaf_dept.ancestors IS '组级列表';
COMMENT ON COLUMN public.leaf_dept.leader_id IS '部门负责人';
COMMENT ON COLUMN public.leaf_dept.status IS '状态：0正常，1禁用';
COMMENT ON COLUMN public.leaf_dept.sortable IS '排序';
COMMENT ON COLUMN public.leaf_dept.create_id IS '创建人';
COMMENT ON COLUMN public.leaf_dept.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_dept.update_id IS '更新人';
COMMENT ON COLUMN public.leaf_dept.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_dept.remark IS '备注';


CREATE TABLE public.leaf_menu (
                                  id bigserial NOT NULL,
                                  menu_name varchar NOT NULL,
                                  parent_id int8 NULL,
                                  menu_type int2 NULL,
                                  "permission" varchar NOT NULL,
                                  route_path varchar NULL,
                                  component_path varchar NULL,
                                  component_name varchar NULL,
                                  icon varchar NULL,
                                  is_external int2 NULL,
                                  is_hidden int2 NULL,
                                  status int2 DEFAULT 0 NOT NULL,
                                  sortable int2 DEFAULT 1 NOT NULL,
                                  CONSTRAINT leaf_menu_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.leaf_menu IS '菜单表';

-- Column comments

COMMENT ON COLUMN public.leaf_menu.menu_name IS '菜单名称';
COMMENT ON COLUMN public.leaf_menu.parent_id IS '父级菜单id';
COMMENT ON COLUMN public.leaf_menu.menu_type IS '菜单类型 1目录，2菜单，3按钮';
COMMENT ON COLUMN public.leaf_menu."permission" IS '权限字符';
COMMENT ON COLUMN public.leaf_menu.route_path IS '路由路径';
COMMENT ON COLUMN public.leaf_menu.component_path IS '组件路径';
COMMENT ON COLUMN public.leaf_menu.component_name IS '组件名称';
COMMENT ON COLUMN public.leaf_menu.icon IS '图标';
COMMENT ON COLUMN public.leaf_menu.is_external IS '是否外链 0外链，1非外链';
COMMENT ON COLUMN public.leaf_menu.is_hidden IS '是否隐藏 0显示，1隐藏';
COMMENT ON COLUMN public.leaf_menu.status IS '状态0正常 1禁用';
COMMENT ON COLUMN public.leaf_menu.sortable IS '排序';
