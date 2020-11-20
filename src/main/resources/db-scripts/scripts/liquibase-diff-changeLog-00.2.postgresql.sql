select * from tbuser t ;


--liquibase formatted sql

--changeset jaire:42
CREATE SEQUENCE IF NOT EXISTS hibernate_sequence;
ALTER TABLE tbuser ALTER tbuser_id SET DEFAULT nextval('hibernate_sequence');
ALTER SEQUENCE hibernate_sequence OWNED BY tbuser.tbuser_id;

CREATE TABLE IF NOT EXISTS tbuser (
 tbuser_id BIGINT NOT NULL CONSTRAINT user_pkey PRIMARY KEY ,
 tbuser_name VARCHAR(255),
 tbuser_type VARCHAR(25),
 tbuser_user_name VARCHAR(10),
 tbuser_status boolean,
 tbuser_created timestamp,
 tbuser_password VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS tbprovider (
 tbprovider_id BIGINT NOT NULL CONSTRAINT provider_pkey PRIMARY KEY ,
 tbprovider_name VARCHAR(255),
 tbprovider_postal_code VARCHAR(10),
 tbprovider_city VARCHAR(100),
 tbprovider_state VARCHAR(2),
 tbprovider_country VARCHAR(50),
 tbprovider_status boolean,
 tbprovider_created timestamp 
);


CREATE TABLE IF NOT EXISTS tbcontact (
 tbcontact_id BIGINT NOT NULL CONSTRAINT contact_pkey PRIMARY KEY,
 tbcontact_phone VARCHAR(15),
 tbcontact_mail VARCHAR(255),
 tbcontact_status boolean,
 tbcontact_created timestamp
);

ALTER TABLE public.tbprovider ADD CONSTRAINT tbprovider_fk FOREIGN KEY (contact_pkey) REFERENCES public.tbcontact(tbcontact_id);

ALTER TABLE public.tbcontact ADD CONSTRAINT tbcontact_un UNIQUE (tbcontact_phone);
ALTER TABLE public.tbcontact ADD CONSTRAINT tbcontact_un UNIQUE (tbcontact_mail);
