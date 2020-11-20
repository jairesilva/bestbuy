--liquibase formatted sql

--changeset jaire:42
CREATE SEQUENCE IF NOT EXISTS hibernate_sequence;

CREATE TABLE IF NOT EXISTS tbuser (
 id BIGINT NOT NULL CONSTRAINT user_pkey PRIMARY KEY ,
 name VARCHAR(255),
 type VARCHAR(25),
 user_name VARCHAR(10),
 status boolean,
 created timestamp,
 password VARCHAR(10), 
 parent_user_id BIGINT CONSTRAINT user_parent_fkey references tbuser
);	
	