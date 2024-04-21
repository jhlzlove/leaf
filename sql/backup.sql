--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-04-21 20:33:40

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

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 4939 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 223 (class 1259 OID 16627)
-- Name: leaf_dept; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_dept (
    dept_id bigint NOT NULL,
    dept_name character varying NOT NULL,
    parent_id bigint,
    dept_code character varying NOT NULL,
    leader_id bigint,
    description character varying,
    status smallint DEFAULT 1 NOT NULL,
    create_by character varying,
    update_by character varying,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    remark character varying,
    role_id bigint,
    sortable smallint
);


ALTER TABLE public.leaf_dept OWNER TO postgres;

--
-- TOC entry 4940 (class 0 OID 0)
-- Dependencies: 223
-- Name: TABLE leaf_dept; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_dept IS '部门表';


--
-- TOC entry 4941 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.dept_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.dept_name IS '部门名称';


--
-- TOC entry 4942 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.parent_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.parent_id IS '父级部门ID';


--
-- TOC entry 4943 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.dept_code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.dept_code IS '父级部门编码';


--
-- TOC entry 4944 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.leader_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.leader_id IS '部门负责人ID';


--
-- TOC entry 4945 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.description; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.description IS '部门描述';


--
-- TOC entry 4946 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.status IS '状态：1正常，0禁用';


--
-- TOC entry 4947 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.create_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.create_by IS '创建人';


--
-- TOC entry 4948 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.update_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.update_by IS '更新人';


--
-- TOC entry 4949 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.create_time IS '创建时间';


--
-- TOC entry 4950 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.update_time IS '更新时间';


--
-- TOC entry 4951 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.remark IS '备注';


--
-- TOC entry 4952 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.role_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.role_id IS '角色ID';


--
-- TOC entry 4953 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN leaf_dept.sortable; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dept.sortable IS '排序';


--
-- TOC entry 222 (class 1259 OID 16626)
-- Name: leaf_dept_dept_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.leaf_dept_dept_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_dept_dept_id_seq OWNER TO postgres;

--
-- TOC entry 4954 (class 0 OID 0)
-- Dependencies: 222
-- Name: leaf_dept_dept_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leaf_dept_dept_id_seq OWNED BY public.leaf_dept.dept_id;


--
-- TOC entry 232 (class 1259 OID 16690)
-- Name: leaf_dict; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_dict (
    dict_id bigint NOT NULL,
    dict_type character varying NOT NULL,
    dict_name character varying NOT NULL,
    dict_key character varying NOT NULL,
    dict_value character varying NOT NULL,
    create_by character varying,
    update_by character varying,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    remark character varying,
    status smallint DEFAULT 1 NOT NULL
);


ALTER TABLE public.leaf_dict OWNER TO postgres;

--
-- TOC entry 4955 (class 0 OID 0)
-- Dependencies: 232
-- Name: TABLE leaf_dict; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_dict IS '字典表';


--
-- TOC entry 4956 (class 0 OID 0)
-- Dependencies: 232
-- Name: COLUMN leaf_dict.dict_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.dict_type IS '字典类型';


--
-- TOC entry 4957 (class 0 OID 0)
-- Dependencies: 232
-- Name: COLUMN leaf_dict.dict_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.dict_name IS '字典名称';


--
-- TOC entry 4958 (class 0 OID 0)
-- Dependencies: 232
-- Name: COLUMN leaf_dict.dict_key; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.dict_key IS '字典键';


--
-- TOC entry 4959 (class 0 OID 0)
-- Dependencies: 232
-- Name: COLUMN leaf_dict.dict_value; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.dict_value IS '字典值';


--
-- TOC entry 4960 (class 0 OID 0)
-- Dependencies: 232
-- Name: COLUMN leaf_dict.create_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.create_by IS '创建人';


--
-- TOC entry 4961 (class 0 OID 0)
-- Dependencies: 232
-- Name: COLUMN leaf_dict.update_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.update_by IS '更新人';


--
-- TOC entry 4962 (class 0 OID 0)
-- Dependencies: 232
-- Name: COLUMN leaf_dict.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.create_time IS '创建时间';


--
-- TOC entry 4963 (class 0 OID 0)
-- Dependencies: 232
-- Name: COLUMN leaf_dict.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.update_time IS '更新时间';


--
-- TOC entry 4964 (class 0 OID 0)
-- Dependencies: 232
-- Name: COLUMN leaf_dict.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.remark IS '备注';


--
-- TOC entry 4965 (class 0 OID 0)
-- Dependencies: 232
-- Name: COLUMN leaf_dict.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_dict.status IS '状态：1正常，0禁用';


--
-- TOC entry 231 (class 1259 OID 16689)
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
-- TOC entry 4966 (class 0 OID 0)
-- Dependencies: 231
-- Name: leaf_dict_dict_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leaf_dict_dict_id_seq OWNED BY public.leaf_dict.dict_id;


--
-- TOC entry 228 (class 1259 OID 16654)
-- Name: leaf_menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_menu (
    menu_id bigint NOT NULL,
    menu_type character varying NOT NULL,
    menu_name character varying NOT NULL,
    parent_id bigint DEFAULT 0 NOT NULL,
    sortable smallint,
    permission character varying,
    status smallint DEFAULT 1 NOT NULL,
    create_by character varying,
    update_by character varying,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    remark character varying
);


ALTER TABLE public.leaf_menu OWNER TO postgres;

--
-- TOC entry 4967 (class 0 OID 0)
-- Dependencies: 228
-- Name: TABLE leaf_menu; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_menu IS '菜单表';


--
-- TOC entry 4968 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN leaf_menu.menu_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.menu_type IS '菜单类型';


--
-- TOC entry 4969 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN leaf_menu.menu_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.menu_name IS '菜单名称';


--
-- TOC entry 4970 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN leaf_menu.parent_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.parent_id IS '父级菜单ID';


--
-- TOC entry 4971 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN leaf_menu.sortable; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.sortable IS '排序';


--
-- TOC entry 4972 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN leaf_menu.permission; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.permission IS '权限字符';


--
-- TOC entry 4973 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN leaf_menu.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.status IS '状态 1正常，0停用';


--
-- TOC entry 4974 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN leaf_menu.create_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.create_by IS '创建人';


--
-- TOC entry 4975 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN leaf_menu.update_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.update_by IS '更新人';


--
-- TOC entry 4976 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN leaf_menu.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.create_time IS '创建时间';


--
-- TOC entry 4977 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN leaf_menu.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.update_time IS '更新时间';


--
-- TOC entry 4978 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN leaf_menu.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu.remark IS '备注';


--
-- TOC entry 227 (class 1259 OID 16653)
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
-- TOC entry 4979 (class 0 OID 0)
-- Dependencies: 227
-- Name: leaf_menu_menu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leaf_menu_menu_id_seq OWNED BY public.leaf_menu.menu_id;


--
-- TOC entry 229 (class 1259 OID 16664)
-- Name: leaf_menu_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_menu_role (
    menu_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.leaf_menu_role OWNER TO postgres;

--
-- TOC entry 4980 (class 0 OID 0)
-- Dependencies: 229
-- Name: TABLE leaf_menu_role; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_menu_role IS '菜单-角色关联表';


--
-- TOC entry 4981 (class 0 OID 0)
-- Dependencies: 229
-- Name: COLUMN leaf_menu_role.menu_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu_role.menu_id IS '菜单ID';


--
-- TOC entry 4982 (class 0 OID 0)
-- Dependencies: 229
-- Name: COLUMN leaf_menu_role.role_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_menu_role.role_id IS '角色ID';


--
-- TOC entry 225 (class 1259 OID 16639)
-- Name: leaf_post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_post (
    post_id bigint NOT NULL,
    post_code character varying NOT NULL,
    post_name character varying NOT NULL,
    dept_id bigint NOT NULL,
    create_by character varying,
    update_by character varying,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    remark character varying
);


ALTER TABLE public.leaf_post OWNER TO postgres;

--
-- TOC entry 4983 (class 0 OID 0)
-- Dependencies: 225
-- Name: TABLE leaf_post; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_post IS '岗位信息表';


--
-- TOC entry 4984 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN leaf_post.post_code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_post.post_code IS '岗位编码';


--
-- TOC entry 4985 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN leaf_post.post_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_post.post_name IS '岗位名称';


--
-- TOC entry 4986 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN leaf_post.dept_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_post.dept_id IS '所属部门ID';


--
-- TOC entry 4987 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN leaf_post.create_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_post.create_by IS '创建人';


--
-- TOC entry 4988 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN leaf_post.update_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_post.update_by IS '更新人';


--
-- TOC entry 4989 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN leaf_post.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_post.create_time IS '创建时间';


--
-- TOC entry 4990 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN leaf_post.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_post.update_time IS '更新时间';


--
-- TOC entry 4991 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN leaf_post.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_post.remark IS '备注';


--
-- TOC entry 224 (class 1259 OID 16638)
-- Name: leaf_post_post_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.leaf_post_post_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_post_post_id_seq OWNER TO postgres;

--
-- TOC entry 4992 (class 0 OID 0)
-- Dependencies: 224
-- Name: leaf_post_post_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leaf_post_post_id_seq OWNED BY public.leaf_post.post_id;


--
-- TOC entry 220 (class 1259 OID 16615)
-- Name: leaf_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_role (
    role_id bigint NOT NULL,
    role_name character varying NOT NULL,
    role_code character varying NOT NULL,
    status smallint DEFAULT 1 NOT NULL,
    create_by character varying,
    update_by character varying,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    remark character varying
);


ALTER TABLE public.leaf_role OWNER TO postgres;

--
-- TOC entry 4993 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE leaf_role; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_role IS '角色表';


--
-- TOC entry 4994 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN leaf_role.role_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.role_name IS '角色名称';


--
-- TOC entry 4995 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN leaf_role.role_code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.role_code IS '角色编码';


--
-- TOC entry 4996 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN leaf_role.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.status IS '状态：1正常，0禁用';


--
-- TOC entry 4997 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN leaf_role.create_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.create_by IS '创建人';


--
-- TOC entry 4998 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN leaf_role.update_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.update_by IS '更新人';


--
-- TOC entry 4999 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN leaf_role.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.create_time IS '创建时间';


--
-- TOC entry 5000 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN leaf_role.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.update_time IS '更新时间';


--
-- TOC entry 5001 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN leaf_role.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_role.remark IS '备注';


--
-- TOC entry 219 (class 1259 OID 16614)
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
-- TOC entry 5002 (class 0 OID 0)
-- Dependencies: 219
-- Name: leaf_role_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leaf_role_role_id_seq OWNED BY public.leaf_role.role_id;


--
-- TOC entry 216 (class 1259 OID 16594)
-- Name: leaf_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_user (
    user_id bigint NOT NULL,
    nick_name character varying NOT NULL,
    username character varying NOT NULL,
    password character varying NOT NULL,
    phone character varying,
    email character varying,
    avatar character varying,
    last_login_time timestamp without time zone,
    status smallint DEFAULT 1 NOT NULL,
    create_by character varying,
    update_by character varying,
    create_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    remark character varying,
    user_detail_id bigint NOT NULL
);


ALTER TABLE public.leaf_user OWNER TO postgres;

--
-- TOC entry 5003 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE leaf_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_user IS '用户表';


--
-- TOC entry 5004 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.nick_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.nick_name IS '昵称';


--
-- TOC entry 5005 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.username; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.username IS '用户名';


--
-- TOC entry 5006 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.password; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.password IS '密码';


--
-- TOC entry 5007 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.phone; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.phone IS '手机号';


--
-- TOC entry 5008 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.email; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.email IS '电子邮箱';


--
-- TOC entry 5009 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.avatar; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.avatar IS '头像';


--
-- TOC entry 5010 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.last_login_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.last_login_time IS '最后登录时间';


--
-- TOC entry 5011 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.status IS '状态';


--
-- TOC entry 5012 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.create_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.create_by IS '创建人';


--
-- TOC entry 5013 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.update_by; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.update_by IS '更新人';


--
-- TOC entry 5014 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.create_time IS '创建时间';


--
-- TOC entry 5015 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.update_time IS '更新时间';


--
-- TOC entry 5016 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.remark IS '备注';


--
-- TOC entry 5017 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN leaf_user.user_detail_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user.user_detail_id IS '用户信息ID';


--
-- TOC entry 226 (class 1259 OID 16647)
-- Name: leaf_user_dept; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_user_dept (
    user_id bigint NOT NULL,
    dept_id bigint NOT NULL
);


ALTER TABLE public.leaf_user_dept OWNER TO postgres;

--
-- TOC entry 5018 (class 0 OID 0)
-- Dependencies: 226
-- Name: TABLE leaf_user_dept; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_user_dept IS '用户-部门关联表';


--
-- TOC entry 5019 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN leaf_user_dept.user_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_dept.user_id IS '用户ID';


--
-- TOC entry 5020 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN leaf_user_dept.dept_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_dept.dept_id IS '部门ID';


--
-- TOC entry 218 (class 1259 OID 16606)
-- Name: leaf_user_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_user_detail (
    user_detail_id bigint NOT NULL,
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

--
-- TOC entry 5021 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE leaf_user_detail; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_user_detail IS '用户详情表';


--
-- TOC entry 5022 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN leaf_user_detail.first_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_detail.first_name IS '姓氏';


--
-- TOC entry 5023 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN leaf_user_detail.last_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_detail.last_name IS '名称';


--
-- TOC entry 5024 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN leaf_user_detail.ethnic; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_detail.ethnic IS '民族';


--
-- TOC entry 5025 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN leaf_user_detail.gender; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_detail.gender IS '性别';


--
-- TOC entry 5026 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN leaf_user_detail.age; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_detail.age IS '年龄';


--
-- TOC entry 5027 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN leaf_user_detail.address; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_detail.address IS '住址';


--
-- TOC entry 5028 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN leaf_user_detail.hometown; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_detail.hometown IS '故乡';


--
-- TOC entry 5029 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN leaf_user_detail.id_card; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_detail.id_card IS '身份证号';


--
-- TOC entry 217 (class 1259 OID 16605)
-- Name: leaf_user_detail_user_detail_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.leaf_user_detail_user_detail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.leaf_user_detail_user_detail_id_seq OWNER TO postgres;

--
-- TOC entry 5030 (class 0 OID 0)
-- Dependencies: 217
-- Name: leaf_user_detail_user_detail_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leaf_user_detail_user_detail_id_seq OWNED BY public.leaf_user_detail.user_detail_id;


--
-- TOC entry 230 (class 1259 OID 16679)
-- Name: leaf_user_post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_user_post (
    user_id bigint NOT NULL,
    post_id bigint NOT NULL
);


ALTER TABLE public.leaf_user_post OWNER TO postgres;

--
-- TOC entry 5031 (class 0 OID 0)
-- Dependencies: 230
-- Name: TABLE leaf_user_post; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_user_post IS '用户-岗位关联表';


--
-- TOC entry 5032 (class 0 OID 0)
-- Dependencies: 230
-- Name: COLUMN leaf_user_post.user_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_post.user_id IS '用户ID';


--
-- TOC entry 5033 (class 0 OID 0)
-- Dependencies: 230
-- Name: COLUMN leaf_user_post.post_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_post.post_id IS '岗位ID';


--
-- TOC entry 221 (class 1259 OID 16623)
-- Name: leaf_user_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leaf_user_role (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.leaf_user_role OWNER TO postgres;

--
-- TOC entry 5034 (class 0 OID 0)
-- Dependencies: 221
-- Name: TABLE leaf_user_role; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.leaf_user_role IS '用户-角色关联表';


--
-- TOC entry 5035 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN leaf_user_role.user_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_role.user_id IS '用户ID';


--
-- TOC entry 5036 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN leaf_user_role.role_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.leaf_user_role.role_id IS '角色ID';


--
-- TOC entry 215 (class 1259 OID 16593)
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
-- TOC entry 5037 (class 0 OID 0)
-- Dependencies: 215
-- Name: leaf_user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leaf_user_user_id_seq OWNED BY public.leaf_user.user_id;


--
-- TOC entry 4743 (class 2604 OID 16630)
-- Name: leaf_dept dept_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_dept ALTER COLUMN dept_id SET DEFAULT nextval('public.leaf_dept_dept_id_seq'::regclass);


--
-- TOC entry 4755 (class 2604 OID 16693)
-- Name: leaf_dict dict_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_dict ALTER COLUMN dict_id SET DEFAULT nextval('public.leaf_dict_dict_id_seq'::regclass);


--
-- TOC entry 4750 (class 2604 OID 16657)
-- Name: leaf_menu menu_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_menu ALTER COLUMN menu_id SET DEFAULT nextval('public.leaf_menu_menu_id_seq'::regclass);


--
-- TOC entry 4747 (class 2604 OID 16642)
-- Name: leaf_post post_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_post ALTER COLUMN post_id SET DEFAULT nextval('public.leaf_post_post_id_seq'::regclass);


--
-- TOC entry 4739 (class 2604 OID 16618)
-- Name: leaf_role role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_role ALTER COLUMN role_id SET DEFAULT nextval('public.leaf_role_role_id_seq'::regclass);


--
-- TOC entry 4734 (class 2604 OID 16597)
-- Name: leaf_user user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_user ALTER COLUMN user_id SET DEFAULT nextval('public.leaf_user_user_id_seq'::regclass);


--
-- TOC entry 4738 (class 2604 OID 16609)
-- Name: leaf_user_detail user_detail_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_user_detail ALTER COLUMN user_detail_id SET DEFAULT nextval('public.leaf_user_detail_user_detail_id_seq'::regclass);


--
-- TOC entry 4924 (class 0 OID 16627)
-- Dependencies: 223
-- Data for Name: leaf_dept; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_dept (dept_id, dept_name, parent_id, dept_code, leader_id, description, status, create_by, update_by, create_time, update_time, remark, role_id, sortable) FROM stdin;
\.


--
-- TOC entry 4933 (class 0 OID 16690)
-- Dependencies: 232
-- Data for Name: leaf_dict; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_dict (dict_id, dict_type, dict_name, dict_key, dict_value, create_by, update_by, create_time, update_time, remark, status) FROM stdin;
\.


--
-- TOC entry 4929 (class 0 OID 16654)
-- Dependencies: 228
-- Data for Name: leaf_menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_menu (menu_id, menu_type, menu_name, parent_id, sortable, permission, status, create_by, update_by, create_time, update_time, remark) FROM stdin;
\.


--
-- TOC entry 4930 (class 0 OID 16664)
-- Dependencies: 229
-- Data for Name: leaf_menu_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_menu_role (menu_id, role_id) FROM stdin;
\.


--
-- TOC entry 4926 (class 0 OID 16639)
-- Dependencies: 225
-- Data for Name: leaf_post; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_post (post_id, post_code, post_name, dept_id, create_by, update_by, create_time, update_time, remark) FROM stdin;
\.


--
-- TOC entry 4921 (class 0 OID 16615)
-- Dependencies: 220
-- Data for Name: leaf_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_role (role_id, role_name, role_code, status, create_by, update_by, create_time, update_time, remark) FROM stdin;
\.


--
-- TOC entry 4917 (class 0 OID 16594)
-- Dependencies: 216
-- Data for Name: leaf_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_user (user_id, nick_name, username, password, phone, email, avatar, last_login_time, status, create_by, update_by, create_time, update_time, remark, user_detail_id) FROM stdin;
\.


--
-- TOC entry 4927 (class 0 OID 16647)
-- Dependencies: 226
-- Data for Name: leaf_user_dept; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_user_dept (user_id, dept_id) FROM stdin;
\.


--
-- TOC entry 4919 (class 0 OID 16606)
-- Dependencies: 218
-- Data for Name: leaf_user_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_user_detail (user_detail_id, first_name, last_name, ethnic, gender, age, address, hometown, id_card) FROM stdin;
\.


--
-- TOC entry 4931 (class 0 OID 16679)
-- Dependencies: 230
-- Data for Name: leaf_user_post; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_user_post (user_id, post_id) FROM stdin;
\.


--
-- TOC entry 4922 (class 0 OID 16623)
-- Dependencies: 221
-- Data for Name: leaf_user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leaf_user_role (user_id, role_id) FROM stdin;
\.


--
-- TOC entry 5038 (class 0 OID 0)
-- Dependencies: 222
-- Name: leaf_dept_dept_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leaf_dept_dept_id_seq', 1, false);


--
-- TOC entry 5039 (class 0 OID 0)
-- Dependencies: 231
-- Name: leaf_dict_dict_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leaf_dict_dict_id_seq', 1, false);


--
-- TOC entry 5040 (class 0 OID 0)
-- Dependencies: 227
-- Name: leaf_menu_menu_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leaf_menu_menu_id_seq', 1, false);


--
-- TOC entry 5041 (class 0 OID 0)
-- Dependencies: 224
-- Name: leaf_post_post_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leaf_post_post_id_seq', 1, false);


--
-- TOC entry 5042 (class 0 OID 0)
-- Dependencies: 219
-- Name: leaf_role_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leaf_role_role_id_seq', 1, false);


--
-- TOC entry 5043 (class 0 OID 0)
-- Dependencies: 217
-- Name: leaf_user_detail_user_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leaf_user_detail_user_detail_id_seq', 1, false);


--
-- TOC entry 5044 (class 0 OID 0)
-- Dependencies: 215
-- Name: leaf_user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leaf_user_user_id_seq', 1, false);


--
-- TOC entry 4766 (class 2606 OID 16637)
-- Name: leaf_dept leaf_dept_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_dept
    ADD CONSTRAINT leaf_dept_pk PRIMARY KEY (dept_id);


--
-- TOC entry 4772 (class 2606 OID 16699)
-- Name: leaf_dict leaf_dict_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_dict
    ADD CONSTRAINT leaf_dict_pk PRIMARY KEY (dict_id);


--
-- TOC entry 4770 (class 2606 OID 16663)
-- Name: leaf_menu leaf_menu_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_menu
    ADD CONSTRAINT leaf_menu_pk PRIMARY KEY (menu_id);


--
-- TOC entry 4768 (class 2606 OID 16646)
-- Name: leaf_post leaf_post_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_post
    ADD CONSTRAINT leaf_post_pk PRIMARY KEY (post_id);


--
-- TOC entry 4764 (class 2606 OID 16622)
-- Name: leaf_role leaf_role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_role
    ADD CONSTRAINT leaf_role_pk PRIMARY KEY (role_id);


--
-- TOC entry 4762 (class 2606 OID 16613)
-- Name: leaf_user_detail leaf_user_detail_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_user_detail
    ADD CONSTRAINT leaf_user_detail_pk PRIMARY KEY (user_detail_id);


--
-- TOC entry 4760 (class 2606 OID 16604)
-- Name: leaf_user leaf_user_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leaf_user
    ADD CONSTRAINT leaf_user_pk PRIMARY KEY (user_id);


-- Completed on 2024-04-21 20:33:40

--
-- PostgreSQL database dump complete
--

