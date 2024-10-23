
CREATE TABLE public.leaf_dept (
    id bigint NOT NULL,
    dept_name character varying NOT NULL,
    parent_id bigint,
    leader_id bigint NOT NULL,
    description character varying,
    status smallint DEFAULT 0 NOT NULL,
    sortable smallint DEFAULT 1 NOT NULL,
    ancestors character varying,
    create_id bigint NOT NULL,
    update_id bigint NOT NULL,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    remark character varying
);


ALTER TABLE public.leaf_dept OWNER TO postgres;

COMMENT ON TABLE public.leaf_dept IS '部门表';
COMMENT ON COLUMN public.leaf_dept.dept_name IS '部门名称';
COMMENT ON COLUMN public.leaf_dept.parent_id IS '父级部门ID';
COMMENT ON COLUMN public.leaf_dept.leader_id IS '部门负责人ID';
COMMENT ON COLUMN public.leaf_dept.description IS '部门描述';
COMMENT ON COLUMN public.leaf_dept.status IS '状态：0正常，1禁用';
COMMENT ON COLUMN public.leaf_dept.create_id IS '创建人';
COMMENT ON COLUMN public.leaf_dept.update_id IS '更新人';
COMMENT ON COLUMN public.leaf_dept.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_dept.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_dept.remark IS '备注';
COMMENT ON COLUMN public.leaf_dept.sortable IS '排序';
COMMENT ON COLUMN public.leaf_dept.ancestors IS '父级列表';

CREATE SEQUENCE public.leaf_dept_dept_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_dept_dept_id_seq OWNER TO postgres;
ALTER SEQUENCE public.leaf_dept_dept_id_seq OWNED BY public.leaf_dept.id;


CREATE TABLE public.leaf_dict (
    id bigint NOT NULL,
    dict_code character varying NOT NULL,
    dict_name character varying NOT NULL,
    status smallint DEFAULT 0 NOT NULL,
    create_id bigint NOT NULL,
    update_id bigint NOT NULL,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    remark character varying
);


ALTER TABLE public.leaf_dict OWNER TO postgres;

COMMENT ON TABLE public.leaf_dict IS '字典表';
COMMENT ON COLUMN public.leaf_dict.dict_code IS '字典编码';
COMMENT ON COLUMN public.leaf_dict.dict_name IS '字典名称';
COMMENT ON COLUMN public.leaf_dict.create_id IS '创建人';
COMMENT ON COLUMN public.leaf_dict.update_id IS '更新人';
COMMENT ON COLUMN public.leaf_dict.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_dict.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_dict.remark IS '备注';
COMMENT ON COLUMN public.leaf_dict.status IS '状态：0正常，1禁用';

CREATE SEQUENCE public.leaf_dict_dict_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_dict_dict_id_seq OWNER TO postgres;
ALTER SEQUENCE public.leaf_dict_dict_id_seq OWNED BY public.leaf_dict.id;

CREATE TABLE public.leaf_dict_item (
    id bigint NOT NULL,
    dict_id bigint NOT NULL,
    label character varying NOT NULL,
    value character varying NOT NULL,
    status smallint DEFAULT 0 NOT NULL,
    sortable smallint DEFAULT 1 NOT NULL,
    create_id bigint NOT NULL,
    update_id bigint NOT NULL,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    remark character varying
);


ALTER TABLE public.leaf_dict_item OWNER TO postgres;

COMMENT ON TABLE public.leaf_dict_item IS '字典信息表';
COMMENT ON COLUMN public.leaf_dict_item.dict_id IS '字典表ID';
COMMENT ON COLUMN public.leaf_dict_item.label IS '标签';
COMMENT ON COLUMN public.leaf_dict_item.value IS '值';
COMMENT ON COLUMN public.leaf_dict_item.create_id IS '创建人';
COMMENT ON COLUMN public.leaf_dict_item.update_id IS '更新人';
COMMENT ON COLUMN public.leaf_dict_item.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_dict_item.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_dict_item.remark IS '备注';
COMMENT ON COLUMN public.leaf_dict_item.status IS '状态：0正常，1禁用';
COMMENT ON COLUMN public.leaf_dict_item.sortable IS '排序';

CREATE SEQUENCE public.leaf_dict_item_dict_item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_dict_item_dict_item_id_seq OWNER TO postgres;
ALTER SEQUENCE public.leaf_dict_item_dict_item_id_seq OWNED BY public.leaf_dict_item.id;


CREATE TABLE public.leaf_menu (
    id bigint NOT NULL,
    title character varying NOT NULL,
    menu_type smallint NOT NULL,
    parent_id bigint,
    permission character varying,
    route_path character varying,
    component_path character varying,
    component character varying,
    icon character varying,
    is_external smallint,
    is_hidden smallint,
    sortable smallint DEFAULT 1 NOT NULL,
    status smallint DEFAULT 0 NOT NULL,
    create_id bigint NOT NULL,
    update_id bigint NOT NULL,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    remark character varying
);


ALTER TABLE public.leaf_menu OWNER TO postgres;

COMMENT ON TABLE public.leaf_menu IS '菜单表';
COMMENT ON COLUMN public.leaf_menu.menu_type IS '菜单类型：1目录，2菜单，3按钮';
COMMENT ON COLUMN public.leaf_menu.parent_id IS '父级菜单ID';
COMMENT ON COLUMN public.leaf_menu.sortable IS '排序';
COMMENT ON COLUMN public.leaf_menu.permission IS '权限字符';
COMMENT ON COLUMN public.leaf_menu.status IS '状态：0正常，1禁用';
COMMENT ON COLUMN public.leaf_menu.create_id IS '创建人';
COMMENT ON COLUMN public.leaf_menu.update_id IS '更新人';
COMMENT ON COLUMN public.leaf_menu.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_menu.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_menu.remark IS '备注';
COMMENT ON COLUMN public.leaf_menu.title IS '标题';
COMMENT ON COLUMN public.leaf_menu.route_path IS '路由地址';
COMMENT ON COLUMN public.leaf_menu.component_path IS '组件路径';
COMMENT ON COLUMN public.leaf_menu.component IS '组件名称';
COMMENT ON COLUMN public.leaf_menu.icon IS '图标';
COMMENT ON COLUMN public.leaf_menu.is_external IS '是否外链：0是，1否';
COMMENT ON COLUMN public.leaf_menu.is_hidden IS '是否隐藏：0是，1否';

CREATE SEQUENCE public.leaf_menu_menu_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_menu_menu_id_seq OWNER TO postgres;
ALTER SEQUENCE public.leaf_menu_menu_id_seq OWNED BY public.leaf_menu.id;

CREATE TABLE public.leaf_menu_role (
    menu_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.leaf_menu_role OWNER TO postgres;

COMMENT ON TABLE public.leaf_menu_role IS '菜单-角色关联表';
COMMENT ON COLUMN public.leaf_menu_role.menu_id IS '菜单ID';
COMMENT ON COLUMN public.leaf_menu_role.role_id IS '角色ID';


CREATE TABLE public.leaf_role (
    id bigint NOT NULL,
    name character varying NOT NULL,
    code character varying NOT NULL,
    sortable smallint DEFAULT 1 NOT NULL,
    status smallint DEFAULT 0 NOT NULL,
    create_id bigint NOT NULL,
    update_id bigint NOT NULL,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    remark character varying
);


ALTER TABLE public.leaf_role OWNER TO postgres;

COMMENT ON TABLE public.leaf_role IS '角色表';
COMMENT ON COLUMN public.leaf_role.name IS '角色名称';
COMMENT ON COLUMN public.leaf_role.code IS '角色编码';
COMMENT ON COLUMN public.leaf_role.status IS '状态：0正常，1禁用';
COMMENT ON COLUMN public.leaf_role.create_id IS '创建人';
COMMENT ON COLUMN public.leaf_role.update_id IS '更新人';
COMMENT ON COLUMN public.leaf_role.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_role.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_role.remark IS '备注';
COMMENT ON COLUMN public.leaf_role.sortable IS '排序';

CREATE SEQUENCE public.leaf_role_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_role_role_id_seq OWNER TO postgres;
ALTER SEQUENCE public.leaf_role_role_id_seq OWNED BY public.leaf_role.id;


CREATE TABLE public.leaf_user (
    id bigint NOT NULL,
    nick_name character varying NOT NULL,
    username character varying NOT NULL,
    password character varying NOT NULL,
    phone character(11),
    email character varying,
    avatar character varying NOT NULL,
    user_detail_id bigint,
    dept_id bigint,
    status smallint DEFAULT 0 NOT NULL,
    create_id bigint NOT NULL,
    update_id bigint NOT NULL,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    remark character varying
);


ALTER TABLE public.leaf_user OWNER TO postgres;

COMMENT ON TABLE public.leaf_user IS '用户表';
COMMENT ON COLUMN public.leaf_user.nick_name IS '昵称';
COMMENT ON COLUMN public.leaf_user.username IS '用户名';
COMMENT ON COLUMN public.leaf_user.password IS '密码';
COMMENT ON COLUMN public.leaf_user.phone IS '手机号';
COMMENT ON COLUMN public.leaf_user.email IS '电子邮箱';
COMMENT ON COLUMN public.leaf_user.avatar IS '头像';
COMMENT ON COLUMN public.leaf_user.status IS '状态：0正常，1禁用';
COMMENT ON COLUMN public.leaf_user.create_id IS '创建人';
COMMENT ON COLUMN public.leaf_user.update_id IS '更新人';
COMMENT ON COLUMN public.leaf_user.create_time IS '创建时间';
COMMENT ON COLUMN public.leaf_user.update_time IS '更新时间';
COMMENT ON COLUMN public.leaf_user.remark IS '备注';
COMMENT ON COLUMN public.leaf_user.user_detail_id IS '外键，leaf_user_detail 表主键';
COMMENT ON COLUMN public.leaf_user.dept_id IS '部门 id';


CREATE TABLE public.leaf_user_detail (
    id bigint NOT NULL,
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    ethnic character varying,
    gender character varying,
    age smallint,
    address character varying,
    hometown character varying,
    id_card character varying
);


ALTER TABLE public.leaf_user_detail OWNER TO postgres;

COMMENT ON TABLE public.leaf_user_detail IS '用户详情表';
COMMENT ON COLUMN public.leaf_user_detail.first_name IS '姓氏';
COMMENT ON COLUMN public.leaf_user_detail.last_name IS '名称';
COMMENT ON COLUMN public.leaf_user_detail.ethnic IS '民族';
COMMENT ON COLUMN public.leaf_user_detail.gender IS '性别';
COMMENT ON COLUMN public.leaf_user_detail.age IS '年龄';
COMMENT ON COLUMN public.leaf_user_detail.address IS '住址';
COMMENT ON COLUMN public.leaf_user_detail.hometown IS '故乡';
COMMENT ON COLUMN public.leaf_user_detail.id_card IS '身份证号';

CREATE SEQUENCE public.leaf_user_detail_user_detail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_user_detail_user_detail_id_seq OWNER TO postgres;
ALTER SEQUENCE public.leaf_user_detail_user_detail_id_seq OWNED BY public.leaf_user_detail.id;


CREATE TABLE public.leaf_user_role (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.leaf_user_role OWNER TO postgres;


COMMENT ON TABLE public.leaf_user_role IS '用户-角色关联表';
COMMENT ON COLUMN public.leaf_user_role.user_id IS '用户ID';
COMMENT ON COLUMN public.leaf_user_role.role_id IS '角色ID';

CREATE SEQUENCE public.leaf_user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_user_user_id_seq OWNER TO postgres;
ALTER SEQUENCE public.leaf_user_user_id_seq OWNED BY public.leaf_user.id;

ALTER TABLE ONLY public.leaf_dept ALTER COLUMN id SET DEFAULT nextval('public.leaf_dept_dept_id_seq'::regclass);

ALTER TABLE ONLY public.leaf_dict ALTER COLUMN id SET DEFAULT nextval('public.leaf_dict_dict_id_seq'::regclass);

ALTER TABLE ONLY public.leaf_dict_item ALTER COLUMN id SET DEFAULT nextval('public.leaf_dict_item_dict_item_id_seq'::regclass);

ALTER TABLE ONLY public.leaf_menu ALTER COLUMN id SET DEFAULT nextval('public.leaf_menu_menu_id_seq'::regclass);

ALTER TABLE ONLY public.leaf_role ALTER COLUMN id SET DEFAULT nextval('public.leaf_role_role_id_seq'::regclass);

ALTER TABLE ONLY public.leaf_user ALTER COLUMN id SET DEFAULT nextval('public.leaf_user_user_id_seq'::regclass);

ALTER TABLE ONLY public.leaf_user_detail ALTER COLUMN id SET DEFAULT nextval('public.leaf_user_detail_user_detail_id_seq'::regclass);


SELECT pg_catalog.setval('public.leaf_dept_dept_id_seq', 1, false);

SELECT pg_catalog.setval('public.leaf_dict_dict_id_seq', 1, false);

SELECT pg_catalog.setval('public.leaf_dict_item_dict_item_id_seq', 1, false);

SELECT pg_catalog.setval('public.leaf_menu_menu_id_seq', 1, false);

SELECT pg_catalog.setval('public.leaf_role_role_id_seq', 1, false);

SELECT pg_catalog.setval('public.leaf_user_detail_user_detail_id_seq', 1, false);

SELECT pg_catalog.setval('public.leaf_user_user_id_seq', 1, false);



ALTER TABLE ONLY public.leaf_dept
    ADD CONSTRAINT leaf_dept_pk PRIMARY KEY (id);

ALTER TABLE ONLY public.leaf_dict_item
    ADD CONSTRAINT leaf_dict_item_pk PRIMARY KEY (id);

ALTER TABLE ONLY public.leaf_dict
    ADD CONSTRAINT leaf_dict_pk PRIMARY KEY (id);

ALTER TABLE ONLY public.leaf_menu
    ADD CONSTRAINT leaf_menu_pk PRIMARY KEY (id);

ALTER TABLE ONLY public.leaf_role
    ADD CONSTRAINT leaf_role_pk PRIMARY KEY (id);

ALTER TABLE ONLY public.leaf_user_detail
    ADD CONSTRAINT leaf_user_detail_pk PRIMARY KEY (id);

ALTER TABLE ONLY public.leaf_user
    ADD CONSTRAINT leaf_user_pk PRIMARY KEY (id);


ALTER TABLE ONLY public.leaf_dict_item
    ADD CONSTRAINT leaf_dict_item_leaf_dict_fk FOREIGN KEY (dict_id) REFERENCES public.leaf_dict(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.leaf_menu_role
    ADD CONSTRAINT leaf_menu_role_leaf_menu_fk FOREIGN KEY (menu_id) REFERENCES public.leaf_menu(id) ON DELETE RESTRICT;

ALTER TABLE ONLY public.leaf_menu_role
    ADD CONSTRAINT leaf_menu_role_leaf_role_fk FOREIGN KEY (role_id) REFERENCES public.leaf_role(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.leaf_user
    ADD CONSTRAINT leaf_user_leaf_dept_fk FOREIGN KEY (dept_id) REFERENCES public.leaf_dept(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.leaf_user
    ADD CONSTRAINT leaf_user_leaf_user_detail_fk FOREIGN KEY (user_detail_id) REFERENCES public.leaf_user_detail(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.leaf_user_role
    ADD CONSTRAINT leaf_user_role_leaf_role_fk FOREIGN KEY (role_id) REFERENCES public.leaf_role(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY public.leaf_user_role
    ADD CONSTRAINT leaf_user_role_leaf_user_fk FOREIGN KEY (user_id) REFERENCES public.leaf_user(id) ON UPDATE CASCADE ON DELETE CASCADE;
