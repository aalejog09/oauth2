PGDMP          
    
        |            authentication    15.7    16.3 '    %           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            &           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            '           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            (           1262    16737    authentication    DATABASE     �   CREATE DATABASE authentication WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Venezuela.1252';
    DROP DATABASE authentication;
                postgres    false            �            1259    16941    function    TABLE     �   CREATE TABLE public.function (
    id integer NOT NULL,
    creation_date timestamp(6) without time zone,
    description character varying(255)
);
    DROP TABLE public.function;
       public         heap    postgres    false            �            1259    16940    function_id_seq    SEQUENCE     �   ALTER TABLE public.function ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.function_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    221            �            1259    16909    role    TABLE     �   CREATE TABLE public.role (
    id integer NOT NULL,
    creation_date timestamp(6) without time zone,
    name character varying(255)
);
    DROP TABLE public.role;
       public         heap    postgres    false            �            1259    16947    role_function    TABLE     m   CREATE TABLE public.role_function (
    id integer NOT NULL,
    function_id integer,
    role_id integer
);
 !   DROP TABLE public.role_function;
       public         heap    postgres    false            �            1259    16946    role_function_id_seq    SEQUENCE     �   ALTER TABLE public.role_function ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.role_function_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    223            �            1259    16908    role_id_seq    SEQUENCE     �   CREATE SEQUENCE public.role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.role_id_seq;
       public          postgres    false    215            )           0    0    role_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;
          public          postgres    false    214            �            1259    16916    users    TABLE     w  CREATE TABLE public.users (
    id bigint NOT NULL,
    email character varying(30) NOT NULL,
    enabled smallint NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    password character varying(60),
    username character varying(30) NOT NULL,
    CONSTRAINT users_enabled_check CHECK ((enabled = ANY (ARRAY[0, 1])))
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16915    users_id_seq    SEQUENCE     u   CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    217            *           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    216            �            1259    16924 
   users_role    TABLE     e   CREATE TABLE public.users_role (
    id integer NOT NULL,
    role_id integer,
    user_id bigint
);
    DROP TABLE public.users_role;
       public         heap    postgres    false            �            1259    16923    users_role_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.users_role_id_seq;
       public          postgres    false    219            +           0    0    users_role_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.users_role_id_seq OWNED BY public.users_role.id;
          public          postgres    false    218            y           2604    16912    role id    DEFAULT     b   ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);
 6   ALTER TABLE public.role ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            z           2604    16919    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216    217            {           2604    16927    users_role id    DEFAULT     n   ALTER TABLE ONLY public.users_role ALTER COLUMN id SET DEFAULT nextval('public.users_role_id_seq'::regclass);
 <   ALTER TABLE public.users_role ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    218    219                       0    16941    function 
   TABLE DATA           B   COPY public.function (id, creation_date, description) FROM stdin;
    public          postgres    false    221   +                 0    16909    role 
   TABLE DATA           7   COPY public.role (id, creation_date, name) FROM stdin;
    public          postgres    false    215   K+       "          0    16947    role_function 
   TABLE DATA           A   COPY public.role_function (id, function_id, role_id) FROM stdin;
    public          postgres    false    223   �+                 0    16916    users 
   TABLE DATA           ^   COPY public.users (id, email, enabled, first_name, last_name, password, username) FROM stdin;
    public          postgres    false    217   �+                 0    16924 
   users_role 
   TABLE DATA           :   COPY public.users_role (id, role_id, user_id) FROM stdin;
    public          postgres    false    219   w,       ,           0    0    function_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.function_id_seq', 1, true);
          public          postgres    false    220            -           0    0    role_function_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.role_function_id_seq', 2, true);
          public          postgres    false    222            .           0    0    role_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.role_id_seq', 2, true);
          public          postgres    false    214            /           0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 1, false);
          public          postgres    false    216            0           0    0    users_role_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.users_role_id_seq', 3, true);
          public          postgres    false    218            �           2606    16945    function function_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.function
    ADD CONSTRAINT function_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.function DROP CONSTRAINT function_pkey;
       public            postgres    false    221            �           2606    16951     role_function role_function_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.role_function
    ADD CONSTRAINT role_function_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.role_function DROP CONSTRAINT role_function_pkey;
       public            postgres    false    223            ~           2606    16914    role role_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pkey;
       public            postgres    false    215            �           2606    16922    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    217            �           2606    16929    users_role users_role_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT users_role_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.users_role DROP CONSTRAINT users_role_pkey;
       public            postgres    false    219            �           2606    16930 &   users_role fk3qjq7qsiigxa82jgk0i0wuq3g    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT fk3qjq7qsiigxa82jgk0i0wuq3g FOREIGN KEY (role_id) REFERENCES public.role(id);
 P   ALTER TABLE ONLY public.users_role DROP CONSTRAINT fk3qjq7qsiigxa82jgk0i0wuq3g;
       public          postgres    false    219    3198    215            �           2606    16957 )   role_function fkeqk2i5h6orbp5blnkcxu880tk    FK CONSTRAINT     �   ALTER TABLE ONLY public.role_function
    ADD CONSTRAINT fkeqk2i5h6orbp5blnkcxu880tk FOREIGN KEY (role_id) REFERENCES public.role(id);
 S   ALTER TABLE ONLY public.role_function DROP CONSTRAINT fkeqk2i5h6orbp5blnkcxu880tk;
       public          postgres    false    223    3198    215            �           2606    16952 )   role_function fkpxk51k07j2jbxi2vckjesc9io    FK CONSTRAINT     �   ALTER TABLE ONLY public.role_function
    ADD CONSTRAINT fkpxk51k07j2jbxi2vckjesc9io FOREIGN KEY (function_id) REFERENCES public.function(id);
 S   ALTER TABLE ONLY public.role_function DROP CONSTRAINT fkpxk51k07j2jbxi2vckjesc9io;
       public          postgres    false    223    3204    221            �           2606    16935 &   users_role fkqpe36jsen4rslwfx5i6dj2fy8    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT fkqpe36jsen4rslwfx5i6dj2fy8 FOREIGN KEY (user_id) REFERENCES public.users(id);
 P   ALTER TABLE ONLY public.users_role DROP CONSTRAINT fkqpe36jsen4rslwfx5i6dj2fy8;
       public          postgres    false    219    217    3200                0   x�3�4202�50�56P04�25�2��3163�4���O������� ��         >   x�3�4202�50�52Q04�26�2��33�064�tt����2BWbheV������� ��      "      x�3�4�4�2�F\1z\\\ 	         �   x�Uͻ�0 @ѹ����G��	��+�ĥ�$�4�!��2�;�K����eoL��o�ZD"6q9;��}36AnTW�W�܃ԝnabͼb��ìG��^>s�1��i����S~>E�c5:��1�^�����.bu[�4��N�B���Hd�b�����T�@5            x�3�4�4�2�B.c i����� !��     