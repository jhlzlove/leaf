--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

ALTER TABLE ONLY public.leaf_user DROP CONSTRAINT leaf_user_pk;
ALTER TABLE ONLY public.leaf_role DROP CONSTRAINT leaf_role_pk;
ALTER TABLE ONLY public.leaf_menu DROP CONSTRAINT leaf_menu_pk;
ALTER TABLE ONLY public.leaf_dict DROP CONSTRAINT leaf_dict_pk;
ALTER TABLE public.leaf_user ALTER COLUMN user_id DROP DEFAULT;
ALTER TABLE public.leaf_role ALTER COLUMN role_id DROP DEFAULT;
ALTER TABLE public.leaf_menu ALTER COLUMN menu_id DROP DEFAULT;
ALTER TABLE public.leaf_dict ALTER COLUMN dict_id DROP DEFAULT;
DROP SEQUENCE public.leaf_user_user_id_seq;
DROP TABLE public.leaf_user;
DROP SEQUENCE public.leaf_role_role_id_seq;
DROP TABLE public.leaf_role;
DROP SEQUENCE public.leaf_menu_menu_id_seq;
DROP TABLE public.leaf_menu;
DROP SEQUENCE public.leaf_dict_dict_id_seq;
DROP TABLE public.leaf_dict;
SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: leaf_dict; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_dict (
    dict_id bigint NOT NULL,
    dict_type character varying,
    dict_key character varying,
    dict_value character varying,
    status smallint DEFAULT 0,
    del_flag smallint DEFAULT 0
);


ALTER TABLE public.leaf_dict OWNER TO postgres;

--
-- Name: TABLE leaf_dict; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_dict IS '字典表';


--
-- Name: COLUMN leaf_dict.dict_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.dict_type IS '字典类型';


--
-- Name: COLUMN leaf_dict.dict_key; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.dict_key IS '字典键';


--
-- Name: COLUMN leaf_dict.dict_value; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.dict_value IS '字典值';


--
-- Name: COLUMN leaf_dict.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.status IS '字典状态(0正常；1弃用)';


--
-- Name: COLUMN leaf_dict.del_flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.del_flag IS '删除标志(0正常；1删除)';


--
-- Name: leaf_dict_dict_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.leaf_dict_dict_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_dict_dict_id_seq OWNER TO postgres;

--
-- Name: leaf_dict_dict_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leaf_dict_dict_id_seq OWNED BY public.leaf_dict.dict_id;


--
-- Name: leaf_menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_menu (
    menu_id bigint NOT NULL,
    menu_name character varying,
    menu_code character varying,
    p_code character varying,
    order_num character varying,
    menu_type character(1),
    icon_url character varying,
    permission character varying,
    status character varying
);


ALTER TABLE public.leaf_menu OWNER TO postgres;

--
-- Name: TABLE leaf_menu; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_menu IS '菜单表';


--
-- Name: COLUMN leaf_menu.menu_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.menu_name IS '菜单名称';


--
-- Name: COLUMN leaf_menu.menu_code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.menu_code IS '菜单编码';


--
-- Name: COLUMN leaf_menu.p_code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.p_code IS '父级编码';


--
-- Name: COLUMN leaf_menu.order_num; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.order_num IS '显示顺序';


--
-- Name: COLUMN leaf_menu.menu_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.menu_type IS '菜单类型(D目录，M菜单，B按钮)';


--
-- Name: COLUMN leaf_menu.icon_url; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.icon_url IS '菜单图标';


--
-- Name: COLUMN leaf_menu.permission; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.permission IS '权限字符';


--
-- Name: COLUMN leaf_menu.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.status IS '状态(0启用；1禁用)';


--
-- Name: leaf_menu_menu_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.leaf_menu_menu_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_menu_menu_id_seq OWNER TO postgres;

--
-- Name: leaf_menu_menu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leaf_menu_menu_id_seq OWNED BY public.leaf_menu.menu_id;


--
-- Name: leaf_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_role (
    role_id bigint NOT NULL,
    role_code character varying,
    role_name character varying,
    status character varying DEFAULT 0,
    create_by character varying,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    update_by character varying,
    remark character varying
);


ALTER TABLE public.leaf_role OWNER TO postgres;

--
-- Name: TABLE leaf_role; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_role IS '角色表';


--
-- Name: COLUMN leaf_role.role_code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.role_code IS '角色编码';


--
-- Name: COLUMN leaf_role.role_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.role_name IS '角色名称';


--
-- Name: COLUMN leaf_role.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.status IS '状态(0启用；1禁用)';


--
-- Name: COLUMN leaf_role.create_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.create_by IS '创建人';


--
-- Name: COLUMN leaf_role.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.create_time IS '创建时间';


--
-- Name: COLUMN leaf_role.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.update_time IS '更新时间';


--
-- Name: COLUMN leaf_role.update_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.update_by IS '更新人';


--
-- Name: COLUMN leaf_role.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.remark IS '备注';


--
-- Name: leaf_role_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.leaf_role_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_role_role_id_seq OWNER TO postgres;

--
-- Name: leaf_role_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leaf_role_role_id_seq OWNED BY public.leaf_role.role_id;


--
-- Name: leaf_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_user (
    user_id bigint NOT NULL,
    username character varying(64) NOT NULL,
    password character varying(64) NOT NULL,
    avatar character varying NOT NULL,
    nick_name character varying NOT NULL,
    status smallint DEFAULT 0,
    del_flag smallint DEFAULT 0,
    create_by character varying,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    update_by character varying,
    remark character varying
);


ALTER TABLE public.leaf_user OWNER TO postgres;

--
-- Name: TABLE leaf_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_user IS '账户信息表';


--
-- Name: COLUMN leaf_user.username; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.username IS '用户名';


--
-- Name: COLUMN leaf_user.password; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.password IS '密码';


--
-- Name: COLUMN leaf_user.avatar; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.avatar IS '头像地址';


--
-- Name: COLUMN leaf_user.nick_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.nick_name IS '昵称';


--
-- Name: COLUMN leaf_user.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.status IS '账户状态(0正常；1禁用)';


--
-- Name: COLUMN leaf_user.del_flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.del_flag IS '删除标志(0正常；1删除)';


--
-- Name: COLUMN leaf_user.create_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.create_by IS '创建人';


--
-- Name: COLUMN leaf_user.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.create_time IS '创建时间';


--
-- Name: COLUMN leaf_user.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.update_time IS '更新时间';


--
-- Name: COLUMN leaf_user.update_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.update_by IS '更新人';


--
-- Name: COLUMN leaf_user.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.remark IS '备注';


--
-- Name: leaf_user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.leaf_user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_user_user_id_seq OWNER TO postgres;

--
-- Name: leaf_user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leaf_user_user_id_seq OWNED BY public.leaf_user.user_id;


--
-- Name: leaf_dict dict_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_dict ALTER COLUMN dict_id SET DEFAULT nextval('public.leaf_dict_dict_id_seq'::regclass);


--
-- Name: leaf_menu menu_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_menu ALTER COLUMN menu_id SET DEFAULT nextval('public.leaf_menu_menu_id_seq'::regclass);


--
-- Name: leaf_role role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_role ALTER COLUMN role_id SET DEFAULT nextval('public.leaf_role_role_id_seq'::regclass);


--
-- Name: leaf_user user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_user ALTER COLUMN user_id SET DEFAULT nextval('public.leaf_user_user_id_seq'::regclass);


--
-- Data for Name: leaf_dict; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_dict (dict_id, dict_type, dict_key, dict_value, status, del_flag) FROM stdin;
\.


--
-- Data for Name: leaf_menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_menu (menu_id, menu_name, menu_code, p_code, order_num, menu_type, icon_url, permission, status) FROM stdin;
\.


--
-- Data for Name: leaf_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_role (role_id, role_code, role_name, status, create_by, create_time, update_time, update_by, remark) FROM stdin;
\.


--
-- Data for Name: leaf_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_user (user_id, username, password, avatar, nick_name, status, del_flag, create_by, create_time, update_time, update_by, remark) FROM stdin;
\.


--
-- Name: leaf_dict_dict_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leaf_dict_dict_id_seq', 1, false);


--
-- Name: leaf_menu_menu_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leaf_menu_menu_id_seq', 1, false);


--
-- Name: leaf_role_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leaf_role_role_id_seq', 1, false);


--
-- Name: leaf_user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leaf_user_user_id_seq', 1, false);


--
-- Name: leaf_dict leaf_dict_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_dict
    ADD CONSTRAINT leaf_dict_pk PRIMARY KEY (dict_id);


--
-- Name: leaf_menu leaf_menu_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_menu
    ADD CONSTRAINT leaf_menu_pk PRIMARY KEY (menu_id);


--
-- Name: leaf_role leaf_role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_role
    ADD CONSTRAINT leaf_role_pk PRIMARY KEY (role_id);


--
-- Name: leaf_user leaf_user_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_user
    ADD CONSTRAINT leaf_user_pk PRIMARY KEY (user_id);


--
-- PostgreSQL database dump complete
--

