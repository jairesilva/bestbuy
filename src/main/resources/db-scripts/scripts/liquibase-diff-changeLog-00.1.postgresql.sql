--liquibase formatted sql

--changeset jaire:1
CREATE SEQUENCE IF NOT EXISTS hibernate_sequence;

CREATE TABLE IF NOT EXISTS tbuser (
 id BIGINT NOT NULL CONSTRAINT user_pkey PRIMARY KEY ,
 name VARCHAR(255),
 user_name VARCHAR(10),
 parent_user_id BIGINT CONSTRAINT user_parent_fkey references tbuser
);

--changeset outrousuario:2
--insert into tbuser (name, user_name)
--values("Jair Estanislau da Silva", "jairesilva");

--rollback ALTER TABLE image DROP CONSTRAINT product_image_fkey;
--rollback DROP TABLE image;