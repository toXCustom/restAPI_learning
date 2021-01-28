--liquibase formatted sql
--changeset pmroz:4
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled boolean NOT NULL
    );
--changeset pmroz:5
CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES
    users (username), UNIQUE KEY username_authority (username, authority)
    );
--changeset pmroz:6
INSERT INTO users (id, username, password, enabled)
VALUES (1, 'test', '{bcrypt}$2y$12$Acp.tnkVu16H7/mQK5GdsunKX2wkHFalOCS1Gsg.tiIx8P1NddYka', true);
INSERT INTO authorities (username, authority) VALUES ('test', 'USER');